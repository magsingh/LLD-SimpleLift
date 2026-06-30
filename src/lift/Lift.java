package lift;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import user.User;

public class Lift {
	private int liftId;
	private static final int MAX_CAPACITY = 20;
	private int curPosition;
	private Direction curDirection; 
	private boolean isFull;
	private List<Integer> scheduledStops;
	
	private List<User> assignedUsers;

	public Lift(int id, int cPos) {
		liftId = id;
		curPosition = cPos;
		curDirection = Direction.STILL;
		isFull = false;
		scheduledStops = new ArrayList<>();
		assignedUsers = new ArrayList<>();
	}
	
	public void pressFloorBtn(int btn) {
		if (btn == curPosition) {
			System.out.println("Already at selected floor");
			return;
		}
		
		//Check if the lift is already going to stop at the floor 
		//If yes then do nothing
		//If no then add current floor to stops				
		if (!scheduledStops.contains(Integer.valueOf(btn))) {
			scheduledStops.add(btn);
		}
		Collections.sort(scheduledStops);
		System.out.println("Sorted scheduledStops = " + scheduledStops);
		if (curDirection == Direction.STILL) {
			if (curPosition < btn) {
				curDirection = Direction.UP;
			} else {
				curDirection = Direction.DOWN;
			}
		}
	}
	
	public void clearFloorBtn(int btn) {
		scheduledStops.remove(Integer.valueOf(curPosition));
		System.out.println("scheduledStops after removing " + btn + " = " + scheduledStops);
		
		System.out.println("Lift stopped at floor " + curPosition);

		// Pick up users waiting here
		List<User> boardedUsers = new ArrayList<>();

		for (User user : assignedUsers) {

		    if (user.getAtFlrNo() == curPosition) {

		        System.out.println(
		            "User boarded. Destination = "
		            + user.getDestFlrNo());

		        pressFloorBtn(user.getDestFlrNo());

		        boardedUsers.add(user);
		    }
		}

		assignedUsers.removeAll(boardedUsers);
	}

	public void step() {
		if (curDirection == Direction.STILL) {
			System.out.println("Lift still");
			return;
		}
		if (curDirection == Direction.UP) {
			curPosition++;
		} else {
			curPosition--;
		}
		
		if (scheduledStops.contains(curPosition)) {
			System.out.println("At floor " + curPosition);
			clearFloorBtn(curPosition);
			
		}
		
		if (scheduledStops.isEmpty()) {
			curDirection = Direction.STILL;
		} else if (curDirection == Direction.UP && scheduledStops.get(scheduledStops.size() - 1) > curPosition) {
			System.out.println("More stops in current direction");
		} else {
			curDirection = Direction.DOWN;
		}
	}
	
	public void assignUser(User user) {
	    assignedUsers.add(user);
	    pressFloorBtn(user.getAtFlrNo());
	}
	
	public boolean isFull() {
		return isFull;
	}
	
	public Direction getCurDirection() {
		return curDirection;
	}
	
	public int getCurPosition() {
		return curPosition;
	}
	
	public List<Integer> getScheduledStops() {
		return scheduledStops;
	}
}

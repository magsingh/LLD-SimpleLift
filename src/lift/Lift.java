package lift;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lift {
	private int liftId;
	private static final int MAX_CAPACITY = 20;
	private int curPosition;
	private Direction curDirection; 
	private boolean isFull;
	private List<Integer> scheduledStops;

	public Lift(int id, int cPos) {
		liftId = id;
		curPosition = cPos;
		curDirection = Direction.STILL;
		isFull = false;
		scheduledStops = new ArrayList<>();
	}
	
	public void pressFloorBtn(int btn) {
		if (btn == curPosition) {
			System.out.println("Already at selected floor");
			return;
		}
		scheduledStops.add(btn);
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
		scheduledStops.remove(Integer.valueOf(btn));
		System.out.println("scheduledStops after removing " + btn + " = " + scheduledStops);
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
			scheduledStops.remove(Integer.valueOf(curPosition));
		}
		
		if (scheduledStops.isEmpty()) {
			curDirection = Direction.STILL;
		} else if (curDirection == Direction.UP && scheduledStops.get(scheduledStops.size() - 1) > curPosition) {
			System.out.println("More stops in current direction");
		} else {
			curDirection = Direction.DOWN;
		}
	}
}

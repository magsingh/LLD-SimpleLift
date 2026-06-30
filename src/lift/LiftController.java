package lift;

import java.util.List;

import building.Building;
import user.User;

public class LiftController {
	private Building building;

	public LiftController(Building b) {
		building = b;
	}
	
	public void assignLift(User u) {
		
		Lift assignedLift = chooseBestLift(building.getLifts(), u);
		assignedLift.pressFloorBtn(u.getAtFlrNo());
		assignedLift.assignUser(u);
		
		//ToDo: Unpress btn once lift arrives
//		if (cFlr < destFlr) {
//			building.getLiftLobbyOfFlr(cFlr).unpressUpBtn();
//		} else {
//			building.getLiftLobbyOfFlr(cFlr).unpressDownBtn();
//		}
	}
	
	private boolean canPickupOnCurrentRoute(Lift lift, User user) {

	    int pickupFloor = user.getAtFlrNo();

	    Direction userDirection =
	            (user.getDestFlrNo() > pickupFloor)
	            ? Direction.UP
	            : Direction.DOWN;

	    if (lift.isFull())
	        return false;

	    if (lift.getCurDirection() == Direction.STILL)
	        return true;

	    if (lift.getCurDirection() != userDirection)
	        return false;

	    if (userDirection == Direction.UP) {
	        return lift.getCurPosition() <= pickupFloor;
	    } else {
	        return lift.getCurPosition() >= pickupFloor;
	    }
	}
	
	private int estimatePickupTime(Lift lift, User user) {

	    int pickupFloor = user.getAtFlrNo();

	    if (canPickupOnCurrentRoute(lift, user)) {
	        return Math.abs(lift.getCurPosition() - pickupFloor);
	    }

	    // crude estimate for now
	    return Math.abs(lift.getCurPosition() - pickupFloor)
	            + lift.getScheduledStops().size() * 2;
	}
	
	private Lift chooseBestLift(List<Lift> lifts, User user) {

	    Lift bestLift = null;
	    int bestCost = Integer.MAX_VALUE;

	    for (Lift lift : lifts) {

	        if (lift.isFull())
	            continue;

	        int cost = estimatePickupTime(lift, user);

	        if (cost < bestCost) {
	            bestCost = cost;
	            bestLift = lift;
	        }
	    }

	    return bestLift;
	}

}

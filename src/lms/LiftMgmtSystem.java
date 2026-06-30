package lms;

import building.Building;
import lift.Lift;
import lift.LiftController;
import user.User;

public class LiftMgmtSystem {

	public LiftMgmtSystem() {
	}

	public static void main(String[] args) {
		
		Building dlf = new Building(1, 10, 1);
		LiftController controller = new LiftController(dlf);

		controller.assignLift(new User(5, 9));
		controller.assignLift(new User(3, 8));

		Lift lift = dlf.getLifts().get(0);

		for (int i = 0; i < 20; i++) {

		    System.out.println("----- STEP " + i + " -----");

		    lift.step();
		}
		
		
	}

}

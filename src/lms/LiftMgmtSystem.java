package lms;

import building.Building;
import lift.LiftController;
import user.User;

public class LiftMgmtSystem {

	public LiftMgmtSystem() {
	}

	public static void main(String[] args) {
		Building dlf = new Building(1, 10, 1);
		LiftController controller = new LiftController(dlf); //Dependency injection
		
		User u1 = new User(1, 5);
//		dlf.getLiftLobbyOfFlr(1).pressUpBtn();
		
		User u2 = new User(3, 8);
//		dlf.getLiftLobbyOfFlr(3).pressUpBtn();
		
		controller.assignLift(u1);
		controller.assignLift(u2);
		
		
	}

}

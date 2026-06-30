package lift;

import building.Building;
import user.User;

public class LiftController {
	private Building building;

	public LiftController(Building b) {
		building = b;
	}
	
	public void assignLift(User u) {
		int cFlr = u.getAtFlrNo();
		int destFlr = u.getDestFlrNo();
		if (cFlr < destFlr) {
			building.getLiftLobbyOfFlr(cFlr).pressUpBtn();
		} else {
			building.getLiftLobbyOfFlr(cFlr).pressDownBtn();
		}
	}

}

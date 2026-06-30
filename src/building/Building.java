package building;

import java.util.ArrayList;
import java.util.List;

import lift.Lift;

public class Building {
	private int lowestFlr;
	private int topFlr;
	private int totalLifts;
	private List<Lift> lifts;
	private List<LiftLobby> liftLobby;

	public Building(int lFlr, int tFlr, int tLifts) {
		lowestFlr = lFlr;
		topFlr = tFlr;
		totalLifts = tLifts;
		
		lifts = new ArrayList<Lift>();
		for(int i = 1; i <= tLifts; i++) {
			Lift l = new Lift(i, lowestFlr);
			lifts.add(l);
		}
		
		liftLobby = new ArrayList<LiftLobby>();
		for(int m = lowestFlr; m <= topFlr; m++) {
			LiftLobby lb = new LiftLobby(m);
			liftLobby.add(lb);
		}
	}
	
	public int getLowestFlr() {
		return lowestFlr;
	}
	
	public int getTopFlr() {
		return topFlr;
	}
	
	public int getTotalLifts() {
		return totalLifts;
	}
	
	public List<Lift> getLifts() {
		return lifts;
	}
	
	public LiftLobby getLiftLobbyOfFlr(int fNo) {
		return liftLobby.get(fNo);
	}
	
	public List<LiftLobby> getLiftLobby() {
		return liftLobby;
	}
}

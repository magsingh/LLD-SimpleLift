package building;

public class LiftLobby {
	private int floorNo;
	private ButtonState upBtn;
	private ButtonState downBtn;

	public LiftLobby(int fNo) {
		floorNo = fNo;
		upBtn = ButtonState.RELEASED;
		downBtn = ButtonState.RELEASED;
	}
	
	public void pressUpBtn() {
		upBtn = ButtonState.PRESSED;
	}
	
	public void unpressUpBtn() {
		upBtn = ButtonState.RELEASED;
	}
	
	public void pressDownBtn() {
		downBtn = ButtonState.PRESSED;
	}
	
	public void unpressDownBtn() {
		downBtn = ButtonState.RELEASED;
	}

}

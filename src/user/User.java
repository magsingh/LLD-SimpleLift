package user;

public class User {
	private int atFlrNo;
	private int destFlrNo;

	public User(int at, int dest) {
		atFlrNo = at;
		destFlrNo = dest;
	}
	
	public int getAtFlrNo() {
		return atFlrNo;
	}
	
	public int getDestFlrNo() {
		return destFlrNo;
	}
	
	public void setAtFlrNo(int atFlrNo) {
		this.atFlrNo = atFlrNo;
	}
	
	public void setDestFlrNo(int destFlrNo) {
		this.destFlrNo = destFlrNo;
	}
}

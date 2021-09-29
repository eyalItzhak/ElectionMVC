package model;

public class Candidate extends Citizen {
	private Party myParty;

	public Candidate(String name, int tZ, String DateOfBirth, boolean isCoronaSick, Party myParty) throws Exception {
		super(name, tZ, DateOfBirth);
		setMyParty(myParty);
	}

	public Party getMyParty() {
		return myParty;
	}

	public boolean setMyParty(Party myParty) {
		this.myParty = myParty;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + "Is a Candidate for Party: " + myParty.getPartyName()+"\n";
	}
	
	
	
}

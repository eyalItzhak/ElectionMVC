package model;

public abstract class Sick extends Citizen implements SickDisable{

	protected int dayOfSickness;

	public Sick(String name, int tZ, String DateOfBirth, int dayOfSickness) throws Exception {
		super(name, tZ, DateOfBirth);
		this.dayOfSickness = dayOfSickness;
	}

	@Override
	public String toString() {
		return super.toString() + "Is sick for " + dayOfSickness + " days ";
	}

}

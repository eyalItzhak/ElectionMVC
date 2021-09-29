package model;

import java.time.LocalDate;
import java.time.Period;

public class Citizen implements SickEnabale {
	public static final int numOfDigitInTZ = 9;
	public static final int minimumVotingAGE = 18;

	protected String Name;
	protected int TZ;
	protected LocalDate DateOfBirth;

	public Citizen(String name, int tZ, String DateOfBirth) throws Exception {

		setName(name);

		setTZ(tZ);

		setDateOfBirth(DateOfBirth);
	}

	// **************************************//getter and
	// set//**********************************************

	public int getTZ() {
		return TZ;
	}

	public String getName() {
		return Name;
	}

	public LocalDate getDateOfBirth() {
		return DateOfBirth;
	}

	public int getAge() {
		return LocalDate.now().getYear() - (DateOfBirth.getYear());
	}

	public boolean setTZ(int tZ) throws Exception {

		if (tZ >= 100000000 && tZ <= 999999999) {
			this.TZ = tZ;
			return true;
		}
		throw new ExceptionForCitizenTZ("Tz should be " + numOfDigitInTZ + " digits.");

	}

	public boolean setDateOfBirth(String dateOfBirth) throws Exception {

		LocalDate temp = LocalDate.parse(dateOfBirth);
		if (LocalDate.now().getYear() - temp.getYear() > minimumVotingAGE) {
			this.DateOfBirth = temp;

		} else {
			throw new ExceptionForCitizenAGE("Illigal voting age. Citizen was not created");
		}
		return true;
	}

	public boolean setName(String name) {
		this.Name = name;
		return true;
	}

	public boolean equals(Citizen other) {
		if (this.getTZ() == other.getTZ())
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Citizen [Name=" + Name + ", TZ=" + TZ + ", DateOfBirth=" + DateOfBirth + "]\n";
	}

	@Override
	public Citizen getSick() throws Exception {
		SickCitizen deadOrAlive = new SickCitizen(this.Name, this.TZ, this.DateOfBirth.toString(), 0);
		return deadOrAlive;
	}

}

package model;

import java.util.ArrayList;


public class KalpiGeneric<T extends Citizen> {
	private ArrayList<T> allvoters;
	private String address;
	private int numOfVotedPeople;
	private int[] numVotesPerParty;

	public KalpiGeneric(String address) {
		allvoters = new ArrayList<T>();
		this.address = address;
	}

	public void addVoter(T dude) {
		allvoters.add(dude);
	}

	public boolean removeVoter(T dude) {
		for (int i = 0; i < allvoters.size(); i++) {
			if (allvoters.get(i).equals(dude)) {
				allvoters.remove(i);
				return true;
			}
		}
		return false;
	}

	public ArrayList<T> getAllvoters() {
		return allvoters;
	}

	public void setNumOfParties(int numOfParties) {
		this.numVotesPerParty = new int[numOfParties];
	}

	public int[] getNumOfVotesPerParties() {
		return numVotesPerParty;
	}

	public void updateCitizenVoteForParty(int chosenParty) {
		numVotesPerParty[chosenParty]++;
	}

	public void resetData() {
		numOfVotedPeople = 0;
		this.numVotesPerParty = new int[0];
	}

	public int getNumOfVotedPeople() {
		return numOfVotedPeople;
	}

	public void updateNumOfVotedPeople() {
		numOfVotedPeople++;
	}

	public String getAddress() {
		return this.address;
	}

	public String showKalpi() {
		StringBuffer str = new StringBuffer();
		str.append("Kalpi Located in " + address + "\n");
		for (int i = 0; i < allvoters.size(); i++) {
			str.append((i + 1) + " " + allvoters.get(i).toString() + "\n");
		}
		return str.toString();
	}

}

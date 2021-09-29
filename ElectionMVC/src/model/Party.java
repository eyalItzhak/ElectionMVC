package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum ePoliticalBranch {	Left, Right, Center};

public class Party {
	private String partyName;
	private ePoliticalBranch typeOfParty;
	private LocalDate creationDate;
	private List<Candidate> listOfCandidates;

	public Party(String partyName, String typeOfParty, String creationDate) {
		setPartyName(partyName);
		setTypeOfParty(typeOfParty);
		setCreationDate(creationDate);
		listOfCandidates = new ArrayList<>();
	}

	public Party() {
		this("Party of nothing", "Center", "2020-03-04");
	}

	public String getPartyName() {
		return partyName;
	}

	public boolean setPartyName(String partyName) {
		this.partyName = partyName;
		return true;
	}

	public String getTypeOfParty() {
		return typeOfParty.toString();
	}

	public boolean setTypeOfParty(String typeOfParty) {
		this.typeOfParty = ePoliticalBranch.valueOf(typeOfParty);
		return true;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public boolean setCreationDate(String creationDate) {
		this.creationDate = LocalDate.parse(creationDate);
		return true;
	}

	public List<Candidate> getListOfCandidates() {
		return listOfCandidates;
	}
	
	public void addCandidateToParty (Candidate cand) {
		listOfCandidates.add(cand);
	}
	
	public void innerElections () {//primerize, the first one is the winner.
		Collections.shuffle(listOfCandidates);	
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		for(int i=0; i<listOfCandidates.size();i++) {
			str.append( (i+1)+") " +listOfCandidates.get(i).getName()+" ");
		}
		return "Party " + partyName + ", Political brench " + typeOfParty + ", Creation Date=" + creationDate
				+ ", party's candidate: " + str.toString() ;
	}

	public boolean equals(Party obj) {
		if(this.getPartyName().equalsIgnoreCase(obj.getPartyName()))
		   return true;
		return false;
	}
	
	

}

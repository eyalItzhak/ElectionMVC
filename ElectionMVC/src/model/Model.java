package model;

import javafx.scene.Group;

public class Model {
	Input input;
	
	public Model () throws Exception {
		input= new Input();
		input.hardcodedData();
	}
	
	public Input getInput () {
		return input;
	}
	
	public void drawAllParties(Group root) {
		input.showParties(root);
	}
	
	public void drawAllCitizen(Group root) {
		input.showCitizen(root);
	}
	
	public void drawAllKalpi(Group root) {
		input.showKalpi(root);
	}
	
	public void drawKalpiElements(Group root) {
		input.drawKalpiElements(root);
	}
	
	public void drawElectionResult(Group root) {
		input.showElectionResults(root);
	}
	
	public void drawAddCitizinElements(Group root) {
		input.drawAddCitizenElements(root);
		
	}
	
	public void drawKalpiForCitizen(Group root, String name, int id, String birthday, boolean isSick, int numSickDays,
			boolean isCarryWeapon) throws Exception {
		input.drawKalpiForCitizen(root,name,id, birthday, isSick,numSickDays, isCarryWeapon);
	}
	
	public void drawInfoForCandidate(Group root, String name, int id, String birthday, int partychoice) throws Exception {
		
		input.drawKalpiForCandidate(root, name, id, birthday, partychoice);
		
	}
	
	public void createCitizen() {
		input.createCitizen();
	}
	
	public void createCandidate() {
		input.createCandidate();
	}
	
	public void drawAddCandidateElements(Group root) {
		input.drawAddCitizenElements(root);
		input.drawPartyForCandidate(root);
	}
	
	public void drawAddPartyElements(Group root) {
		input.addPartyElements(root);
	}
	
	public void submitElectionResult() {
		input.submitElections();
	}
	
	public void createParty() {
		input.createParty();
	}

	public void drawEleCtionElements(Group root) throws Exception {
		input.drawElection(root);		
	}

	
}

package model;

import javafx.scene.Group;

public interface UI {
	void createKalpi(String type, String Location);
	void createCitizen() throws Exception;
	void createParty();
	void createCandidate() throws Exception;
	void showKalpi(Group root);
	void showParties(Group root);
	void showCitizen(Group root);
	void preformElections() throws Exception;
	void showElectionResults(Group root);
}

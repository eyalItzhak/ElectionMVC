package model;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import java.util.Scanner;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Input implements UI {
	private Scanner scan = new Scanner(System.in);
	private boolean electionsBeenMade;
	private boolean isException = true;
	private int choice;
	private Citizen tempCitizen;
	
	private Text genLabel;
	private ComboBox<String> kalpiType, allParty, partyType;
	private ComboBox<Boolean> isCitizenSick;
	private ComboBox<Integer> numSickDays;
	private TextField kalpiLocation, citizenName, citizenID, partyName;
	private DatePicker citizenBirthday, partyCreationDate;
	private ToggleGroup tg;
	private RadioButton isCarryWeapon, isNotCarryWeapon;
	private ArrayList<ComboBox<String>> citizenVotingOption;
	
	public int getNumOfCitizen() {
		return Excecution_Menegment.allCitizens.getAllCitizen().size();
	}
	
	public ArrayList<ComboBox<String>> getCitizenVotingChoice() {
		return citizenVotingOption;
	}
	
	public String getPartyName() {
		return partyName.getText();
	}
	
	public String getPartyTypeSelected() {
		return partyType.getSelectionModel().getSelectedItem();
	}
	
	public String getPartyCreationDate() {
		return partyCreationDate.getValue().toString();
	}
	
	
	public ComboBox<String> getAllParty(){
		return allParty;
	}
	
	public ComboBox<String> getKalpiType() {
		return kalpiType;
	}
	
	public String getCitizenName() {
		return citizenName.getText();
	}
	
	public int getCitizenId() {
		return Integer.parseInt(citizenID.getText());
	}
	
	public String getBirthdayCitizen() {
		return citizenBirthday.getValue().toString();
	}
	
	public boolean getIsSick() {
		return isCitizenSick.getValue();
	}
	
	public int getNumSickDays() {
		return numSickDays.getValue();
	}
	
	public boolean isCarryWeapon() {
		if(isCarryWeapon.isSelected())
			return true;
		return false;
	}
	
	public String getKalpitype() {
		return kalpiType.getValue();
	}
	
	public String getKalpiLocation() {
		return kalpiLocation.getText();
	}

	public void hardcodedData() throws Exception {
		
		Excecution_Menegment.addNewKalpi("Citizen", "batyam"); //noram kalpi
		Excecution_Menegment.addNewKalpi("Sick Citizen", "Tel aviv"); //corna kalpi
		Excecution_Menegment.addNewKalpi("Soldier", "Jerusalem"); //soldier
		Excecution_Menegment.addNewKalpi("Sick Soldier", "Haifa"); //sick soldier
		
		
		Citizen dudu1 = Excecution_Menegment.addCitizen("iron maiden", "1990-10-10",1990, 564765545,false, false, 0 );
		Excecution_Menegment.addCitizenToKalpi(dudu1, 0);
		Citizen dudu2 = Excecution_Menegment.addCitizen("pink floyd", "1990-10-10",1990, 645535643,false, true, 10);
		Excecution_Menegment.addCitizenToKalpi(dudu2, 0);
		Citizen dudu3 = Excecution_Menegment.addCitizen("dream theater", "1990-10-10",1990, 645535644,false, false, 0);
		Excecution_Menegment.addCitizenToKalpi(dudu3, 0);
		Citizen dudu4 = Excecution_Menegment.addCitizen("dire straits", "2000-10-10",2000, 645535645,true,false, 5);
		Excecution_Menegment.addCitizenToKalpi(dudu4, 0);
		Citizen dude5 = Excecution_Menegment.addCitizen("gun n roses", "2000-10-10",2000, 645535646,false, true, 7);
		Excecution_Menegment.addCitizenToKalpi(dude5, 0);

		Excecution_Menegment.addParty("Havoda", "Left", "1948-06-07");
		Excecution_Menegment.addParty("Likud", "Right", "1949-06-07");
		Candidate cand1= Excecution_Menegment.addCandidate("bibi", 111111111, "1956-10-01",1);
		Excecution_Menegment.addCitizenToKalpi(cand1, 0);

		Candidate cand2=Excecution_Menegment.addCandidate("Rabin", 456378442, "1913-09-08",0);
		Excecution_Menegment.addCitizenToKalpi(cand2, 0);
	}

	
	@Override
	public void createKalpi(String type, String Location) {
		Excecution_Menegment.addNewKalpi(type, Location);
	}
	
	public void drawKalpiElements(Group root) {
		
		Text kalpiTypeMessege= new Text("Which type of kalpi you want?");
		kalpiTypeMessege.setLayoutX(-170);
		kalpiTypeMessege.setLayoutY(-10);
		kalpiTypeMessege.setFont(new Font(15));
		
		
		kalpiType= new ComboBox<String>();
		kalpiType.getItems().addAll("Citizen", "Sick Citizen", "Soldier", "Sick Soldier");
		kalpiType.setValue("Citizen");
		kalpiType.setLayoutX(130);
		kalpiType.setLayoutY(-30);
		
		Text kalpiLocationMessege = new Text("\nWhere the Kalpi located?");
		kalpiLocationMessege.setLayoutX(-170);
		kalpiLocationMessege.setLayoutY(20);
		kalpiLocationMessege.setFont(new Font(15));
		
		kalpiLocation = new TextField();
		kalpiLocation.setLayoutX(130);
		kalpiLocation.setLayoutY(25);
		
		root.getChildren().addAll( kalpiTypeMessege,kalpiType,kalpiLocationMessege,kalpiLocation);
				
		
	}
	

	public void drawAddCitizenElements(Group root) {
		Text citizenNameMessege = new Text("Citizen Name: ");
		citizenNameMessege.setFont(new Font (15));
		citizenNameMessege.setLayoutX(-120);
		citizenNameMessege.setLayoutY(-400);
		
		citizenName = new TextField();
		citizenName.setLayoutX(140);
		citizenName.setLayoutY(-415);
		
		Text citzenBirthdayMessege= new Text("Citizen Date of birth: ");
		citzenBirthdayMessege.setFont(new Font(15));
		citzenBirthdayMessege.setLayoutX(-120);
		citzenBirthdayMessege.setLayoutY(-355);
		
		citizenBirthday = new DatePicker();
		citizenBirthday.setLayoutX(140);
		citizenBirthday.setLayoutY(-370);
		
		Text citizenIdMessege = new Text("ID: ");
		citizenIdMessege.setFont(new Font(15));
		citizenIdMessege.setLayoutX(-120);
		citizenIdMessege.setLayoutY(-310);
		
		citizenID= new TextField();
		citizenID.setLayoutX(140);
		citizenID.setLayoutY(-325);
		
		Text citizenIsSickMessege = new Text("Is it true that The Citizen Sick?");
		citizenIsSickMessege.setFont(new Font(15));
		citizenIsSickMessege.setLayoutX(-120);
		citizenIsSickMessege.setLayoutY(-265);
		
		isCitizenSick = new ComboBox<Boolean>();
		isCitizenSick.getItems().addAll(true, false);
		isCitizenSick.setValue(false);
		isCitizenSick.setLayoutX(140);
		isCitizenSick.setLayoutY(-285);
		
		Text citizenSickDaysMessege = new Text("How many days the citizen Sick?");
		citizenSickDaysMessege.setFont(new Font(15));
		citizenSickDaysMessege.setLayoutX(-120);
		citizenSickDaysMessege.setLayoutY(-220);
		
		numSickDays= new ComboBox<Integer>();
		for(int i=0; i<100;i++) {
			numSickDays.getItems().add(i);
		}
		numSickDays.setValue(0);
		numSickDays.visibleRowCountProperty().setValue(10);
		numSickDays.setLayoutX(140);
		numSickDays.setLayoutY(-240);
		
		
		Text citizenCarryWeaponMessege = new Text("Does the citizen carry weapon? ");
		citizenCarryWeaponMessege.setFont(new Font(15));
		citizenCarryWeaponMessege.setLayoutX(-120);
		citizenCarryWeaponMessege.setLayoutY(-175);
		
		tg= new ToggleGroup();
		
		isCarryWeapon= new RadioButton(" Have Weapon ");
		isCarryWeapon.setLayoutX(140);
		isCarryWeapon.setLayoutY(-195);
		
		isNotCarryWeapon= new RadioButton(" Dont have Weapon ");
		isNotCarryWeapon.setLayoutX(250);
		isNotCarryWeapon.setLayoutY(-195);
		isNotCarryWeapon.setSelected(true);
		
		isCarryWeapon.setToggleGroup(tg);
		isNotCarryWeapon.setToggleGroup(tg);
		
		
		
		root.getChildren().addAll(citizenNameMessege, citizenName,citzenBirthdayMessege, citizenBirthday,
				citizenIdMessege, citizenID,citizenIsSickMessege, isCitizenSick,citizenSickDaysMessege,numSickDays,
				citizenCarryWeaponMessege, isCarryWeapon, isNotCarryWeapon	);
		
	}
	
	public void drawKalpiForCitizen(Group root, String name, int id, String birthday, boolean isSick, int numSickDays,
			boolean isCarryWeapon) throws Exception {
		int year= Integer.parseInt(birthday.substring(0, 3));
		tempCitizen = Excecution_Menegment.addCitizen(name, birthday, year, id, isCarryWeapon, isSick, numSickDays);
		
		Text assigneKalpiMessege= new Text("Assigne a Kalpi For Citizen:");
		assigneKalpiMessege.setFont(new Font(15));
		assigneKalpiMessege.setLayoutX(-120);
		assigneKalpiMessege.setLayoutY(20);
		 
		
		kalpiType = new ComboBox<String>();
		String value = Excecution_Menegment.showAvailableKalpi(tempCitizen);
		String[] allvalue= value.split("\n");
		 
		kalpiType.getItems().addAll(allvalue);
		
		kalpiType.setLayoutX(140);
		kalpiType.setLayoutY(5);
		
		root.getChildren().addAll(kalpiType, assigneKalpiMessege);
		 
		
	}
	
	@Override
	public void createCitizen() {
		int kalpiCoice = kalpiType.getSelectionModel().getSelectedIndex();
		Excecution_Menegment.addCitizenToKalpi(tempCitizen, kalpiCoice);
		
		Alert a= new Alert(AlertType.INFORMATION);
		a.setContentText("Citizen Has Been Created");
		a.show();
	}

	public void addPartyElements(Group root) {
		Text partyNameMessege = new Text("Enter Party's name: ");
		partyNameMessege.setFont(new Font(15));
		partyNameMessege.setLayoutX(-120);
		partyNameMessege.setLayoutY(-300);
		
		partyName = new TextField();
		partyName.setLayoutX(140);
		partyName.setLayoutY(-315);
		
		Text partyTypeMessege = new Text("Please Select party's Political Branch: ");
		partyTypeMessege.setFont(new Font(15));
		partyTypeMessege.setLayoutX(-120);
		partyTypeMessege.setLayoutY(-250);
		
		partyType = new ComboBox<String>();
		partyType.getItems().addAll("Left", "Right", "Center");
		partyType.setLayoutX(140);
		partyType.setLayoutY(-265);
		
		Text partyDateCreationMessege = new Text("Select party's creation date: ");
		partyDateCreationMessege.setFont(new Font(15));
		partyDateCreationMessege.setLayoutX(-120);
		partyDateCreationMessege.setLayoutY(-200);
		
		partyCreationDate = new DatePicker();
		partyCreationDate.setLayoutX(140);
		partyCreationDate.setLayoutY(-215);
		
		root.getChildren().addAll(partyNameMessege, partyName, partyTypeMessege, partyType, partyDateCreationMessege, partyCreationDate);
		
		
	}
	@Override
	public void createParty() {
		String nameParty= getPartyName();
		String typeParty= getPartyTypeSelected();
		String dateCreationParty= getPartyCreationDate();
		
		Excecution_Menegment.addParty(nameParty, typeParty, dateCreationParty);
		
		Alert a= new Alert(Alert.AlertType.INFORMATION);
		a.setContentText("Party been Created!");
		a.show();

	}
	
	public void drawPartyForCandidate(Group root) {
		
		Text assignePartyMessege = new Text("Please Choose Party for the Candidate: ");
		assignePartyMessege.setFont(new Font(15));
		assignePartyMessege.setLayoutX(-120);
		assignePartyMessege.setLayoutY(-125);
		
		allParty= new ComboBox<String>();
		
		
		for(int i =0; i<Excecution_Menegment.partyList.size();i++) {
			allParty.getItems().addAll(Excecution_Menegment.partyList.get(i).getPartyName());	
		}
		
		
		allParty.setLayoutX(140);
		allParty.setLayoutY(-140);
		
		root.getChildren().addAll(assignePartyMessege, allParty);
		
		
	}
	public void drawKalpiForCandidate(Group root, String name, int id, String birthday,int partyChoice) throws Exception {
		tempCitizen = Excecution_Menegment.addCandidate(name, id, birthday, partyChoice);
		
		Text assigneKalpiMessege= new Text("Assigne a Kalpi For Candidate:");
		assigneKalpiMessege.setFont(new Font(15));
		assigneKalpiMessege.setLayoutX(-120);
		assigneKalpiMessege.setLayoutY(20);
		 
		
		kalpiType = new ComboBox<String>();
		String value = Excecution_Menegment.showAvailableKalpi(tempCitizen);
		String[] allvalue= value.split("\n");
		 
		kalpiType.getItems().addAll(allvalue);
		
		kalpiType.setLayoutX(140);
		kalpiType.setLayoutY(5);
		
		root.getChildren().addAll(kalpiType, assigneKalpiMessege);
		
	}
	@Override
	public void createCandidate() {
		int choice= kalpiType.getSelectionModel().getSelectedIndex();
		
		Excecution_Menegment.addCitizenToKalpi(tempCitizen, choice);
		
		Alert a = new Alert(AlertType.INFORMATION);
		a.setContentText("Candidate has been added! ");
		a.show();
	}
	
	@Override
	public void showKalpi(Group root) {
		genLabel= new Text();
		
		genLabel.setText(Excecution_Menegment.showAllKalpi());
		genLabel.setFont(new Font(15));
		root.getChildren().add(genLabel);
	}
	
	@Override
	public void showParties(Group root) {
		genLabel= new Text();
		genLabel.setText(Excecution_Menegment.showAllParties());
		genLabel.setFont(new Font(15));
		root.getChildren().add(genLabel);
		
	}

	@Override	
	public void showCitizen(Group root) {
		genLabel= new Text();
		genLabel.setText(Excecution_Menegment.showAllCitizence());
		genLabel.setFont(new Font(15));
		root.getChildren().add(genLabel);
	}
	
	public void drawElection(Group root) throws Exception {
		Excecution_Menegment.preElction();
		
		citizenVotingOption= new ArrayList<ComboBox<String>>();
		ComboBox<String> tempCombo = new ComboBox<String>();
		genLabel= new Text();
		
		
		VBox vb= new VBox();
		tempCombo.getItems().add("Not Voting");
		for(int i =0; i<Excecution_Menegment.partyList.size();i++) {
			tempCombo.getItems().addAll(Excecution_Menegment.partyList.get(i).getPartyName());	
		}
		
		
		
		String allCitize="";
		for(int i=0; i<Excecution_Menegment.allCitizens.getAllCitizen().size();i++) {
			allCitize= allCitize +("Citizen " +Excecution_Menegment.allCitizens.getAllCitizen().get(i).getName() + " vote: \n\n\n");
			citizenVotingOption.add(new ComboBox<String>());
			citizenVotingOption.get(i).setValue("Not Voting");
			citizenVotingOption.get(i).getItems().addAll(tempCombo.getItems());
			
			vb.getChildren().add(citizenVotingOption.get(i));
			vb.setLayoutX(60);
			vb.setLayoutY(-40);
			VBox.setMargin(citizenVotingOption.get(i), new Insets(20,10,15,10));
		}
		
		
		genLabel.setText(allCitize);
		genLabel.setFont(new Font(15));
		genLabel.setLayoutX(-200);
		root.getChildren().addAll(genLabel, vb);
		
		
	}
	
	@Override
	public void preformElections() throws Exception {
		System.out.println("Election");
		Excecution_Menegment.preElction();
		allKalpyElction();
		electionsBeenMade=true;
		System.out.println("ELECTIONS BEEN MADE!");
	}
	

	@Override
	public void showElectionResults(Group root) {
		genLabel= new Text();
		if (electionsBeenMade == true) {
			genLabel.setText(Excecution_Menegment.ShowKalpiResult());
		} else {
			Alert a = new Alert(Alert.AlertType.ERROR);  
			a.setContentText("THERE IS NO RESULT BEFORE THE ELECTIONS!!!");
			a.show();
		

		}
		genLabel.setFont(new Font(15));
		root.getChildren().add(genLabel);

	}
	

	public void submitElections() {
		allKalpyElction();
		
		Alert a = new Alert(AlertType.INFORMATION);
		a.setContentText("Elections Been Made");
		a.show();
		
		electionsBeenMade=true;
	}
	
	
	private void allKalpyElction() {
		for (int i = 0; i < Excecution_Menegment.allCitizenKalpi.size(); i++) {
			InkalpyElction(Excecution_Menegment.allCitizenKalpi.get(i));
		}
		for (int i = 0; i < Excecution_Menegment.allSickCitizenKalpi.size(); i++) {
			InkalpyElction(Excecution_Menegment.allSickCitizenKalpi.get(i));
		}
		for (int i = 0; i < Excecution_Menegment.allSoldierKalpi.size(); i++) {
			InkalpyElction(Excecution_Menegment.allSoldierKalpi.get(i));
		}
		for (int i = 0; i < Excecution_Menegment.allSickSoldierKalpi.size(); i++) {
			InkalpyElction(Excecution_Menegment.allSickSoldierKalpi.get(i));
		}
	}
	
	
	private void InkalpyElction(KalpiGeneric kalpy) {
		ArrayList<Citizen> listOfVoter=kalpy.getAllvoters();
		int vote=0;
		for(int i=0;i<Excecution_Menegment.allCitizens.getAllCitizen().size();i++) {
			for(int j=0;j<listOfVoter.size();j++) {
				if(Excecution_Menegment.allCitizens.getAllCitizen().get(i).equals(listOfVoter.get(j))) {
					vote = citizenVotingOption.get(i).getSelectionModel().getSelectedIndex();
					if(vote==0)
						continue;
					kalpy.updateNumOfVotedPeople();
					kalpy.updateCitizenVoteForParty(vote-1);
				
				}
			}
		}
		
	}
	
}

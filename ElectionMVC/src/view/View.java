package view;

import javafx.geometry.HPos;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class View {

	private Group root;
	private BorderPane bp;
	private Label headline;
	private ComboBox<String> comboOptions;
	private HBox hbUp, hbDown;
	// private VBox vbdownInRoot;
	private Button btnExit, btnCreatKalpi, btnSubmitCitizen, btncreateCitizen, btnCreateCandidate,
	btnSubmitCandidate, btnCreateParty, btnSubmitElectionResult;
	private Stage theStage;
	private ScrollPane scroll;
	//private boolean isCandidate;

	public View(Stage stage) {

		root = new Group();

		theStage = stage;

		// HeadLINE
		headline = new Label("     		 Welcome to elections!\n Please Choose the activity\n ");
		headline.setFont(new Font(30));

		// Combobox
		comboOptions = new ComboBox<String>();
		String def = "---------------------------";
		comboOptions.getItems().addAll(def, "Add Kalpi", "Add Citizen", "Add Party", "Add Candidate", "Show all Kalpis",
				"Show all Citizen", "Show all Parties", "Preform Elections", "Show election result");
		comboOptions.setValue(def);

		hbUp = new HBox();
		hbUp.setAlignment(Pos.CENTER);
		hbUp.getChildren().addAll(headline, comboOptions);
		HBox.setMargin(comboOptions, new Insets(10, 10, 10, 10));

		// exit button
		hbDown = new HBox();
		btnExit = new Button(" Exit ");
		btnExit.setTextFill(Color.RED);
		btnExit.setFont(new Font(15));
		btnExit.setAlignment(Pos.CENTER);
		hbDown.setAlignment(Pos.CENTER);
		hbDown.getChildren().add(btnExit);
		HBox.setMargin(btnExit, new Insets(10, 10, 20, 10));

		btnCreatKalpi = new Button(" Create Kalpi ");
		// double x= btnCreatKalpi.getLayoutX();
		// btnCreatKalpi.setLayoutY(-400);
		btnCreatKalpi.setAlignment(Pos.BOTTOM_CENTER);

		// root.getChildren().add(btnCreatKalpi);

		btnCreatKalpi = new Button("Create Kalpi");
		btnSubmitCitizen = new Button("Submit citizen");
		btncreateCitizen = new Button("Create Citizen");
		btnCreateCandidate = new Button("Create Candidate");
		btnSubmitCandidate = new Button("Submit Candidate");
		btnCreateParty= new Button("Create Party");
		btnSubmitElectionResult = new Button("Submit Voting");
		
		bp = new BorderPane();
		bp.setTop(hbUp);
		bp.setCenter(root);
		bp.setBottom(hbDown);

		scroll = new ScrollPane(bp);
		scroll.fitToHeightProperty().set(true);

		Scene scene = new Scene(scroll, 700, 700);
		stage.setScene(scene);
		stage.show();

	}

	public void update(Model m, String actionID) throws Exception {
		root.getChildren().clear();
		
		switch (actionID) {
		case "Show all Parties":
			m.drawAllParties(root);
			break;

		case "Show all Citizen":
			m.drawAllCitizen(root);
			break;

		case "Show all Kalpis":
			m.drawAllKalpi(root);
			break;

		case "Add Kalpi":
			m.drawKalpiElements(root);

			btnCreatKalpi.setLayoutY(100);
			root.getChildren().add(btnCreatKalpi);
			break;

		case "Add Citizen":
			m.drawAddCitizinElements(root);

			btnSubmitCitizen.setLayoutY(-100);
			btnSubmitCitizen.setLayoutX(80);
			root.getChildren().add(btnSubmitCitizen);
			// btncreateCitizen.setLayoutY(-100);
			// root.getChildren().add(btncreateCitizen);
			break;

		case "Show election result":
			m.drawElectionResult(root);
			break;
		case "Add Candidate":
			
			m.drawAddCandidateElements(root);
			
			
			btnSubmitCandidate.setLayoutY(-50);
			btnSubmitCandidate.setLayoutX(80);
			root.getChildren().add(btnSubmitCandidate);

			break;
			
		case "Add Party":
			m.drawAddPartyElements(root);
			
			btnCreateParty.setLayoutX(60);
			btnCreateParty.setLayoutY(-100);
			root.getChildren().add(btnCreateParty);
			break;
			
		case "Preform Elections":
			m.drawEleCtionElements(root);
			double mesure = m.getInput().getNumOfCitizen();
			btnSubmitElectionResult.setLayoutX(-65);
			btnSubmitElectionResult.setLayoutY(350+mesure*20);
			root.getChildren().add(btnSubmitElectionResult);
			break;
		}

	}
	public void addEventHandlerToExitButton(EventHandler<ActionEvent> eventForExitButton) {
		btnExit.setOnAction(eventForExitButton);
	}

	public Stage getStage() {
		return theStage;
	}

	public void addChangeListenerToComboBoxOption(ChangeListener<String> cl) {
		comboOptions.valueProperty().addListener(cl);
	}

	public void addEventHandlerToCreateKalpiButton(EventHandler<ActionEvent> eventForCreateKalpi) {

		btnCreatKalpi.setOnAction(eventForCreateKalpi);
	}

	public void addEventHandlertoSumbitCitizenButton(EventHandler<ActionEvent> eventForSubmitCitizen) {
		
		btnSubmitCitizen.setOnAction(eventForSubmitCitizen);

	}

	public void updateKalpiInfoToCitizen(Model m, String name, int id, String birthday, boolean isSick, int numSickDays,
			boolean isCarryWeapon) throws Exception {
		m.drawKalpiForCitizen(root, name, id, birthday, isSick, numSickDays, isCarryWeapon);

	}
	
	public void updateInfoToCandidate (Model m, String name, int id, String birthday,int partyChoice) throws Exception
	{
		m.drawInfoForCandidate(root, name, id, birthday, partyChoice);
	}
	public void setCreatCitizenButton() {
		btncreateCitizen.setLayoutX(btnSubmitCitizen.getLayoutX());
		btncreateCitizen.setLayoutY(btnSubmitCitizen.getLayoutY() + 200);
		root.getChildren().add(btncreateCitizen);

	}

	public void addEventHandlerToCreateCitizenButton(EventHandler<ActionEvent> eventForCreateCitizen) {
		btncreateCitizen.setOnAction(eventForCreateCitizen);
	}
	
	public void addEventHandlerToSubmitCandidate(EventHandler<ActionEvent> eventForSubmitCandidate) {
		btnSubmitCandidate.setOnAction(eventForSubmitCandidate);
	}

	public void setCreatCandidateButton() {
		btnCreateCandidate.setLayoutX(btnSubmitCandidate.getLayoutX());
		btnCreateCandidate.setLayoutY(btnSubmitCandidate.getLayoutY()+150);
		root.getChildren().add(btnCreateCandidate);
		
	}
	
	public void addEventHandlerToCreateCandidateButton(EventHandler<ActionEvent> eventForCreateCandidate) {
		btnCreateCandidate.setOnAction(eventForCreateCandidate);
	}
	
	public void addEventHandlerToCreatePartyButton(EventHandler<ActionEvent> eventForCreateParty) {
		btnCreateParty.setOnAction(eventForCreateParty);
	}
	
	public void addEventHandlerForSubmitELECTIONButton(EventHandler<ActionEvent> eventforSubmitElection) {
		btnSubmitElectionResult.setOnAction(eventforSubmitElection);
	}
}

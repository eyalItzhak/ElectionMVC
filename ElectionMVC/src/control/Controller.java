package control;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import model.Excecution_Menegment;
import model.Model;
import view.View;

public class Controller {
	
	private View theView;
	private Model theModel;
	
	public Controller ( Model m,View v) {
		theModel= m;
		theView= v;
		
		EventHandler<ActionEvent> eventForExitButton= new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				theView.getStage().close();
			
				
			}
			
		};
		//theView.update(theModel);
		theView.addEventHandlerToExitButton(eventForExitButton);
		
		ChangeListener<String> EventForActionOptions = new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					theView.update(theModel, newValue);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
			}
			
		};
		theView.addChangeListenerToComboBoxOption(EventForActionOptions);
		
		EventHandler<ActionEvent> eventForCreateKalpi = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String location =theModel.getInput().getKalpiLocation();
				String type = theModel.getInput().getKalpitype();
				theModel.getInput().createKalpi(type, location);
				
				Alert a = new Alert(Alert.AlertType.INFORMATION);  //INFORMATION);
				a.setContentText("Kalpi for " + type + " been created in " + location);
				a.show();
				
			}
			
		};
		theView.addEventHandlerToCreateKalpiButton(eventForCreateKalpi);
		
		EventHandler<ActionEvent> eventForSubmitCitizen = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String name = theModel.getInput().getCitizenName();
				int id = theModel.getInput().getCitizenId();
				String birthday= theModel.getInput().getBirthdayCitizen();
				boolean isSick = theModel.getInput().getIsSick();
				int numSickDays= theModel.getInput().getNumSickDays();
				boolean isCarryWeapon = theModel.getInput().isCarryWeapon();
				
				//Citizen newMan =// Excecution_Menegment.addCitizen(name, Birthday,year, TZ, isCarryWeapon, isSick, sicknessDays);
				
				//if(name ==null || id<0 ||birthday==null) {
					//theView.getSublitButton().setDisable(true);
				//} else {
					//theView.getSublitButton().setDisable(false);
				//}
				
				try {
					theView.updateKalpiInfoToCitizen(m,name,id, birthday, isSick,numSickDays, isCarryWeapon);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
				theView.setCreatCitizenButton();
				
			}
			
		};
		theView.addEventHandlertoSumbitCitizenButton(eventForSubmitCitizen);
		
		EventHandler<ActionEvent> eventForCreateCitizen = new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				theModel.createCitizen();
			}
		};
		theView.addEventHandlerToCreateCitizenButton(eventForCreateCitizen);
		
		EventHandler<ActionEvent> eventForSubmitCandidate= new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String name = theModel.getInput().getCitizenName();
				int id = theModel.getInput().getCitizenId();
				String birthday= theModel.getInput().getBirthdayCitizen();
				int partyChoice = theModel.getInput().getAllParty().getSelectionModel().getSelectedIndex();

				try {
					theView.updateInfoToCandidate(m,name,id, birthday,partyChoice );
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
				
				theView.setCreatCandidateButton();
				
				
			}
			
		};theView.addEventHandlerToSubmitCandidate(eventForSubmitCandidate);
		
		EventHandler<ActionEvent> eventForCreateCandidate= new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				theModel.createCandidate();
				
			}
		}; theView.addEventHandlerToCreateCandidateButton(eventForCreateCandidate);
		
		EventHandler <ActionEvent> eventForCreateParty = new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				theModel.createParty();
				
			}
		};
		theView.addEventHandlerToCreatePartyButton(eventForCreateParty);
		
		EventHandler<ActionEvent> eventforSubmitElection = new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				theModel.submitElectionResult();
				
			}
		}; theView.addEventHandlerForSubmitELECTIONButton(eventforSubmitElection);
	}
	
	
	

	
}

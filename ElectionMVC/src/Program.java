import control.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import view.View;

public class Program extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage Stage) throws Exception {
		Model theModel = new Model();
		View theView = new View(Stage);
		Controller theControl = new Controller(theModel, theView);
		
	}

}

package rockPaperScissorMain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RockPaperScissor extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// Load the FXML file.
		Parent parent = FXMLLoader.load(getClass().getResource("RockPaperScissors.fxml"));

		// Build the scene graph
		Scene scene = new Scene(parent);

		// Display our window, using the scene graph.
		stage.setTitle("Rock, paper, scissors!");
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
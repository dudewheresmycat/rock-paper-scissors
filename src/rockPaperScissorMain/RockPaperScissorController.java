package rockPaperScissorMain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class RockPaperScissorController {
	// save player's first inputs to compare for winner
	private String p1in = "";
	private String p2in = "";
	private String firstkey = "";
	private String secondkey = "";
	private int p1score=0;
	private int p2score=0;
	private int count=0;
	@FXML
    private Button resetGame;
	@FXML
	private ImageView player2image;

	@FXML
	private Label winnerLabel;

	@FXML
	private ImageView player1image;
    @FXML
    private Label pl2score;

    @FXML
    private Label pl1score;

	@FXML
	void keyListener(KeyEvent key) {
		if(count <2){
		firstkey = key.getText();
		if(!(firstkey.equalsIgnoreCase("a")||firstkey.equalsIgnoreCase("s")||firstkey.equalsIgnoreCase("d"))){
			firstkey = key.getText();
		}
		secondkey = key.getText();	
		if(!(secondkey.equalsIgnoreCase("j")||secondkey.equalsIgnoreCase("k")||secondkey.equalsIgnoreCase("l"))){
			secondkey = key.getText();	
		}
		if(!(firstkey.equals("") && secondkey.equals(""))){
			gameLogic();
			
		}
		count++;
		}
		
		
	}
	@FXML
	void buttonListener(ActionEvent event) {
		p1in="";
		p2in="";
		firstkey = "";
		secondkey = "";
		player1image.setImage(null);
		player2image.setImage(null);
		winnerLabel.setText(null);
		count=0;
	}
	private void gameLogic(){
		// first if to create image of player's inputs
				if (firstkey.toString().equalsIgnoreCase("a")) {
					p1in = "rock";
				} else if (firstkey.toString().equalsIgnoreCase("s")) {
					p1in = "paper";
				} else if (firstkey.toString().equalsIgnoreCase("d")) {
					p1in = "scissors";
				} 
				//set image on p2 input
				if (secondkey.toString().equalsIgnoreCase("j")) {
					p2in = "rock";
				} else if (secondkey.toString().equalsIgnoreCase("k")) {
					p2in = "paper";
				} else if (secondkey.toString().equalsIgnoreCase("l")) {
					p2in = "scissors";
				}
				//shows images after both ifs run
				
				// second if to compare player's inputs
				// tie case
				if ((p1in.equals(p2in))) {

					winnerLabel.setText("Its a TIE!");
					Image p1 = new Image(getClass().getResourceAsStream(p1in+".png"));
					player1image.setImage(p1);
					Image p2 = new Image(getClass().getResourceAsStream(p2in+".png"));
					player2image.setImage(p2);
					// p1 wins cases
				} else if ((p1in.equals("rock") && p2in.equals("scissors"))
						|| (p1in.equals("paper") && p2in.equals("rock"))
						|| (p1in.equals("scissors") && p2in.equals("paper"))) {
					winnerLabel.setText("Player 1 Wins!");
					Image p1 = new Image(getClass().getResourceAsStream(p1in+".png"));
					player1image.setImage(p1);
					Image p2 = new Image(getClass().getResourceAsStream(p2in+".png"));
					player2image.setImage(p2);
					p1score++;
					pl1score.setText(""+p1score);
					// p2 wins cases
				} else if ((p1in.equals("rock") && p2in.equals("paper"))
						|| (p1in.equals("paper") && p2in.equals("scissors"))
						|| (p1in.equals("scissors") && p2in.equals("rock"))) {
					winnerLabel.setText("Player 2 Wins!");
					Image p1 = new Image(getClass().getResourceAsStream(p1in+".png"));
					player1image.setImage(p1);
					Image p2 = new Image(getClass().getResourceAsStream(p2in+".png"));
					player2image.setImage(p2);
					p2score++;
					pl2score.setText(""+p2score);
				}
	}
}
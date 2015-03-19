package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Game;

public class GamePanel extends JPanel implements Observer {
	private JLabel playerLabel = new JLabel("Player : ");
	private JLabel scoreLabel = new JLabel("Score : ");
	private JLabel player = new JLabel();
	private JLabel score = new JLabel();
	private JPanel playerPan = new JPanel();
	private JPanel scorePan = new JPanel();
	private Game currentGame;
	
	public GamePanel(Game currentGame){
		//Link to the model
		this.currentGame = currentGame;
		this.currentGame.addObserver(this);
		//Set Layouts
		this.setLayout(new GridLayout(2,1));
		this.playerPan.setLayout(new BorderLayout());
		this.scorePan.setLayout(new BorderLayout());
		
		this.playerPan.add(this.playerLabel, BorderLayout.WEST);
		this.playerPan.add(this.player, BorderLayout.CENTER);
		
		this.scorePan.add(this.scoreLabel, BorderLayout.WEST);
		this.scorePan.add(this.score, BorderLayout.CENTER);
		
		this.add(playerPan);
		this.add(scorePan);
	
	}

	@Override
	public void update(Observable o, Object arg) {
		this.player.setText(this.currentGame.getPlayer(this.currentGame.getCurrentPlayer()).getName());
		this.score.setText(Integer.toString(this.currentGame.getPlayer(this.currentGame.getCurrentPlayer()).getScore()));
		
	}

}

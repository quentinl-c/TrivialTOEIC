package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Game;

public class GamePanel extends JPanel implements Observer {
	private JLabel playerLabel = new JLabel("Player : ");
	private JLabel scoreLabel = new JLabel("Score : ");
	private JLabel nextPlayerLabel = new JLabel("Next player : ");
	private JLabel statLabel = new JLabel("Stat : ");
	
	private JLabel player = new JLabel();
	private JLabel score = new JLabel();
	private JLabel nextPlayer = new JLabel();
	private JLabel stat = new JLabel();
	
	private JPanel playerPan = new JPanel();
	private JPanel scorePan = new JPanel();
	private JPanel nextPlayerPan = new JPanel();
	private JPanel statPan = new JPanel();
	private Game currentGame;
	
	
	public GamePanel(Game currentGame){
		//Link to the model
		this.currentGame = currentGame;
		this.currentGame.addObserver(this);
		//Set Layouts
		this.setLayout(new GridLayout(4,1));
		this.playerPan.setLayout(new BorderLayout());
		this.scorePan.setLayout(new BorderLayout());
		this.nextPlayerPan.setLayout(new BorderLayout());
		this.statPan.setLayout(new BorderLayout());
		
		
		this.playerPan.add(this.playerLabel, BorderLayout.WEST);
		this.playerPan.add(this.player, BorderLayout.CENTER);
		
		this.scorePan.add(this.scoreLabel, BorderLayout.WEST);
		this.scorePan.add(this.score, BorderLayout.CENTER);
		
		this.nextPlayerPan.add(this.nextPlayerLabel, BorderLayout.WEST);
		this.nextPlayerPan.add(this.nextPlayer, BorderLayout.CENTER);
		
		this.statPan.add(this.statLabel, BorderLayout.WEST);
		this.statPan.add(this.stat, BorderLayout.CENTER);
		
		this.add(playerPan);
		this.add(scorePan);
		this.add(statPan);
		this.add(nextPlayerPan);
	
	}

	@Override
	public void update(Observable o, Object arg) {
		this.player.setText(this.currentGame.getPlayer(this.currentGame.getCurrentPlayer()).getName());
		
		switch(this.currentGame.getPlayer(this.currentGame.getCurrentPlayer()).getColor()){
		case "yellow":
			this.player.setForeground(Color.ORANGE);
			break;
		case "red":
			this.player.setForeground(Color.red);
			break;
		case "blue":
			this.player.setForeground(Color.blue);
			break;
		case "green":
			this.player.setForeground(Color.green);
			break;
		default :
			break;
		}
		this.score.setText(Integer.toString(this.currentGame.getPlayer(this.currentGame.getCurrentPlayer()).getScore()));
		this.nextPlayer.setText(this.currentGame.getNextPlayer());
		this.stat.setText(this.currentGame.getStat());
	}

}

package uniandes.dpoo.taller4.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class BottomInfoPanel extends JPanel {
    private String playerName = "";
    private String numberOfMoveString = "";
    private GameInfoLabel movesLabel;
    private GameInfoLabel playerNameLabel;

    public BottomInfoPanel() {
        this.setBounds(0, 668, 1024, 50);
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        
        movesLabel = new GameInfoLabel("Jugadas", numberOfMoveString);
        playerNameLabel = new GameInfoLabel("Jugador", playerName);
        this.add(movesLabel);
        this.add(playerNameLabel);
        movesLabel.setPreferredSize(new Dimension(500, 40));
        playerNameLabel.setPreferredSize(new Dimension(500, 40));
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
        playerNameLabel.setValue(playerName);
    }

    public String getNumberOfMoveString() {
        return numberOfMoveString;
    }

    public void setNumberOfMoveString(String numberOfMoveString) {
        this.numberOfMoveString = numberOfMoveString;
        movesLabel.setValue(numberOfMoveString);
    }

    private class GameInfoLabel extends JPanel {
        JLabel infoNameLabel = new JLabel();
        JLabel valueLabel = new JLabel();

        public GameInfoLabel(String informationName, String initValue) {
            infoNameLabel.setText(informationName + ": ");
            valueLabel.setText(initValue);
            this.add(infoNameLabel);
            this.add(valueLabel);
            this.setBackground(Color.LIGHT_GRAY); 
        }

        public void setValue(String value) {
            valueLabel.setText(value);
            this.revalidate(); 
            this.repaint(); 
        }
    }
}

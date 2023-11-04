package uniandes.dpoo.taller4.interfaz;

import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.KeyStore.PrivateKeyEntry;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import uniandes.dpoo.taller4.modelo.Tablero;

public class SideOptionsPanel extends JPanel {
	private Top10Window top10Window;
	private final BoardUI boardUI;
	private final TopConfigPanel topConfigPanel;
	
	public SideOptionsPanel(BoardUI boardUI, TopConfigPanel topConfigPanel) {
		this.topConfigPanel = topConfigPanel;
		this.boardUI = boardUI;
		this.setBounds(618, 50, 406, 618);
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
		this.add(new VerticalSpacer(200));
		this.add(new Button("NUEVO", getNewBoardActionListener()));
		this.add(new Button("REINICIAR", getResetActionListener()));
		this.add(new Button("TOP-10", getTop10ActionListener()));
		this.add(new Button("CAMBIAR JUGADOR", getChangeNameActionListener()));
	}
	
	private class Button extends JButton  {
		public Button(String buttonText, ActionListener action) {
			this.setBackground(ColorPalette.PRIMARY);
			this.setText(buttonText);
			this.setForeground(ColorPalette.SECONDARYTEXT);
			this.addActionListener(action);
			this.setFocusable(false);
			this.setPreferredSize(new Dimension(406, 40));
			this.setVerticalAlignment(JButton.CENTER);
		}
	}
	
	private class VerticalSpacer extends Panel  {
		public VerticalSpacer(int height) {
			this.setPreferredSize(new Dimension(406, height));
		}
	}
	
	private ActionListener getTop10ActionListener() {
		ActionListener buttonAction = new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				if ("TOP-10".equals(source.getText())) {
					top10Window = top10Window != null ? top10Window : new Top10Window();
				} 
			}
		};
		return buttonAction;
	}
	
	private ActionListener getResetActionListener() {
		ActionListener buttonAction = new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				if ("REINICIAR".equals(source.getText())) {
					boardUI.getGameBoard().reiniciar();
					boardUI.updateBoardUI();
				} 
			}
		};
		return buttonAction;
	}
	private ActionListener getNewBoardActionListener() {
		ActionListener buttonAction = new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				if ("NUEVO".equals(source.getText())) {
					int size = Character.getNumericValue(topConfigPanel.getSelectedGridSize().charAt(0));
					String dificulty = topConfigPanel.getSelectedDifficulty();
					int dificultyInt = 0;
					switch (dificulty) {
					case "Fácil": {	
						dificultyInt = 5;
					}
					case "Medio": {	
						dificultyInt = 7;
					}
					case "Difícil": {	
						dificultyInt = 10;
					}
					default:
						dificultyInt = 5;
					}
					Tablero nuevo = new Tablero(size);
					nuevo.desordenar(dificultyInt);
					boardUI.setGameBoard(nuevo);
					boardUI.updateBoardUI();
					PlayerNameWindow playerNameWindow = new PlayerNameWindow(boardUI.getBottomInfoPanel());
				} 
			}
		};
		return buttonAction;
	}
	private ActionListener getChangeNameActionListener() {
		ActionListener buttonAction = new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				if ("CAMBIAR JUGADOR".equals(source.getText())) {
					PlayerNameWindow playerNameWindow = new PlayerNameWindow(boardUI.getBottomInfoPanel());
				} 
			}
		};
		return buttonAction;
	}
}

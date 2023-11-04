package uniandes.dpoo.taller4.interfaz;

import javax.swing.JFrame;

import uniandes.dpoo.taller4.modelo.Tablero;

public class MainFrame extends JFrame {
	public MainFrame() {
		this.setTitle("LightsOut");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(1024, 768);
		this.getContentPane().setBackground(ColorPalette.SECONDARY);
		
		TopConfigPanel topConfigPanel = new TopConfigPanel();
		Tablero tablero = new Tablero(5);
		BottomInfoPanel bottomInfoPanel = new BottomInfoPanel();
		BoardUI boardUI = new BoardUI(tablero, bottomInfoPanel);	
		
		this.add(topConfigPanel);
		this.add(new MainGamePanel(boardUI));
		this.add(new SideOptionsPanel(boardUI, topConfigPanel));
		this.add(bottomInfoPanel);
		
		this.setVisible(true);
	}
}

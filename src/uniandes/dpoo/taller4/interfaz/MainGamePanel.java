package uniandes.dpoo.taller4.interfaz;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import uniandes.dpoo.taller4.modelo.Tablero;

public class MainGamePanel extends JPanel {
	public MainGamePanel(BoardUI boardUI) {
		this.setBounds(0, 50, 618, 618);
		this.setBackground(ColorPalette.LIGHTON);
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.add(boardUI);
	}
}

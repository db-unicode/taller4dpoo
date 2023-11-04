package uniandes.dpoo.taller4.interfaz;

import uniandes.dpoo.taller4.modelo.Tablero;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardUI extends JPanel {

	private int cellSize;
	private Tablero gameBoard;
	private BottomInfoPanel bottomInfoPanel;

	public BoardUI(Tablero tablero, BottomInfoPanel bottomInfoPanel) {
		this.bottomInfoPanel = bottomInfoPanel;
		this.gameBoard = tablero;
		int n = tablero.darTablero().length;
		this.cellSize = 618 / n;

		setPreferredSize(new Dimension(618, 618));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = e.getY() / cellSize;
				int col = e.getX() / cellSize;
				gameBoard.jugar(row, col);
				bottomInfoPanel.setNumberOfMoveString(String.valueOf(gameBoard.darJugadas()));
				repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		boolean[][] tablero = gameBoard.darTablero();
		Graphics2D g2d = (Graphics2D) g;

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				// Fill the cell with color
				g2d.setColor(tablero[i][j] ? Color.YELLOW : Color.DARK_GRAY);
				int x = j * cellSize;
				int y = i * cellSize;
				g2d.fillRect(x, y, cellSize, cellSize);

				// Draw a black border around the cell
				g2d.setColor(Color.BLACK);
				g2d.drawRect(x, y, cellSize, cellSize);
			}
		}
	}

	public void updateBoardUI() {
		bottomInfoPanel.setNumberOfMoveString(String.valueOf(gameBoard.darJugadas()));
		repaint();
	}

	public Tablero getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(Tablero tablero) {
		this.gameBoard = tablero;
		int n = gameBoard.darTablero().length;
		this.cellSize = 618 / n;
	}

	public BottomInfoPanel getBottomInfoPanel() {
		return bottomInfoPanel;
	}
}

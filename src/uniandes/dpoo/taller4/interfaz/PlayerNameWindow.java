package uniandes.dpoo.taller4.interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerNameWindow {
    private JFrame frame;
    private JTextField playerNameField;
    private String playerName;
    private BottomInfoPanel bottomInfoPanel;

    public PlayerNameWindow(BottomInfoPanel bottomInfoPanel) {
    	this.bottomInfoPanel = bottomInfoPanel;
        setupUI();
    }

    private void setupUI() {
        frame = new JFrame("Nombre del Jugador");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel promptLabel = new JLabel("Escriba el nombre del jugador (3 caracteres, no ';'):");
        promptLabel.setHorizontalAlignment(JLabel.CENTER);

        playerNameField = new JTextField(20);

        JButton confirmButton = new JButton("Confirmar");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputName = playerNameField.getText();
                if (inputName.length() == 3 && !inputName.contains(";")) {
                    playerName = inputName.toUpperCase();
                    bottomInfoPanel.setPlayerName(playerName);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame,
                        "El nombre debe tener exactamente 3 caracteres y no contener ';'.",
                        "Error en el nombre",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(promptLabel, BorderLayout.NORTH);
        frame.add(playerNameField, BorderLayout.CENTER);
        frame.add(confirmButton, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void closeWindow() {
        frame.dispose();
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}

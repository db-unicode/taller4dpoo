package uniandes.dpoo.taller4.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;

public class TopConfigPanel extends JPanel {
    private String selectedGridSize = "5x5";
    private String selectedDifficulty = "Fácil";

    public TopConfigPanel() {
        this.setBounds(0, 0, 1024, 50);
        this.setBackground(ColorPalette.PRIMARY);
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.setLayout(new GridLayout(1, 5, 20, 20));

        JLabel tamanoLabel = new JLabel("Tamaño:");
        tamanoLabel.setForeground(ColorPalette.SECONDARYTEXT);
        this.add(tamanoLabel);
        String[] gridOptions = {"5x5", "7x7", "9x9"};
        JComboBox<String> gridSize = new JComboBox<>(gridOptions);
        gridSize.setSelectedItem(selectedGridSize); 
        gridSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSelectedGridSize((String) gridSize.getSelectedItem());
            }
        });
        this.add(gridSize);

        JLabel dificultadLabel = new JLabel("Dificultad:");
        dificultadLabel.setForeground(ColorPalette.SECONDARYTEXT);
        this.add(dificultadLabel);
        JRadioButton facilButton = new JRadioButton("Fácil", selectedDifficulty.equals("Fácil"));
        JRadioButton medioButton = new JRadioButton("Medio", selectedDifficulty.equals("Medio"));
        JRadioButton dificilButton = new JRadioButton("Difícil", selectedDifficulty.equals("Difícil"));
        facilButton.setForeground(ColorPalette.SECONDARYTEXT);
        medioButton.setForeground(ColorPalette.SECONDARYTEXT);
        dificilButton.setForeground(ColorPalette.SECONDARYTEXT);
        facilButton.setBackground(ColorPalette.PRIMARY);
        medioButton.setBackground(ColorPalette.PRIMARY);
        dificilButton.setBackground(ColorPalette.PRIMARY);

        ButtonGroup dificultadGroup = new ButtonGroup();
        dificultadGroup.add(facilButton);
        dificultadGroup.add(medioButton);
        dificultadGroup.add(dificilButton);

        ActionListener dificultadListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSelectedDifficulty(e.getActionCommand());
            }
        };
        facilButton.addActionListener(dificultadListener);
        medioButton.addActionListener(dificultadListener);
        dificilButton.addActionListener(dificultadListener);

        this.add(facilButton);
        this.add(medioButton);
        this.add(dificilButton);
    }

    private void setSelectedGridSize(String size) {
        this.selectedGridSize = size;
    }

    private void setSelectedDifficulty(String difficulty) {
        this.selectedDifficulty = difficulty;
    }
    
    public String getSelectedGridSize() {
        return selectedGridSize;
    }

    public String getSelectedDifficulty() {
        return selectedDifficulty;
    }
}

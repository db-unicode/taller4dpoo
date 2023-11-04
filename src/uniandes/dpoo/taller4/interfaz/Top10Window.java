package uniandes.dpoo.taller4.interfaz;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Top10;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Collection;

public class Top10Window extends JFrame {

    private JList<RegistroTop10> top10List;

    public Top10Window() {
        setTitle("Top 10 Jugadores - LightsOut");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(400, 600);
        getContentPane().setBackground(ColorPalette.SECONDARY);

        JLabel topLabel = new JLabel("TOP-10", SwingConstants.CENTER);
        topLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 24));
        add(topLabel, BorderLayout.NORTH);

        DefaultListModel<RegistroTop10> listModel = new DefaultListModel<>();
        Top10 top10 = new Top10();
		File archivo = new File("data/top10.csv");
		top10.cargarRecords(archivo);
		Collection<RegistroTop10> registros =  top10.darRegistros();
        for (RegistroTop10 registro : registros) {
            listModel.addElement(registro);
        }

        top10List = new JList<>(listModel);
        top10List.setCellRenderer(new Top10ListCellRenderer());

        add(new JScrollPane(top10List), BorderLayout.CENTER);
        
        setVisible(true);
    }

    private static class Top10ListCellRenderer extends DefaultListCellRenderer {
        private static final Color GOLD = new Color(255, 215, 0);
        private static final Color SILVER = new Color(192, 192, 192);
        private static final Color BRONZE = new Color(205, 127, 50);

        @Override
        public Component getListCellRendererComponent(
                JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);

            RegistroTop10 registro = (RegistroTop10) value;

            // Numerar los elementos y centrar el texto
            String numberedText = String.format("%d. %s", index + 1, registro.toString());
            label.setText(numberedText);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            
            // Negrita y tamaño de la fuente
            label.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));

            // Color de aacuerdo a la posición
            if (index == 0) {
                label.setForeground(GOLD);
            } else if (index == 1) {
                label.setForeground(SILVER);
            } else if (index == 2) {
                label.setForeground(BRONZE);
            } else {
                label.setForeground(Color.BLACK);
            }

            return label;
        }
    }
}

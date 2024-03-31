package src;

import javax.swing.SwingUtilities;

public class Rodar {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Jogo().setVisible(true));
    }
}
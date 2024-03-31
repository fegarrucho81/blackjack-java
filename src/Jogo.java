package src;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Jogo extends JFrame {
    private JButton comprarButton;
    private Jogador jogador;
    private Deck deck;
    private JTextArea resultadoTextArea;

    public Jogo() {
        setTitle("Jogo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar um JPanel personalizado para desenhar a imagem de fundo
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    // Carregar a imagem de fundo
                    Image backgroundImage = ImageIO.read(new File("C:\\Users\\felip\\OneDrive\\Área de Trabalho\\FELIPE\\java\\blackjack VERSÃO CORRETA\\img\\imagemdefundo.jpeg"));
                    // Desenhar a imagem de fundo
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        backgroundPanel.setLayout(new BorderLayout()); // Define o layout do JPanel

        jogador = new Jogador();
        deck = new Deck();
        deck.gerarBaralho(10);
        deck.embaralhar();

        ImageIcon iconCarta = new ImageIcon("C:\\Users\\felip\\OneDrive\\Área de Trabalho\\FELIPE\\java\\blackjack VERSÃO CORRETA\\img\\imgbaralho.jpg");
        Image image = iconCarta.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);
        comprarButton = new JButton("Comprar Carta", resizedIcon);
        resultadoTextArea = new JTextArea(10, 30);
        resultadoTextArea.setEditable(false);
        resultadoTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        resultadoTextArea.setBackground(new Color(0,100,0)); 

        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para comprar a carta
                Carta carta = deck.darCarta();
                jogador.comprarCarta(carta);
                resultadoTextArea.append("Jogador comprou uma carta: \n");
                resultadoTextArea.append("Face: " + carta.getFace() + "\n");
                resultadoTextArea.append("Naipe: " + getNaipeNome(carta.getNaipe()) + "\n");
                int somaDasCartas = jogador.valorDaMao();
                resultadoTextArea.append("Soma das cartas: " + somaDasCartas + "\n");

                if (somaDasCartas > 21) {
                    resultadoTextArea.append("Estourou, perdeu o jogo\n");
                    verificarResultado(jogador);
                    encerrarJogo();
                } else if (somaDasCartas == 21) {
                    resultadoTextArea.append("Parabéns, você venceu!\n");
                    verificarResultado(jogador);
                    encerrarJogo();
                }

                resultadoTextArea.append("\n");
            }
        });

        // Painel para centralizar o botão
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false); // Tornando o painel transparente
        buttonPanel.add(comprarButton);

        // Adicionar os componentes ao JPanel de fundo
        backgroundPanel.add(buttonPanel, BorderLayout.NORTH);
        backgroundPanel.add(new JScrollPane(resultadoTextArea), BorderLayout.CENTER);

        // Adicionar o JPanel de fundo ao JFrame
        setContentPane(backgroundPanel);
    }

    private void encerrarJogo() {
        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Deseja jogar novamente?",
                "Fim de jogo",
                JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            reiniciarJogo();
        } else {
            System.exit(0);
        }
    }

    private void reiniciarJogo() {
        deck.gerarBaralho(10);
        deck.embaralhar();
        jogador = new Jogador();
        resultadoTextArea.setText("");
    }

    private String getNaipeNome(int naipe) {
        switch (naipe) {
            case 0:
                return "♦ (ouros)";
            case 1:
                return "♥ (copas)";
            case 2:
                return "♠ (espadas)";
            case 3:
                return "♣ (paus)";
            default:
                return "";
        }
    }

    public void verificarResultado(Jogador jogador) {
        int somaCartas = jogador.valorDaMao();
        int pontuacaoVitoria = 21;

        if (somaCartas == pontuacaoVitoria) {
            Audio.tocarMusicaVitoria();
            System.out.println("Você venceu!");
        } else if (somaCartas > pontuacaoVitoria) {
            Audio.tocarMusicaDerrota();
            System.out.println("Você perdeu!");
        } else {
            System.out.println("O jogo continua...");
        }
    }

}
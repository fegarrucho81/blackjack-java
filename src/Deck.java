package src;
import java.util.*;

public class Deck {
    Random rand = new Random();

    private ArrayList<Carta> carta = new ArrayList<Carta>();

    public void gerarBaralho(int quantidade) {
        
        for(int i = 0; i < quantidade;i++)
            for (int naipe = 0; naipe < 4; naipe++) 
                for (int face = 1; face <= 13; face++) 
                    carta.add(new Carta(face, naipe));
                 
    }

    public void embaralhar() {
        for(int i = 0; i < carta.size(); i++) {
            Carta guardar = new Carta();
            guardar = carta.get(i);
            int max = rand.nextInt(52);
            carta.set(i, carta.get(max));
            carta.set(max, guardar);
        }
    }

    public Carta darCarta() {
        Carta cartaAtual = carta.get(rand.nextInt(52));
        return cartaAtual;
    }

    public void add(Carta carta1) {
        carta.add(carta1);
    }

    public int size() {
        return carta.size();
    }

    public Carta get(int i) {
        return carta.get(i);
    }

    public void limpar() {
        carta.clear(); 
    }
}
package src;
public class Jogador {
    private String nome;
    Deck mao = new Deck();

    public Jogador() {
        nome="Sem nome";
    }
    
    public Jogador(String nome) {
        this.nome = nome;
        mao.gerarBaralho(1);
    }

    public void setNome(String nome) {
        if (nome != null)
            this.nome=nome;
    }
    
    public String getNome() {
        return nome;
    }

    public Deck getMao() {
        return mao;
    }

    public void comprarCarta(Carta carta1) {
        mao.add(carta1);
    }

    public void imprimirMao() {
        for(int i = 0; i < mao.size(); i++)
            mao.get(i).imprime();
    }

    public int valorDaMao() {
        int soma=0;

        for(int i = 0; i < mao.size(); i++)
            soma += mao.get(i).getFace();

        return soma;
    }

}
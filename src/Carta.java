package src;
import java.util.Random;

class Carta {
    private int face, naipe;
    private boolean visivel=true;

    public Carta() {
        Random rand = new Random();
        this.face=rand.nextInt(13); 
        this.naipe=rand.nextInt(4);
        this.visivel=true;
    }

    public Carta(int face, int naipe) {
        this.face=face;
        this.naipe=naipe;
        this.visivel=true;
    }

    public int getFace() { 
        return face; 
    }

    public int getNaipe() { 
        return naipe; 
    }

    public void virarCarta() { 
        visivel=!visivel; 
    }

    public void imprime() {
        if(visivel==true)
            switch(naipe) {
                case 0:
                    if(face >= 1 && face <= 9) {
                        System.out.println("Face:" + getFace());
                        System.out.println("Naipe: ♦ (ouros)");
                    }
                    else if(face == 0) {
                        System.out.println("Face: A");
                        System.out.println("Naipe: ♦ (ouros)");
                    }
                    else if(face == 10) {
                        System.out.println("Face: K");
                        System.out.println("Naipe: ♦ (ouros)");
                    }
                    else if(face == 11) {
                        System.out.println("Face: Q");
                        System.out.println("Naipe: ♦ (ouros)");
                    }
                    else if(face == 12) {
                        System.out.println("Face: J");
                        System.out.println("Naipe: ♦ (ouros)");
                    }
                    break;
                case 1:
                    if(face >=1 && face <= 9) {
                        System.out.println("Face:" + getFace());
                        System.out.println("Naipe: ♥ (copas)");
                    }
                    else if(face == 0) {
                        System.out.println("Face: A");
                        System.out.println("Naipe: ♥ (copas)");
                    }
                    else if(face == 10) {
                        System.out.println("Face: K");
                        System.out.println("Naipe: ♥ (copas)");
                    }
                    else if(face == 11) {
                        System.out.println("Face: Q");
                        System.out.println("Naipe: ♥ (copas)");
                    }
                    else if(face == 12) {
                        System.out.println("Face: J");
                        System.out.println("Naipe: ♥ (copas)");
                    }
                    break;
                case 2:
                    if(face >= 1 && face <= 9) {
                        System.out.println("Face:" + getFace());
                        System.out.println("Naipe: ♠ (espadas)");
                    }
                    else if(face == 0) {
                        System.out.println("Face: A");
                        System.out.println("Naipe: ♠ (espadas)");
                    }
                    else if(face == 10) {
                        System.out.println("Face: K");
                        System.out.println("Naipe: ♠ (espadas)");
                    }
                    else if(face == 11) {
                        System.out.println("Face: Q");
                        System.out.println("Naipe: ♠ (espadas)");
                    }
                    else if(face == 12) {
                        System.out.println("Face: J");
                        System.out.println("Naipe: ♠ (espadas)");
                    }
                    break;
                case 3:
                    if(face >= 1 && face <= 9) {
                        System.out.println("Face:" + getFace());
                        System.out.println("Naipe: ♣ (paus)");
                    }
                    else if(face == 0) {
                        System.out.println("Face: A");
                        System.out.println("Naipe: ♣ (paus)");
                    }
                    else if(face == 10) {
                        System.out.println("Face: K");
                        System.out.println("Naipe: ♣ (paus)");
                    }
                    else if(face == 11) {
                        System.out.println("Face: Q");
                        System.out.println("Naipe: ♣ (paus)");
                    }
                    else if(face == 12) {
                        System.out.println("Face: J");
                        System.out.println("Naipe: ♣ (paus)");
                    }
                    break;
            }
    }
}
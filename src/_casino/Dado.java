
package _casino;

import java.util.Random;



public class Dado {
    private int numero;
    private String color;
    private int[] historicoDeCaras;

    public Dado(int numero, String color) {
        this.numero = numero < 1 ? 1 : numero;
        this.color = color == null ? "E404" : color;
    }

    public Dado() {
        this(0, "Blanco");
    }

    public void show() {
        System.out.printf("Dado con caras: %d, color: %s.%n",
                numero, color);
    }

    public void Draw() {
        Random random = new Random();
        this.numero = random.nextInt(6) + 1;
    }
    
    
    
    
    
    public static void main(String[] args) {
       
        Dado d1 = new Dado();
        d1.show();
        d1.Draw();
        d1.show();
        
    }
 
    
}

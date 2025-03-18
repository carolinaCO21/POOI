
package geometria;

public class Rectangulo {
    int base;
    int altura;
    String color;

    public Rectangulo(int base, int altura, String color) {
        this.base = base;
        this.altura = altura;
        this.color = color;
    }
    
    public int superficie(){
        return base * altura;
    }
    
    public int perimetro(){
        return 2 * base + 2 * altura;
    }
    
    public void  show(){
        System.out.printf("Rectángulo %s de %d x %d, superficie %d y perímetro %d .%n",
                color, base, altura, superficie(), perimetro());
    }

}

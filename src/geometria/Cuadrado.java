
package geometria;

public class Cuadrado {
    int lado;
    String color;

    public Cuadrado(int lado, String color) {
        this.lado = lado;
        this.color = color;
    }
    
    public int superficie(){
        return lado * lado;
    }
    
    public int perimetro(){
        return lado * 4;
    }
    
    public void  show(){
        System.out.printf("Cuadrado %s de lado %d, superficie %d y perímetro %d .%n",
                color, lado, superficie(), perimetro());
    }
    
}



























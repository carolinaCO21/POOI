
package misprimerasclases;

public class Animal {

    double precio;
    String descripcion;
    int cantidad;
    String especie;
    boolean oferta;
    boolean animalDeAyuda;

    public Animal(double precio, String descripcion, int cantidad, String especie, boolean oferta, boolean animalDeAyuda) {
        this.precio = precio;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.especie = especie;
        this.oferta = oferta;
        this.animalDeAyuda = animalDeAyuda;
    }

    public Animal(double precio, String descripcion, int cantidad, String especie) {
        this(precio, descripcion, cantidad, especie, true, true);
    }

    public Animal(double precio, int cantidad, String especie) {
        this(precio, "sin descripción", cantidad, especie, true, true);
    }
    
    public void show(){
        System.out.printf("%d animales <%s> %s (%f) oferta=%b animalDeAtyda=%b.%n", 
                cantidad, especie, descripcion, precio, oferta, animalDeAyuda);
    }
    
    public static void main(String[] args) {
        Animal a1 = new Animal(3.5, "desc-1", 10, "felino", true, false);
        Animal a2 = new Animal(6.5, "desc-2", 100, "ominido");
        Animal a3 = new Animal(16.5, 1, "primate");
        
        Animal[] animales = {a1, a2, a3};
        
        for(Animal a: animales){
            a.show();
        } 
    }
}

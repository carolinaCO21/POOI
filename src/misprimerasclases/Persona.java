
package misprimerasclases;

public class Persona {
   String nombre;
   String apellido1;
   String apellido2;
   int añoNacimiento;

    public Persona(String nombre, String apellido1, String apellido2, int añoNacimiento) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.añoNacimiento = añoNacimiento;
    }
    
    public Persona(String nombre, String apellido1, String apellido2) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        añoNacimiento = 2024;
    }
    
    public void show(){
        System.out.printf("Nombre : %s Apellidos : %s %s Año de nacimiento: %d%n", nombre, apellido1, apellido2, añoNacimiento);
        
        
    }
    public static void main(String[] args) {
        
        Persona p1 = new Persona("Carolina", "Carrera", "Ochoa",2006);
        p1.show();
        Persona p2 = new Persona("Estefanía", "Carrera", "Ochoa");
        p2.show();
        
    }
     
   
  
   
}


package vehiculos;

public class TestVehiculo {
    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo();
        v1.show();
        Vehiculo v2 = new Vehiculo(v1, 2345);
        v2.show();
        Vehiculo v3 = new Vehiculo(v2);
        v3.show();
        Vehiculo v4 = new Vehiculo("azul", "renault", (byte) 4, 9999);
        v4.acelera().acelera().frena().para().show();
        
        v2 = null; 
       // v1.pintarBasadoEn(v2); //pinta el vehiculo del mismo color q el otro vehiculo
        v1.pintar("Verde");
        v1.show();
        
        System.out.println(v1.getVelocidad());
        
        
        
        
        
    }
    
}

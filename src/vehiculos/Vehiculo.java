package vehiculos;

public class Vehiculo {

    private String marca;
     // getter
    public String getMarca (){
        return marca;
    }
    private String tipo;
    // getter
    public String getTipo (){
        return marca;
    }
    private byte numRuedas;
     public byte getNumRuedas() {
        return numRuedas;
    }
    private short anioFabricacion;
      public short getAnioFabricacion() {
        return anioFabricacion;
    }

    String[] historicoColores; // máximo 5    
       public String[] getHistoricoColores() {
        return historicoColores;
    }
       
    String color;
    public String getColor() {
        return color;
    }
    private int x;
     public int getX() {
        return x;
    }
     
    private double velocidad;
    public double getVelocidad () {//tienes que poner public + la propiedad que necesitas que te de
        return velocidad; 
    }
      public void setVelocidad (double velocidad) {
        this.velocidad = velocidad;
    
    }
    private boolean nuevo;
       public boolean getNuevo (){
        return nuevo;
    }
    private double kms;

    public double getKms() {
        return kms;
    }
    

    public boolean isNuevo() {
        return nuevo;
    }
    
    private double precio; 

    public double getPrecio() {
        return precio;
    }
    
    public void show() {
        //tarea mostrar en el show el array
        System.out.printf(
                "%s %s %s %s [%d] de %d ruedas con %.2f kms a %.2f km/h de precio %.2f (x=%d).%n",
                tipo, marca, color, nuevo ? "nuevo" : "usado", anioFabricacion,
                numRuedas, kms,
                velocidad, precio, x);
        System.out.println("Histórico de colores");
        for(String c : historicoColores){
            System.out.printf("%S ", c != null ? c: "");
        }
        System.out.println();
    }
    
    //v3 
    public Vehiculo(Vehiculo v) { //Vehiculo copia
        x = 0;
        anioFabricacion = v.anioFabricacion;
        velocidad = v.velocidad;
        color = v.color;
        marca = v.marca;
        tipo = v.tipo;
        numRuedas = v.numRuedas;
        nuevo = v.nuevo;
        kms = v.kms;
        historicoColores = v.historicoColores;
        precio = v.precio;

    }
    
    //v1
     public Vehiculo() {                                 //constructor por defecto
        this("blanco", "Seat", (byte) 4, (int) 1_000.4);
    }
 
     //v2
    public Vehiculo(Vehiculo ve, double precio) {  //copia del vehiculo y se le añade el precio
        this(ve.color, ve.marca, ve.numRuedas, precio);
    }
    
     
    //v4
    public Vehiculo(String color, String marca, byte numRuedas, double precio) {
        // tengo ya el this con los valores por defecto
        x = 0;

        anioFabricacion = 2024;
        velocidad = 0;
        this.color = color;
        this.marca = marca == null ? "Seat" : marca; // Seat si no hay marca

        this.numRuedas = numRuedas < 2 ? 2 : numRuedas;

        switch (this.numRuedas) {
            case 2:
                tipo = "moto";
                break;
            case 3:
                tipo = "triciclo";
                break;
            case 4:
                tipo = "coche";
                break;
            case 10:
                tipo = "autobús";
                break;
            default:
                tipo = "camión";
        }

        nuevo = true;
        kms = 0;
        historicoColores = new String[5];
        if (this.color != null) {
            historicoColores[0] = this.color;
        }
        this.precio = precio < 100 ? 100 : precio;
    }

    
    //Métodos
    public Vehiculo pintar(String color) {
        // Ver si lo puedo pintar (hay nulls)
        int puedoEscribirEn = -1; //si no encuentra hueco vale -1

        for (int i = 0; i < historicoColores.length; i++) {
            if (historicoColores[i] == null) {
                puedoEscribirEn = i;
                break;                            
            }
        }

        if (puedoEscribirEn != -1) {
            historicoColores[puedoEscribirEn] = color;
            this.color = color;
            return this;
        } else {
            return null;
        }
        
        // si puedo, lo pinto y actualizo el historico
        //Retorenar lo q proceda. Si no lo puedo pintar null,
       
    }
    //arreglar CONSTRUCTOS//arreglado
    // se llama pintar y coge el vehículo sobre el que aplica cambia a color blanco
    public Vehiculo pintar() {
        return pintar("blanco");
    }

    public Vehiculo para(){
        velocidad = 0;
        System.out.println("Vehículo detenido.");
        return this;
    }
    
    public void circula(double velocidad) {
        
    }

    public Vehiculo acelera() {
        
        velocidad = ((velocidad + 10) >= 120) ? 120: velocidad + 10; // limite de velocidad 120
        System.out.printf("Nueva velocidad: %.2f%n", velocidad);
        return this;
    }
    
    //pintar mi coche con el color que esta pintando otro coche
    //pintar BasadoEn(Vehiculo vehiculo){}
    public Vehiculo pintarBasadoEn(Vehiculo vehiculo){
        /*if(vehiculo == null){
          return null;
        }else{
            pintar(vehiculo.color);
        }*/
        
      
        return vehiculo == null ? null: pintar(vehiculo.color);//
    }
    
   

    public Vehiculo frena() {
        velocidad = ((velocidad - 10) <=0) ? 0: velocidad - 10;
        System.out.printf("Nueva velocidad: %.2f%n", velocidad);
        return this;
    }
    
   

}

    
    
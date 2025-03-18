
package misprimerasclases;

public class Counter3 {
    // encapsular = private propiedad
    private int value;
    private int maxValue = 100_000;
    private String model = "M-Model";
    private static String counterEnEsperanto = "Ohmmmm"; //propiedad static se pregunta a la clase y no varia entre objetos. Característica de la clase no del objeto.
    private static int totalCounters = 0;
      
    //constructores
    public Counter3() {
        totalCounters++;
    }
    
    public Counter3(int maxValue) {
        this.maxValue = maxValue < 10 ? 10: maxValue;
        totalCounters++;
    }
    
    public Counter3(int maxValue, String model) {
        this.maxValue = maxValue < 10 ? 10: maxValue;
        this.model = model;
        totalCounters++;
    }
    
    public Counter3(Counter3 c){
        model = c.model;
        value = c.value;
        maxValue = c.maxValue;
        totalCounters++;
    }
    //Métodos
    //los métodos pueden ser privados en algunos casos hemos hechos que tiran 
    //de otros métodos y tal vez quieras q no se toque ese método
    
    public void show(){                                                         //no es static pq se esta aplicando a algún contador, no a la clase en general. 
        System.out.printf("Contador %s (%d/%d)%n", 
                model, maxValue, value);
    }
    //counter en Esperanto
    public void showEnEsperanto(){
         System.out.printf("%s %s (%d/%d)%n", 
                counterEnEsperanto, model, maxValue, value);
                //Counter3.counterEnEsperanto, this.model, this.maxValue, this.value);
                //puedes no poner Counter3. 
                //Counter3. --> puedo poner this pero lo suyo es llamarlo desde la clase pq es static. Perfecto..
                //en vez de preguntarle a los counters le preguntas a un counter con this
    }
    public String comoSeDiceShowEnEsperanto(){ //LE PUEDO PREGUNTAR A UN OBJETO INFORMACIÓN DE LA CLASE PQ ELLOS TIENEN ACCESSO A ESA INFORMACIÓN POR ESO FUNCIONA SIN EL STATIC
        return counterEnEsperanto;
    }
    
    public boolean increment(){
        return this.increment(1);
    }
    
    public boolean increment(int n){
        if(value + n <= maxValue){
            value += n;
            return true;
        } else {
            value = maxValue;
            return false;
        }
    }
    
    public boolean reset(){
        if(maxValue == value){
            value = 0;
            return true;
        } else {
            return false;
        }
    }
    //Getters
    //nombre concuerda con el atributo
    public int getMaxValue(){
        return maxValue;
    }
    
    public int getValue(){
        return value;
    }
    
    public String getModel(){
        return model;
    }
    
    
    
}

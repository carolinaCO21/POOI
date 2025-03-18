
package misprimerasclases;
    
public class Counter {
    
    // Priopiedades
    private int value;
    private int maxValue = 100_000;
    private String model = "N-COUNTER";

    public Counter() {
    }

    public Counter(int maxValue) {
        this.maxValue = maxValue < 100 ? 100: maxValue;   
    }

    public Counter(int maxValue, String model) {
        this.maxValue = maxValue < 100 ? 100: maxValue;
        this.model = model;
    }
    
    public Counter(Counter c){
        this.value = c.value;
        this.maxValue = c.maxValue;
        model = c.model;
    }

   
     public boolean reset(){
        if(value == maxValue) {
            value = 0;
            return true;
        } else {
            return false;
        }
    }
    
    public void show(){
        System.out.printf("Contador: modelo (%s) y valor %d de %d.%n",
                model, value, maxValue);
       
    }
    
    public boolean increment(){

        /*
        boolean puedoIncrementar = value < maxValue;
        value = puedoIncrementar ? value++: value;
        return puedoIncrementar;
        */

        if(value < maxValue){
            // incrementa
            value++;
            return true;
        } else {
            // no incrementa
            return false;
        }
    }
        
    public boolean increment(int n){
        if(value + n <= maxValue){
            // incrementa en n
            value += n;
            return true;
        } else {
            // llega al máximo, perdiento algún incremento
            value = maxValue;
            return false;
        }
    }    
    
    public static void main(String[] args) {
        
        // Probando constructores
        Counter c1 = new Counter();
        Counter c2 = new Counter(-100);
        Counter c3 = new Counter(100, "Model-ONE");
        Counter c4 = new Counter(c3);
        
        // Array de counters diversos
        Counter[] counters = {c1, c2, c3, c4};
        
        // Mostrar counters
        for (Counter counter : counters) {
            counter.show();
        }
        // Probando increment()
        c1.show();
        for (int i = 0; i < 99_999; i++) {
            c1.increment();
        }
        System.out.println(c1.increment());
        c1.show();
        
        // Probando increment(int n)
        
        System.out.println("Probando increment(n)");
        c2.show();
        System.out.println(c2.increment(50));
        c2.show();
        System.out.println(c2.increment(40));
        c2.show();
        System.out.println(c2.increment(20));
        c2.show();
        
        // Probando reset()
        
        System.out.println("Probando reset()");
        c2.show();
        System.out.println(c2.reset());
        c2.show();
        c4.show();
        System.out.println(c4.reset());
        c4.show();
        
    }
    
   
    

}


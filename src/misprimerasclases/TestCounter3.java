
package misprimerasclases;


public class TestCounter3 {
    public static void main(String[] args) {
        Counter3 c1 = new Counter3();
        Counter3 c2 = new Counter3(-100);
        Counter3 c3 = new Counter3(120, "Guay");
        Counter3 c4 = new Counter3(c2);
        
        c1.show();
        c2.show();
        c3.show();
        c4.show();
        
        // Prueba increment()
        c2.show();
        for (int i = 0; i < 12; i++) {
            System.out.println(c2.increment());
        }
        
        c2.show();
        
        // Prueba increment(n)
        c4.show();

        System.out.println(c4.increment(10));

        
        c4.show(); 
        
        
        // Prueba del reset
        
        c1.show();
        System.out.println(c1.reset());
        c1.show();
        c4.show();
        System.out.println(c4.reset());
        c4.show();
        
        System.out.println("c1.getMaxvalue()");
    }         
}

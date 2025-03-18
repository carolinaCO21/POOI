package singleclassesvector;

public class Run {

    public static void main(String[] args) {
        // Vector v1 = new Vector();
        System.out.println("v2");
        Vector v2 = new Vector(3, 5);
        v2.show();
        System.out.println("v3");
        Vector v3 = new Vector(3);
        v3.show();
        System.out.println("v4");
        Vector v4 = new Vector(v3);
        v4.show();
        System.out.println("v5, suma v2 y v3");
        Vector v5 = v2.suma(v3);
        v5.show();
        System.out.println("v6, suma v2 y v3");
        Vector v6 = v2.resta(v3);
        v6.show();
        System.out.println("Prueba extrema");
        new Vector(Integer.MIN_VALUE).resta(new Vector(5)).show();
        System.out.println("v7 opera v2 y v3");
        Vector v7 = v2.opera(v3, 'v');
        v7.show();

    }
}

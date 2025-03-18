package singleclassesvector;

public class Vector {
    //propiedades

    private int x, y;
    //constructores    
    //a
    // cuando cree otro constructos el sin parámetros no existira.

    //b //desde este momento el constructor sin parámetros no existe
    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //c             
    public Vector(int n) {
        
        x = n;
        y = n;
    }

    //d
    public Vector(Vector r) {
        this.x = r.x;
        this.y = r.y;

    }

    //b gtter y setter
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    //Métodos
    //a
    public void show() {
        //this.x, this.y
        System.out.printf("Vector de coordenadas (%d, %d)%n", x, y);
    }

    public Vector suma(Vector v) {
        if (this.x + (long) v.x <= Integer.MAX_VALUE && this.x + (long) v.x >= Integer.MIN_VALUE) {
            //objeto             Vector V = v.x, v.y
            Vector resultado = new Vector(this.x + v.x, this.y + v.y);
            return resultado;
        } else {
            return new Vector(0);
        }

    }

    public Vector resta(Vector v) {
        //Vector resultado = new Vector(this.x - v.x, this.y - v.y);
        return this.suma(new Vector(-v.x, -v.y));
    }

    public Vector opera(Vector v, char operacion) {
        Vector resultado = operacion == '-' ? this.resta(v) : this.suma(v);
        System.out.printf("(%d,%d) %c (%d, %d) = (%d,%d)%n",
                x, y,
                operacion == '-' ? '-' : '+',
                v.x, v.y,
                resultado.x, resultado.y);
        return resultado;
    }

}

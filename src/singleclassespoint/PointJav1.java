package singleclassespoint;

public class PointJav1 {

    // propiedades 
    private byte x;
    private byte y;
    private String colour;
    private char symbol;

    // Constructores
    public PointJav1 (byte x, byte y, String colour, char symbol) {

        // validando y seteando la x
        if (x < 0) {
            this.x = 0;
        } else if (x > 12) {
            this.x = 12;
        } else {
            this.x = x;
        }
        // validando y seteando la y pero con operador ternario

        this.y = y < 0 ? 0 : y > 7 ? 7 : y;

       /* // validando y seteando el color
        // Opción con switch
        switch (colour) {
            case "red":
                break;
            case "green":
                break;
            case "yellow":
                break;
            case "blue":
                break;
            case "purple":
                break;
            default:
                colour = "black";
        }
       */
        // Opción con condición lógica
        
        if(!("red".equals(colour) || "green".equals(colour) || "yellow".equals(colour) || 
                "blue".equals(colour) || "purple".equals(colour))) {
            colour = "black";
        }
         
        this.colour = colour;

        this.symbol = symbol;
    }

    public PointJav1() {
        this((byte) 0, (byte) 0, "black", '*');
    }

    public PointJav1 (byte x, byte y) {
        this(x, y, "black", '*');
    }

    public PointJav1(String colour, char symbol) {
        this((byte) 0, (byte) 0, colour, symbol);
    }

    public PointJav1(PointJav1 p) {
        this.colour = p.colour;
        this.symbol = p.symbol;
        this.x = p.x;
        this.y = p.y;
    }

    // Métodos de la clase
    public void showSimple() {
        System.out.printf("Point %c de color %s (%d, %d)%n",
                symbol, colour, x, y);
    }

    public boolean up() {
        byte valorOriginal = y;
        y = y < 7 ? ++y : y;
        return valorOriginal != y;
    }

    public boolean down() {
        if (y == 0) {
            return false;
        } else {
            y--;
            return true;
        }
    }

    public boolean right() {
        if (x == 12) {
            return false;
        } else {
            x++;
            return true;
        }
    }

    public boolean left() {
        if (x == 0) {
            return false;
        } else {
            x--;
            return true;
        }
    }

    public static void main(String[] args) {

        // point con color null mal
        PointJav1 p = new PointJav1((byte) -3, (byte) 5, null, '+');
        p.showSimple();
        PointJav1 p2 = new PointJav1(p);
        p2.showSimple();
        System.out.println(p == p2);
        // Pruebas up, down, right, left
        PointJav1 p10 = new PointJav1((byte) 3, (byte) 5);
        p10.showSimple();

        for (int i = 0; i < 10; i++) {
            System.out.println(p10.down());
            p10.showSimple();
        }

    }
}

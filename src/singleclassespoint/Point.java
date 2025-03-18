package singleclassespoint;

public class Point {

    private int x; // entre 0 y 12
    private int y; // entre 0 y 7
    private String colour; // *“black”*, “red”, “green”, “yellow”, “blue”, “purple”
    private char symbol; // sin valor por defecto   

    public Point(int x, int y, String colour, char symbol) {
        this.x = x < 0 ? 0 : x < 12 ? x : 12;
        this.y = y < 0 ? 0 : y < 7 ? y : 7;
        this.colour = "red".equals(colour)
                || "green".equals(colour) || "yellow".equals(colour)
                || "blue".equals(colour) || "purple".equals(colour) ? colour : "black";
        this.symbol = symbol;
    }

    public Point() {
        this(0, 0, "black", '*');
    }

    public Point(int x, int y) {
        this(x, y, "black", '*');
    }

    public Point(String colour, char symbol) {
        this(0, 0, colour, symbol);
    }

    public Point(Point p) {
        x = p.x;
        y = p.y;
        colour = p.colour;
        symbol = p.symbol;
    }

    public void showSimple() {
        System.out.printf("Point %c de color %s (%d, %d)%n",
                symbol, colour, x, y);
    }

    private boolean move(String direction, int cantidad) {

        if (cantidad <= 0) {
            return false;
        }

        switch (direction) {
            case "up":
                if (y + cantidad <= 7) {
                    y += cantidad;
                    return true;
                } else {
                    y = 7;
                    return false;
                }
            case "down":
                if (y - cantidad >= 0) {
                    y -= cantidad;
                    return true;
                } else {
                    y = 0;
                    return false;
                }

            case "right":
                if (x + cantidad <= 12) {
                    x += cantidad;
                    return true;
                } else {
                    x = 12;
                    return false;
                }

            case "left":
                if (x - cantidad >= 0) {
                    x -= cantidad;
                    return true;
                } else {
                    x = 0;
                    return false;
                }
            default:
        }
        return false;
    }

    public boolean up() {
        return move("up", 1);
    }

    public boolean down() {
        return move("down", 1);
    }

    public boolean right() {
        return move("right", 1);
    }

    public boolean left() {
        return move("left", 1);
    }

    public void show() {

        String coloreo;
        switch (colour) {
            case "red":
                coloreo = "\033[31m";
                break;
            case "green":
                coloreo = "\033[32m";
                break;
            case "yellow":
                coloreo = "\033[33m";
                break;
            case "blue":
                coloreo = "\033[34m";
                break;
            case "purple":
                coloreo = "\033[35m";
                break;
            default:
                coloreo = "\033[30m";
        }

        for (int fila = 0; fila < 7; fila++) {
            // dibuja linea de puntos
            System.out.printf("%d ", 7 - fila);
            for (int columna = 0; columna < 12; columna++) {
                System.out.printf("%s--",
                        fila == 7 - y && columna == x
                                ? coloreo + symbol + "\u001B[0m" : '+');
            }
            System.out.printf("%s%n",
                    fila == 7 - y && x == 12
                            ? coloreo + symbol + "\u001B[0m" : '+');

            // dibuja linea de palos
            System.out.print("  ");
            for (int columna = 0; columna < 12; columna++) {
                System.out.print("|  ");
            }
            System.out.println("|");
        }

        // dibuja linea de puntos
        System.out.printf("%d ", 0);
        for (int columna = 0; columna < 12; columna++) {
            System.out.printf("%s--",
                    y == 0 && columna == x
                            ? coloreo + symbol + "\u001B[0m" : '+');
        }
        System.out.printf("%s%n",
                y == 0 && x == 12
                        ? coloreo + symbol + "\u001B[0m" : '+');

        // dibuja números de abajo
        System.out.print("  ");
        for (int columna = 0; columna <= 12; columna++) {
            System.out.printf("%d%s ", columna, columna > 9 ? "" : " ");
        }
        System.out.println();

        System.out.printf("%sPoint %c de %s (%d, %d)\u001B[0m%n",
                coloreo, symbol, colour, x, y);

    }

    public static void main(String[] args) {

        Point p1 = new Point(3, 7, "red", '*');
        //p1.showSimple();
        p1.show();
    }
}

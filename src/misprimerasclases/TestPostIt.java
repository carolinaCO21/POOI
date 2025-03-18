
package misprimerasclases;

public class TestPostIt {
    public static void main(String[] args) {
        //1. Crea un postit de 50 x 50 mm rosa al que llamarás `p1` con mensaje “AA” .
        //2. Crea otro postit adicional de 50 x 50 mm amarillo al que llamarás `p2` con mensaje “BB” .
        //3. Crea otro postit adicional de 30 x 30 mm naranja al que llamarás `p3` con mensaje “CC” .
        //4. Crea otro postit adicional de 30 x 30 mm azul al que llamarás `p4` con mensaje “DD” .
        
        PostIt p1 = new PostIt();
        p1.alto = p1.ancho = 50;
        p1.color = "rosa";
        p1.msg = "AA";

        PostIt p2 = new PostIt();
        p2.alto = p2.ancho = 50;
        p2.color = "amarillo";
        p2.msg = "BB";
        
        PostIt p3 = new PostIt();
        p3.alto = p3.ancho = 30;
        p3.color = "naranja";
        p3.msg = "CC";
        
        PostIt p4 = new PostIt();
        p4.alto = p4.ancho = 30;
        p4.color = "azul";
        p4.msg = "DD"; 
        
        PostIt p = p1;
        System.out.printf("un postit de %d x %d mm %s al que llamarás `p1` con mensaje %s%n"
                , p.ancho, p.alto, p.color, p.msg);
        
        p = p2;
        System.out.printf("un postit de %d x %d mm %s al que llamarás `p2` con mensaje %s%n"
                , p.ancho, p.alto, p.color, p.msg);
        
        p = p3;
        System.out.printf("un postit de %d x %d mm %s al que llamarás `p3` con mensaje %s%n"
                , p.ancho, p.alto, p.color, p.msg);
        
        p = p4;
        System.out.printf("un postit de %d x %d mm %s al que llamarás `p4` con mensaje %s%n"
                , p.ancho, p.alto, p.color, p.msg);
    }
}

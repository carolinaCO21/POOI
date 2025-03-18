package humanos;

public class Person {

    private short yearOfBirth;
    private String name;
    private String surname;
    private boolean brokenName;
    boolean brokenSurname;
    
        //c
    public Person(short yearOfBirth, String name, String surname){
        /*   
        this.yearOfBirth = yearOfBirth;
        if(yearOfBirth < 1900){
            yearOfBirth = 1900;
        }else if (yearOfBirth > 2023){
            yearOfBirth = 2023;
        }
        this.yearOfBirth = yearOfBirth;
        */
        this.yearOfBirth = yearOfBirth < 1900? 1900 : yearOfBirth > 2023? 2023 : yearOfBirth; 
        //establecemos limitaciones para el name que se va _casino introducir.
        if (name.length() > 20) {
            name = name.substring(0, 20);
            this.brokenName = true;
        }
        this.name = name.toUpperCase();
        if (surname.length() > 20) {
            surname = surname.substring(0, 20);
            this.brokenSurname = true;
        }
        this.surname = surname.toUpperCase();
    }

    //b
    public Person(String name, String surname) {
        this((short)2023, name, surname);
    }

    //d

    public Person(Person p) {
        this.yearOfBirth = p.yearOfBirth;
        this.name = p.name;
        this.surname = p.surname;
        this.brokenName = p.brokenName;
        this.brokenSurname = p.brokenSurname;
    }
    //métodos
    public void show() {
        System.out.printf("Person %s bkn(%b) %s bks(%b) edad %d años.%n", name, brokenName, surname, brokenSurname, 2023 - yearOfBirth);
    }
    
    //para averiguar si alguno tiene name o surname roto (es decir, truncado). 
    public boolean isBroken(){
        return brokenName || brokenSurname;
    }
      public boolean changeName(String name, String surname) {
       
      //Name solo alfabeto inglés o espacio en blanco
        for (int i = 0; i < name.length(); i++) {
            if (!(name.charAt(i) >= 'A' && name.charAt(i) <= 'Z' || name.charAt(i) == ' ')) {
                return false;
            }

        }
        //Surame solo alfabeto inglés o espacio en blanco
        for (int i = 0; i < surname.length(); i++) {
            if (!(surname.charAt(i) >= 'A' && surname.charAt(i) <= 'Z' || surname.charAt(i) == ' ')) {
                return false;
            }
        }
        //Deben tener solo 1 ó 2 palabras
        // 0 ó 1 espacios en blanco que no pueden estar en los extremos
        String nameSinBlancosEnExtremos = name.trim();
        int contadorBlancosEnName = 0;
        for (int i = 0; i < nameSinBlancosEnExtremos.length(); i++) {
            if (nameSinBlancosEnExtremos.charAt(i) == ' ') {
                contadorBlancosEnName++;
            }
            if (contadorBlancosEnName > 1) {
                return false;
            }
        }
        String surNameSinBlancosEnExtremos = surname.trim();
        int contadorBlancosEnSurName = 0;
        for (int i = 0; i < surNameSinBlancosEnExtremos.length(); i++) {
            if (surNameSinBlancosEnExtremos.charAt(i) == ' ') {
                contadorBlancosEnSurName++;
            }
            if (contadorBlancosEnSurName > 1) {
                return false;
            }
            //Ninguno puede ser broken después del cambio
            //longitud como mucho 20
            if (name.length() > 20 || surname.length() > 20) {
                return false;
            } 
            
            //No puede ser ninguno blanco: al menos debe haber una letra del alfabeto inglés
            /*if(name.trim().equals("")|| surname.trim().equals("")){
                return false;
            } MUY BIEN, OTRA FORMA*/
            if(name.trim().length()== 0){
            return false;
            }
        }
         this.name = name;
         this.surname = surname;
         //brokenName = brokenSurname = false;
         
        return true;
    
    }
    public boolean changeName(String surname){
    return this.changeName(name,surname);  
    }
    
    short getAge() {
    //devuelve la edad haciendo un calculo sencillo restando el año actual del año de nacimiento.
    return (short)(2024 - yearOfBirth);
    
    }

    public boolean sameAge(Person p) {
    //compara fechas de nacimiento de una persona con otra, devolviendo true en caso de que hayan nacido el mismo año y false en caso contrario.
    //return yearOfBirth == p.yearOfBirth;
    return this.getAge() == p.getAge();
    }
    
    public boolean compareWith (Person p){
        return name.equals(p.name) && surname.equals(p.surname) && sameAge(p);
    }

    // segunda opción incompleta char [] ls = name.trim().toCharArray();
    //MAIN
   
    public static void main(String[] args) {
        Person p1 = new Person((short)2006, "Javier Caleb Ochoa Albarran", "Dorles");
        p1.show();
        System.out.println(p1.isBroken());
        Person p2 = new Person(p1);
        p2.show();
        Person p3 = new Person("José","Fernando");
        p3.show();
        
        System.out.println(p3.changeName("CAROLINA CARRERA","CARRERA"));
        
     

    }

     
    
    
 }


package humanos;


public class PersonS {
    
    private short yearOfBirth;// valor por defecto 2023 (acaba de nacer).
    private String name;//máximo 20 caracteres.
    private String surname;// máximo 20 caracteres.
    private boolean brokenName;
    private boolean brokenSurname;

    //Dados yearOfBird, name y surname.
    public PersonS(short yearOfBirth, String name, String surname) {

        if (name.length() > 20) {
            name = name.substring(0, 20);
            brokenName = true;
        }
        if (name.length() > 20) {
            surname = surname.substring(0, 20);
            brokenSurname = true;
        }

        this.yearOfBirth = yearOfBirth < 1900 ? 1900 : yearOfBirth > 2024 ? 2024 : yearOfBirth;
        this.name = name;
        this.surname = surname;
    }
    //Dados name y surname

    public PersonS (String name, String surname) {
        this((short) 2024, name, surname);
    }

    //Constructor copia.
    public PersonS(PersonS p) {
        yearOfBirth = p.yearOfBirth;
        name = p.name;
        surname = p.surname;
        brokenName = p.brokenName;
        brokenSurname = p.brokenSurname;
    }

    //Métodos: 
    public void show() {
        //muestra la información de la persona como en el ejemplo
        //Person JUAN GOMEZ de 7 años.
        System.out.printf("Person %s %s de %d años.%n", name, surname, 2024 - yearOfBirth);
    }

    public boolean isBroken() {
        //para averiguar si alguno tiene name o surname roto (es decir, truncado).
        return brokenName || brokenSurname;
    }

    public boolean changeName(String name, String surname) {
//: en este caso solo cambia el nombre si se cumplen las siguientes condiciones (si no lo cambia devuelve false)
//Usar solo caracteres del alfabeto inglés en mayúsculas.
        if(name == null || surname == null) return false;
        for (int i = 0; i < name.length(); i++) {
            if (!(name.charAt(i) >= 'A' || name.charAt(i) >= 'a' && name.charAt(i) >= 'Z' || name.charAt(i) >= 'z' || name.charAt(i) == ' ')) {
                return false;
            }
        }
        for (int i = 0; i < surname.length(); i++) {
            if (!(surname.charAt(i) >= 'A' || surname.charAt(i) >= 'a' && surname.charAt(i) >= 'Z' || surname.charAt(i) >= 'z' || surname.charAt(i) == ' ')) {
                return false;

            }

        }
//Deben tener solo 1 ó 2 palabras: 0 o 1 espacios en blanco que no pueden estar en los extremos.
        String nameSinEspaciosExtremos = name.trim();
        int contadorEspaciosEnBlandoName = 0;
        for (int i = 0; i < nameSinEspaciosExtremos.length(); i++) {
            if (nameSinEspaciosExtremos.charAt(i) == ' ') {
                contadorEspaciosEnBlandoName++;
            }
        }
        if (contadorEspaciosEnBlandoName > 1) {
            return false;
        }
        String surnameSinEspaciosExtremos = surname.trim();
        int contadorEspaciosEnBlandoSurname = 0;
        for (int i = 0; i < surnameSinEspaciosExtremos.length(); i++) {
            if (surnameSinEspaciosExtremos.charAt(i) == ' ') {
                contadorEspaciosEnBlandoSurname++;
            }
        }
        if (contadorEspaciosEnBlandoSurname > 1) {
            return false;
        }

//Ninguno puede ser broken después del cambio: longitud debe ser como mucho 20.
        if (name.length() > 20) {
            brokenName = true;
            return false;
        }
        if (surname.length() > 20) {
            brokenSurname = true;
            return false;
        }
//No puede ser ninguno blanco: al menos debe haber una letra del alfabeto inglés.
        
        if(name.trim().length()== 0 || surname.trim().length()==0)return false;
          
        return true;
    }

    short getAge() {
    //devuelve la edad haciendo un calculo sencillo restando el año actual del año de nacimiento.
    return (short)(2024 - yearOfBirth);
    
    }

    public boolean sameAge(PersonS p) {
    //compara fechas de nacimiento de una persona con otra, devolviendo true en caso de que hayan nacido el mismo año y false en caso contrario.
    //return yearOfBirth == p.yearOfBirth;
    return this.getAge() == p.getAge();
    }

   /* public boolean compareWith(Person p){
           // devuelve true si tienen exactamente la misma edad, nombre y apellido. 
            if(!(yearOfBirth==p.yearOfBirth))return false;
            
            if(!(name.equals(p.name))) return false; 
            if(!(surname.equals(p.surname)))return false;
           
    }*/
    public boolean compareWith (PersonS p){
        return name.equals(p.name) && surname.equals(p.surname) && sameAge(p);
    }
    public static void main(String[] args) {
        PersonS p1 = new PersonS((short) 2006, "Javier Caleb Ochoa Albarran", "Dorles");
        p1.show();
        System.out.println(p1.isBroken());
        PersonS p2 = new PersonS(p1);
  
               
        
        PersonS p3 = new PersonS("José", "Fernando");
        p3.show();
        System.out.println(p3.changeName("CAROLINA CARRERA", "CARRERA"));
        p3.show();
      
    }

}

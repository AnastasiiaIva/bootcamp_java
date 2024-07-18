package JAVA.sheet02.ex01;

import lombok.Data;

@Data

public class Persona {
    String name;
    int age;
/*public Persona (String name, int age) {
    this.name = name;
    this.age = age;*/
}

public void mostrarDetalles () {
    System.out.println("Nombre: " + name);
    System.out.println("Edad: " + age);
}

/*
public static void main(String[] args) {
    Persona myObj = new Persona("Juan",25);
    myObj.mostrarDetalles ();
    
} */

}

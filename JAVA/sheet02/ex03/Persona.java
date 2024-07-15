package JAVA.sheet02.ex02;

public class Persona {
    private String name;
    private int age;
public Persona (String name, int age) {
    this.name = name;
    this.age = age;
}

public void mostrarDetalles () {
    System.out.println("Nombre: " + name);
    System.out.println("Edad: " + age);
}

public void setName(String newName) {
    this.name = newName;
    } 

public void setAge(int newAge) {
   this.age = newAge;
}

public String getName () {
    return name;
}

public int getAge() {
    return age;
}






}

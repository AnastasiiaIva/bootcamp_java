package JAVA.sheet02.ex03;

public class Main {
    public static void main(String[] args) {
        Persona myObj = new Persona("Juan",25);
        myObj.mostrarDetalles ();

        Persona myObj2 = new Persona(null, 0);
        myObj2.setName("Carlos");
        myObj2.setAge(30);
        myObj2.mostrarDetalles ();
    }
}

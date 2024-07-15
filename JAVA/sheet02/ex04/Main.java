package JAVA.sheet02.ex04;

public class Main {
    public static void main(String[] args) {
        Persona[] personas = {
            new Estudiante("Ana", 20, "Ingenieria"),
            new Empleado("Luis",30,5000),
            new Persona("Marta",40)
        };
        for(Persona persona : personas) {
            persona.mostrarDetalles();
        }
    }
}

package JAVA.sheet02.ex05;

public class Main {
    public static void main(String[] args) {
        Imprimible[] im = {
            new Estudiante("Ana", 20, "Ingenieria"),
            new Empleado("Luis",30,5000),
            new Persona("Marta",40)
        };
        for(Imprimible ims : im) {
            ims.imprimir();
        }
        
    }
}

package JAVA.sheet02.ex03;

public class Estudiante extends Persona {
    String grado;
    
    public Estudiante(String name, int age, String grado) {
        super(name,age);
        this.grado = grado;
    }
    
    public void mostrarDetalles () {
        super.mostrarDetalles();
        System.out.println("Grado: " + grado);
    }
    
    }
    

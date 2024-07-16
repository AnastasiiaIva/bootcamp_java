package JAVA.sheet02.ex05;

public class Estudiante extends Persona {
    

    String grado;
    
    public Estudiante(String name, int age, String grado) {
        super(name,age);
        this.grado = grado;
    }


    
    @Override
    public void mostrarDetalles () {
        super.mostrarDetalles();
        System.out.println("Grado: " + grado);
    }

    @Override
    public void imprimir() {
        System.out.println("-------Estudiante-------");
        mostrarDetalles ();
    }
    
    }
    

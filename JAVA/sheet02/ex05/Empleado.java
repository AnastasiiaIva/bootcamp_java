package JAVA.sheet02.ex05;

public class Empleado extends Persona {
    int salario;

    public Empleado (String name, int age, int salario) {
        super(name,age);
        this.salario = salario;
    }

    @Override
    public void mostrarDetalles(){
        super.mostrarDetalles();
        System.out.println("salario es:" + salario);
    }
    
}

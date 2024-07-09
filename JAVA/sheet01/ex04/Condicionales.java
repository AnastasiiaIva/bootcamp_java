package JAVA.sheet01.ex04;

import java.util.Scanner;

public class Condicionales {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Number");

        int number = myObj.nextInt();

        if (number < 0) {
            System.out.println("negativo");}
        else if (number > 00) {
            System.out.println("positivo");}
        else if (number == 0) {
            System.out.println("cero");
        }
        else {
            System.out.println("error");
        }
    }
}

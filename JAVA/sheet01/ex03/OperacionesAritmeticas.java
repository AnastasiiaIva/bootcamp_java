package JAVA.sheet01.ex03;

import java.util.Scanner;

public class OperacionesAritmeticas {
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        int number1;
        int number2;

        System.out.println("Enter number1");
        number1 = myObj.nextInt();

        System.out.println("Enter number2");
        number2 = myObj.nextInt();

        int sum = number1 + number2;
        System.out.println("Sum is:" +  sum);

        int subtraction = number1 - number2;
        System.out.println("subtraction is:" +  subtraction);

        int multiplication = number1 * number2;
        System.out.println("multiplication is:" +  multiplication);

        float division = (float) number1 / number2;
        System.out.println("division is:" +  division);

    
    }
}

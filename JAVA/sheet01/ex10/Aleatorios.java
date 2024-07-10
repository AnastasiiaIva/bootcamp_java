package JAVA.sheet01.ex10;

import java.util.Scanner;

public class Aleatorios {
    public static void main(String[] args) {
        int randomNum = (int)(Math.random() * 100);
        System.out.println(randomNum);

        Scanner myObj = new Scanner(System.in);
        int numberUs;

        System.out.println("Enter your number:");

        numberUs = myObj.nextInt();

        if(numberUs > randomNum) {
            System.out.println(numberUs + " - es mayor");
        }
        else if (numberUs < randomNum) {
            System.out.println(numberUs + " - es menor");
        }
        else if (numberUs == randomNum) {
            System.out.println(numberUs + " - lo adivine");
        }



    }
}

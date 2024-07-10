package JAVA.sheet01.ex09;

import java.util.Scanner;

public class mensaje {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String userName;

        System.out.println("Enter your name:");
        userName = myObj.nextLine();

        System.out.println("Hello " + userName);

    }
}

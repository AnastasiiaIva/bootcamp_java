package JAVA.sheet03.ex01;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date {
    public static void main(String[] args){
        LocalDateTime myDateObj = LocalDateTime.now();
        System.out.println("Formato 1: " + myDateObj);

        DateTimeFormatter formatObj1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formated1 = myDateObj.format(formatObj1);
        System.out.println("Formato 1: " + formated1);

        DateTimeFormatter formatObj2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formated2 = myDateObj.format(formatObj2);
        System.out.println("Formato 2: " + formated2);


        DateTimeFormatter fomatObj3 = DateTimeFormatter.ofPattern("EEE, MMM, dd yyyy");
        String formated3 = myDateObj.format(fomatObj3);
        System.out.println("Formato 3: " + formated3);


    




    }
    
}

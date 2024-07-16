package JAVA.sheet03.ex02;
import java.util.ArrayList;

public class ArrayLists {
    public static void main(String[] args){
        ArrayList<Integer> myNumb = new ArrayList<Integer>();
        myNumb.add(10);
        myNumb.add(20);
        myNumb.add(30);


    for (int num : myNumb) {
        System.out.println(num);
    }
    
}
}

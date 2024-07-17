package JAVA.sheet03.ex05;
import java.util.HashSet;
import java.util.TreeSet;

public class HashSets {
    public static void main(String[] args){
        HashSet<Integer> numb = new HashSet<Integer>();
        numb.add(10);
        numb.add(20);
        numb.add(30);
        numb.add(10);
        System.out.println(numb);

        TreeSet<Integer> sortNumb = new TreeSet<Integer>(numb);

        System.out.println(sortNumb);

        for (int i : sortNumb){
;
            System.out.println(i);
        }


    }
    
}

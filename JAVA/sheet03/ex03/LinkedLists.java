package JAVA.sheet03.ex03;
import java.util.LinkedList;

public class LinkedLists {
    public static void main(String[] args){
        LinkedList<String> words = new LinkedList<String>();
        words.add("Hola");
        words.add("Mundo");
        words.add("Java");

        System.out.println(words);

        for (String w : words) {
            System.out.println(w);
        }
    }


    
}

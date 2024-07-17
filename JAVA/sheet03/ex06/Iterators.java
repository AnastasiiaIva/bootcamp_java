package JAVA.sheet03.ex06;
import java.util.*;


public class Iterators {
    public static void main(String[] args) {
        LinkedList<Integer> numb = new LinkedList<Integer>();
        numb.add(10);
        numb.add(15);
        numb.add(20);
        numb.add(25);

        Iterator<Integer> iter = numb.iterator();

        while (iter.hasNext()){
            Integer i = iter.next();
            if (i % 2 != 0){
                iter.remove();
            }
        }
            System.out.println(numb);

        

    
}
    
}

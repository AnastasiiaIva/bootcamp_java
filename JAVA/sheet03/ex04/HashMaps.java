package JAVA.sheet03.ex04;
import java.util.HashMap;

public class HashMaps {
    public static void main(String[] args){
        HashMap<String, Integer> person = new HashMap<String, Integer>();
        person.put("Ana", 25);
        person.put("Luis",35);
        person.put("Juan", 30);

        System.out.println(person);

        for(String i : person.keySet()) {
          
        System.out.println(i + " tiene " + person.get(i) + " anos." );

        }


    }
    
}

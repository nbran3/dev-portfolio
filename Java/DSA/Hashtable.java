import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {

        Hashtable<Integer, String> table = new Hashtable<>(10);

        table.put(100, "Bill");
        table.put(229, "Amy");
        table.put(387, "Jeff");
        table.put(444, "Mary");
        table.put(503, "Jack");

        //table.remove(300);


        for(Integer key : table.keySet()){
            System.out.println(key.hashCode() % 10 + "\t" + key + "\t" + table.get(key));
        }

        

    }
}

import java.util.HashMap;
import java.util.Map;

public class HashMapProgram
{
    public static void main(String[] args) {
        Map<Integer,String>hm = new HashMap<>();
        hm.put(1, "Raj");
        hm.put(2,"gokul");
        hm.put(3,"john");
        /*for(Map.Entry m:hm.entrySet())
        {
            System.out.println(m.getKey()+" "+m.getValue());
        }*/
       /*  for(hm.keySet())
        {
            System.out.println();
        }*/
    }
}
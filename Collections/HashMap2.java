import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMap2 {
    public static void main(String[] args) {
        HashMap<String,List<String>>hm = new HashMap<String,List<String>>();
        List<String> values1 = new ArrayList<String>();
        values1.add("value1");
        values1.add("value2");
        List<String> values2 = new ArrayList<String>();
        values2.add("value3");
        values2.add("value4");
        hm.put("key1", values1);
        hm.put("key2", values2);
        String specificValue = "value3";
        for(Map.Entry<String, List<String>> entry: hm.entrySet())
        {
            if(entry.getValue().contains(specificValue))
            {
                System.out.println("Key associated with specific value "+specificValue+" is :  "+entry.getKey());
            }
        }
    }
}

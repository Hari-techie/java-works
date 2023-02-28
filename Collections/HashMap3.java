import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HashMap3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,List<String>>hm = new HashMap<String,List<String>>();
        List<String> values1 = new ArrayList<String>();
        values1.add("o365");
        values1.add("office365");
        List<String> values2 = new ArrayList<String>();
        values2.add("jira id not found");
        values2.add("unable to login jira");
        values2.add("unable to login account");
        List<String> values3 = new ArrayList<String>();
        values3.add("unable to regularize calendar");
        values3.add("unable to apply leave");
        values3.add("unable to request permission");
        List<String> values4 = new ArrayList<String>();
        values4.add("travel");
        values4.add("internet");
        hm.put("o365", values1);
        hm.put("jira", values2);
        hm.put("talentX", values3);
        hm.put("hr", values4);
        System.out.print("Enter the issue : ");
        String issue = sc.nextLine();
       /*  for(Map.Entry<String, List<String>> entry: hm.entrySet())
        {
            if(entry.getValue().toString().contains(issue))
            {
                System.out.println("Issue faced : "+issue+" Corresponding team :  "+entry.getKey());
            }
        }*/
        /*for(Map.Entry<String, List<String>> entry: hm.entrySet())
        {
            if(entry.getValue().contains(issue))
            {
                System.out.println("Issue faced : "+issue+" Corresponding team :  "+entry.getKey());
            }
        }*/
    }
}

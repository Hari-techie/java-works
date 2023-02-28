import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToyReaader {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Toy.csv"));
            String line;
            //List<List<String>> toys = new ArrayList<List<String>>();
            List<Toy>toys = new ArrayList<>();
            while((line = br.readLine()) != null)
            {
               // toys.add(Arrays.asList(line.split(",")));
               String toy[] = line.split(",");
               Toy t = new Toy(toy[0],toy[1],toy[2]);
               toys.add(t);
            }
            /*System.out.println(toys);
            for (List<String> list : toys) {
                System.out.println(list);
            }*/
            for (Toy toy : toys) {
                System.out.println(toy);
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("File not found");
        }
    }
}

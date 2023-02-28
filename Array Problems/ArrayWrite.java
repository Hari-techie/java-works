import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ArrayWrite {
    public static void main(String[] args) throws IOException {
        String a[] = new String[4];
        a[0] = "orange";
        a[1] = "grapes";
        a[2] = "mango";
        a[3] = "banana";
        try(FileWriter writer = new FileWriter("array.txt"); 
            BufferedWriter bw = new BufferedWriter(writer)) {
            for(String k: a)
            {
                bw.write(k);
                bw.newLine();
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("File not found");
        }
    }
}

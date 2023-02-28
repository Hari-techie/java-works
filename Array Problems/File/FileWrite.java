import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileWrite 
{
    static List <String> cart = new ArrayList<String>();
    static String filename = "Cart.txt";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String elements[] = sc.nextLine().split(" ");
        cart.addAll(Arrays.asList(elements));
        write();
        read();
    }
    public static void write()
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            for(String k:cart)
            {
                bw.write(k);
                bw.newLine();
            }            
        } catch (Exception e) {
            System.out.println("File not found");
        }
        
    }
    public static void read()
    {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = br.readLine())!= null)
            {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
}
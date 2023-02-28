import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShoppingCartTest {
    static List<String> cart = new ArrayList<String>();
    //String filename = "Shopping.txt";
    String filename = "D:\\Hariram\\Mini Project\\Fred.txt";
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        ShoppingCartTest shop = new ShoppingCartTest();
        int choice;
        String option;
        do {
            System.out.println("1-List \n2-Add \n3-Delete \n4-Load \n5-Save \n6-Exit");
            System.out.print("Enter the Choice : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    shop.display();
                    break;
                case 2:
                    sc.nextLine();
                    String addElement[] = sc.nextLine().split(" ");
                    shop.add(Arrays.asList(addElement));
                    break;
                case 3:
                    System.out.print("Enter the index of element that you want to delete : ");
                    int index = sc.nextInt();
                    shop.delete(index);
                    break;
                case 4:
                    shop.load(cart);
                    break;
                case 5:
                    shop.save();
                    break;
                case 6:
                    System.out.println("Exitted successfully");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Kindly Enter The Correct Choice ");
                    break;
            }
            System.out.println("Do you want to Continue? yes or no");
            option = sc.next();
        } while (option.equalsIgnoreCase("yes"));
        sc.close();
    }

    public void add(List<String> addElement) {
        cart.addAll(addElement);
        System.out.println("Elements are added successfully!!");
    }

    public void display() throws IOException {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
           /*  try(BufferedReader br = new BufferedReader(new FileReader(filename)))
            {
                String line;
                while((line = br.readLine()) != null)
                {
                    System.out.println(line);
                }
            } */
            Path path = Paths.get(filename);
            try(BufferedReader br = Files.newBufferedReader(path,Charset.forName("UTF-8")))
            {
                String line;
                while((line = br.readLine()) != null)
                {
                    System.out.println(line);
                }
            }
            catch(Exception e)
            {
                System.out.println("File not found");
            }
            
        }    
        
    }

    public void delete(int index) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
        } else if (index < 1 || index > cart.size()) {
            System.out.println("Kindly check the index you have entered");
        } else {
            String item = cart.get(index - 1);
            cart.remove(index - 1);
            System.out.println(item + " removed from the cart");
        }
    }

    public void load(List<String> addElement) throws IOException
    {
       /*  try(FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw)) {
            for(String element: addElement)
            {
                bw.write(element);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Initially cart is empty");
        }
        finally{
            System.out.println("Cart loaded successfully!!!");
        } */
        Path path = Paths.get(filename);
        try(BufferedWriter bw = Files.newBufferedWriter(path, Charset.forName("UTF-8")))
        {
            for(String element: addElement)
            {
                bw.write(element);
                bw.newLine();
            }
        }
        catch(Exception e)
        {
            System.out.println("File not found");
        }
        finally
        {
            System.out.println("Loaded successfully");
        }
    }
    public void save()
    {
        try(BufferedReader bw = new BufferedReader(new FileReader(filename)))
        {
            bw.close();
        }
        catch(Exception e)
        {
            System.out.println("Data not saved");
        }
        finally
        {
            System.out.println("File saved");
        }
    }
}
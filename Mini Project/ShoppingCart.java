import java.util.ArrayList;
import java.util.List;

public class ShoppingCart
{
    static List<String> cart = new ArrayList<String>();
    public static void add(List<String> addElement)
    {
        cart.addAll(addElement);
        System.out.println("Elements are added successfully!!");
    }
    public static void display()
    {
        if(cart.isEmpty())
        {
            System.out.println("Cart is empty");
        }
        else
        {
            for(String elements : cart)
            {
                System.out.println(elements);
            }
        }
    }
    public static void delete(int index)
    {
        if(cart.isEmpty())
        {
            System.out.println("Cart is empty");
        }
        else if(index < 1 || index > cart.size())
        {
            System.out.println("Kindly check the index you have entered");
        }
        else 
        {
            String item = cart.get(index-1);
            cart.remove(index-1);
            System.out.println(item+" removed from the cart");
        }
    }    
}
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Prog2SecondLargest{
    public static void display(int a[])
    {
        for(int k:a)
        {
            System.out.print(k+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements : ");
        int num = sc.nextInt();
        int a[] = new int[num];
        int i,n=a.length;
        for(i=0;i<n;i++)
        {
            System.out.print("Enter "+i+" index element : ");
            a[i] = sc.nextInt();
        }
        System.out.println("Array elements : ");
        display(a);
        Arrays.sort(a);
        System.out.println("Second largest element is : "+a[n-2]);
    }
}
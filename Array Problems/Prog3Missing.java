import java.util.Arrays;
import java.util.Scanner;

public class Prog3Missing {
    public static void display(int a[])
    {
        for(int k:a)
        {
            System.out.print(k+" ");
        }
        System.out.println();
    }
    public static void findMissing(int a[])
    {
        int sum = 0,n = a.length,realSum = (n*(n+1))/2;
        for(int k:a)
        {
            sum+=k;
        }
        System.out.println("Missing element is "+(realSum-sum));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements : ");
        int num = sc.nextInt();
        int a[] = new int[num];
        int i,n=a.length;
        for(i=0;i<n-1;i++)
        {
            System.out.print("Enter "+i+" index element : ");
            a[i] = sc.nextInt();
        }
        System.out.println("Array elements : ");
        display(a);
        findMissing(a);
    }
}

import java.util.Scanner;
public class Prog1ReverseArrayNumbers{
    public static void reverseArray(int a[])
    {
        int i=0,n=a.length,j=n-1,temp;
        for(i=0,j=n-1;i<j;i++,j--)
        {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
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
        System.out.println("Array before reversal : ");
        display(a);
        reverseArray(a);
        System.out.println("Array after reverse function : ");
        display(a);
    }
}
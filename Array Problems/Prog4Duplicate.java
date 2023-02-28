import java.util.Arrays;
import java.util.Scanner;

public class Prog4Duplicate {
    public static void display(int a[])
    {
        for(int k:a)
        {
            System.out.print(k+" ");
        }
        System.out.println();
    }
    public static void findDuplicate(int a[])
    {
        int n = a.length,count;
        System.out.println("Duplicate elements : ");
        for(int i=0;i<n;i++)
        {
            count = 1;
            for(int j=i+1;j<n;j++)
            {
                if(a[i]==a[j])
                {
                    count++;
                    a[j]=-1;
                }
            }
            if(a[i]!=-1 && count > 1)
            {
                System.out.print(a[i]+" ");
            }
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
        findDuplicate(a);
        Arrays.sort(a);
        System.out.println("Array after sort");
        display(a);
        
    }
}

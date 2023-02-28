import java.util.Arrays;

public class JagArray {
    public static void main(String[] args) {
        int a[][] = new int[2][];
        a[0] = new int[]{1,2,3};
        a[1] = new int[]{4,5,6,9,3};
        int ind = 2;
       /* for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[i].length;j++)
            {
            System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }*/
        for(int arows[]:a)
        {
            //System.out.println(Arrays.toString(arows));
           // System.out.println();
        }
    }
}

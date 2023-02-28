import java.io.FileOutputStream;

public class FileOutputEg {
     public static void main(String args[]){    
           try{    
             FileOutputStream fout=new FileOutputStream("testout.txt");    
             String s="Welcome to javaTpoint.";   
             int k = 1; 
            // byte b[]=s.getBytes();//converting string into byte array    
             fout.write(k);    
             fout.close();    
             System.out.println("success...");    
            }catch(Exception e){System.out.println(e);}    
      }    
}

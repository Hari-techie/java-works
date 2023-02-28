
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Write {
   public static void main(String args[]) throws Exception {
      String[] myArray = {"JavaFX", "HBase", "OpenCV", "Java", "Hadoop", "Neo4j"};
      BufferedWriter writer = new BufferedWriter(new FileWriter("myFile.txt", false));
      for(int i = 0; i < myArray.length; i++) {
         writer.write(myArray[i]);
         writer.newLine();
      }
      writer.flush();
      System.out.println("Data Entered in to the file successfully");
      writer.close();
   }
}
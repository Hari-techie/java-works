import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CityTest {
    static List <City> cities = new ArrayList<City>();
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("city.csv"));
            String line;
            while((line = br.readLine()) != null)
            {
                String city[] = line.split(" ");
                for(String k: city)
                {
                    System.out.print(city);
                }
                System.out.println();
               // City c = new City(city[0], city[1], city[2], city[3], city[4],Double.parseDouble(city[5]),Double.parseDouble(city[6]),Long.parseLong(city[7]),Long.parseLong(city[8]));
               // cities.add(c);
            }
        }
        catch(IOException e)
        {
            System.out.println("File not found");
        }
        System.out.println(cities);
    }
}

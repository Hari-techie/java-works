import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class CityTest {
    //static ArrayList<City> cityList = new ArrayList<City>();
    static City cities[] = new City[101];
    public static void main(String[] args) throws FileNotFoundException, IOException {
        loadCities();
       // printCities();
       // uniqueCities();
       //countryWiseCityCount();
       citiesInSameLatitude();
       // uniqueCityCapital();
       //lessPopulatedCity();
       //orderCitiesByPopulation();
       //searchMyCity("Mumbai");
       // queriesOnCities();
    }

    public static void citiesInSameLatitude()
    {
        City citiesClone[] = cities.clone();
        String first, second;
        int i,j,n = citiesClone.length;
        for(i=0;i<n-1;i++)
        {
            if(citiesClone[i]!=null)
            {
                first = citiesClone[i].getLat().replace("-", "").substring(0,citiesClone[i].getLat().indexOf("."));
                System.out.print("------------Latitude : "+first+"-------------\n"+citiesClone[i].getCity());
                for(j=i+1;j<n;j++)
                {
                    if(citiesClone[j]!=null)
                    {
                        second = citiesClone[j].getLat().replace("-", "").substring(0,citiesClone[j].getLat().indexOf("."));
                        if(first==second)
                        {
                            System.out.print(citiesClone[j].getCity());
                            citiesClone[j]=null;
                        }
                    }
                }
                System.out.println();
            }
        }
    }

    public static void searchMyCity(String cityVal)
    {
        for(City c : cities)
        {
            if(c.getCity().equalsIgnoreCase(cityVal))
            {
                System.out.println(c);
                break;
            }
        }
    }

    // public static void orderCitiesByPopulation()
    // {
    //     City citiesClone[] = cities.clone();
    //     Arrays.sort(citiesClone,new CityPopulationComparator());
    //     for(City c : citiesClone)
    //     {
    //         System.out.println(c);
    //     }
    // }

    public static void lessPopulatedCity()
    {
        City citiesClone[] = cities.clone();
        Arrays.sort(citiesClone,new CityPopulationComparator());
        System.out.println("Less populated city is "+citiesClone[0].getCity());
    }

    public static void uniqueCityCapital()
    {
        City citiesClone[] = cities.clone();
        int count = 0, uniqueCityCount = 0;
        System.out.println("------------Uniques city capital---------------");
        for(int i = 0;i < citiesClone.length-1;i++)
        {
            count = 1;
            for(int j = i+1;j < citiesClone.length;j++)
            {
                if(citiesClone[i]!=null && citiesClone[j]!=null &&  citiesClone[i].getCapital().equalsIgnoreCase(citiesClone[j].getCapital()))
                {
                    count++;
                    citiesClone[j] = null;
                }
            }
            if(citiesClone[i] != null &&  count == 1)
            {
                uniqueCityCount++;
                System.out.println(citiesClone[i].getCity());
            }
        }
        System.out.println("----------Unique city capital count ------------\n"+uniqueCityCount);        
    }

    public static void countryWiseCityCount()
    {
        System.out.println("-----------Country wise unique city count----------------");
        City citiesClone[] = cities.clone();
        int i,j,count = 0, n = citiesClone.length; 
        for(i=0;i<n-1;i++)
        {
            count = 1;
            for(j=i+1;j<n;j++)
            {
               if(citiesClone[i]!=null && citiesClone[j]!=null && citiesClone[i].getCountry().equalsIgnoreCase(citiesClone[j].getCountry()))
               {
                    count++;
                    citiesClone[j] = null;
               }
            }
            if(citiesClone[i]!= null && count >= 1)
            {
                System.out.println(citiesClone[i].getCountry()+" "+count);
            }
        }
    }

    public static void uniqueCities()
    {
        City citiesClone[] = cities.clone();
        int count = 0, uniqueCityCount = 0;
        System.out.println("------------Uniques cities---------------");
        for(int i = 0;i < citiesClone.length-1;i++)
        {
            count = 1;
            for(int j = i+1;j < citiesClone.length;j++)
            {
                if(citiesClone[i].getCity().equalsIgnoreCase(citiesClone[j].getCapital()))
                {
                    count++;
                    citiesClone[j] = null;
                }
            }
            if(citiesClone[i] != null &&  count == 1)
            {
                uniqueCityCount++;
                System.out.println(citiesClone[i].getCity());
            }
        }
        System.out.println("----------Unique city count ------------\n"+uniqueCityCount);
    }

    public static void loadCities() throws FileNotFoundException, IOException {
        String fileName = "worldcities.csv";
        int k = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                City city = new City(parts[0].replaceAll("\"", ""), parts[1].replaceAll("\"", ""), parts[2].replaceAll("\"", ""), parts[3].replaceAll("\"", ""), parts[4].replaceAll("\"", ""), parts[5].replaceAll("\"", ""), parts[6].replaceAll("\"", ""), parts[7].replaceAll("\"", ""),
                        parts[8].replaceAll("\"", ""), parts[9].replaceAll("\"", ""), parts[10].replaceAll("\"", ""));
                cities[k++] = city;
                //cityList.add(city);
            }
        }
    }

    public static void printCities() {
        for(City city:cities)
        {
            System.out.println(city);
        }
    }

    public static void queriesOnCities() {
        // print unique cities
        System.out.println("Print unique cities");
        for (City city : cities) {
            System.out.println(city.getCity());
        }

        System.out.println("************************************************");

    }
}

class CityPopulationComparator implements Comparator<City> 
{

    @Override
    public int compare(City o1, City o2) {
        // TODO Auto-generated method stub
        return o1.getPopulation().compareToIgnoreCase(o2.getPopulation());
    }
    
}
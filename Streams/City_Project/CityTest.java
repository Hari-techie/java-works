import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CityTest {
    static List<City>Worldcities = new ArrayList<City>();
    public static void loadCities() throws IOException
    {
        String fileName = "worldcity.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = br.readLine()) != null)
            {
                String cit[] = line.split(",");
                dataCleaning(cit);
            }
        } 
    }
    public static void dataCleaning(String[] cities)
    {
        String city,city_ascii,country,iso2,iso3,capital,adminName;
        double latitude,longitude;
        long population,populationId;
        city = cities[0] ;
        city_ascii = cities[1] ;
        latitude = Double.parseDouble(cities[2] );
        longitude = Double.parseDouble(cities[3] );
        country =  cities[4] ;
        iso2 = cities[5] ;
        iso3 = cities[6] ;
        adminName = cities[7] ;
        capital = cities[8] ;
        population = Long.parseLong(cities[9] );
        populationId = Long.parseLong(cities[10] );

        City c = new City(city, city_ascii, latitude, longitude, country, iso2, iso3, adminName, capital, population, populationId);
        Worldcities.add(c);
    }
    public static void printCities()
    {
        Worldcities.forEach(System.out::println);
    }
    
    public static void uniqueCity()
    {
        Worldcities.stream().map(City::getCity).distinct().forEach(System.out::println);
    }

    public static void noOfUniqueCities()
    {
        long n = Worldcities.stream().map(City::getCity).distinct().count();
        System.out.println(n);
    }

    public static void CountryWiseCityCount()
    {
       Map<String,Long> CityCountMap =  Worldcities.stream().collect(Collectors.groupingBy(City::getCountry, Collectors.counting()));
       CityCountMap.entrySet().stream().forEach(e -> System.out.println(e.getKey()+" "+e.getValue()));
    }

    public static void cityInSameLat()
    {
        Map<Double,List<City>> citySameLat =  Worldcities.stream().map(c -> { c.setLat(Math.round(c.getLat())); return c;}).collect(Collectors.groupingBy(City::getLat));
        for(Map.Entry<Double,List<City>> entry: citySameLat.entrySet()){
            System.out.println("Latitude : "+entry.getKey()+"\nCities  : ");
            entry.getValue().stream().forEach(c -> System.out.println("\t"+c.getCity()));
        }
    }

    public static void cityInSameLng()
    {
        Map<Double,List<City>> cityInLng = Worldcities.stream().map(c -> { c.setLng(Math.round(c.getLng())); return c;}).collect(Collectors.groupingBy(City::getLng));
        for(Map.Entry<Double,List<City>> entry : cityInLng.entrySet())
        {
            System.out.println("Longitude : "+entry.getKey());
            System.out.println("Cites : ");
            entry.getValue().stream().forEach(e -> System.out.println("\t"+e.getCity()));
        }
    }

    public static void cityInSameLatOrLng()
    {
        System.out.println("Cities in same latitude ");
        cityInSameLat();
        System.out.println("Cities in same longitude ");
        cityInSameLng();
    }

    public static void orderCitiesByPopulation()
    {
        List<City> orderCity = Worldcities.stream().sorted(Comparator.comparingLong(City::getPopulation)).collect(Collectors.toList());
        orderCity.stream().forEach(c -> System.out.println(c.getCity()));
    }

    public static void countryWiseStateCount()
    {
        //Map<String,Long> stateCount = Worldcities.stream().collect(Collectors.groupingBy(City::getAdmin_name,Collectors.counting()));
        //Map<String,Map<String,Long>> stateCount = Worldcities.stream().collect(Collectors.groupingBy(City::getCountry),collect(Collectors.groupingBy(City::getAdmin_name,Collectors.counting())));
        Map<String,Map<String,Long>> stateCount = Worldcities.stream().collect(Collectors.groupingBy(City::getCountry, Collectors.groupingBy(City::getAdmin_name, Collectors.counting())));
        //stateCount.entrySet().stream().forEach(e -> System.out.println(e.getKey()+" "+e.getValue()));
        System.out.println("Country wise state count ");
        stateCount.forEach((country, stateAndItscounts) -> System.out.println(" - "+country+" : "+stateAndItscounts));
                // stateCount.forEach((country, count) -> {
        //    // System.out.println(country+" : ");
        //     stateCount.forEach((state, counts) -> System.out.println(" - "+state+" : "+counts));
        // });
    }

    public static void stateWiseCityCount()
    {
        Map<String,Map<String,Long>> cityCount = Worldcities.stream().collect(Collectors.groupingBy(City::getAdmin_name,Collectors.groupingBy(City::getCity,Collectors.counting())));
        System.out.println("State wise city count : ");
        cityCount.forEach((state, cityAndItsCount) -> System.out.println(" - "+state+" : "+cityAndItsCount));
    }

    public static void lessPopulatedCity()
    {
        Worldcities.stream().min(Comparator.comparing(City::getPopulation)).ifPresent(s ->  System.out.print(s.getCity()+" "+s.getPopulation()));
    }

    public static void searchByCity(String searchCity)
    {
        List<City> searchedCity = Worldcities.stream().filter(s -> s.getCity().equalsIgnoreCase(searchCity)).collect(Collectors.toList());
        searchedCity.forEach(System.out::println);
    }

    public static void listStatesByCountry()
    {
        Map<String,List<String>> statesByCountry = Worldcities.stream().collect(Collectors.groupingBy(City::getCountry,Collectors.mapping(City::getAdmin_name,Collectors.toList())));
        for(Map.Entry<String,List<String>> entry: statesByCountry.entrySet())
        {
            System.out.println("------Country : "+entry.getKey()+"--------------");
            entry.getValue().stream().forEach(s -> System.out.print(s+" "));
            System.out.println("\n---------------------------------");
        }
    }

    public static void selectedCountryAvgPopulation(String country)
    {
        double avg = Worldcities.stream().filter(s -> s.getCountry().equalsIgnoreCase(country)).mapToDouble(City::getPopulation).average().getAsDouble();
        System.out.println(country+" : "+avg);
    }

    public static void selectedCountrytotalPopulation(String country)
    {
        long tot = Worldcities.stream().filter(s -> s.getCountry().equalsIgnoreCase(country)).mapToLong(City::getPopulation).sum();
        System.out.println(country+" : "+tot);
    }

    public static void selectedCountryOrderByPopulation(String country)
    {
        System.out.println("Selected country : "+country);
        Worldcities.stream().filter(s -> s.getCountry().equalsIgnoreCase(country)).sorted(Comparator.comparing(City::getPopulation).reversed()).forEach(c -> System.out.println(c.getCity()+" -  "+c.getPopulation()));;
    }

    public static void listUniqueCapital()
    {
        /*Map<String,Long> uniqCap = Worldcities.stream().collect(Collectors.groupingBy(City::getCapital,Collectors.counting()));
        System.out.println(uniqCap);
        // for(Map.Entry<String,Long>entry : uniqCap.entrySet())
        // {
        //     if(entry.getValue()==1)
        //     {
        //         System.out.println(entry.getKey());
        //     }
        // }        */
        Worldcities.stream().map(City::getCapital).distinct().forEach(System.out::println);
    }

    public static void searchByCityAndLocateNearCity(String city)
    {
        double cityLat,cityLng;
        List<City> searchedCity = Worldcities.stream().filter(s -> s.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
        cityLat = searchedCity.get(0).getLat();
        cityLng = searchedCity.get(0).getLng();
        List<City> nearCity = Worldcities.stream().filter(cit -> !cit.getCity().equalsIgnoreCase(city)).peek(cit -> cit.setDistance(cit.distanceTo(cityLat, cityLng))).sorted((c1,c2)-> Double.compare(c1.getDistance(), c2.getDistance())).limit(5).collect(Collectors.toList());
        System.out.println(city+" "+cityLat+" "+cityLng);
        nearCity.forEach(s -> System.out.println(s.getCity()+" - "+s.getLat()+" - "+s.getLng()));
    }
    public static void main(String[] args) throws IOException {
        loadCities();
        //printCities();
        //uniqueCity();
        //noOfUniqueCities();
        //CountryWiseCityCount();
        //cityInSameLat();
        //cityInSameLng();
        //cityInSameLatOrLng();
        //orderCitiesByPopulation();
        //countryWiseStateCount();
        //stateWiseCityCount();
        //lessPopulatedCity();
        //searchByCity("Chennai");
        //listStatesByCountry();
        //searchByCityAndLocateNearCity("Chennai");
        //selectedCountryAvgPopulation("India");
        //selectedCountrytotalPopulation("India");
        //selectedCountryOrderByPopulation("India");
        //listUniqueCapital();

        // Sorting map in descending order
 /*       Map<String,Long> countryWiseCityCount = Worldcities.stream().collect(Collectors.groupingBy(City::getCountry,Collectors.counting()));
        countryWiseCityCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(e -> System.out.println(e.getKey()+" "+e.getValue())); 
       
        Worldcities.stream().collect(Collectors.groupingBy(City::getAdmin_name,Collectors.counting()))
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEach(e -> System.out.println(e.getKey()+" "+e.getValue())); */

        // to store in treeset
       // Worldcities.stream().map(City::getCountry).collect(Collectors.toCollection(TreeSet::new)).forEach(System.out::println);
    }
}

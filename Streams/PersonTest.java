import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PersonTest {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person("Ravi", 20), new Person("Ravi", 21), 
        new Person("Dhinesh", 25), new Person("Jai", 28));
        /*// maximum name
        //System.out.println(persons.stream().max(Comparator.comparing(Person::getName)));
       persons.stream().max(Comparator.comparing(Person::getName)).ifPresent(p -> System.out.println("Maximum : "+p.getName()));

       // minimum name
       persons.stream().min(Comparator.comparing(Person::getName)).ifPresent(p -> System.out.println("Minimum : "+p.getName()));

       // filter
       List<Person> nameWithI = persons.stream().filter(p -> p.getName().endsWith("i")).collect(Collectors.toList());
       nameWithI.stream().forEach(System.out::println);

       //count
       long n = persons.stream().filter(p -> p.getName().endsWith("i")).count();
       System.out.println(n);

       // distinct
       System.out.println("Distinct : ");
       List<String> distinctPerson = persons.stream().map(Person::getName).distinct().collect(Collectors.toList());
       distinctPerson.forEach(System.out::println);

       //skip
       persons.stream().skip(2).forEach(System.out::println); 

       //limit
       persons.stream().limit(3).forEach(System.out::println); 

       //allmatch 
       boolean b1 = persons.stream().allMatch(p -> p.getAge()<30);
       System.out.println(b1);

       //anymatch
       boolean b2 = persons.stream().anyMatch(p -> p.getName().startsWith("R"));
       System.out.println(b2);

       //nonematch
       boolean b3 = persons.stream().noneMatch(p -> p.getAge() > 30);
       System.out.println(b3); 

        // string reduce
        String[] myArray = { "this", "is", "a", "sentence" }; 
        String result = Arrays.stream(myArray).reduce("", (a, b) -> a + b);
        System.out.println(result); 

        // number reduce
        int[] myArray1 = { 1, 2, 3, 4 };
        int result1 = Arrays.stream(myArray1).reduce(0, (a, b) -> a + b);
        System.out.println(result1);

         // find any
        Optional<Person> anyEmpAbove40 = persons.stream().filter(emp -> emp.getAge() > 25).findAny();
        if (anyEmpAbove40.isPresent()) {
            System.out.println("Any Employee above age 40: " + anyEmpAbove40.get());
        } 

         // find first
        Optional<Person> o1 = persons.stream().filter(emp -> emp.getAge() > 20).findFirst();
        if (o1.isPresent()) {
            System.out.println("Any Employee above age 20: " + o1.get());
        } 

        // sort
        List<Person> slist = persons.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
        slist.forEach(System.out::println); */

         // peek
        List<Integer> list = Arrays.asList(10, 11, 12);
        list.stream().peek(i -> System.out.println(i * i)).collect(Collectors.toList());
    }
}

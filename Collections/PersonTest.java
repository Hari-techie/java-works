public class PersonTest {
    public static void main(String[] args) {
        Person p = new Person() {
            public void display(){System.out.println("Display method");}
        };
        p.display();
    }
}

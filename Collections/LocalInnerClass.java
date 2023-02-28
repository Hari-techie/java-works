public class LocalInnerClass {
    void display()
    {
        class Inner
        {
            void local()
            {
                System.out.println("Local ");
            }
        }
        Inner in = new Inner();
        in.local();
    }
    public static void main(String[] args) {
        LocalInnerClass obj = new LocalInnerClass();
        obj.display();
    }
}

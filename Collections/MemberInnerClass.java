public class MemberInnerClass{
    int data = 20;
    class Inner{
        int value;
        Inner(int value)
        {
            this.value = value;
        }
        void msg(){
            System.out.println("Data "+value);
        }
    }
    public static void main(String[] args) {
        MemberInnerClass ob = new MemberInnerClass();
        MemberInnerClass.Inner in = ob.new Inner(30);
        in.msg();
    }      
}
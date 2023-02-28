import java.util.Arrays;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of students : ");
        int num = sc.nextInt(),roll,age;
        String name;
        Student students[] = new Student[num];
        for(int i=0;i<num;i++)
        {
            System.out.print("Enter rollno : ");
            roll = sc.nextInt();
            System.out.print("Enter age : ");
            age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter name : ");
            name = sc.nextLine();
            students[i] = new Student(roll, age, name);
        }
        /*Student student1 = new Student(1, 20, "Kumar");
        Student student2 = new Student(2, 22, "Hari");
        Student student3 = new Student(3, 21, "Ravi");
        students[0] = student1;
        students[1] = student2;
        students[2] = student3;*/
        for(Student s:students)
        {
            System.out.println(s.getName()+" "+s.getRollNo()+" "+s.getAge());
        }
        Arrays.sort(students,new StudentNameComparator());
        System.out.println("Students after sorting name : ");
        for(Student s:students)
        {
            System.out.println(s.getName()+" "+s.getRollNo()+" "+s.getAge());
        }
        Arrays.sort(students,new StudentAgeComparator());
        System.out.println("Students after sorting age : ");
        for(Student s:students)
        {
            System.out.println(s.getName()+" "+s.getRollNo()+" "+s.getAge());
        }
    }
}

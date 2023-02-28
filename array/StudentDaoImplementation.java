import java.util.ArrayList;
import java.util.List;

class StudentDaoImplementation implements StudentDao
{
    List<Student>students;
    
    public StudentDaoImplementation()
    {
        students = new ArrayList<Student>();
        Student student1 = new Student(1,20,"Manoj");
        Student student2 = new Student(2, 25, "Raju");
        students.add(student1);
        students.add(student2);
    }
    @Override
    public List<Student> getAllStudents() {
        // TODO Auto-generated method stub

        return students;
    }

    @Override
    public Student getStudent(int rollNo) {
        // TODO Auto-generated method stub
        return students.get(rollNo);
    }

    @Override
    public void updateStudent(Student student) {
        // TODO Auto-generated method stub
        students.get(student.getRollNo()).setName(student.getName());
        System.out.println("Roll no : "+student.getRollNo()+" is updated");
    }

    @Override
    public void deleteStudent(Student student) {
        // TODO Auto-generated method stub
        students.remove(student.getRollNo());
        System.out.println("Roll no : "+student.getName()+" is deleted");
    }
    
}
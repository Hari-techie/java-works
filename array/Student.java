public class Student {
    private int rollNo,age;
    private String name;
    public Student(int rollNo, int age, String name) {
        this.rollNo = rollNo;
        this.age = age;
        this.name = name;
    }
    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Student [rollNo=" + rollNo + ", age=" + age + ", name=" + name + "]";
    }
    
  /*   @Override
    public int compareTo(Student o) {
        // TODO Auto-generated method stub
        if(age == o.age)
           return 0;
        else if(age < o.age)
            return -1;
        else 
            return 1;
    } 
    @Override
    public int compareTo(Student o) {
        return (name.compareTo(o.name));
    }*/
}

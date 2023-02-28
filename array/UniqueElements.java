import java.util.Arrays;
public class UniqueElements {
    public static void main(String[] args) {
        Employee employees[] = new Employee[4];
        employees[0] = new Employee(2,21,"Ravi");
        employees[1] = new Employee(3,22,"Hari");
        employees[2] = new Employee(3, 22, "Hari");
        employees[3] = new Employee(1, 24, "Kumar");
        Employee employeesIt[] = new Employee[2];
        employeesIt[0] = new Employee(5, 22, "Yuvi");
        employeesIt[1] = new Employee(7,23,"Karn");
        Employee allEmployees[][] = new Employee[2][];
        allEmployees[0] = employees;
        allEmployees[1] = employeesIt;
        //System.out.println(Arrays.deepHashCode(employees));
        /*System.out.println(Arrays.toString(employees));  // used for 1d array - primitive
        System.out.println(Arrays.toString(allEmployees)); // used for multi dimension - not used for primitive
        for(Employee allEmp[]: allEmployees)
        {
            System.out.println(Arrays.deepToString(allEmp));
        }*/
        //displayAllEmployees(employees);
        //findUniqEmployeeByCount(employees);
        //findUniqEmployeeBySort(employees);
        //System.out.println(employees[1].equals(employees[2]));
        //System.out.println(employees[1].hashCode());
    }
    public static void displayAllEmployees(Employee employees[])
    {
        System.out.println("-------------All employees------------");
        for(int i=0;i<employees.length;i++)
        {
            employees[i].display();
        }
    }
    public static void findUniqEmployeeBySort(Employee employees[])
    {
        Arrays.sort(employees);
        displayAllEmployees(employees);
        Employee uniqEmployees[] = new Employee[employees.length];
        int k=0;
        for(int i=0;i<employees.length;i++)
        {
            if(i==0 && employees[i].empId!=employees[i+1].empId)
            {
                uniqEmployees[k++]=employees[i];
            }
            else if(i==employees.length-1 && employees[i].empId!=employees[i-1].empId)
            {
                uniqEmployees[k++]=employees[i];
            }
            else if(employees[i].empId!=employees[i-1].empId && employees[i].empId!=employees[i+1].empId)
            {
                uniqEmployees[k++]=employees[i];
            }
        }
        System.out.println("-------------Unique employees : --------------");
        for(int i=0;i<k;i++)
        {
            System.out.print(i+" ");
            uniqEmployees[i].display();
        }
    }
    public static void findUniqEmployeeByCount(Employee employees[])
    {
        Employee uniqEmployee[] = new Employee[employees.length];
        int i,j,k=0,count=0;
        for(i=0;i<employees.length;i++)
        {
            count=0;
            for(j=0;j<employees.length;j++)
            {
                if(employees[i].name.equals(employees[j].name))
                {
                    count++;
                }
            }
            if(count==1)
            {
                uniqEmployee[k]=employees[i];
                k++;
            }
        }
        for(i=0;i<k;i++)
        {
            uniqEmployee[i].display();
        }   
    }
}
class Employee implements Comparable
{
    int empId,age;
    String name;
    public Employee(int empId, int age, String name) {
        this.empId = empId;
        this.age = age;
        this.name = name;
    }
    void display()
    {
        System.out.println("Empid : "+empId+" age : "+age+" name : "+name);
    } 
    @Override
    public int compareTo(Object o) {
        Employee temp = (Employee)o;
        if(this.empId>temp.empId)
        {
            return 1;
        }
        else if(this.empId<temp.empId)
        {
            return -1;
        }
        else 
        {
            return 0;
        }
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
           return true;
        if(obj == null || this.getClass()!= obj.getClass())
           return false;
        Employee emp = (Employee) obj;
        return (this.empId==emp.empId && this.age==emp.age && this.name==emp.name);
    }
    @Override
    public int hashCode() {
        return this.empId;
    }
    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", age=" + age + ", name=" + name + "]";
    }
    
}
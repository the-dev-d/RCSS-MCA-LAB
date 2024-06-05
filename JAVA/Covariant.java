class Employee {

    float salary = 40000;

    void display() {
        System.out.println("Employee");
    }
}
class Teacher extends Employee {

    float salary = 50000;

    void display() {
        System.out.println("Teacher");
    }
}
class EmployeeFactory {
    
    Employee getEmployee() {
        return new Employee();
    }
    
}
class TeacherFactory extends EmployeeFactory {
    
    Teacher getEmployee() {
        return new Teacher();
    }
    
}
class Covariant {

    public static void main(String[] args) {
        
        TeacherFactory tf = new TeacherFactory();
        Teacher t = tf.getEmployee();
        t.display();
    }
}
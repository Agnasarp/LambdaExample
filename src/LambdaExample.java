import java.util.*;

public class LambdaExample {
    public static void main(String args[]){
        System.out.println("This is my main method.");

        //Implementing the Runnable interface with Lambda
        new Thread(() -> {
            System.out.println("This is my second thread with Lambda.");
            System.out.println("This another line in the second thread.");
        }).start();

        //Sorting employee names with Lambda
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Smith", 30));
        employeeList.add(new Employee("Anne", 35));
        employeeList.add(new Employee("John", 40));

        /*Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        });*/

        Collections.sort(employeeList, (e1, e2) -> e1.getName().compareTo(e2.getName()));

        for (Employee e:employeeList){
            System.out.println(e.getName());
        }

        //Handling return values in Lambda
        /*UpperConcat uc = new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1 + " " + s2;
            }
        };*/

        UpperConcat uc = (s1, s2) -> s1 + " " + s2;

        System.out.println(uc.upperAndConcat(employeeList.get(0).getName(), employeeList.get(1).getName()));
    }
}

class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println("This is my second thread.");
    }
}

class Employee{
    public String name;
    public int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

interface UpperConcat{
    public String upperAndConcat(String s1, String s2);
}
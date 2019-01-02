import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> lst = new ArrayList<>();
        //        lst.add("mamta");
//        lst.add("sagar");
//        lst.add("vandna");
//        lst.add("test");
//        lst.add("zzyy");
//        lst.add("ankit");
//        Collections.sort(lst);
//        System.out.println(lst);

//        List<Employee> employeeList = new ArrayList<>();
//        employeeList.add(new Employee("sagar", 3000));
//        employeeList.add(new Employee("sagar", 2000));
//        employeeList.add(new Employee("pppp", 90));
//        employeeList.add(new Employee("ankit", 80));
//
//        Collections.sort(employeeList);
//        for (Employee employee : employeeList) {
//            System.out.println(employee);
//        }


        List<User> users = new ArrayList<>();
        users.add(new User("sagar", 3000));
        users.add(new User("sagar", 2000));
        users.add(new User("pppp", 90));
        users.add(new User("ankit", 80));

        Collections.sort(users, new ObjectComprator());
        for (User employee : users) {
            System.out.println(employee);
        }


        List<Person> people = new ArrayList<>();
        people.add(new Person("sagar", 3000));
        people.add(new Person("sagar", 2000));
        people.add(new Person("pppp", 90));
        people.add(new Person("ankit", 80));
        Collections.sort(people, new ObjectComprator());
        for (Person person : people) {
            System.out.println(person);
        }


    }
}

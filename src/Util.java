import java.util.Comparator;
import java.util.function.Predicate;

public class Util {
    public static Predicate<Person> findByNameWithSalary(String name, Integer salary) {
        return (it) -> it.getName().equals(name) && it.getSalary().equals(salary);
    }

    public static Predicate<Person> findByNamePrefix(String name) {
        return (it) -> it.getName().startsWith(name);
    }

    public static Predicate<Person> gt(Integer salary) {
        return (it) -> it.getSalary() > salary;
    }

    public static Predicate<Person> lt(Integer salary) {
        return (it) -> it.getSalary() < salary;
    }

    public static Comparator<Person> personComparator() {
        return (Person p1, Person p2) -> {

            int temp = p1.getName().compareTo(p2.getName());
            if (temp == 0) {
                return p1.getSalary().compareTo(p2.getSalary());
            }
            return temp;
        };
    }

    public static Comparator<Person> salaryComprator() {
        return (Person p1, Person p2) -> p2.getSalary().compareTo(p1.getSalary());
    }
}

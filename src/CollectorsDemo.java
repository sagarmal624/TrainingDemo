import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("sagar", 3000));
        personList.add(new Person("sagar", 2000));
        personList.add(new Person("pppp", 9000));
        personList.add(new Person("pppp", 9000));
        personList.add(new Person("ankit", 80));

        IntSummaryStatistics intSummaryStatistics = personList.stream().collect(Collectors.summarizingInt(Person::getSalary));
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getCount());
        System.out.println(intSummaryStatistics.getSum());


        List<String> list = new ArrayList<>();
        list.add("sagar");
        list.add("vandana");
        list.add("ankit");
        list.add("mamta");
        list.add("test");
        list.add("shyam");
        list.add("ram");


        String joined = list.stream().collect(Collectors.joining("="));
        System.out.println(joined);


        for (Person person : personList.stream().filter(it -> it.getSalary() > 2000).collect(Collectors.toCollection(LinkedList::new))) {
            System.out.println(person.toString());
        }

        Map<Boolean, List<Person>> listMap = personList.stream().collect(Collectors.partitioningBy(it -> it.getSalary() > 2000));
        System.out.println(listMap);


    }
}

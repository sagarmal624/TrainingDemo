import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Intermediate_Operation {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("sagar");
        list.add("vandana");
        list.add("ankit");
        list.add("mamta");
        list.add("test");
        list.add("shyam");
        list.add("ram");
        // upto java7
        List<String> copy = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("s")) {
                copy.add(name);
            }
        }
        //java 8
        System.out.println("java8=-----------------");
        List<String> response = list.stream().filter(it -> it.startsWith("s")).collect(Collectors.toList());
        System.out.println(response);

        // upto java7
        copy = new ArrayList<>();
        for (String name : list) {
            copy.add(name.toUpperCase());
        }
        //java 8
        System.out.println("java8=-----------------");
        response = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(response);


        System.out.println("java8=-----------------");
        response = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(response);

        Boolean result = list.stream().allMatch(it -> it.equals("sagar"));

        System.out.println(copy);


        List<Person> personList = new ArrayList<>();
        personList.add(new Person("sagar", 3000));
        personList.add(new Person("sagar", 2000));
        personList.add(new Person("pppp", 9000));
        personList.add(new Person("pppp", 9000));
        personList.add(new Person("ankit", 80));
        personList.stream().filter(it -> {
            System.out.println(it.toString());
            if (it.getSalary() > 1000)
                return true;
            return false;
        }).forEach(it -> {
            System.out.println("=======>" + it.toString());
        });
        List<String> list1 = personList.stream().map(Person::getName).distinct().sorted().collect(Collectors.toList());
        System.out.println(list1);
        Person person = personList.stream().findFirst().get();

        personList.stream().sorted(Util.personComparator()).collect(Collectors.toList());

        personList.stream().sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList());
        String temp = personList.stream().map(Person::getName).reduce((s1, s2) -> s1 + "&" + s2).get();
        System.out.println(temp);

        int a[] = {1, 2, 3, 4, 5};
        IntStream.of(a).boxed().mapToDouble(it -> it);

        personList.stream().sorted(Util.salaryComprator()).limit(1).collect(Collectors.toList()).forEach(System.out::println);

        Person min = personList.stream().min(Comparator.comparing(Person::getSalary)).get();
        Person min2 = personList.stream().min((t1, b) -> t1.getSalary().compareTo(b.getSalary())).get();
        System.out.println(min2.toString());

        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> map2 = personList.stream().collect(Collectors.groupingBy(Person::getSalary, Collectors.counting()));
        System.out.println(map2);

        Map<String, String> map1 = list.stream().collect(Collectors.toMap(String::toLowerCase, String::toUpperCase));
        System.out.println(map1);
    }
}

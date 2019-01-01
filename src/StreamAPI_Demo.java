import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI_Demo {
    public static void main(String[] args) {
// Ways to create s stream
//        int[] a = {1, 2, 3, 4, 5};
//        Stream.of(a);
//        List<String> list = new ArrayList<>();
//        list.add("12");
//        list.add("asdas");
//        list.add("#@432");
//        list.add("Asdad");
//        Stream<String> stream = list.stream();
//
//        Stream<Integer> nums = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        nums.forEach(System.out::println);
//        Stream<Date> dateStream = Stream.generate(() -> new Date());
//        dateStream.forEach(it -> System.out.println(it));
//// Convert Stream to list

        Stream<String> stream = Stream.of("sagar", "asdada", "asdas");
        List<String> strings = stream.collect(Collectors.toList());
        strings.forEach(System.out::println);
//convert to array

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        Integer[] objects = list.stream().toArray(Integer[]::new);

    }

}




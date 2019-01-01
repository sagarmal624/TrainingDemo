import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@FunctionalInterface
interface Addition {
    public Integer display(Integer a, Integer b);
}

public class Lambda_Exp_Functional_Interface_demo {
    public static void main(String[] args) {
//        Addition addition = new Addition() {
//            public Integer add(Integer a, Integer b) {
//                return a + b;
//            }
//        };
//        Runnable runnable = new Runnable() {
//            public void run() {
//                System.out.println("Thread is stretad now");
//            }
//        };
//        runnable.run();;
//
//        Addition addition1 = (a, b) -> {
//            return a + b;
//        };
//        Runnable runnable1 = () -> {
//            System.out.println("sadasdasdasdsa");
//        };
//
//        System.out.println(addition.add(10, 20));
//        System.out.println(addition1.add(10, 20));
//        runnable1.run();

        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("qwer");
        list.add("123");

//        list.forEach(i->System.out.println(i));
//        list.forEach(System.out::println);
        Consumer consumer = (a) -> System.out.println(a);
        consumer.accept(2);

        list.forEach(Lambda_Exp_Functional_Interface_demo::display);
    }

    public static void display(Object object) {
        System.out.println(object.toString());
    }
}

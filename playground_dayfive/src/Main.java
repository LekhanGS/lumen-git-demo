import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("hello world");
//        ComplexNumber a = new ComplexNumber(3,56);
//
//        double real = a.getReal();
//        double image= a.getImaginary();
//
//        System.out.printf("%s + i %s",real,image);
//        Person p1 = new Person("solk");
//        Person p2 = new Person("kolik");
//
//        System.out.println(p1.compareTo(p2));
//        List<Integer> list = List.of(1,2,9,3,4,5,6,7);
//
//        Stream<Integer> stream = list.stream();
//        list .stream()
//                .sorted((o1,o2)->o2-o1)
//                //.filter(e -> e % 2  != 1)
//                .map(e -> e * e)
//             .forEach(e -> {
//            System.out.println(String.format("each : %d",e));
//        } );
    List<Person> personList = List.of(
            new Person("a","b","c","d"),
            new Person("e","f","g","h"),
            new Person("I","J","L","L"),
            new Person("M","MN","OP","QR")

    );
//    personList
//            .stream()
//            .map(p->String.format("%s %s",p.getFirstName(),p.getLastName()))
//        .sorted(Comparator.reverseOrder())
//                .map(String::toUpperCase)
//            .limit(2)
//                .forEach(System.out::println);
//        Optional<Person> first = personList
//                .parallelStream()
//                .findFirst();
//
//        Person person = first.orElseThrow(()->new RuntimeException("Oops!"));
//        String[] collect = personList
//                .stream()
//                .map(p->String.format("%s %s",p.getFirstName(),p.getLastName()))
//                .toArray(String[]::new);
        personList.stream().forEach(System.out::println);

        Iterator<Person> iterator = personList.stream().iterator();
        while (iterator.hasNext()){
            Person p = iterator.next();
            System.out.println(p);
        }
    }
}
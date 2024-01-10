import java.time.LocalDate;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
//        Container<String> c = new Container<>("Like");
//        var c = new Container<>(1.9898776666);
//        Container<Double> x = new Container<>(890.098);
//         x.getElement();
//
//        c.setElement("lake");
//        Pair<String, Integer> mypairs= new Pair<>(null,null);
//        Pair<String,Integer> mypair = new Pair<>("19878",900);
//
//        String a = new String("hello world");
//        String b = "hello world";
//
//        System.out.println(a.equals(b));

        Sample s = new SampleImplementation();
//      s.printMessage("Heyy, Chad");
//
//        Sample s2 = (m) -> System.out.println("SampleImplementation: " + m);
//        s2.printMessage("fearce");
//
//        StringProvider sp = () -> "hello";
//
//        IntProduct ip = (a,b) -> {
//            return a*b;
//        } ;
//        System.out.println(ip.getProduct(23,56));
//
//        IntSquare is = (a)-> a*a;
//        System.out.println(is.getSquare(6));

//        Consumer<String> cs2 = s::printMessage;
//        cs2.accept("Hi there!");
//
//        Sample s2 = (m) -> System.out.println("SampleImplementation : " + m);
//        s2.printMessage("Good afternoon");
//
//        StringProvider sp = () -> "Hello";
//        Supplier<String> sp2 = () -> "Hello";
//
//        System.out.println(sp2.get());
//
//        Function<Integer, Integer> fl = (a) -> a * a;
//        System.out.println(fl.apply(4));
//
//        BiFunction<Integer, Integer, Integer> bf = (a, b) -> a * b;
//        System.out.println(bf.apply(5, 6));

        try {
            foo();
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
    }
    static void foo(){
        try{
            bar();
        }catch (RuntimeException re){
            System.out.println(re.getMessage());
    } }
    static void bar(){
        try{
            baz();
        }catch (RuntimeException re){
            System.out.println(re.getMessage());
        }
    }
    static void baz(){
        try {
            throw new RuntimeException("Oops");
        } catch (Exception re){
            System.out.println(re.getMessage());
            //throw new IllegalArgumentException("masked",re);
            //throw re;
        }finally {
            System.out.println("Finally baz");
        }
    }
}
@FunctionalInterface
interface StringProvider{
    String getString();
}

@FunctionalInterface
interface IntProduct{
    int getProduct(int a, int b);
}

@FunctionalInterface
interface IntSquare{
    int getSquare(int n);
}
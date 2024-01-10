public class Main {
    void Atom() {
        System.out.print("atom "); }
}
class Rock extends Atom {
    Rock(String type) {
        System.out.print(type); }
}
public class Mountain extends Rock {
    Mountain() {
        super();
        System.out.println("granite ");
    }
    public static void main(String[] a) {
        new Mountain();
    }
}
public class Pair <T,U>{
    private T element;
    private U aelement;

    public Pair(T element, U aelement) {
        this.element = element;
        this.aelement = aelement;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public U getAelement() {
        return aelement;
    }

    public void setAelement(U aelement) {
        this.aelement = aelement;
    }
}

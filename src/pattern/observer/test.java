package pattern.observer;

public class test {
    public static void main(String[] args) {
        subject sub = new subject();
        new observer1(sub);
        new observer2(sub);

        sub.doso();
    }
}

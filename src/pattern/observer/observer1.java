package pattern.observer;

public class observer1 implements observer{

    observer1(subject subject){
        subject.addObserver(this);
    }
    @Override
    public void dosome() {
        System.out.println("i see you");
    }
}

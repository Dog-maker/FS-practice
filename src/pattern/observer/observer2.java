package pattern.observer;

public class observer2 implements observer{
    observer2(subject subject){
        subject.addObserver(this);
    }
    @Override
    public void dosome() {
        System.out.println("2 see you");
    }
}

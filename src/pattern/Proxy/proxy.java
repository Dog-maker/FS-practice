package pattern.Proxy;

/**
 * 代理模式
 */
public class proxy implements person{
    private person person;

    proxy(person person){
        this.person = person;
    }

    @Override
    public void dosome() {
        person.dosome();
    }
}

package pattern.Adapter;

/**
 * 这才是真的适配器
 */
class student extends adapter implements person{
    @Override
    public void doSomething() {
        super.doSomething();
        System.out.println("I DO THIS");
    }
}

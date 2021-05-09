package pattern.Singleton;

/**
 * 单例设计模式
 */
public class Singleton {
}


class person{
    //懒
    private static person person;

    private person(){}

    public static person getPerson(){
        synchronized (person.class){
            if(person == null){
                person = new person();
            }
        }
        return person;
    }
    //饿
//    private static person person = new person();
//
//    private person(){}
//
//    public static person getPerson(){
//        return person;
//    }

}

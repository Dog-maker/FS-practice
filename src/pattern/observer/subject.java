package pattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class subject {
    List<observer> list = new ArrayList<>();

    public void addObserver(observer observer){
        list.add(observer);
    }

    public void doso(){
        System.out.println("I do");
        Observer();
    }

    public void Observer(){
        for(observer o : list){
            o.dosome();
        }
    }

}

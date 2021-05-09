package pattern.Builder;

/**
 * 建造者设计模式
 */
public class builder {
    public teacher build(){
        return new teacher(null,null);
    }
    public teacher build(String name){
        return new teacher(name,null);
    }
    public teacher build(String name,String age){
        return new teacher(name,age);
    }
}

interface person{
}

class teacher implements person{
    private String name;
    private String age;
    public teacher(String name,String age) {}
}
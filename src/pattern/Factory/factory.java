package pattern.Factory;

/**
 * 工厂设计模式
 */
public class factory {

    public person geteacher(){
        return new teacher();
    }
    public person getstu(){
        return new student();
    }
}

interface person{

}

class teacher implements person{
    teacher(){
        System.out.println("I am a teacher");
    }
}

class student implements person{
    student(){
        System.out.println("I am a student");
    }
}
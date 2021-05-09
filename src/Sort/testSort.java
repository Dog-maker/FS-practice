package Sort;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.xml.bind.Marshaller;
import java.util.Random;

public class testSort {
    private sort sort;
    public Integer[] arry;

    public static void main(String[] args) {
        testSort testSort = new testSort();
        testSort.addArray(10000000, 10000);
        sort sort = new merge(testSort.arry);
        testSort.addSort(sort);

//        System.out.println(testSort.toString());

        System.out.println(testSort.isSort());
        testSort.timeGet();

//        System.out.println(testSort.toString());

        System.out.println(testSort.isSort());

    }


    public void timeGet(){
        long begin,end;
        begin = System.currentTimeMillis();
        sort.takeSort();
        end = System.currentTimeMillis();
        System.out.println();
        System.out.println(sort.name+":排序时间为:"+(end - begin)+"ms");
    }

    public void addSort(sort sort){
        this.sort = sort;
    }

    public void addArray(int number,int index){
        Random random = new Random();
        Integer[] arry = new Integer[number];
        for (int x = 0;x<arry.length;x++)
            arry[x] = random.nextInt(index);
        this.arry = arry;
    }

    public String toString(){
        StringBuffer str = new StringBuffer();
        str.append(sort.name+":");
        for (Integer a:arry){
            str.append(a+",");
        }
        return str.toString();
    }

    public boolean isSort(){
        Integer ag = arry[0];
        for(Integer i : arry){
            if(i < ag)
                return false;
            ag = i;
        }
        return true;
    }
}

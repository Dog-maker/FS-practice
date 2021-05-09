package Sort;

import javafx.scene.layout.BackgroundRepeat;

/**
 * 归并排序
 */
public class merge extends sort{

    Integer[] newArray;

    merge(Integer[] array) {
        super(array);
        this.name = "归并排序";
    }

    @Override
    public void takeSort() {
        newArray = new Integer[array.length];
        divide(0, array.length);
    }

    //分
    public void divide(int begin,int end){
        if((begin+1) == end) return;
        int mid = (begin+end) >> 1;
        divide(begin, mid);
        divide(mid, end);
        marge(begin,mid,end);
    }

    //合
    public void marge(int begin,int mid,int end){
        int index1 = 0;
        int index2 = mid;
        int mas;
        System.arraycopy(array, begin, newArray, 0, mid-begin);
        for(int i = begin;i<end;i++){
            if(index1 == mid-begin){
                mas = array[index2++];
            }else if(index2 == end){
                mas = newArray[index1++];
            }else if(compare(newArray[index1], array[index2])>0){
                mas = array[index2++];
            }else {
                mas = newArray[index1++];
            }
            array[i] = mas;
        }
    }
}

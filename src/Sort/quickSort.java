package Sort;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 快速排序
 */
public class quickSort extends sort{
    Integer[] newArray;
    quickSort(Integer[] array) {
        super(array);
        this.name = "快速排序";
    }

    @Override
    public void takeSort() {
        newArray = new Integer[array.length];
        beginSort(array[0],1,array.length);
    }

    /**
     *
     * @param axes ：轴心
     * @param begin 开始点
     * @param end    结束点
     */
    private void beginSort(Integer axes, int begin, int end) {
        if(begin >= end)return;
        int index1 = begin;
        int index2 = end;
        int size = end-begin;
        System.arraycopy(array, begin, newArray, 0, size);
        for(int i = 0;i<size;i++){
            if(compare(axes, newArray[i])>0)
                array[(index1++)-1] = newArray[i];
            else
                array[(index2--)-1] = newArray[i];
        }
        array[index1-1] = axes;
        beginSort(array[begin-1],begin,index1-1);
        if(index1 >= array.length)
            return;
        beginSort(array[index1],index1+1,end);
    }

}

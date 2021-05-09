package Sort;

import sun.net.RegisteredDomain;

import javax.swing.text.StyledEditorKit;

/**
 * 这是傻逼想出来的
 */
public class analogy extends sort{

    private int max;
    private int min;
    Integer[] newArray;
    Integer[] redo;
    analogy(Integer[] array) {
        super(array);
        this.name = "类比排序";
        newArray = new Integer[array.length];
        redo = new Integer[array.length];
    }

    @Override
    public void takeSort() {
        findsort();
        for (Integer x:newArray) {
            System.out.print(x+" ");
        }
    }

    private void findsort() {
        int newArrayBegin = 0;
        int newArrayEnd = array.length;
        int minValue;
        int maxValue ;
        int local;
        int index;
        boolean isMax = true;
        boolean isMin = true;
        int mas;
        int begin = 0;
        int end = array.length;


        while (begin < array.length){
            if(array[begin] == -1){
                begin++;
                continue;
            }
            index = 0;
            local = 0;
            minValue = maxValue = mas = array[begin];
            redo[index++] = mas;
            for(int i = begin+1;i<array.length;i++){
                if(array[i] == -1)
                    continue;
                if(compare(mas, array[i])>0){
                    local++;
                    if(compare(array[i],minValue)<0) {
                        min = i;
                        minValue = array[i];
                        if(isMin)
                            isMin = false;
                    }
                }else if(mas == array[i]){
                    redo[index++] = array[i];
                    array[i] = -1;
                }else {
                    if(compare(array[i], maxValue)>0){
                        max = i;
                        maxValue = array[i];
                        if(isMax)
                            isMax = false;
                    }
                }

            }
            if(isMin){
                System.arraycopy(redo, 0, newArray, newArrayBegin, index);
                isMax = true;
                newArray[--end] = maxValue;
                array[max] = -1;
                array[begin++] = -1;
                newArrayBegin = newArrayBegin+index;
                newArrayEnd--;
                continue;
            }
            if(isMax){
                System.arraycopy(redo, 0, newArray, newArrayEnd-index, index);
                isMin = true;
                array[begin] = -1;
                newArray[newArrayBegin++] = minValue;
                array[min] = -1;
                end = end - index;
                newArrayEnd = newArrayEnd - index;
                continue;
            }

            System.arraycopy(redo, 0, newArray, begin+local, index);
            isMax = true;
            isMin = true;
            array[begin] = -1;
            newArray[newArrayBegin++] = minValue;
            newArray[--newArrayEnd] = maxValue;
            array[min] = -1;
            array[max] = -1;
            begin++;
            end--;
        }
    }


}

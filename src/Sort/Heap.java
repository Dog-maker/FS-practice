package Sort;

/**
 * 堆排序
 */
public class Heap extends sort{

    int heapSize;

    Heap(Integer[] array){
        super(array);
        name = "堆排序";
    }

    public void takeSort(){
        heapSize = array.length;
        for (int i = (heapSize>>1)-1; i>=0;i--){
            sifeDown(i);
        }

        while (heapSize>1){
            sweap(0,--heapSize);
            sifeDown(0);
        }
    }


    /**
     * 堆构建
     * @param index
     */
    private void sifeDown(int index){
        Integer element = array[index];

        int half = heapSize >> 1;
        while (index < half){
            int childIndex = (index << 1) + 1;
            Integer child = array[childIndex];

            int rightIndex = childIndex + 1;

            if(rightIndex < heapSize && compare(array[rightIndex],child)>0){
                child = array[childIndex = rightIndex];
            }

            if(compare(element, child) >= 0)break;

            array[index] = child;
            index = childIndex;
        }
        array[index] = element;
    }


}

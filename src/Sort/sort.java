package Sort;

public abstract class sort {
    public String name;

    protected Integer[] array;

    sort(Integer[] array){
        this.array = array;
    }

    public abstract void takeSort();


    protected int compareIndex(int index1,int index2){
        return array[index1]-array[index2];
    }

    protected int compare(Integer integer, Integer child) {
        return integer-child;
    }

    /**
     * 根据下标交换位置
     * @param i
     * @param i1
     */
    protected void sweap(int i, int i1) {
        int a = array[i];
        array[i] = array[i1];
        array[i1] = a;
    }
}

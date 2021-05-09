package Sort;

/**
 * 冒泡
 */
public class bubbling extends sort{
    bubbling(Integer[] array) {
        super(array);
        name = "冒泡排序";
    }

    @Override
    public void takeSort() {
        int sortindex = 0;
        for (int end = array.length ; end > 1 ;end--){
            sortindex = 1;
            for (int i = 1;i<end;i++){
                if(array[i-1]>array[i]){
                    int c = array[i-1];
                    array[i-1] = array[i];
                    array[i] = c;
                    sortindex = i;
                }
            }
            end = sortindex+1;
        }
    }
}

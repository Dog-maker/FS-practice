package Sort;

/**
 * 插入排序
 */
public class insertion extends sort{

    insertion(Integer[] array) {
        super(array);
        name = "插入排序";
    }

    //方法一
//    @Override
//    public void takeSort() {
//        for(int i = 1;i<array.length;i++){
//            for(int y = i-1;y>=0;y--){
//                if(compareIndex(i, y)<0){
//                    sweap(i,y);
//                    i = y;
//                }else {
//                    break;
//                }
//            }
//        }
//    }

    //优化 方法二 数组移动
//    public void takeSort() {
//        //被交换元素下标
//        int index;
//        for(int i = 1;i<array.length;i++){
//            index = -1;
//            for(int y = i-1;y>=0;y--){
//                if(compareIndex(i, y)<0){
//                    index = y;
//                }else {
//                    break;
//                }
//            }
//            if(index != -1)
//                moveArray(index,i);
//        }
//    }



    //优化 方法三 数组移动+二分查找
    public void takeSort() {
        //被交换元素下标
        int index;
        for(int i = 1;i<array.length;i++){
            index = -1;
            for(int y = i-1;y>=0;y--){
                if(compareIndex(i, y)<0){
                    index = findIndex(i);
                }
                break;
            }
            if(index != -1)
                moveArray(index,i);
        }
    }

    private int findIndex(int y) {
        int number = array[y];
        int mid;
        int begin = 0;
        int end = y;
        while(end > begin){
            if((begin+1) == end)
                break;
            mid = (end+begin)>>1;
            if(number<array[mid]){
                end = mid;
            }else {
                begin = mid;
            }
        }
        if(number>array[begin])
            return end;
        return begin;
    }


    //数组移动
    public  void moveArray(int x,int y){
        int mas = array[y];
        while (y > x){
            array[y] = array[y-1];
            y--;
        }
        array[x] = mas;
    }

}

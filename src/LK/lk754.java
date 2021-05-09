package LK;

import java.sql.ResultSet;

public class lk754 {

    public static void main(String[] args) {
        lk754 lk = new lk754();
        System.out.println(lk.reachNumber(19));
    }

    public int reachNumber(int target) {
        if(target<0)
            target = -target;
        int all = 0;
        int k = 0;
        int x;
        while (true){
            k++;
            all = k + all;
            x = all - target;
            if(x < 0){
                continue;
            }
            if((x)%2 == 0)
                return k;
        }
    }
}

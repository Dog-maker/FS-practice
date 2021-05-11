package LK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lk539 {

    public static void main(String[] args) {
        lk539 ls = new lk539();
        String[] s = {"22:27","18:42","09:57","09:24","09:26"};
        List<String> timePoints = new ArrayList<>();
        timePoints = Arrays.asList(s);

        System.out.println(ls.findMinDifference(timePoints));
    }

    public int findMinDifference(List<String> timePoints) {
        List<String> newTime = new ArrayList<>();
        newTime.add(timePoints.get(0));
        int result = 12*60;
        int time;
        for(int i = 1;i<timePoints.size();i++){
            for(String str : newTime){
                time = getTime(str, timePoints.get(i));
                if(result > time){
                    result = time;
                }
            }
            if(result == 0)
                break;
            newTime.add(timePoints.get(i));
        }

        return result;
    }

    public int getTime(String time1,String time2){
        if(time1 == time2)
            return 0;
        int[] t1 = toTime(time1);
        int[] t2 = toTime(time2);
        int result;

        if(t1[0] > t2[0]){
            result = calTime(t1, t2);
        }else {
            result = calTime(t2, t1);
        }
        if(result > (12*60))
            return (24*60)-result;
        return Math.abs(result);

    }

    public int calTime(int[] t1,int[] t2){
        int result =0;
        int calMinute = t1[1] - t2[1];
        if(calMinute > 0){
            return calMinute+(t1[0]-t2[0])*60;
        }else {
            return 60+calMinute+(t1[0]-t2[0]-1)*60;
        }
    }

    public int[] toTime(String str){
        String[] split = str.split(":");
        int[] time = new int[2];
        time[0] = Integer.valueOf(split[0]);
        time[1] = Integer.valueOf(split[1]);
        return time;
    }
}

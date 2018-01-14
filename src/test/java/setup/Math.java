package setup;

import java.util.ArrayList;

public class Math {
    static ArrayList<String>data=new ArrayList<>();
    public static void main(String args[]){
        String date = "Dec 29 22:58:37 ";
        String date1 = "Dec 29 23:02:25 ";
       long time=date(date);
       long time1=date(date1);
       long timedifference=time1-time;
       System.out.println("Time difference is"+timedifference);
       for(int i=0;i<data.size();i++){
           System.out.println("Data is"+data.get(i));
       }
       System.out.println("data size is"+data.size());



    }
    public static long date(String date){
        int hours = Integer.parseInt(date.substring(7,9));
        int minutes = Integer.parseInt(date.substring(10,12));
        int seconds= Integer.parseInt(date.substring(13,15));
        long timeInSeconds=(hours*3600)+(minutes*60)+seconds;
        data.add("string");
        data.add("abc");
        data.add("efgh");
        return timeInSeconds;



    }

}

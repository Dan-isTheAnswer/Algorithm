package IOandCalculation;

import java.io.*;
import java.util.StringTokenizer;

class ID2884 {

    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        ans(hour, min);
    }

    private static void ans (int hour, int min) {
        
        int ansMin, ansHour;

        if (min < 45) {
            if (hour == 0) {
                ansMin = min +15;
                ansHour = 23;
            } else {
                ansMin = min +15;
                ansHour = hour -1;
            }
        } else {
            if (hour == 0) {
                ansMin = min -45;
                ansHour = hour;
            } else {
                ansMin  = min -45;
                ansHour = hour;
            }
        }

        System.out.println(ansHour + " " + ansMin);
    }
}
// summary*
// 0 ~ 23 hour and 0 ~ 59 min.
// -45 min. 

// min changes*
// 0-44 -> 15 16 17 18 19 20 ... 59 : +15 min and -1 hour
// 45-59 -> 0 1 2 ... 14  : -45 min

// hour changes*
// 0 -> 23 : if 0, 23
// 1-23 -> 0 1 2 ... 22 : -1 hour


// data
// 1) 10 10 -> 9 25; 2) 0 35 -> 23 45; 3) 0 45 -> 0 0;
package SegmentTreeAndDP;

import java.util.Scanner;

public class BoxisPull {
    public static void main(String at[]){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++){
            int x1=s.nextInt();
            int y1=s.nextInt();
            int x2=s.nextInt();
            int y2=s.nextInt();
            greed(x1,y1,x2,y2);

        }
    }
    static void greed(int x1,int y1,int x2,int y2){
        int x=Math.abs(x1-x2);
        int y=Math.abs(y1-y2);
        if(x==0 && y==0){
            System.out.println("0");
            return;
        }
        else if(x==0||y==0){
            System.out.println(Math.max(x,y));
            return;
        }
        ///////////////////
        System.out.println((x+y+2));
    }
}

package SegmentTreeAndDP;

import java.util.Scanner;

public class BeltedRooms {
    public static void main(String at[]){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++){
            int n=s.nextInt();
            String str=s.next();

            greed(str);

        }
    }
    static void greed(String str){
        int dash=0;
        int up=0;
        int down=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='-'){
                dash++;
            }
            else if(str.charAt(i)=='>'){
                up++;
            }
            else if(str.charAt(i)=='<'){
                down++;
            }

        }
        //////////
        if(dash+up==str.length()||dash+down==str.length()){
            System.out.println(str.length());
            return;
        }
        ////////////
        int count=0;
        int n= str.length();
        for(int i=0;i<str.length();i++){
            int prev=i-1;
            if(i==0){
                prev=n-1;
            }
            ///////////////
            if(str.charAt(i)=='-'||str.charAt(prev)=='-'){
                count++;
            }

        }
        System.out.println(count);
    }
}

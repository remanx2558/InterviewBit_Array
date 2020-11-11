package SegmentTreeAndDP;

import java.util.Scanner;

public class PerformEasily {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        long str[]=new long [6];
        for(int i=0;i<6;i++){
            str[i]=s.nextLong();
        }
        int n=s.nextInt();
        long note[]=new long [n];
        for(int i=0;i<n;i++){
            note[i]=s.nextLong();
        }
        greed(str,note,n);
    }
    static void greed(long str[],long note[],int n){
        long min=Integer.MAX_VALUE;
        long max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(min>note[i]){
                min=note[i];
            }
            if(max<note[i]){
                max=note[i];
            }
        }
        /////////////////////////////
        long ans=Integer.MAX_VALUE;
        long less=Integer.MAX_VALUE;
        long more=Integer.MIN_VALUE;


        for(int i=0;i<6;i++){
            long note1=min+str[i];
            for(int j=0;j<6;j++){
                long note2=max+str[j];

                if(less>note1){
                    less=note1;
                }
                if(more<note1){
                    more=note1;
                }
                if(less>note2){
                    less=note2;
                }
                if(more<note2){
                    more=note2;
                }

                ans=Math.min(ans,Math.abs(more-less));

            }
        }
        System.out.println(ans);




    }
}

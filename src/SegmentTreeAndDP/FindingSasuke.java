package SegmentTreeAndDP;

import java.util.Scanner;

public class FindingSasuke {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++){
            int n=s.nextInt();
            int arr[]=new int[n];
            for(int j=0;j<n;j++){
                arr[j]=s.nextInt();
            }
            greed(arr);
        }

    }
    static void greed(int []arr){
        /////////
        int ans[]=new int[arr.length];
        for(int i=0;i+1< ans.length;i=i+2){
            ans[i]=arr[i+1]*(-1);
            ans[i+1]=arr[i];

        }
      for(int i=0;i< ans.length;i++){
          System.out.print(ans[i]+" ");
      }
      System.out.println();

    }
}

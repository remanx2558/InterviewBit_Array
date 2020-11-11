package Codeforces_November;

import java.util.Scanner;

public class ExtremeSubtraction {
    public static void main(String[]args){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int p=0;p<t;p++){

            int n=s.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=s.nextInt();

            }
            greed(arr);

        }

    }
    static void greed(int []arr){
        int diff[]=new int[arr.length];

        int n= arr.length;

        diff[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            diff[i]=arr[i]-arr[i-1];
        }

        int max=diff[0];
        for(int i=1;i<n;i++){
            if(diff[i]<0 && max+ diff[i]>=0){
                max=diff[i]+max;
                diff[i]=0;
            }
        }
        boolean ff=true;
        for(int i=0;i<n;i++){
            ff=ff && (diff[i]>=0);
        }


        if(ff){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

    }
}

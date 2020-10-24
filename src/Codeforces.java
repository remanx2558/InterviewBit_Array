import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Codeforces {
    public static void main(String args[])throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int p=0;p<t;p++){
            String arr[]=br.readLine().split(" ");
            int arr2[]=new int[arr.length];
            for(int i=0;i<arr.length;i++){
                arr2[i]=Integer.parseInt(arr[i]);
            }
            greed(arr2);
        }


    }
    static void greed(int []arr){
        int nc=0;
        int ns=1;
        int x=arr[0];
        int y=arr[1];
        int k=arr[2];
        int count=0;

        makecoal(nc,ns,x,y,k,count);
        makestick(nc,ns,x,y,k,count);


        System.out.println(count);


    }
    static void makecoal(int nc,int ns,int x,int y,int k,int count) {
        while (nc < k) {
            if (ns < y + 1) {
                ns = ns + (x - 1);
                count++;
                System.out.println("count increased");
            } else if (ns >= y + 1 && nc < k) {
                nc = nc + 1;
                ns = ns - y;
                count++;
            }
        }
    }

        static void makestick(int nc,int ns,int x,int y,int k,int count){
            while(ns<k){
                ns=ns+(x-1);
                count++;
                System.out.println("count increased");

            }
    }
}

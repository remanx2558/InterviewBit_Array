import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Array1 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int p = 0; p < t; p++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int x = s.nextInt();
            int y = s.nextInt();
            int n = s.nextInt();
            greed(a,b,x,y,n);

        }
    }
static void greed(int a ,int b,int x,int y,int n){

        int cx=a-x;
        int cy=b-y;

        while(n!=0 && !(cx==0 && cy==0)){
            if(a>b && cy>0){
                ////reduce b
                if(cy==n){
                    b=b-cy;
                    n=0;
                    cy=0;
                }
                else if(cy>n){
                    b=b-n;
                    n=0;
                    cy=cy-n;
                }
                else if(cy<n){
                    b=b-cy;
                    cy=0;
                    n=n-cy;


                }}
            else if(a<b && cx>0){
                ////reduce b
                if(cx==n){
                    a=a-cx;
                    n=0;
                    cx=0;
                }
                else if(cx>n){
                    a=a-n;
                    n=0;
                    cx=cx-n;
                }
                else if(cx<n){
                    a=a-cx;
                    cx=0;
                    n=n-cx;

                }


            }
            else if(a==b){
                break;
            }

        }
        long ans=a*b;
        System.out.println("a is "+a+" b is "+b+" cx "+cx+" cy is "+cy+" and n is "+n);
        System.out.println(ans);



}


}



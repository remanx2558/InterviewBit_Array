package Codeforces_November;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TheDeliverDelima {
    static class pair{
        long f;
        long s;
        pair(long ff,long ss){
            f=ff;
            s=ss;
        }

    }
    static class my implements Comparator<pair> {

        @Override
        public int compare(pair p1, pair p2) {
            int k=p1.f>p2.f?-1:1;
            if(p1.f==p2.f && p1.s!=p2.s){
                k=p1.s>p2.s?-1:1;
            }
            else if(p1.f==p2.f && p1.s==p2.s){
                k=0;
            }
            return k;
        }
    }
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int p=0;p<t;p++){
            PriorityQueue<pair>pq=new PriorityQueue<pair>(new my());

            int n=s.nextInt();
            long arr1[]=new long[n];
            long arr2[]=new long[n];

            for(int i=0;i<n;i++){
                arr1[i]=s.nextLong();
            }
            long sum=0;
            for(int i=0;i<n;i++){
                arr2[i]=s.nextLong();
                sum=sum+arr2[i];
            }
            for(int i=0;i<n;i++){
                pq.add(new pair(arr1[i],arr2[i]));
            }
            greed(pq,sum);


        }

    }
    static void greed(PriorityQueue<pair>pq,long s){

        long ans=0;
        long sum=0;
//        while (!pq.isEmpty()){
//            System.out.print(pq.poll().f+"/");
//        }

        while (!pq.isEmpty()){
            pair curr=pq.poll();
            sum=sum+ curr.s;
            if(sum< curr.f){
                continue;
            }
            else if(sum>curr.f){
                ans=Math.max(sum- curr.s, curr.f);
                System.out.println(ans);
                return;
            }
            else{
                System.out.println(curr.f);
                return;
            }



        }

        if(ans!=0){
            System.out.println(ans);
        }
        else{
            System.out.println(s);
        }
       // System.out.println("um is "+s);





    }
}

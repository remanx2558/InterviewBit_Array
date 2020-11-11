package SegmentTreeAndDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class swapMin {
    public static void main(String ars[]){

        int []a = {101, 758, 315, 730, 472,
                619, 460, 479 };
        sweta(a);

    }
    static int val;
    static void sweta(int []arr) {
        int arr2[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }

        Arrays.sort(arr2);

         HashMap<Integer,Integer>hm=new HashMap<Integer, Integer>();
        for(int i=0;i< arr.length;i++){
            hm.put(arr2[i]-1,i);
        }
        ////////////////////////////////
        boolean visited[] = new boolean[arr.length];
        int ans = 0;
        for(int i=0;i< arr.length;i++){

            if(visited[i]==true||hm.get(arr[i]-1)==i){
//                if(visited[i]==true){
//                    System.out.println("continues as visited");
//
//                }
//                else{
//                    System.out.println("continues as same");
//                }

                continue;
            }

            int count=0;

            int j=i;
            while(visited[j]==false){
                visited[j]=true;
                count++;


                j=hm.get(arr[j]-1);

            }
            if(count>0){
                ans=ans+(count-1);
            }


        }
        System.out.println(ans);
    }
}

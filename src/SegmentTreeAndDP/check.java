package SegmentTreeAndDP;

import java.util.HashMap;

public class check {
    public static void main(String args[]){


        int []arr = {85};
        int[][]pieces = {{85}};
        System.out.println(canFormArray(arr,pieces));

    }
   static public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<String,Integer> hm=new HashMap<String,Integer>();
        int m=pieces.length;

        for(int i=0;i<m;i++){
            int n=pieces[i].length;
            String str="";
            for(int j=0;j<n;j++){
                str=str+pieces[i][j]+"/";
                System.out.println(str+"its added");
            }
            hm.put(str,1);
        }
        return greed(0,arr,hm);
    }
    static boolean greed(int i,int[]arr,HashMap<String,Integer>hm){
        int n=arr.length-1;
        if(i>=arr.length){
            return true;
        }


        for(int j=i;j<=n;j++){
            String str="";
                    //+arr[i]+"/";

            for(int k=i;k<=j;k++){
                str=str+arr[k]+"/";
            }
            System.out.println("looking at "+str);
            if(hm.containsKey(str)){
                boolean b=greed(j+1,arr,hm);
                if(b){
                    return b;
                }
            }

        }
        return false;

    }
}

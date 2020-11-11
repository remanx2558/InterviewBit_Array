package SegmentTreeAndDP;

import java.util.Arrays;

public class part2_heck {
    public static void main(String args[]){


        int []arr = {4,12,2,7,3,18,20,3,19};
        System.out.println(furthestBuilding(arr,10,2));

    }
    static int ans;
 static  public int furthestBuilding(int[] heights, int bricks, int ladders) {
        ans=0;
        greed(0,heights,bricks,ladders);


        return ans;

    }
  static  void greed(int i,int h[],int b,int l){
        if(i>=h.length){
            ans=h.length-1;
            return;
        }
        ans=Math.max(i,ans);
        if(i+1<h.length){

            if(h[i]>=h[i+1]){
                greed(i+1,h,b,l);
                return;
            }
            ////use bricks
            int diff=h[i+1]-h[i];

            if(h[i]<h[i+1] && b>=diff){
                greed(i+1,h,b-diff,l);

            }
            if(h[i]<h[i+1] && l>0){
                greed(i+1,h,b,l-1);
            }
            ///use ladder


        }
        else{
            ans=Math.max(i,ans);
        }

    }
}

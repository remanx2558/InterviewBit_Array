package AmazonTarget;

import java.util.Arrays;
import java.util.Comparator;

public class StringArrange {
    public static void main(String args[]){
        String arr[]={"3", "30", "34", "5", "9"};

        System.out.println(printLargest(arr));
    }
  static String printLargest(String[] arr) {
        // code here
      Arrays.sort(arr,new my());
        String str="";

        for(int i=arr.length-1;i>=0;i--){
            str=str+arr[i];
        }
        return str;
    }
   static class my implements Comparator<String>{

       @Override
       public int compare(String aa, String bb) {
           int s1=aa.length();
           int s2=bb.length();
           int k=Math.max(s1,s2);






           if(s1>s2){
               return 1;
           }
           else if(s1<s2){
               return -1;
           }
           return 1;
       }
   }
}

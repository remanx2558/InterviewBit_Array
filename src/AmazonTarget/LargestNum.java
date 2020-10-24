package AmazonTarget;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNum {
    public static void main(String args[]){
        String []arr={"54", "546", "548", "60"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(printLargest(arr));
    }
   static String printLargest(String[] arr) {
        // code here
        String str="";
        Arrays.sort(arr,new my());

        for(int i=arr.length-1;i>=0;i--){
            str=str+arr[i];
        }
        return str;
    }
   static class my implements Comparator<String> {

        public int compare(String a,String b){
            String ab=a+b;
            String ba=b+a;
            return ab.compareTo(ba)>0?1:-1;
        }

    }
}

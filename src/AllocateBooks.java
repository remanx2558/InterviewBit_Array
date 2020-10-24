import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AllocateBooks {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        int B=4;
        int A[]={ 5, 17, 100, 11};
        ArrayList<Integer> al=new ArrayList<Integer>();


       System.out.println(books(A,B));

    }
    static long get_min(int[] A, long B){
        int total = 0, reqPainters = 1;
        for(Integer a : A){
            total += a;
            if(total > B){
                total=a;

                reqPainters++;
            }
        }

        return reqPainters;
    }
    static long binS(int[] A, int B,long s,long e){
        if(s<e){
            long mid=s+((e-s)/2);
            long val=get_min(A,mid);
          //  System.out.println("mid is "+mid+" and val is "+val);
            if(val>B){
               // System.out.println("up s"+(mid+1)+" e "+e);
                return binS(A,B,mid+1,e);
            }
            else if(val<=B){
             //   System.out.println("up s"+s+" e "+mid);

                return binS(A,B,s,mid);
            }
        }
        return e;
    }
   static  public int books(int[] A, int B) {

        if(A.length<B){
            return -1;
        }
        int start=Integer.MIN_VALUE;
        int end=0;
        for(int i=0;i<A.length;i++){
            end=end+A[i];
            start=Math.max(start,A[i]);
        }
       // System.out.println("start is "+start+" end is "+end);
        long ans=binS(A,B,start,end);
        return (int)ans;


    }
}

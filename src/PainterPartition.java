import java.util.ArrayList;
import java.util.Scanner;

public class PainterPartition {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int A=5;
                int B=10;
                        int arr[]={ 658, 786, 531, 47, 169, 397, 914};
        ArrayList<Integer>al=new ArrayList<Integer>();

        for(int i=0;i<arr.length;i++){
            al.add(arr[i]);
        }
            System.out.println(paint(A,B,al));

        }
  static public int paint(int A, int B, ArrayList<Integer> C) {

        /////////
      long total = 0, max = Long.MIN_VALUE;
      for(Integer c : C){
          total += c;
          max = Math.max(max,c);
      }
      long l = max, h = total;

      while(l<h){
          long mid = (l + (h-l)/2);
          long reqPainters = getRequiredPainters(C,mid);
          if(reqPainters <= A) h = mid;
          else l = mid + 1;
      }
      long ans = ((l%10000003)*(B%10000003))%10000003;
      return (int)ans;
//        ////////
//        int start=0;
//        int end=0;
//        for(Integer c : C){
//            start=Math.max(start,c);
//            end=end+c;
//        }
//
//        int ans=binS(C,start,end,A);
//        ans=((ans%10000003)*(B%10000003))%10000003;
//
//        return ans;
    }
    static int binS(ArrayList<Integer> C,int s,int e,int A){
        if(s<e){
            int mid=s+(e-s)/2;

            int val=get_min(C,mid);

            if(val>A){
                return binS(C,mid+1,e,A);
            }
            else if(val<=A){
                return binS(C,s,mid,A);
            }


        }

        return s;

    }
    static int get_min(ArrayList<Integer> C,int k){
        int total = 0, reqPainters = 1;
        for(Integer a : C){
            total += a;
            if(total > k){
                total = a;
                reqPainters++;
            }
        }
        return reqPainters;
    }

    static public long getRequiredPainters(ArrayList<Integer> A , long k){
        long total = 0, reqPainters = 1;
        for(Integer a : A){
            total += a;
            if(total > k){
                total = a;
                reqPainters++;
            }
        }
        return reqPainters;
    }

}

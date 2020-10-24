import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MedianOfArray {


    ////////
    static public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        double ans=0;
        if(a.size()>b.size()){
            ans=greed(b,0,b.size(),a);
        }else{
            ans=greed(a,0,a.size(),b);
        }

        return ans;

    }
   static public double greed(final List<Integer> a, int l, int r, final List<Integer> b) {
        // if(a.size()>b.size()) return findMedianSortedArrays(b, a);

        int x = a.size();
        int y = b.size();

        int low = l; int high = r;

        if(low<=high){
            int partitionX = (low+high)/2;
            int partitionY = (x+y+1)/2-partitionX;

            int leftMaxX = (partitionX==0)? Integer.MIN_VALUE: a.get(partitionX-1);
            int leftMaxY = (partitionY==0)? Integer.MIN_VALUE:b.get(partitionY-1);

            int rightMinX = (partitionX==x)? Integer.MAX_VALUE:a.get(partitionX);
            int rightMinY = (partitionY==y)? Integer.MAX_VALUE:b.get(partitionY);

            if((leftMaxX<=rightMinY)&& (leftMaxY<=rightMinX)){
                if((x+y)%2==0){
                    return ((double)Math.max(leftMaxX,leftMaxY)+Math.min(rightMinX, rightMinY))/2;
                }else{
                    return ((double)Math.max(leftMaxX, leftMaxY));
                }
            }else if(leftMaxX>rightMinY) {
                return greed(a,l,partitionX-1,b);
                //  high = partitionX-1;

            }
            else {
                //low = partitionX+1;
                return greed(a,partitionX+1,r,b);
            }
        }
        return -1;

    }

    public static void main(String args[]){
    int A[]={-43, -25, -18, -15, -10, 9, 39, 40  };
    int B[]={-2};
    ArrayList<Integer>a=new ArrayList<Integer>();
        ArrayList<Integer>b=new ArrayList<Integer>();
for(int i=0;i<A.length;i++){
    a.add(A[i]);
}
        for(int i=0;i<B.length;i++){
            b.add(B[i]);
        }
        System.out.println(findMedianSortedArrays(a,b));

    }
}

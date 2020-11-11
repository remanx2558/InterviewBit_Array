package GFG_InterView_Pre;

public class RangeLCMQueries {
    static long gcd(long a,long b){
        if(a==0){
            return b;
        }
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    static long lcm(long a,long b){
        long gcd=gcd(a,b);
        long mul=a*b;
        return mul/gcd;
    }
    static long st[];
    static int getMid(int s, int e) {
        return s + (e - s) / 2;
    }
   // static long multi[];
    //static long count=0;
    public static long getLCM(long stt[], long arr[], int n, int qs, int qe)
    {
        //Your code here
        st=stt;
//        if(count==0){
//            multi=new long[arr.length];
//            for(int i=0;i<arr.length;i++){
//                multi[i]=arr[i]*multi[i-1];
//            }
//        }
//        count++;

        if (qs < 0 || qe > n - 1 || qs > qe) {
            // System.out.println("Invalid Input");
            return 1;
        }
        return findRangelcmUtil(0, n - 1, qs,qe, 0);
    }
//    static long getmulti(int l,int r){
//        if(r>multi.length||l>multi.length||r<0||l<0 ){
//            return 1;
//        }
//        if(l==0){
//            return multi[r];
//        }
//        return multi[r]/multi[l-1];
//    }
    static long findRangelcmUtil(int ss, int se, int qs, int qe, int si)
    {
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (qs <= ss && qe >= se)
        { return st[si];}

        // If segment of this node is outside the given range
        if (se < qs || ss > qe)
            return 1;

        // If a part of this segment overlaps with the given range
        int mid = getMid(ss, se);

        long left=findRangelcmUtil(ss, mid, qs, qe, 2 * si + 1);
        long right=findRangelcmUtil(mid + 1, se, qs, qe, 2 * si + 2);
        return  lcm(left,right);
    }

    // update arr array at index with value new_val
    public static void updateValue(long arr[], long stt[], int n, int i, long new_val)
    {
        // Your code here
        st=stt;
        // Check for erroneous input index
        if (i < 0 || i > n - 1) {
            //System.out.println("Invalid Input");
            return;
        }

        // Get the difference between new value and old value
        // int diff = new_val - arr[i];

        // Update the value in array
        arr[i] = new_val;

        // Update the values of nodes in segment tree
        updateValueUtil(0, n - 1, i, new_val, 0);
    }
    static  void updateValueUtil(int ss, int se, int i, long diff, int si)
    {
        // Base Case: If the input index lies outside the range of
        // this segment
        if (i < ss || i > se)
            return;

        if(ss==se){
            st[si]=diff;
            return;
        }


        // If the input index is in range of this node, then update the
        // value of the node and its children
        //st[si] = st[si] + diff;


        int mid = getMid(ss, se);
        updateValueUtil(ss, mid, i, diff, 2 * si + 1);
        updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);



        st[si]=lcm(st[2 * si + 1],st[2 * si + 2]);

    }


}

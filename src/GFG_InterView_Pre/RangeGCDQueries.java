package GFG_InterView_Pre;

public class RangeGCDQueries {
    static int gcd(int a,int b){
        if(a==0){
            return b;
        }
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    static int st[];
    static int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    public static int findRangeGcd(int l, int r, int stt[],int n)
    {
        //Your code here
        // Your code here
        st=stt;
        // Check for erroneous input values
        if (l < 0 || r > n - 1 || l > r) {
            // System.out.println("Invalid Input");
            return 0;
        }
        return findRangeGcdUtil(0, n - 1, l,r, 0);

    }
    static int findRangeGcdUtil(int ss, int se, int qs, int qe, int si)
    {
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (qs <= ss && qe >= se)
        { return st[si];}

        // If segment of this node is outside the given range
        if (se < qs || ss > qe)
            return 0;

        // If a part of this segment overlaps with the given range
        int mid = getMid(ss, se);

        int left=findRangeGcdUtil(ss, mid, qs, qe, 2 * si + 1);
        int right=findRangeGcdUtil(mid + 1, se, qs, qe, 2 * si + 2);
        return  gcd(left,right);
    }



    public static void updateValue(int i, int new_val, int arr[], int stt[], int n) {
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
    static  void updateValueUtil(int ss, int se, int i, int diff, int si)
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



        st[si]=gcd(st[2 * si + 1],st[2 * si + 2]);

    }

}

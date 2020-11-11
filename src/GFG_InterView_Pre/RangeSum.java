package GFG_InterView_Pre;

public class RangeSum {
    static void updateValue(int arr[], long stt[], int n, int i, int new_val) {
        // Your code here
        st=stt;
        // Check for erroneous input index
        if (i < 0 || i > n - 1) {
            //System.out.println("Invalid Input");
            return;
        }

        // Get the difference between new value and old value
        int diff = new_val - arr[i];

        // Update the value in array
        arr[i] = new_val;

        // Update the values of nodes in segment tree
        updateValueUtil(0, n - 1, i, diff, 0);
    }
    static  void updateValueUtil(int ss, int se, int i, int diff, int si)
    {
        // Base Case: If the input index lies outside the range of
        // this segment
        if (i < ss || i > se)
            return;


        // If the input index is in range of this node, then update the
        // value of the node and its children
        st[si] = st[si] + diff;
        if (se != ss) {
            int mid = getMid(ss, se);
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }

    // function to compute minimum and maximum in a given range
    public static long getSum(long stt[], int n, int l, int r) {
        // Your code here
        st=stt;
        // Check for erroneous input values
        if (l < 0 || r > n - 1 || l > r) {
            // System.out.println("Invalid Input");
            return -1;
        }
        return getSumUtil(0, n - 1, l,r, 0);

    }
    static long st[];
    static int getMid(int s, int e) {
        return s + (e - s) / 2;
    }
    static long getSumUtil(int ss, int se, int qs, int qe, int si)
    {
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (qs <= ss && qe >= se)
            return st[si];

        // If segment of this node is outside the given range
        if (se < qs || ss > qe)
            return 0;

        // If a part of this segment overlaps with the given range
        int mid = getMid(ss, se);
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
                getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
    }
    static long constructSTUtil(int arr[], int ss, int se, int si)
    {
        // If there is one element in array, store it in current node of
        // segment tree and return
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }

        // If there are more than one elements, then recur for left and
        // right subtrees and store the sum of values in this node
        int mid = getMid(ss, se);
        st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1) +
                constructSTUtil(arr, mid + 1, se, si * 2 + 2);
        return st[si];
    }
    static void construct(int arr[], int n)
    {
        // Allocate memory for segment tree
        //Height of segment tree
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;

        st = new long[max_size]; // Memory allocation

        constructSTUtil(arr, 0, n - 1, 0);
    }

}

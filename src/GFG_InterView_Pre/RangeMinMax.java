package GFG_InterView_Pre;

public class RangeMinMax {
    static class PII{
        long first;
        long second;
    }
    static int getMid(int s, int e) {
        return s + (e - s) / 2;
    }
    public static PII getMinMax(PII stt[], long arr[], int n, int l, int r)
    {
        //Your code here
        // Your code here
        st=stt;
        // Check for erroneous input values
        if (l < 0 || r > n - 1 || l > r) {
            // System.out.println("Invalid Input");
            PII ans=new PII();
            ans.first=-1;
            ans.second=-1;

            return ans;
        }
        return getMinMaxUtil(0, n - 1, l,r, 0);
    }
    static PII st[];

    static PII getMinMaxUtil(int ss, int se, int qs, int qe, int si)
    {
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (qs <= ss && qe >= se)
            return st[si];

        // If segment of this node is outside the given range
        if (se < qs || ss > qe){
            PII ans=new PII();
            ans.first=Integer.MAX_VALUE;
            ans.second=Integer.MIN_VALUE;
            return ans;
        }


        // If a part of this segment overlaps with the given range
        int mid = getMid(ss, se);
        PII left=getMinMaxUtil(ss, mid, qs, qe, 2 * si + 1);
        PII right=getMinMaxUtil(mid + 1, se, qs, qe, 2 * si + 2);
        long max=Math.max(left.second,
                right.second);
        long min=Math.min(left.first,
                right.first);
        PII ans=new PII();
        ans.first=min;
        ans.second=max;
        return ans;

    }

    // arr : given array
// n : size of array arr
// st : segment tree of array arr
// index : given index to update with new_val
    public static void updateValue(long arr[], PII stt[], int n, int i, long new_val)
    {
        //Your code here
        st=stt;
        // Check for erroneous input index
        if (i < 0 || i > n - 1) {
            //System.out.println("Invalid Input");
            return;
        }

        // Get the difference between new value and old value
      //  int diff = new_val - arr[i];

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
        if(ss == se)
        {

            st[si] = new PII();
            st[si].first=diff;
            st[si].second=diff;
            return;
        }

        if (se != ss) {
            int mid = getMid(ss, se);
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
        st[si].first = Math.min(st[2*si+1].first, st[2*si+2].first);
               st[si].second= Math.max(st[2*si+1].second, st[2*si+2].second);
        return;
    }
}

package SegmentTreeAndDP;

public class xorSegmentTree {
    static int st[];
    // Driver program to test above functions
    public static void main(String args[])
    {
        int arr[] = {1, 3, 5, 7, 9, 11};
        int n = arr.length;
        createTree(arr);
        ///////////print
        for(int i=0;i<st.length;i++){
            System.out.print(st[i]+" ");
        }






        System.out.println("Sum of values in given range = " +
                getSum(n, 1, 3));

        // Update: set arr[1] = 10 and update corresponding segment
        // tree nodes
        //   updateValue(arr, n, 1, 10);

        // Find sum after the value is updated
        System.out.println("Updated sum of values in given range = " +
                getSum(n, 1, 3));
    }
    /////////////search of range
    static int getSum(int n,int s,int e){
        if(n<=s){
            return -1;
        }
        if (s < 0 || e > n - 1 || s > e) {
            System.out.println("Invalid Input");
            return -1;
        }
        return getSumUtil(0, n - 1, s, e, 0);

    }
    static int getSumUtil(int l,int r,int s,int e,int i){

        ////////////l r cover .............s e
        if (l <= s && r >= e)
            return st[i];

        ///////no overlap
        if (e < l || s > r)
            return 0;

        // partial overlap
        int mid = s+(e-s)/2;

        return (getSumUtil( l, r, s, mid,2 * i + 1)^getSumUtil( l,r,mid + 1, e, 2 * i + 2));


    }

    //////////////crating of st
    static void createTree(int arr[]){
        int n=arr.length;
        int height=(int)Math.ceil(Math.log(n)/Math.log(2));
        int size= (int) (2*Math.pow(2,height)-1);
        st=new int[size];

        createutil(0,0,n-1,arr);
        return;


    }
    static int createutil(int i,int s,int e,int arr[]){
        if(i>=st.length||s>e||e>=arr.length||s<0){
            return 0;
        }
        /////////////////
        if(s==e){
            st[i]=arr[e];
            return st[i];
        }
        int mid=s+(e-s)/2;
        int val=(createutil(2*i+1,s,mid,arr)^createutil(2*i+2,mid+1,e,arr));
        st[i]=val;

        return st[i];
    }
    /////////////////////////////////////////////
//
    static void updateValue(int arr[], int s,
                    int e, int index, int new_value,int old_value ){
        // Check for erroneous input index
        int n=arr.length;
        if (index < 0 || index > n - 1) {
            System.out.println("Invalid Input");
            return;
        }

        updateValueUtil(s,e,index,new_value,old_value,0);
    }
    static void updateValueUtil( int s,
                            int e, int index, int new_value,int old_value ,int i)
    {

        // Base Case: If the input index lies outside the range of
        // this segment
        if (i < s || i > e)
            return;

        // If the input index is in range of this node, then update the
        // value of the node and its children
        st[i] = st[i]^old_value^new_value;

        if (e != s) {
            int mid = s+(e-s)/2;
            updateValueUtil(s, mid, i, new_value,old_value, 2 * i + 1);
            updateValueUtil(mid + 1, e, i,new_value,old_value,2 * i + 2);
        }
    }

}

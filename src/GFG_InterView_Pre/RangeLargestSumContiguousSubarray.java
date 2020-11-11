package GFG_InterView_Pre;

public class RangeLargestSumContiguousSubarray {
   static class Node
    {
        public int sum, prefixSum, suffixSum, maxSubArraySum;
        public Node()
        {
            sum = prefixSum = suffixSum = maxSubArraySum = Integer.MIN_VALUE;
        }
    }
    public static void update(int arr[], Node tree[], int n, int index, int new_value) {
        //Your code here
    }

    public static int query(int arr[], Node tree[], int n, int l, int r) {
        //Your code here
        return 0;
    }
}

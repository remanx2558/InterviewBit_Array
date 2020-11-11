package GFG_InterView_Pre;

import java.util.Scanner;

public class RangeLongestCorrectBracketSubsequenceQueries {

    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        long t=sc.nextInt();
        while(t-->0)
        {
            sc.nextLine();
            int query;

            String line[]=sc.nextLine().split(" ");

            String str=line[0];
            query=Integer.parseInt(line[1]);
            int n=str.length();
            Node st[]=constructST(str, n);

            int startIndex,endIndex;
            while(query-->0)
            {
                startIndex=sc.nextInt();
                endIndex=sc.nextInt();
                System.out.println(getLongestSequence(st, str, startIndex, endIndex, n));
            }


        }
    }

    public static int getMid(int s,int e)
    {
        return s + (e - s) / 2;
    }

    public static Node merge(Node leftChild, Node rightChild) {
        Node parentNode=new Node();
        int minMatched = Math.min(leftChild.open, rightChild.closed);
        parentNode.pairs = leftChild.pairs + rightChild.pairs + minMatched;
        parentNode.open = leftChild.open + rightChild.open - minMatched;
        parentNode.closed = leftChild.closed + rightChild.closed - minMatched;
        return parentNode;
    }


    public static void constructSTUtil(String str, int ss, int se, Node[]st, int si)
    {
        st[si]=new Node();
        if (ss == se) {
            st[si].pairs = 0;
            if (str.charAt(ss) == '(')
                st[si].open = 1;
            else
                st[si].closed = 1;

            return;
        }

        int mid = getMid(ss, se);
        constructSTUtil(str, ss, mid, st, si * 2 + 1);
        constructSTUtil(str, mid + 1, se, st, si * 2 + 2);

        st[si] = merge(st[si * 2 + 1], st[si * 2 + 2]);

    }

    public static Node [] constructST(String str, int n)
    {
        int x=(int) Math.ceil(Math.log(n)/Math.log(2));
        int max_size = 2 * (int)Math.pow(2, x) - 1;
        Node st[]=new Node[max_size];
        constructSTUtil(str, 0, n - 1, st, 0);

        return st;
    }

    public static int getLongestSequence(Node[] st, String str, int qs, int qe, int n)
    {
        Node node =  getLongestSequenceUtil(st, qs, qe, 0, n-1, 0);
        return 2*node.pairs;
    }

    public static Node getLongestSequenceUtil(Node st[], int qs, int qe, int ss, int se, int si){

        if(qe<ss || se<qs){
            Node node = new Node();
            return node;
        }

        if(qs<=ss && se<=qe){
            return st[si];
        }

        int mid = ss + (se-ss)/2;
        Node left = getLongestSequenceUtil(st, qs, qe, ss, mid, 2*si+1);
        Node right = getLongestSequenceUtil(st, qs, qe, mid+1, se, 2*si+2);
        Node node = mergeUtil(left, right);
        return node;
    }


    public static Node mergeUtil(Node left, Node right){
        Node node = new Node();
        int minMatch = Math.min(left.open,right.closed);
        node.pairs = left.pairs + right.pairs + minMatch;
        node.open = left.open + right.open - minMatch;
        node.closed = left.closed + right.closed - minMatch;
        return node;
    }


    static class Node {
        public int pairs;
        public int open;   // unused
        public int closed; // unused

        public Node() { pairs = open = closed = 0; }
    }
}

// } Driver Code Ends
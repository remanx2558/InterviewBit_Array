package GFG_InterView_Pre;

public class ContiguousElementsXOR {
    static final int ALPHABET_SIZE = 2;

    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;
        int value;

        TrieNode(){
            isEndOfWord = false;
            value=0;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }
    static int ans;
    static int maxSubarrayXOR(int arr[], int n)
    {
        //Your code here
        ans=Integer.MIN_VALUE;
        int pre_xor=0;
        TrieNode root=new TrieNode();
        insert(0,root);
        for(int i=0;i<arr.length;i++){
            pre_xor=pre_xor^arr[i];
          //  System.out.println(pre_xor);
            insert(pre_xor,root);
            int vv=query(pre_xor,root);
            ans=Math.max(ans,vv);
          //  System.out.println("pre xor is "+pre_xor+" and other is "+vv+" with ans "+ans);

        }

        return ans;
    }
    static void insert(int val,TrieNode root){
        TrieNode crawl=root;
        for(int i=31;i>=0;i--){
            int index=((val & 1<<i)>=1)?1:0;
            if(crawl.children[index]==null){
                crawl.children[index]=new TrieNode();
            }
            crawl=crawl.children[index];

        }
        crawl.value=val;
    }
    static int query(int val,TrieNode root){
        TrieNode crawl=root;
        for(int i=31;i>=0;i--){
            int index=(val & 1<<i)>=1?1:0;

            if(crawl.children[1-index]!=null){
                crawl=crawl.children[1-index];
            }
            else if(crawl.children[index]!=null){
                crawl=crawl.children[index];
            }
        }
        return val ^ crawl.value;

    }

    public static void main(String args[]){
        int arr[] = {8, 1, 2, 12};
        int n = arr.length;
        System.out.println(maxSubarrayXOR(arr,n));
    }
}

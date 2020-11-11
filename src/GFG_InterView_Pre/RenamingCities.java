package GFG_InterView_Pre;

public class RenamingCities {
    static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;
        int count;

        TrieNode(){
            isEndOfWord = false;
            count=0;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }
    static int ll;
   static boolean bull;
    static void insert(TrieNode root, String key) {
        // Your code here
        ll=0;
        bull=true;


        if(root==null){
            root=new TrieNode();
        }
        TrieNode crawl=root;
        for(int i=0;i<key.length();i++){

            int index=(int)key.charAt(i)-(int)'a';


            if(crawl.children[index]==null){
                if(bull){
                    bull=false;
                    ll=i;
                }
                crawl.children[index]=new TrieNode();

                crawl=crawl.children[index];
                crawl.count++;
            }
            else{

                crawl=crawl.children[index];
                crawl.count++;
            }
        }
        //////////////////////////////////////////
        if(crawl.isEndOfWord==true){
            System.out.println(key+" "+crawl.count);
        }
        else {
            System.out.println(key.substring(0,ll+1));
        }
        /////////////////////////////////////////////

        crawl.isEndOfWord=true;
    }

    public static void check(String arr[],int n)
    {
        //Your code here
        TrieNode root=new TrieNode();
        for(int i=0;i< arr.length;i++){
            insert(root,arr[i]);
        }
    }
    public static void main(String args[]){
        String Cities[] = {"shimla","safari","jammu","delhi",
                "jammu","dehradun"};
        check(Cities, Cities.length);
    }
}

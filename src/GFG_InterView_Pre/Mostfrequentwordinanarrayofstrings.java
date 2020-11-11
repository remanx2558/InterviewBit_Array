package GFG_InterView_Pre;

public class Mostfrequentwordinanarrayofstrings {
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;
        int count=0;
        boolean picked;

        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
            count=0;
            picked=false;
        }
    }
    public static String mostFrequentWord(String arr[],int n)
    {
        //Your code here
        cc=0;
        ans="";
        TrieNode root=new TrieNode();
        for(int i=0;i< arr.length;i++){
            insert(root,arr[i]);
        }
        for(int i=0;i<n;i++){
            search(root,arr[i]);
        }
        return ans;

    }
    static String ans;
    static final int ALPHABET_SIZE = 26;

    // trie node

    static int cc;
    static void insert(TrieNode root, String key) {
        // Your code here

        if(root==null){
            root=new TrieNode();
        }
        TrieNode crawl=root;

        for(int i=0;i<key.length();i++){
            int index=(int)key.charAt(i)-(int)'a';
            if(crawl.children[index]==null){
                crawl.children[index]=new TrieNode();
                crawl=crawl.children[index];
            }
            else{
                crawl=crawl.children[index];
            }
        }
        crawl.isEndOfWord=true;
        crawl.count++;
       // System.out.println("word "+key+" added at with count "+crawl.count);


    }
    static void search(TrieNode root, String key) {

        TrieNode crawl=root;
        for(int i=0;i<key.length();i++){
            int index=(int)key.charAt(i)-(int)'a';

            if(crawl.children[index]==null){
               return;
            }
            else{
                crawl=crawl.children[index];
            }
        }

        if(crawl.isEndOfWord && crawl.count>=cc && crawl.picked==false){
            cc=crawl.count;
            ans=key;
            crawl.picked=true;

        }
       // System.out.println("word was "+key+" with count"+crawl.count);

    }
    public static void main(String args[]){

       String arr[]={ "xejdcj", "xejdcj", "lvjpb", "tmyuiu"
               ,"lvjpb" ,"tmyuiu" ,"ovoba", "lvjpb", "lvjpb",
               "fqhyu" ,"fqhyu" ,"tmyuiu" ,"xejdcj"
               ,"tmyuiu" ,"fqhyu" ,"ovoba" ,"xejdcj"};

       System.out.println( mostFrequentWord(arr, arr.length));

    }

}

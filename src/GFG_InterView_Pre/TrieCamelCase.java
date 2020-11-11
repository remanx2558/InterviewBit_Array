package GFG_InterView_Pre;

public class TrieCamelCase {
    static void findAllWords(String[] dict, String pattern)
    {
        //Your code here
        TrieNode root=new TrieNode();
        for(int i=0;i< dict.length;i++){
            insert(root,dict[i]);
        }
    }
    static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode
    {
       TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }
    static void insert(TrieNode root, String key) {
        // Your code here
        if(root==null){
            root=new TrieNode();
        }
        TrieNode crawl=root;
        String str="";
        for(int i=0;i<key.length();i++){
            int val=(int)key.charAt(i);
            int start=(int)'A';
            int end=(int)'Z';

            if(val>=start && val<=end){
                str=str+key.charAt(i);
                int index=(int)key.charAt(i)-(int)'A';
                if(crawl.children[index]==null){
                    crawl.children[index]=new TrieNode();
                    crawl=crawl.children[index];
                }
                else{
                    crawl=crawl.children[index];
                }
            }
       
        }

    }

    // Returns true if key presents in trie, else false
    static boolean search(TrieNode root, String key) {
        // Your code here
        TrieNode crawl=root;
        for(int i=0;i<key.length();i++){
            int index=(int)key.charAt(i)-(int)'a';

            if(crawl.children[index]==null){
                return false;
            }
            crawl=crawl.children[index];
        }
        return crawl.isEndOfWord;

    }
}

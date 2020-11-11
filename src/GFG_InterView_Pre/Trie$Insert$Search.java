package GFG_InterView_Pre;

public class Trie$Insert$Search {
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

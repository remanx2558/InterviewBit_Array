package AmazonTarget;

import java.util.ArrayList;

public class AlienDeictionary {

    static public boolean isAlienSorted(String[] words, String order) {
        ArrayList<Integer> arr[]= new ArrayList[26];

        for(int i=0;i<26;i++){
            arr[i]=new ArrayList<Integer>();
        }
        /////////////
        for(int i=0;i+1<words.length;i++){
            String st1=words[i];
            String st2=words[i+1];
            int j=Math.min(st1.length(),st2.length());

            for(int k=0;k<j;k++){
                if(st1.charAt(k)!=st2.charAt(k)){
                    int u=st1.charAt(k)-'a';
                    int v=st2.charAt(k)-'a';
                    arr[u].add(v);
                }
            }

        }
        ans="";
        boolean visited[]=new boolean[26];
        for(int i=0;i<26;i++){
            int siz=arr[i].size();
            if(siz>0 && visited[i]==false){
                topi(i,arr,visited);
            }

        }
        boolean vis[]=new boolean[26];
        for(int i=0;i<ans.length();i++){
            int index=(int)ans.charAt(i)-(int)'a';
            vis[index]=true;

        }
        for(int i=0;i<26;i++){
            if(vis[i]==false){
                char cc=(char)(i+(int)'a');
                ans=ans+cc;
            }
        }

        System.out.println(ans);
        if(ans.compareTo(order)==0){
            return true;
        }
        return false;


    }
   static void topi(int index, ArrayList<Integer> arr[], boolean []visited){
        if(visited[index]){
            return ;
        }
        visited[index]=true;
        int siz=arr[index].size();
        ///////////
        for(int j=0;j<siz;j++){
            int v=arr[index].get(j);
            if(visited[v]==false && arr[v].size()>0){
                topi(v,arr,visited);
            }
        }


        //////////////////
        char cc=(char)(index+((int)('a')));
        ans=ans+cc;
    }
 static    String ans;
public static void main(String args[]){
    String []arr={"hello","leetcode"};
    String order = "hlabcdefgijkmnopqrstuvwxyz";
            System.out.println(isAlienSorted(arr, order));
}
}

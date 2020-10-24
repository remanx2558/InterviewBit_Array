import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class djs {
    public static void main(String args[])throws IOException {

        String arr[]={"foo", "bar"};
        ArrayList<String>al=new ArrayList<String>();
        for(int i=0;i<arr.length;i++){
            al.add(arr[i]);
        }
        ArrayList<Integer> threeSum=findSubstring("barfoothefoobarman",al);
        System.out.println(threeSum);
    }
    static public ArrayList<Integer> findSubstring(String A, final List<String> B) {

        int dp[][]=new int[A.length()][A.length()];

        HashMap<String,Integer> hm=new HashMap<String,Integer>();
        for(int i=0;i<B.size();i++){
            hm.put(B.get(i),1);
        }
        ///////////////len=1
        for(int i=0;i<A.length();i++){
            String s=A.substring(i,i+1);
            if(hm.containsKey(s)){
                dp[i][i]=1;
            }
        }
        ////////
        for(int len=2;len<=A.length();len++){
            for(int y=0;y+len-1<A.length();y++){
                int x=y+len-1;

                String sub=A.substring(y,x+1);
                if(hm.containsKey(sub)){
                    dp[y][x]=1;
                }
                else{

                    for(int k=y;k<x;k++){
                        if(dp[y][k]>0 && dp[k+1][x]>0){
                            dp[y][x]=Math.max(dp[y][x],dp[y][k]+dp[k+1][x]);

                        }
                    }

                }


            }
        }

        ////////////////////////////ans
        ArrayList<Integer>al=new ArrayList<Integer>();
        for(int len=0;len<A.length();len++){
            for(int y=0;y<A.length();y++){
                //System.out.print(dp[len][y]+" ");
                if(dp[len][y]==B.size()){
                    al.add(len);
                }
            }
     //   System.out.println();
        }




        return al;








    }


}

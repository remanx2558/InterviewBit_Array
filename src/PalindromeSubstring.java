import java.util.ArrayList;

public class PalindromeSubstring {
    public static void main(String args[]){
System.out.println(longestPalindrome("aaaabaaa"));
    }
    static public String longestPalindrome(String A) {

        int dp[][]=new int [A.length()+1][A.length()+1];
        int max=1;
        int x=0;
        int j=0;

        //////diagonal
        for(int i=1;i<A.length()+1;i++){
            dp[i][i]=1;
        }
        //////////////length 2
        for(int i=1;i<A.length()+1;i++){
            if(i<A.length() && A.charAt(i-1)==A.charAt(i)){
                dp[i][i+1]=2;
                x=i;
                j=i+1;
                max=2;
            }
        }
        /////////////

        for(int i=1;i<A.length()+1;i++){
            for(int len=3;len-1+i<A.length()+1;len++){
                int y=i+len-1;
                if(A.charAt(i-1)==A.charAt(y-1)){
                    if(i-1>=0 && y+1<A.length() && dp[i-1][y+1]>0){
                        dp[i][y]=dp[i-1][y+1]+2;

                    }
                    if(max<dp[i][y]){
                        max=dp[i][y];
                        x=i;
                        j=y;
                        System.out.println(max+" ites the maxx");
                    }
                }

            }
            ////////////////
        }

        ///
        for(int i=0;i<A.length();i++){
            for(int len=0;len<A.length();len++) {
                System.out.print(dp[i][len]+" ");
            }
            System.out.println();
        }

                //////////
       // String ans=A.substring(x,j+1);
String ans="";
        return ans;



    }
}

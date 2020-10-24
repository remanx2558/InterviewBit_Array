import java.io.IOException;
import java.util.ArrayList;

public class eggBreak {
    public static void main(String args[])throws IOException {

        int threeSum=numDistinct("bbababa","aaaababbababbaabbaaababaaabbbaaabbb");
        System.out.println(threeSum);
    }
    static public int numDistinct(String A, String B) {
        int dp[][]=new int[A.length()+1][B.length()+1];
        ///0th row
        for(int i=0;i<B.length()+1;i++){
            dp[0][i]=1;
        }
        //////0th col is 0
        for(int i=1;i<A.length()+1;i++){
            for(int j=1;j<B.length()+1;j++){
                if(A.charAt(i-1)!=B.charAt(j-1)){
                    dp[i][j]=dp[i][j-1];
                }
                else{
                    dp[i][j]=dp[i][j-1]+dp[i-1][j-1];
                }
            }
        }
        for(int i=0;i<A.length()+1;i++){
            for(int j=0;j<B.length()+1;j++) {
                System.out.print(dp[i][j]+" ");
            }
        System.out.println();}
                return dp[A.length()][B.length()];
    }
}

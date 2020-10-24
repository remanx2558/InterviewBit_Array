import java.io.IOException;
import java.util.ArrayList;

public class Nwords {
    public static void main(String args[])throws IOException {

int threeSum=arrange("WWBB",2);
        System.out.println(threeSum);
    }
    

    static public int arrange(String A, int B) {
        int dp[][][]=new int[B][A.length()][A.length()];
        int n=A.length();
        //////////
        for(int len=1;len<=n;len++){
            for(int y=0;y+len-1<n;y++){
                int x=y+len-1;
                if(len==1){
                    dp[0][y][x]=0;
                }
                else{
                    int w=0;
                    int b=0;
                    String sub=A.substring(y,x+1);
                    for(int i=0;i<sub.length();i++){
                        if(sub.charAt(i)=='W'){
                            w++;
                        }
                        else if(sub.charAt(i)=='B'){
                            b++;
                        }
                    }
                    int val=w*b;
                    dp[0][y][x]=val;
                }

            }
        }
        ////////
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(dp[0][i][j]+" ");
            }
            System.out.println();
        }

        /////////////
        for(int k=1;k<B;k++){
            for(int len=1;len<=n;len++){
                for(int y=0;y+len-1<n;y++){
                    int x=y+len-1;
                    String sub=A.substring(y,x);
                    if(sub.length()<k+1){
                        dp[k][y][x]=0;
                    }
                    else{

                        for(int m=y;m+1<=x;m++){
                            int val=dp[k-1][y][m]+dp[k-1][m+1][x];
                            dp[k][y][x]=Math.max(val,dp[k][y][m]);
                        }


                    }

                }
            }
            //////////////////

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(dp[k][i][j]+" ");
                }
                System.out.println();
            }
                    ////////////////
        }
        //////////////////



        //////////////
        return dp[B-1][0][A.length()-1];
    }
}

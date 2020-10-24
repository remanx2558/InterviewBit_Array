import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class subSet {
    public static void main(String args[])throws IOException {
int A[]={1,2,3};
        int [][]ans=subsets(A);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[i].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
   static public int[][] subsets(int[] A) {
        Arrays.sort(A);
        //String str="";
        int siz=0;
        for(int  i=0;i<A.length;i++){
            siz=siz+(int)Math.pow(2,i);
        }
        System.out.println("siz is "+siz);
        int ans[][]= new int[siz+1][];
        for(int i=0;i<=siz;i++){
            String str=Integer.toString(i,2);
            System.out.println("for i "+i+" is "+str);
            ArrayList<Integer> al=new ArrayList<Integer>();
            int k=0;
            for(int j=str.length()-1;j>=0;j--){
                if(str.charAt(j)=='1'){
                    al.add(A[k]);
                }
                k++;
            }
            ///////////
            int arr[]=new int[al.size()];

            for(int f=0;f<al.size();f++){
                arr[f]=al.get(f);
            }
            ans[i]=arr;

        }
        //////////


       /////////
        return ans;

    }
}

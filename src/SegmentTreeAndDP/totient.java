package SegmentTreeAndDP;

public class totient {
    static void tot(int n){
        int ans[]=new int [n+1];
        for(int i=0;i<n+1;i++){
            ans[i]=i;
        }
        int m=1000000007;
        for(int p=2;p<n+1;p++){
            if(ans[p]==p){
                ans[p]=p-1;
                for(int k=2*p;k<n+1;k=k+p){
                    ans[k]=(((ans[k]%m)*((p-1)%m))%m)/p;
                }
            }
        }



    }
}

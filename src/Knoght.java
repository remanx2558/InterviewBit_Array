public class Knoght {
    int ans;
    int x[]={-2,-1,1,2,2,1,-1,-2};
    int y[]={1,2,2,1,-1,-2,-2,-1};

    public int knight(int A, int B, int C, int D, int E, int F) {
        ans=Integer.MAX_VALUE;

        long limit=Math.min(ans,A*B);
        ans=(int)limit;

        boolean visit[][]=new boolean[A][B];



        dfs(A-1,B-1,C-1,D-1,E-1,F-1,visit,0,limit);
        if(ans>=(int)limit || ans<0 ){
            return -1;
        }


        return ans;
    }
    void dfs(int A, int B, int C, int D, int E, int F,boolean [][]visit,int val,long limit){
        if(val>=limit){
            return ;
        }

        if(C<0 ||C>A||D<0 ||D>B){
            return;
        }
        if(visit[C][D]==true){
            return;
        }
        if(val>ans){
            return;
        }

        ///answer
        if(C==E && D==F && val<ans ){
            ans=val;
            return;
        }
        /////////
        visit[C][D]=true;
        for(int i=0;i<8;i++){
            if(!(C+x[i]<0||C+x[i]>A||D+y[i]<0||D+y[i]>B||val+1>ans)){
                dfs(A,B,C+x[i],D+y[i],E,F,visit,val+1,limit);
            }

        }
        visit[C][D]=false;
        return;




    }
}

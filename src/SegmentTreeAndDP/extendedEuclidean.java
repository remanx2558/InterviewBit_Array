package SegmentTreeAndDP;

public class extendedEuclidean {
    static int extecli(int a,int b,int x,int y){

        if(a==0){
            x=0;
            y=1;
            return b;
        }
        int x1=1;
        int y1=1;
        int g=extecli(b,a%b,x1,y1);
        y=x1;
        x=y1-((b/a)*x1);
        return g;


    }
}

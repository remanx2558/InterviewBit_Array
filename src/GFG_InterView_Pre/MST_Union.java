package GFG_InterView_Pre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MST_Union {
    static class Edge{
        int src;
        int des;
        int wt;
        Edge(int s,int d,int w){
            src=s;
            des=d;
            wt=w;
        }
    }
    static class my implements Comparator<Edge> {

        @Override
        public int compare(Edge e1, Edge e2) {
            int k=e1.wt>e2.wt?1:-1;
            if(e1.wt==e2.wt){
                k=0;
            }
            return k;
        }
    }
    static long kruskalDSU(ArrayList<Edge> adj, int n, int m)
    {
        // add your code here
        //sort
        Collections.sort(adj, new my());
        //sum and boolean
        long sum=0;
        boolean vi[]=new boolean[n];
        parent=new int[n];
        rank=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
        }


        for(int i=0;i<adj.size();i++){
            Edge curr=adj.get(i);
            int u=curr.src-1;
            int v= curr.des-1;
          //  System.out.println("src is "+u+" dsr is "+v+" weight is "+curr.wt);

            if( iscycle(u,v)==false){
                union(u,v);
                vi[v]=true;
                vi[u]=true;

                sum=sum+ curr.wt;
                System.out.println("src is "+u+" dsr is "+v+" weight is "+curr.wt);
            }


        }
        return sum;

    }
    static boolean iscycle(int x,int y){

        int x_p=find(x);
        int y_p=find(y);
        if(x_p==y_p){
            return true;
        }


        return false;
    }
    static void union(int x,int y){
        int x_p=find(x);
        int y_p=find(y);
        if(x_p==y_p){
            return;
        }
        int x_r= rank[x_p];
        int y_r=rank[y_p];

        if(x_r>y_r){
            parent[y_p]=x_p;
        }
        else if(x_r<y_r){
            parent[x_p]=y_p;
        }
        else if(x_r==y_r){
            parent[y_p]=x_p;
            rank[x_p]++;
        }





        return;
    }
    static int find(int x){
        if(parent[x]==x){
            return x;
        }
        int p=find(parent[x]);
        parent[x]=p;

        return parent[x];


    }
    static int parent[];
    static int rank[];
    public static void main(String args[]){
//        int N = 5;
//        int M = 6;
        int N=9 ;
        int M=16;

        Edge e[] = {new Edge(1, 2, 8),
                new Edge(1, 5, 14),
                new Edge(1, 8, 19),
                new Edge(2, 3, 14),
                new Edge(2, 5, 4),
                new Edge(2, 6, 17),new Edge(2, 7, 7),new Edge(2, 8, 15),new Edge(3, 7, 6),
                new Edge(3, 8, 10),new Edge(3, 9, 12),
                new Edge(4, 7, 13),new Edge(4, 8, 18),new Edge(4, 9, 3),new Edge(6, 7, 17),
                new Edge(6, 8, 10)
        };


                //new Edge(1,2,4),new Edge(1,3,3),new Edge(2,4,1),
              //  new Edge(2,5,1),new Edge(4,5,3),new Edge(3,4,2)};
        ArrayList<Edge>al=new ArrayList<>();
        for(int i=0;i<e.length;i++){
            al.add(e[i]);
        }
        System.out.println(kruskalDSU(al,N,M));

    }

}

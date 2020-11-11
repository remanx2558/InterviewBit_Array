package SegmentTreeAndDP;

import java.util.HashMap;

public class disjoint {
    public static void main(String args[]){

        int arr[]={1,2,3,4,5};
        int rank[]={1,1,1,1,1};
        unionNodes(1,5,arr,rank,5);
        unionNodes(1,3,arr,rank,5);
        System.out.println(findNumberOfConnectedComponents(5,arr,rank));




    }


    /* This function does union of 2 nodes a and b */
    // a : node 1
    // b : node 2
    // arr : array (n+1) size with elements from 1 to N equal to its index.
    // rank1 : array (n+1) size with all elements equal to 1.
    // n : Number of nodes
    static void unionNodes( int a, int b, int arr[], int rank1[], int n)
    {
        // add your code
        // add your code here
        int []par=arr;
        int rank[]=rank1;
        a=a-1;
        b=b-1;


        int p_a=find(a,par);
        int p_b=find(b,par);

        if(p_a==p_b){
            return ;
        }
        else{
            ///////////////
            int r1=rank[p_a];
            int r2=rank[p_b];
            if(r1>r2){
                par[p_b]=p_a;

            }
            else if(r1<r2){
                par[p_a]=p_b;

            }
            else if(r1==r2){
                par[p_b]=p_a;
                rank[p_a]++;
            }




        }
        for(int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }

    static public int find(int x,int []par){
        if(par[x]==x){
            return x;
        }
        return find(par[x],par);
    }
    /* This function returns number of connected components */
    // arr : array (n+1) size with elements from 1 to N equal to its index.
    // rank1 : array (n+1) size with all elements equal to 1.
    // n : Number of nodes
    static int findNumberOfConnectedComponents( int n, int arr[], int rank1[])
    {
        // add your code
        HashMap<Integer,Integer>hm=new HashMap<Integer,Integer>();
        int count=0;
        for(int i=0;i<arr.length;i++){
            int parent=find(arr[i],arr);

            if(!hm.containsKey(parent)){
                hm.put(parent,1);
                count++;
            }

        }
        return count;

    }
}

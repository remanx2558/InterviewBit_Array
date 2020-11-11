package SegmentTreeAndDP;

import java.util.HashMap;
import java.util.Scanner;

public class BouncingBoomerangs {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        greed(arr);

    }
    static void greed(int []arr){
        int n= arr.length;
        int [][]matrix=new int[n][n];
        HashMap<Integer,Integer>row=new HashMap<Integer, Integer>();
        HashMap<Integer,Integer>col=new HashMap<Integer, Integer>();
        int ro=0;//optimal


        for(int c=0;c<n;c++){
//            if(ro>=n){
//                System.out.println("-1");
//                return;
//            }
            int v=arr[c];

            if(v==2){
                int index=searchone(c,ro,arr,matrix);
                if(index!=-1 && ro<n){
                    System.out.println("found 2 and next for it");
                    matrix[ro][c]=1;
                    matrix[ro][index]=1;
                    ro++;

                }
                else{
                    System.out.println("-1");
                   // return ;
                }
            }
            else if(v==3){
                int index=searchone(c,ro,arr,matrix);
                if(index!=-1 && ro<n){
                    System.out.println("found 3 and next for it");

                    matrix[ro][c]=1;
                    matrix[ro][index]=1;
                    ro++;
                    if(ro<n){
                        matrix[ro][index]=1;
                        ro++;
                    }
                    else{
                        System.out.println("-1");
                        //return ;
                    }

                }
                else{
                    System.out.println("-1");
                   // return ;
                }
            }
            else if(v==1 && ro<n){
                System.out.println("found 1 and next for it");

                int rof=0;

                ////////just check right in row
                for(int k=0;k<n;k++){
                    if(matrix[c][k]==1){
                        rof++;
                        ///check side
                        int side=0;
                        for(int s=c+1;s<n;s++){

                        }



                    }
                }
                /////////////sides

                if(rof==0){
                    matrix[ro][c]=1;
                }



            }
        }
        //////////////final check all rows

        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                sum=sum+ matrix[i][j];
            }
            if(sum>2){
                System.out.println("-1");
               // return;
            }

        }
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                sum=sum+ matrix[j][i];
            }
            if(sum>2){
                System.out.println("-1");
               // return;
            }

        }
        ///////////print ans
        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    System.out.println((i+1)+" "+(j+1));
                }
            }

        }
        //////////////////////////////////
        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){
              System.out.print(matrix[i][j]+" ");
            }
            System.out.println();

        }



    }
    static int searchone(int c,int r,int arr[],int[][]mat){
        for(int i=c+1;i<arr.length;i++){
            if(arr[i]==1){
                ///////check colm below and up
                int col=0;
                int ro=0;
                for(int j=0;j<arr.length;j++){
                    if(mat[j][i]>0){
                        col++;
                    }
                }
                for(int j=0;j<arr.length;j++){
                    if(mat[r][j]>0){
                        ro++;
                    }
                }
                if(col==0 && ro==0){
                    return i;
                }
                //System.out.println("col is "+col+" and ro is "+ro+" at index "+(i+1));

                ////check row
            }
//            else{
//                System.out.print("not "+(i+1));
//            }
        }

        return -1;
    }
}

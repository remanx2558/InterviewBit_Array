package SegmentTreeAndDP;

import java.util.*;

public class covexhull {
    //////tushar roy code
    static class point{
        int x;
        int y;
        point(int xx,int yy){
            x=xx;
            y=yy;
        }
    }
    ///////////////////////////////////////
    public static void main (String[] args)
    {
        //code
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int p=0;p<t;p++){
            int n=s.nextInt();
            point []arr=new point[n];

            for(int i=0;i<n;i++){
                int x=s.nextInt();
                int y=s.nextInt();
                arr[i]=new point(x,y);
            }
            convex(arr);

        }

    }
    static void convex(point[]arr){



        ////////left most
        point start=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i].x<start.x){
                start=arr[i];
            }
        }
        ////////
        HashSet<point> hs=new HashSet<point>();
        ArrayList<point>collinear=new ArrayList<point>();
        hs.add(start);
        ///////////////
        point curr=start;
        ////////////////
        while(true){
            point np=arr[0];/////assumed
            for(int i=1;i<arr.length;i++){
                if(arr[i]==curr){
                    continue;
                }
                ////////////////////
                int val=cross(curr,np,arr[i]);
                if(val>0){
                    np=arr[i];
                    collinear=new ArrayList<point>();
                }
                else if(val==0){
                    int distance=dis(curr,np,arr[i]);
                    if(distance<0){
                        collinear.add(np);
                        np=arr[i];

                    }
                    else{
                        collinear.add(arr[i]);
                    }

                }

            }
            ////////////////////////////
            for(int i=0;i<collinear.size();i++){
                hs.add(collinear.get(i));
            }
            hs.add(np);
            curr=np;
            if(curr==start){
                break;
            }
           // System.out.println("curr is "+curr.x+" "+curr.y);


            //////////////////////
        }
        ArrayList<point>al=new ArrayList<point>(hs);
        Collections.sort(al,new my());
        int i=0;
        for(i=0;i<al.size()-1;i++){
            System.out.print(al.get(i).x+" "+al.get(i).y+", ");
        }
        System.out.print(al.get(i).x+" "+al.get(i).y);




//        //////print
//     //   Collections.sort(hs,new my());
//        Iterator itr=hs.iterator();
//
//        for(int i=0;i< hs.size()-1;i++){
//            point cu=(point)itr.next();
//            System.out.print(cu.x+" "+cu.y+", ");
//        }
//        point cu=(point) itr.next();
//        System.out.print(cu.x+" "+cu.y);
//




    }
    static class my implements Comparator<point>{

        @Override
        public int compare(point p1, point p2) {
            int k=(p1.x>p2.x)?1:-1;
            if(p1.x==p2.x){
                k=0;
            }
            if(k==0){
                k=(p1.y>p2.y)?1:-1;
            }
            return k;

        }
    }
    static int cross(point p1,point p2,point p3){


        int x1=p1.x-p2.x;
        int x2=p1.x-p3.x;
        int y1=p1.y-p2.y;
        int y2=p1.y-p3.y;
        ////////////////
        return (y2*x1)-(y1*x2);

    }
    static int dis(point p1,point p2,point p3){
        int x1=p1.x-p2.x;
        int x2=p1.x-p3.x;
        int y1=p1.y-p2.y;
        int y2=p1.y-p3.y;
        ////////////////
        return (x1*x1+y1*y1)-(x2*x2+y2*y2);

    }
}

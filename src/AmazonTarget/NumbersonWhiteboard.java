package AmazonTarget;

import java.util.*;

public class NumbersonWhiteboard {

    public static void main (String[] args)
    {
        //code
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();

        for(int o=0;o<t;o++){
            int n=s.nextInt();
            greed(n);
        }
}
static void greed(int n){
        //System.out.println((n+1)/2);

        PriorityQueue<Long> even=new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Long> odd=new PriorityQueue<>(Collections.reverseOrder());
    //////////////////////////////////////////////
    for(int i=1;i<=n;i++){
        if(i%2==0){
            even.add((long)i);
        }else{
            odd.add((long)i);
        }
    }
    ///////////////////////////////////////////////////////
    long ans=0;
    for(int count=1;count<=n-1;count++){
        if((even.size()!=0 && odd.size()==0)||((even.size()!=0 && odd.size()!=0)&& even.peek()>odd.peek() && even.size()>1)){
            long front=0;
            long back=0;
            if(!even.isEmpty()){
                back=even.poll();

            }
            if(!even.isEmpty()){
                front=even.poll();
            }
            long val=(front+back)/2;
            if(val%2==0){
                even.add(val);
            }
            else{
                odd.add(val);
            }
            //System.out.println(front+" "+back);

            if(count==n-1){
                ans=val;
            }
        }
        else if((even.size()==0 && odd.size()!=0)||((even.size()!=0 && odd.size()!=0)&&even.peek()<odd.peek()&& odd.size()>1 )){
            long front=0;
            long back=0;
            if(!odd.isEmpty()){
                back=odd.poll();

            }
            if(!odd.isEmpty()){
                front=odd.poll();
            }
            long val=(front+back)/2;
            if(val%2==0){
                even.add(val);
            }
            else{
                odd.add(val);
            }
           // System.out.println(front+" "+back);

            if(count==n-1){
                ans=val;
            }
        }
        else if(odd.size()>0 && even.size()>0){
            long front=0;
            long back=0;
            if(!odd.isEmpty()){
                back=odd.poll();

            }
            if(!even.isEmpty()){
                front=even.poll();
            }
            long val=(front+back)/2;
            if(val%2==0){
                even.add(val);
            }
            else{
                odd.add(val);
            }
          //  System.out.println(front+" "+back);

            if(count==n-1){
                ans=val;
            }
        }

    }
    System.out.println(ans);


    ///////////////////////////////////////////////
     even=new PriorityQueue<>(Collections.reverseOrder());
    odd=new PriorityQueue<>(Collections.reverseOrder());
    //////////////////////////////////////////////
    for(int i=1;i<=n;i++){
        if(i%2==0){
            even.add((long)i);
        }else{
            odd.add((long)i);
        }
    }
    for(int count=1;count<=n-1;count++){
        if((even.size()!=0 && odd.size()==0)||((even.size()!=0 && odd.size()!=0)&& even.peek()>odd.peek() && even.size()>1)){
            long front=0;
            long back=0;
            if(!even.isEmpty()){
                back=even.poll();

            }
            if(!even.isEmpty()){
                front=even.poll();
            }
            long val=(front+back)/2;
            if(val%2==0){
                even.add(val);
            }
            else{
                odd.add(val);
            }
            System.out.println(front+" "+back);

            if(count==n-1){
                ans=val;
            }
        }
        else if((even.size()==0 && odd.size()!=0)||((even.size()!=0 && odd.size()!=0)&&even.peek()<odd.peek()&& odd.size()>1)){
            long front=0;
            long back=0;
            if(!odd.isEmpty()){
                back=odd.poll();

            }
            if(!odd.isEmpty()){
                front=odd.poll();
            }
            long val=(front+back)/2;
            if(val%2==0){
                even.add(val);
            }
            else{
                odd.add(val);
            }
             System.out.println(front+" "+back);

            if(count==n-1){
                ans=val;
            }
        }
        else if(odd.size()==1 && even.size()==1){
            long front=0;
            long back=0;
            if(!odd.isEmpty()){
                back=odd.poll();

            }
            if(!even.isEmpty()){
                front=even.poll();
            }
            long val=(front+back)/2;
            if(val%2==0){
                even.add(val);
            }
            else{
                odd.add(val);
            }
            System.out.println(front+" "+back);

            if(count==n-1){
                ans=val;
            }
        }

    }



}
}

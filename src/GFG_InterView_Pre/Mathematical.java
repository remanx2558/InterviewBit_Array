package GFG_InterView_Pre;

import java.math.BigInteger;
import java.util.ArrayList;

public class Mathematical {
    public static ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        // code here
        long d=(long)Math.pow(b,2)-4*a*c;
        d=(long)Math.sqrt(d);
        System.out.println("d is "+d);
        System.out.println("ib is "+(-1*b));
        long r1=(long)Math.floor(((-1*b)+d)/(2.0*a));
        long r2=(long)Math.floor(((-1*b)-d)/(2.0*a));

        System.out.println(r1+ " "+r2);
        ArrayList<Integer> al=new ArrayList<Integer>();
        al.add((int)r1);
        al.add((int)r2);
        return al;

//        double d=Math.pow(b,2)-4*a*c;
//        if(d<0)
//            System.out.print("Imaginary");
//        else {
//            int x1=(int)Math.floor((Math.sqrt(d)-b)/(2.0*a));
//            int x2=(int)Math.floor((-Math.sqrt(d)-b)/(2.0*a));
//            System.out.print(x1+" "+x2);
//        }
    }
   static public int digitsInFactorial(int N){
       // Your code here
       if(N==0 || N==1){
           return 1;
       }
       double d=0.0;
       for(int i=2;i<=N;i++){
           d=d+(Math.log(i)/Math.log(10));
       }
       d=d+1;
       return (int)d;}
    public static void main(String args[]){
       //System.out.println(termOfGP(2,3,1));
        System.out.println(isPrime(4));

    }
    public static double termOfGP(int A,int B,int N)
    {
        //Your code here
        double a=A*(1.0);
        double b=B*(1.0);

        double r=b/a;

        System.out.println("r is "+r);

        double ans=a*Math.pow(r,N);
        return ans;

    }
    public static boolean isPrime(int N)
    {
        //Your code here
        BigInteger b=new BigInteger(""+N);
        boolean ans=b.isProbablePrime(1);
        return ans;
    }
}

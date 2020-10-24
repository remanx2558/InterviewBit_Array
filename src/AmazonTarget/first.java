package AmazonTarget;

import java.util.Scanner;

public class first {
    public static void main(String atg[]){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int p=0;p<t;p++){
            long a=s.nextLong();
            long b=s.nextLong();
            System.out.println(a^b);

        }


    }
}

package AmazonTarget;

import java.util.ArrayList;
import java.util.Scanner;

public class second {
    ////////
    public static void main(String atg[]){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int p=0;p<t;p++){
            int n=s.nextInt();
            String arr[]=new String[n];
            for(int i=0;i<n;i++){
                arr[i]=s.next();
            }
            greed(arr,n);

        }


    }
static void greed(String arr[],int n) {
    int m = arr[0].length();
    /////////////////////////////
    char upright=arr[0].charAt(1);
    char upleft=arr[1].charAt(0);

    char downright=arr[n-2].charAt(m-1);
    char downleft=arr[n-1].charAt(m-2);

    ////////////////////
    int count=0;
    if(upleft==upright){
        if(upleft=='1'){
            if(downright=='0'){
                count++;
            }
            if(downleft=='0'){
                count++;
            }
        }
        else if(upleft=='0'){
            if(downright=='1'){
                count++;
            }
            if(downleft=='1'){
                count++;
            }
        }


    }
    else{
        if(downleft==downright){
            if(downleft=='1'){
                if(upright=='0'){
                    count++;
                }
                if(upleft=='0'){
                    count++;
                }
            }
            if(downleft=='0'){
                if(upright=='1'){
                    count++;
                }
                if(upleft=='1'){
                    count++;
                }
            }
        }
        else{
            //up0ne
            if(upright=='0'){
                count++;
            }
            if(upleft=='0'){
                count++;
            }
            //down zero
            if(downright=='1'){
                count++;
            }
            if(downleft=='1'){
                count++;
            }

        }

    }
    //////////////////////
    System.out.println(count);
    if(upleft==upright){
        if(upleft=='1'){
            if(downright=='0'){
                System.out.println((n-1)+" "+(m));
            }
            if(downleft=='0'){
                System.out.println((n)+" "+(m-1));
            }
        }
        else if(upleft=='0'){
            if(downright=='1'){
                System.out.println((n-1)+" "+(m));
            }
            if(downleft=='1'){
                System.out.println((n)+" "+(m-1));
            }
        }


    }
    else{
        if(downleft==downright){
            if(downleft=='1'){
                if(upright=='0'){
                    System.out.println((1)+" "+(2));
                }
                if(upleft=='0'){
                    System.out.println((2)+" "+(1));
                }
            }
            if(downleft=='0'){
                if(upright=='1'){
                    System.out.println((1)+" "+(2));
                }
                if(upleft=='1'){
                    System.out.println((2)+" "+(1));
                }
            }
        }
        else{
            //up0ne
            if(upright=='0'){
                System.out.println((1)+" "+(2));
            }
            if(upleft=='0'){
                System.out.println((2)+" "+(1));
            }
            //down zero
            if(downright=='1'){
                System.out.println((n-1)+" "+(m));
            }
            if(downleft=='1'){
                System.out.println((n)+" "+(m-1));
            }

        }

    }






}
}

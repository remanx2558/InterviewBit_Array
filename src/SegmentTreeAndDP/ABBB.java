package SegmentTreeAndDP;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ABBB {
    public static void main(String at[]){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++){
            String str=s.next();
            greed(str);
        }
    }
    static void greed(String str){
        Queue<Integer> two=new LinkedList<Integer>();
        Queue<Integer> one=new LinkedList<Integer>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='A'){
                one.add(i);
            }
            else if(str.charAt(i)=='B'){
                two.add(i);
            }
        }
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='B'){
                if(one.size()>0 && one.peek()<i){
                    two.remove(new Integer(i));
                    one.poll();

                }
                else if(two.size()>0 && two.peek()<i){
                    two.remove(new Integer(i));
                    two.poll();
                }



            }

        }
        System.out.println((one.size()+two.size()));


    }
}

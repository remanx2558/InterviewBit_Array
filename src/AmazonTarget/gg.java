package AmazonTarget;

import java.util.ArrayList;
import java.util.Stack;

public class gg {
    // Function to reverse array in group of k
    public static ArrayList<Integer> reverseInGroups(ArrayList<Integer> mv, int n, int k) {
        // add your code here
        ArrayList<Integer>ans=new ArrayList<Integer>();
        Stack<Integer>stk=new Stack<Integer>();
        int counter=0;

        for(int i=0;i<mv.size();i++){
          //  System.out.println("at index "+i);
            if(counter<k){
                stk.add(mv.get(i));
                counter++;
               // System.out.println("in stack");
            }
            else{
                counter=0;
                while(!stk.isEmpty()){
                    int val=stk.pop();
                    ans.add(val);

                   // System.out.println("value added is "+val);
                }
                stk.add(mv.get(i));


            }
        }
        while(!stk.isEmpty()){
            int val=stk.pop();
            ans.add(val);                }
        return ans;

    }

    public static void main(String args[]){
        int N = 4; int K = 3;

        int arr[] = {5,6,8,9};
        ArrayList<Integer>al=new ArrayList<Integer>();
        for(int i=0;i< arr.length;i++){
            al.add(arr[i]);
        }
al=reverseInGroups(al,N,K);
        System.out.println(al);
    }
}

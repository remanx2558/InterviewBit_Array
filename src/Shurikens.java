import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Shurikens {
    public static void main(String args[]) throws IOException {
        //Scanner s=new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());

        ArrayList<Integer>al=new ArrayList<Integer>();
        ArrayList<Character>cal=new ArrayList<Character>();

        for(int i=0;i<n*2;i++){
            String str= br.readLine();

            if(str.charAt(0)=='+'){
                cal.add(str.charAt(0));
               // System.out.println("+ added");
            }
            else if(str.charAt(0)=='-'){
                cal.add(str.charAt(0));
                String num[]=str.split(" ");
                int val=Integer.parseInt(num[1]);
                al.add(val);
                //System.out.println("- added");


            }
        }
        greed(n,al,cal);

    }
    static void greed(int s,ArrayList<Integer>al,ArrayList<Character>cal){

//        for(int i=0;i<cal.size();i++){
//            System.out.print(cal.get(i)+" ");
//        }
//        System.out.println();
//        for(int i=0;i<al.size();i++){
//            System.out.print(al.get(i)+" ");
//        }
        int p=0;
        int n=0;
        int index=0;
        int aindex=0;
        PriorityQueue<Integer>pq=new PriorityQueue<Integer>();
        for(int i=0;i<cal.size();i++){
            if(cal.get(i)=='+'){
                p++;
            }
            else{
                n++;
            }

            if(n>p){
                System.out.println("No as n>p at "+i);
                return;
            }
            ////////////////////////////////////////
            if(cal.get(i)=='+'){
                pq.add(al.get(index));
                index++;
            }
            else {
                int v=pq.poll();
                if(v!=al.get(aindex)){
                    System.out.println("No as value mis match at "+i+" need to be "+v+" but "+al.get(aindex));
                    return;
                }
                aindex++;

            }

            System.out.println("pass at "+i);

            //////////////////////////////////////////
        }
        System.out.println("YES");
        for(int i=0;i<al.size();i++){
            System.out.print(al.get(i)+" ");
        }
        System.out.println();
    }
}

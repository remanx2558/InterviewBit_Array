package SegmentTreeAndDP;

public class Zalgo {
    public static void main(String args[]){
        zalgo("GEEK","GEEKS FOR GEEKS");
    }
    static void zalgo(String p,String t){
        String n=p+"$"+t;
        int arr[]=new int[n.length()];
        int i=0;

        for(int j=1;j<n.length();j++){
            ////////
            if(n.charAt(i)!=n.charAt(j)){
                arr[j]=0;
                i=0;
            }
            else if(n.charAt(i)==n.charAt(j)){

                int k=j;
                int count=0;
                while(i!=j && k<n.length() && n.charAt(i)==n.charAt(k)){
                    count++;
                    k++;
                    i++;
                }
                arr[j]=count;


                i=0;
            }
        }
        for(int j=0;j<n.length();j++){
            System.out.print(arr[j]+" ");
        }
        System.out.println();
        for(int j=0;j<n.length();j++){
            if(arr[j]==p.length()){
                System.out.println("pattern at "+(j-p.length()-1));
            }
        }



    }
}

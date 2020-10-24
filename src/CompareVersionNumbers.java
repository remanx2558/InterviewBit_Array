import java.util.ArrayList;

public class CompareVersionNumbers {
    public static void main(String args[]){


        System.out.println(compareVersion("01","1"));
    }
  static   public int compareVersion(String A, String B) {

        ArrayList<String> arr1=new ArrayList<String>();
        ArrayList<String>arr2=new ArrayList<String>();

        String s1="";

        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='.'){
                arr1.add(s1);
                s1="";
            }
            else{
                s1=s1+A.charAt(i);
            }
        }
        arr1.add(s1);

        String s2="";

        for(int i=0;i<B.length();i++){
            if(B.charAt(i)=='.'){
                arr2.add(s2);
                s2="";
            }
            else{
                s2=s2+B.charAt(i);
            }
        }
        arr2.add(s2);



        int len=Math.min(arr1.size(),arr2.size());

        for(int i=0;i<len;i++){
            int val=compareto(arr1.get(i),arr2.get(i));

            if(val==1){
                return 1;
            }
            else if(val==-1){
                return -1;
            }

        }
        return 0;

    }
   static int compareto(String A,String B){

        int fa=0;
        while(fa<A.length() && A.charAt(fa)=='0'){
            fa++;
        }

        int fb=0;
        while(fb<B.length() && B.charAt(fb)=='0'){
            fb++;
        }

        System.out.println(fa+" "+fb);
       System.out.println(A+" "+B);
//       int v1=A.length()-fa;
//       int v2=B.length()-fb
//        if(fb>=B.length()&& fa>=A.length()){
//            return 0;
//        }

//        if(>B.length()-fb){
//            return 1;
//        }
//        else if(A.length()-fa<B.length()-fb){
//            return -1;
//        }

        for(int i=fa;i<A.length();i++){
            if(A.charAt(i)>B.charAt(i)){
                return 1;
            }
            else if(A.charAt(i)<B.charAt(i)){
                return -1;
            }
        }
        return 0;


    }



}

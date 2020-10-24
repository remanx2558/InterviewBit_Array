import java.util.ArrayList;
import java.util.Scanner;

public class Ahahahahahahahaha {
    static ArrayList<Integer>al;

    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int p=0;p<t;p++){
            int n=s.nextInt();
            int arr[]=new int[n];
            for(int i=0;i< arr.length;i++){
                arr[i]=s.nextInt();
            }
            al=new ArrayList<Integer>();
            sudo(arr,0, arr.length-1);

            if(al.size()==0){
                al.add(0);
            }
            System.out.println(al.size());

            for(int i=0;i< al.size();i++){
                System.out.print(al.get(i)+" ");
            }
            System.out.println();
        }


    }
    static void sudo(int []arr,int l,int r){
if(l>= arr.length ||r<0||l>=r){
    return;
}


int countz=0;
int counto=0;
int index=-1;


//////find stuff
      //  System.out.println("searcching "+arr[l]);
for(int i=l+1;i<=r;i++){

    if(arr[i]==arr[l]){
        index=i;
        break;
    }
    if(arr[i]==0){
        countz++;
    }
    if(arr[i]==1){
        counto++;
    }
}






///////////////
if(index!=-1){
   // System.out.println("found at "+index);

    al.add(arr[l]);
    if(counto>1 || countz>1){
        sudo(arr,l+1,index-1);
    }
    al.add(arr[index]);
    sudo(arr,index+1,r);
}
else if(index==-1){
   // System.out.println("not found");
    sudo(arr,l+1,r);
}
else{
    return;
}


/////////////
    }
}

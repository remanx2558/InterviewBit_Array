package SegmentTreeAndDP;

public class ChineseRemainder {
    public static void main(String args[]){
        ////////////////////////
       int num[] = {3, 4, 5}, rem[] = {2, 3, 1};
        System.out.println(china(num,rem));

    }
    static int china(int arr1[],int arr2[]){
        int x=1;
        while(true){
            int i=0;
            for( i=0;i<arr1.length;i++){
                if(x%arr1[i]!=arr2[i]){
                    break;
                }
            }
            if(i==arr1.length){
                return x;
            }
            x++;

        }


    }
}

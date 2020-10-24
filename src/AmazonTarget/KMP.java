package AmazonTarget;

import java.util.HashMap;
import java.util.Scanner;

public class KMP {

    public static void main (String[] args)
    {
        //code
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();

        for(int o=0;o<t;o++){
            int n=s.nextInt();
            int arr[]=new int [n];

            for(int i=0;i<n;i++){
                arr[i]=s.nextInt();
            }

            greed(arr);

        }

    }
    static void greed(int []arr){
        int sum = 0; // initialize sum of whole array
        int leftsum = 0; // initialize leftsum

        int n=arr.length;
        /* Find sum of the whole array */
        for (int i = 0; i < n; ++i)
            sum += arr[i];

        for (int i = 0; i < n; ++i) {
            sum -= arr[i]; // sum is now right sum for index i

            if (leftsum == sum)
            {  System.out.println(i+1);
            return;}

            leftsum += arr[i];
        }

        /* If no equilibrium index found, then return 0 */
        System.out.println("-1");

    }
}

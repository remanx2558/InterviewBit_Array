import java.io.IOException;

public class SetBits {
    public static void main(String args[])throws IOException {
        int A[]={1,2,3};
        int ans=getAngle(9, 60);
    }

    static int getAngle(int H , int M) {
        // code here

        double h=H;
        h=(((h%12)/12)*360)%360;

        double m=M;
        m=((m/60)*360)%360;

        double val=1;
        val=(val/12)*360;
        double mm=M;
        mm=(mm/60);


       // System.out.println("val us "+val+" and mm "+mm);
        h=((h)%360+(val*mm)%360)%360;

        double ans=((double) Math.abs(h-m));
        ans=Math.min(ans,360-ans);


      System.out.println("h is "+h+" m is "+m+" and ans is "+ans);
        return (int)(ans);
    }
}


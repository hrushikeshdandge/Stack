import java.io.*;
import java.util.*;
public class Rain_Water_Tapping
{
    public void check(int a[])
    {
        int mxr[]=new int[a.length];
        int mxl[]=new int[a.length];

        mxl[0]=a[0];
        for(int i=1;i<a.length;i++)
        {
            mxl[i]=Math.max(a[i],mxl[i-1]);
            System.out.println(mxl[i]+" "+mxl[i-1]);
        }
        mxr[a.length-1]=a[a.length-1];
        for(int i=a.length-2;i>=0;i--)
        {
            mxr[i]=Math.max(a[i],mxr[i+1]);
        }
        int water[]=new int[a.length];
        int sum=0;
        //System.out.println(mxl);
        //System.out.println(mxr);
        for(int i=0;i<a.length;i++)
        {
            
            water[i]=Math.min(mxr[i],mxl[i])-a[i];
            sum=sum+water[i];
        }
        System.out.println("Water logged is "+sum);
    }
    public static void main(String args[])
    {
        Rain_Water_Tapping obj=new Rain_Water_Tapping();
        Scanner sc=new Scanner(System.in);
        System.out.println("ENter the size of array ");
        int size=sc.nextInt();
        int a[]=new int[size];
        System.out.println("Enter the elements in array ");
        for(int i=0;i<size;i++)
        {
            a[i]=sc.nextInt();
        }
        obj.check(a);
    }
}
import java.io.*;
import java.util.*;
public class Maximum_Area_Histogram
{
    public Vector NSR(int a[])
    {
        Stack<int []> s=new Stack<>();
        Vector<Integer> v=new Vector<Integer>();

        int size=a.length;

        for(int i=a.length-1;i>=0;i--)
        {
            if(s.size()==0)
            {
                v.add(size);
            }
            else if(s.size()>0 && a[i]>s.peek()[0])
            {
                v.add(s.peek()[1]);
            }
            else if(s.size()>0 && a[i]<=s.peek()[0])
            {
                while(s.size()>0 && a[i]<=s.peek()[0])
                {
                    s.pop();
                }
                if(s.size()==0)
                {
                    v.add(size);
                }
                else
                {
                    v.add(s.peek()[1]);
                }
            }
            s.push(new int[]{a[i],i});
        }
        Collections.reverse(v);
        return v;
    }

    public Vector NSL(int a[])
    {
        Stack<int []> s=new Stack<>();
        Vector<Integer> v=new Vector<Integer>();
        for(int i=0;i<a.length;i++)
        {
            if(s.size()==0)
            {
                v.add(-1);
            }
            else if(s.size()>0 && a[i]>s.peek()[0])
            {
                v.add(s.peek()[1]);
            }
            else if(s.size()>0 && a[i]<=s.peek()[0])
            {
                while(s.size()>0 && a[i]<=s.peek()[0])
                {
                    s.pop();
                }
                if(s.size()==0)
                {
                    v.add(-1);
                }
                else
                {
                    v.add(s.peek()[1]);
                }
            }
            s.push(new int[]{a[i],i});
        }
        return v;
    }

    public void check(int a[])
    {
        Vector v1=NSR(a);
        Vector v2=NSL(a);
        System.out.println(v1);
        System.out.println(v2);
        Vector<Integer> v3=new Vector<Integer>();
        for(int i=0;i<a.length;i++)
        {
            int width=(int)v1.get(i)-(int)v2.get(i)-1;
            v3.add(width*a[i]);
        }

        System.out.println("MAximum Histogram Area is " + Collections.max(v3));
    }
    public static void main(String args[])
    {
        Maximum_Area_Histogram obj=new Maximum_Area_Histogram();
        Scanner sc=new Scanner(System.in);
        System.out.println("ENter the size of the array");
        int size=sc.nextInt();
        int a[]=new int[size];
        System.out.println("ENter the elements in the array");
        for(int i=0;i<size;i++)
        {
            a[i]=sc.nextInt();
        }
        obj.check(a);
    }
}
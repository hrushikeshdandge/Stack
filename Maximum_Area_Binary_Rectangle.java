import java.io.*;
import java.util.*;
import java.lang.*;

public class Maximum_Area_Binary_Rectangle
{
    public Vector NSR(Vector a)
    {
        Stack<int []> s=new Stack<>();
        Vector<Integer> v=new Vector<Integer>();
        int size=a.size();
        for(int i=a.size()-1;i>=0;i--)
        {
            if(s.size()==0)
            {
                v.add(size);
            }
            else if(s.size()>0 && s.peek()[0]<(int)a.get(i))
            {
                v.add(s.peek()[1]);
            }
            else if (s.size()>0 && s.peek()[0]>=(int)a.get(i))
            {
                while(s.size()>0 && s.peek()[0]>=(int)a.get(i))
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
            s.push(new int[]{(int)a.get(i),i});
        }
        Collections.reverse(v);
        return v;
    }
    public Vector NSL(Vector a)
    {
        Stack<int []> s=new Stack<>();
        Vector<Integer> v= new Vector<>();
        for(int i=0;i<a.size();i++)
        {
            if(s.size()==0)
            {
                v.add(-1);
            }
            else if(s.size()>0 && s.peek()[0]<(int)a.get(i))
            {
                v.add(s.peek()[1]);
            }
            else if(s.size()>0 && s.peek()[0]>=(int)a.get(i))
            {
                while(s.size()>0 && s.peek()[0]>=(int)a.get(i))
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
            s.push(new int[]{(int)a.get(i),i});
        }
        return v;
    }

    public int MAH(Vector a)
    {
        Vector v1=NSR(a);
        Vector v2=NSL(a);
     
        Vector<Integer> v3=new Vector<Integer>();
        for(int i=0;i<a.size();i++)
        {
            int width=(int)v1.get(i)-(int)v2.get(i)-1;
            int area=width*(int)a.get(i);
            v3.add(area);
        }
        return Collections.max(v3);
    }

    public void check(int a[][])
    {
        
        Vector<Integer> v=new Vector<Integer>();
        int max=0;

        for(int i=0;i<a[0].length;i++)
        {
            v.add(a[0][i]);

        }
        max=MAH(v);
        for(int i=1;i<a.length;i++)
        {
            
            for(int j=0;j<a[i].length;j++)
            {
                if(a[i][j]==0)
                {
                    v.set(j,0);
                }
                else
                {
                    v.set(j,(int)v.get(j)+a[i][j]);
                }
            }
           
            max=Math.max(max,MAH(v));
        }
        System.out.println(max);
        
    }
    public static void main(String args[])
    {
        Maximum_Area_Binary_Rectangle obj=new Maximum_Area_Binary_Rectangle();
        Scanner sc=new Scanner(System.in);
        
        System.out.println("ENter the size of the array");
        int row=sc.nextInt();
        int col=sc.nextInt();
        int a[][]=new int[row][col];
        System.out.println("ENter the elements in the array");
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                a[i][j]=sc.nextInt();
            }
            
        }
        obj.check(a);
      
       
    }
}
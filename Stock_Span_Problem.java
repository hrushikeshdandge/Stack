import java.io.*;
import java.util.*;
//import javafx.util.Pair;
public class Stock_Span_Problem
{
    public void check(int a[])
    {
       Stack<int[]> s = new Stack<>();
        Vector<Integer> v=new Vector<Integer>();

        for(int i=0;i<a.length;i++)
        {
            if(s.size()==0)
            {
                v.add(-1);
            }
            else if(s.size()>0 && s.peek()[0]>a[i])
            {
                v.add(s.peek()[1]);
            }
            else if(s.size()>0 && s.peek()[0]<=a[i])
            {
                while(s.size()>0 && s.peek()[0]<=a[i])
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
        for(int i=0;i<v.size();i++)
        {
            v.set(i,(i-v.get(i)));
        }
        System.out.println(v);
    }
    public static void main(String args[])
    {
        Stock_Span_Problem obj=new Stock_Span_Problem();
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
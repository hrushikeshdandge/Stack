import java.io.*;
import java.util.*;
public class Nearest_Smallest_ELement_Left
{
    public void check(int a[])
    {
        Stack<Integer> s=new Stack<Integer>();
        Vector<Integer> v=new Vector<Integer>();

        for(int i=0;i<a.length;i++)
        {
            if(s.size()==0)
            {
                v.add(-1);
            }
            else if(s.size()>0 && s.peek()<a[i])
            {
                v.add(s.peek());
            }
            else if(s.size()>0 && s.peek()>=a[i])
            {
                while(s.size()>0 && s.peek()>=a[i])
                {
                    s.pop();
                }
                if(s.size()==0)
                {
                    v.add(-1);
                }
                else
                {
                    v.add(s.peek());
                }
            }
            s.push(a[i]);
        }
        System.out.println(v);
    }
    public static void main(String args[])
    {
        Nearest_Smallest_ELement_Left obj=new Nearest_Smallest_ELement_Left();
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

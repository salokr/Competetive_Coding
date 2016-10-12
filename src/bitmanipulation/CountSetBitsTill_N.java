/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmanipulation;
import java.util.*;
/**
 *
 * @author ashutosh
 */
public class CountSetBitsTill_N 
{
    public static int getCount(int n)
    {
        int count=0;
        while(n!=0)
        {
            count+= ((n & 1)!= 0)?1:0;
            n=n>>1;
        }
        return count;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n=sc.nextInt();
            int count=0;
            for(int i=1;i<=n;i++)
                count+=getCount(i);
            System.out.println(count);
            t--;
        }
    }
}

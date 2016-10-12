/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmanipulation;

/**
 *
 * @author Saurabh <saurabh.mtcs15@iitp.ac.in>
 */
public class CountSetBits 
{
    public static int getBits(int num)
    {
        int count=0;
        while(num>0)
        {
            if((num&1)!=0)
                count++;
            num>>=1;
        }
        return count;
    }
    public static void main(String[] args)
    {
        int n=Integer.parseInt("1111100101010100000000111110000",2);
        
        
        long begin=System.nanoTime();
        System.out.println(getBits(n));
        long end=System.nanoTime();
        System.out.println((end-begin)*Math.pow(10,-9));
        
        begin=System.nanoTime();
        System.out.println(getSetBits(n));
        end=System.nanoTime();
        System.out.println((end-begin)*Math.pow(10,-9));
    }
    
    public static int getSetBits(int num)
    {
        int count=0;
        while(num>0)
        {
            count++;
            num= num & (num-1);
        }
        return count;
    }
}

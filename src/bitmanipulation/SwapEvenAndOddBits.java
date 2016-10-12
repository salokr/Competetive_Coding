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
public class SwapEvenAndOddBits
{
    public static int swapBits(int n)
    {
        int i=4;//assume 8 bits, can do 16 for 32 bits, in general n for 2n bits
        String op="";
        while(i>0)
        {
            int first=n&1;
            n>>=1;
            int second=n&1;
            n>>=1;
            op=(first)+""+(second)+op;
            i--;
        }
        return (Integer.parseInt(op,2));
    }
    public static void main(String[] args)
    {
        System.out.println(swapBits(swapBits(23)));
        System.out.println(swapBitsConstantTime(43));
        System.out.println(swapBitsConstantTime(23));
    }
    public static long swapBitsConstantTime(int num)
    {
        /*Let Number is stored in 32 bits*/
        return (num&Long.parseLong("10101010101010101010101010101010",2))>>1|(num&Long.parseLong("01010101010101010101010101010101",2))<<1;
    }
    
    public static long inHexa(long num)
    {
        return ((num&0xAAAAAAAA)>>1)|((num&0x55555555)<<1);
    }
}

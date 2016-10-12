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
public class ReverseBits
{
    public static int reverseBits(int num)
    {
        int size=32,rev=0;
        System.out.println(Integer.toBinaryString(num));
        while(num>0)
        {
            rev <<= 1;
            rev|= num&1;
            size--;
            num >>= 1;
        }
        rev<<=size;
        System.out.println(Integer.toBinaryString(rev));
        return rev;
    }
    public static int getLen(int num){return(int)(1+(Math.log(num)/Math.log(2)));}
    public static void main(String[] args)
    {
        int num=6;
        System.out.println(reverseBits(num));
    }
}

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
public class CountBitsToBeFlipped 
{
    public static int getCount(int a,int b)
    {
        int xor=a^b,count=0;
        while(xor>0)
        {
            count++;
            xor=xor&(xor-1);
        }
        return count;
    }
    public static void main(String[] args)
    {
        System.out.println(getCount(Integer.parseInt("1001001",2),Integer.parseInt("0010101",2)));
    }
}

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
public class TwoDistinctElements 
{
    /*Every element except two are repeated once, those two have appeared once only :D */
    public static void getDistinct(int a[])
    {
        int xor=0,set1=0,set2=0,setbit;
        for(int i:a)
            xor^=i;
        setbit=xor&(~(xor)+1);//twos complement and AND with 2's complement will do the work, NOTE XOR WILL NEVER BE ZERO
        for(int i:a)
        {
            if((i&setbit)!=0)
                set1^=i;
            else set2^=i;
        }
        System.out.println(set1+" "+set2);
    }
    public static void main(String[] args)
    {
        int a[]={2, 3, 7, 9, 11, 2, 3, 11};
        getDistinct(a);
    }
}

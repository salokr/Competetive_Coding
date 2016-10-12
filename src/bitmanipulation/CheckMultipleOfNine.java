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
public class CheckMultipleOfNine
{
    public static boolean isMultiple(int num)
    {
        if(num==9||num==0)
            return true;
        if(num<9)
            return false;
        return isMultiple((num>>3)-(num&7));
    }
    public static void main(String[] args)
    {
        for (int i = 0; i < 100; i++)
            if (isMultiple(i))
                System.out.print(i+"\t");
    }
}

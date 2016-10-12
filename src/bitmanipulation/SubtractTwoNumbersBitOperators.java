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
public class SubtractTwoNumbersBitOperators
{
    public static int subtract(int n1,int n2)
    {
        while(n2!=0)
        {
            int borrow=(~n1) & (n2);
            n1^=n2;
            n2=borrow<<1;/*current borrow bits will subtract from there immediate right bits*/
        }
        return n1;
    }
    public static void main(String[] arths)
    {
        System.out.println(subtract(2,4));
    }
}

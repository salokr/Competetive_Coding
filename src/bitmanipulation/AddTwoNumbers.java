/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmanipulation;

/**
 *
 * @author ashutosh
 */
public class AddTwoNumbers 
{
    /**
     * @param num1     
     * @param num2     
     * /*
        The Idea is Simple, Suppose we have
        Num1======>>>       1  1  0  0  1  1  0  1  1
        Num2======>>>       1  0  1  1  0  1  1  1  1, so what we do normally is, first we will set all bits in result zero  where we have same bits
        in num1 and num2, why ? suppose x is 1 and y is 1, then x+y will have 0 at last place same true for 0+0 =0 ...
        Now how to propagate carry? 
        suppose at ith bit we have 1 and 1 (i.e. carry is generated) then this will be affected to (i+1)st bit, same thing we will follow here.
        
        for above in first iteration, result=x XoR y, i.e. result=  0  1  1  1  1  0  1  0  0, now the carry that are generated in this step
        can be calculated using carry= x AND y, ie. carry=  1 0 0 0 0 1 0 1 1, now starting from last bit this carry will be propagated in result,
        so will shift left this thing and add again to result and follow the same steps till carry becomes zero.
        thus carry = 0 0 0 0 1 0 1 1 0 
        
        Actually what we are doing is, in steps we are adding current values of x and y, and storing the carry value, now this carry will be added
        to result and again new carry will be generated, this step will be repeated till carry generation is stopped :).
     */
    public static void addNums(int num1,int num2)
    {
        while(num2!=0)// while there is carry repeat the addition process
        {
            int carry=num1 & num2;//store the carry bits to be propagated
            num1^=num2;//add current bits without carry
            num2 =carry<<1;
        }
        System.out.println(num1);
    }
    public static void main(String[] argbs)
    {
        int n1=15,n2=32;
        addNums(n1, n2);
        addNums(n1, -n2);
    }
}

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
public class MultiplyWithSeven
{
    public static int multiply7(int num)
    {
        return (num<<3) - num;
    }
    public static void main(String[] args)
    {
        System.out.println(multiply7(-10));
        System.out.println(multiply7(-15));
        System.out.println(multiply7(multiply7(multiply7(7))));
        
        
        System.out.println("\n\n\n");
        
        
        System.out.println(withoutNegativeSign(-10));
        System.out.println(withoutNegativeSign(-15));
        System.out.println(withoutNegativeSign(withoutNegativeSign(withoutNegativeSign(7))));
        
    }
    public static int withoutNegativeSign(int num)
    {
        return (num<<2) + (num<<1)+ num;
    }
}

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
public class ShiftConcept 
{
    public static void main(String[] args)
    {
        int num=-10;
        System.out.println(Integer.toBinaryString(num));
        /*When you left shift a negative number you append a zero to the end*/
        System.out.println(Integer.toBinaryString(num<<1));
        /*BUT!!!! when you right shift a negtive number you append a 1 at the begining*/
        System.out.println(Integer.toBinaryString(num>>1));
    }
}

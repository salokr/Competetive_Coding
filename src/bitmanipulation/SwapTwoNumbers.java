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
public class SwapTwoNumbers {
    public static void main(String[] args)
    {
        int y=10,x=100;
        System.out.println(x+" "+y);
        x=(y^x)^(y=x);
        System.out.println(x+" "+y);
    }
}

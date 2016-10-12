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
public class CheckForIntegerOverFlow 
{
    public static int avoidOverFlow(int a,int b)
    {
        return ((a>>31)==(b>>31)&&((a+b)>>31)!=(a>>31))?-1:a+b;
    }
    public static void main(String[] args){
        System.out.println(avoidOverFlow(Integer.MAX_VALUE, 2));//overflow
        System.out.println(avoidOverFlow(Integer.MAX_VALUE, 0));
        System.out.println(avoidOverFlow(Integer.MAX_VALUE-10, 2));
        System.out.println(avoidOverFlow(Integer.MIN_VALUE, -2));//overflow
        System.out.println(avoidOverFlow(Integer.MIN_VALUE, 2));
        System.out.println(avoidOverFlow(Integer.MIN_VALUE, 0));
    }
}


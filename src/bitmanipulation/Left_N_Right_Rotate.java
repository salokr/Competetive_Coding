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
public class Left_N_Right_Rotate 
{
    static int size=8;
    public static int leftRotate(int num,int shift)
    {
        return (num<<shift)|(num>>(size-shift));
    }
    public static void main(String[] args)
    {
        int n=11,d=3;
        System.out.println(Integer.toBinaryString(leftRotate(Integer.parseInt("11101",2), d)));
        
    }
    public static int rightRotate(int num,int shift)
    {
        return (num>>shift)|(num<<(size-shift));
    }
}

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
public class PositionOfRightMostSetBit 
{
    public static int getPos(int num)
    {
        num=num & ~(num-1);
        return (int)(Math.log(num)/Math.log(2))+1;
    }
    public static void main(String[] args)
    {
        System.out.println(getPos(1));
        System.out.println(getPos(32));
        System.out.println(getPos(Integer.parseInt("1100000000",2)));
    }
}

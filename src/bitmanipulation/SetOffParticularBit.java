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
public class SetOffParticularBit 
{
    public static int turnOff(int a,int k)
    {
        return k<=0?-1:a&(~(1<<(k-1)));
    }
    public static void main(String[] args){
        System.out.println(turnOff(15, -34));
    }
}

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
public class CkeckForPowerOfTwo 
{
    public static boolean checkPower2(int n)
    {
        /*
        System.out.println((n&(n-1))==0);
        System.out.println(n==(n&~(n-1)));
        Both Don't work with n=0 :(
        */
        return (n&~((n&(n-1))))==n;
    }
    public static void main(String[] args)
    {
        int n=0;
        System.out.println(checkPower2(n));
    }
}

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
public class CheckParity 
{
    public static boolean checkParity(int num)
    {
        int count=0;
        while(num>0)
        {
            if((num&1)==1)
                count++;
            num>>=1;
        }
        return ((count&1)==0);
    }
    public static void main(String[] args)
    {
        int num=7;
        System.out.println("IsEven: "+checkParity(num));
        System.out.println(isEvenParity(num));
        num=21;
        System.out.println("IsEven: "+checkParity(num));
        System.out.println(isEvenParity(num));
    }
    /*A Better Way and optimized too....*/
    public static boolean isEvenParity(int num)
    {
        boolean flag=true;
        while(num>0)
        {
            flag=!flag;
            num=num&(num-1);
        }
        return flag;
    }
}

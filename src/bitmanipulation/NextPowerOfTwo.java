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
public class NextPowerOfTwo 
{
    public static int nextPower(int n)
    {
        return 1<<((int)Math.ceil(Math.log(n)/Math.log(2)));
    }
    public static int getNextPower(int n)
    {
        int len=0,cnt=0,x=n;
        while(n>0)
        {
            cnt+=(n&1)!=0?1:0;
            len++;
            n>>=1;
        }
        return cnt==1?x:1<<len;
    }
    /*
        Another idea is to check whether number is already in power of two, if yes no need to go further just return it, else count length shift 1
        get answer
    */
    public static void main(String[] sr)
    {
        System.out.println(nextPower(17));
        System.out.println(nextPower(32));
        
        System.out.println(getNextPower(17));
        System.out.println(getNextPower(32));
    }
}

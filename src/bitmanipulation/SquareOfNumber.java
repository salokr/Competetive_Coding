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
public class SquareOfNumber 
{
    public static int getSquare(int n)
    {
        if(n==0||n==1)
            return n;
        if((n&1)!=0)
        {
            int floor=(int)(Math.floor(n/2.0)),ceil=(int)(Math.ceil(n/2.0));
            int tf=getSquare(floor),tc=getSquare(ceil),carry=((floor*ceil))<<1;
            return tf+tc+carry;
        }
        else
        {
                int half=getSquare(n>>1);
                return (half)<<2;
        }
    }
    
    public static int getSq(int n)
    {
        if(n==0||n==1)
            return 1;
        int x=n>>1,sq=getSq(x);
        if((n&1)!=0)/*n is odd*/
            return (sq<<2) + (1) + (x<<2);
        return sq<<2;
    }
    public static void main(String[] args)
    {
        System.out.println(getSquare(19));
        System.out.println(getSq(19));
    }
}

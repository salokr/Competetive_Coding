/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmanipulation;

/**
 *
 * @author ashutosh
 */
public class BinaryRepresentation 
{
    public static String toBinary(int n)
    {
        String op="";
        while(n>0)
        {
            op=(n&1)+op;
            n>>=1;
        }
        return op;
    }
    public static void main(String[] args)
    {
        int n=4;
        System.out.println(toBinary(n));
        n=7;
        System.out.println(toBinary(n));
    }
}

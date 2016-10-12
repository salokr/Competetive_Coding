/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmanipulation;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 * @author Saurabh <saurabh.mtcs15@iitp.ac.in>
 */
public class FindOnlyOne 
{
    public static void findOnlyOne(long n)
    {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        double log=(Math.log(n)/Math.log(2));
        try
        {
        if(log!=Math.ceil(log))
            out.write("-1\n");
        else
            out.write((long)Math.ceil(log+1)+"\n");
        out.flush();
        }
        catch(Exception e)
        {System.out.println(e);}
    }
    public static void main (String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            findOnlyOne(sc.nextLong());
            t--;
        }
    }
}

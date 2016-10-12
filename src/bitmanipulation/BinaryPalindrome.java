/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmanipulation;

import java.util.Scanner;

/**
 *
 * @author Saurabh <saurabh.mtcs15@iitp.ac.in>
 */
public class BinaryPalindrome 
{
public static void main (String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t>0)
	    {
	        long num=sc.nextLong();
	        int length=(int)Math.ceil((Math.log(num)/Math.log(2)));
	        int i=0;
	        boolean flag=true;
                while(i<length)
	        {
                    boolean tflag=((((1<<length-1)&num)!=0)==(((1<<i)&num)!=0));
	            if(!tflag)
	            {
	                flag=false;
	                break;
	            }
	            i++;length--;
	        }
	        if(flag)
	        System.out.println(1);
	        else
	        System.out.println(0);
	        t--;
	    }
	}    
}

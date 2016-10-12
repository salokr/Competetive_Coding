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
public class DetermineIfNumbersHaveOppositeSign
{
    static int isOpposite(int x,int y)
    {
        return (x^y)>>31;//<<----IMPROVED VERSION   !!!!
        //return ((x>>31)^(y>>31));<<---Main Idea
        //return (x^y)<0;
        //return x<0?y>=0:y<0;
    }
    
    
    public static void main(String[] args)
    {
        int n1=100,n2=-100;
        System.out.println(isOpposite(n1, n2));
        n1=100;n2=100;
        System.out.println(isOpposite(n1, n2));
        n1=-100;n2=-100;
        System.out.println(isOpposite(n1, n2));
    }
    
}

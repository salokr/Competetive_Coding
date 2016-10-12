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
public class Max_Min_Of_Two
{
    public static int findMin(int x,int y)
    {
        int diff=x-y;
        diff=y+(diff &(diff>>31));
        return diff;
    }
    
    
    public static int findMax(int x,int y)
    {
        return (x-((x-y)&((x-y)>>31)));
    }
    public static void main(String[] args)
    {
        int a=-2,b=-6,c=10;
        System.out.println(findMin(a, findMin(b, c)));
        System.out.println(findMax(a, findMax(b, c)));
    }
    
    
}

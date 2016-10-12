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
public class StrcmpIgnoringCases 
{
    public static void strcmp(String s1,String s2)
    {
        /*for(int i='a';i<='z';i++)
        {
            System.out.print(Integer.toBinaryString(i)+"\t");//small letters
            System.out.println(Integer.toBinaryString('A'+(i-'a')));//capital letters
            /*
            Thus we can see that 5th bit from left (indexing starts from 0) is only that differs in small and capital representation
            It is so because there is a difference of 32 in each representation.
            
        }
        */
        int i=0,j=0;
        while(i<s1.length()&&j<s2.length())
        {
            char a1=s1.charAt(i),a2=s2.charAt(j);
            if(a1!=a2)
            {
                if((a1^a2)!=32)
                {
                    /*Make them of same case*/
                    a1=(char)(a1|32);a2=(char)(a2|32);//System.out.println(a1+" "+a2);/*Now both are in smaller case*/
                    System.out.println((a1-a2)>>31==-1?"-1":"+1");
                    return;
                }//else they are equal so continue;;
            }
            i++;j++;
        }
        /*if i has ended -1 is answer, if j has ended +1 is answer, else 0 is answer.*/
        if(i==s1.length()&&j!=s2.length())
        {
            System.out.println("-1");
            return;
        }
        if(i!=s1.length()&&j==s2.length())
        {
            System.out.println("+1");
            return;
        }
        System.out.println("0");
    }
    public static void main(String[] args)
    {
        strcmp("Geeks","apple");
        strcmp("","ABCD");
        strcmp("ABCD", "z");
        
        strcmp("abcd","ABCDeGHE");
        
        strcmp("GeeksForGeeks", "gEEksFORGeEKs");
        
        strcmp("GeeksForGeeks", "geeksForGeeks");
    }
}

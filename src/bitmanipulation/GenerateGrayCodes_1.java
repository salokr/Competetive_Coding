
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saurabh <saurabh.mtcs15@iitp.ac.in>
 */
public class GenerateGrayCodes_1
{
    public static void generateCodes(int n)
    {
        //String output=""+(n^n>>1);
        //System.out.println(Integer.toBinaryString(n)+" "+Integer.toBinaryString(n>>1));
        System.out.print(Integer.toBinaryString(n^n>>1)+", ");
    }
    public static void main(String[] args)
    {
        int n=5;
        for(int i=0;i<Math.pow(2,n-1);i++)
            generateCodes(i);
        System.out.println();
        
        generateGrayCodes(n);
    }
    public static void generateGrayCodes(int n)
    {
        ArrayList<String> list= new ArrayList<>();
        list.add("0");list.add("1");
        //list size will double every time so we need to check when we have reached 2^(n-1)
        for(int m=2;m<(1<<(n-1));m<<=1)
        {//m=2 since current size is 2, 1<<n means 2^n and since we need 2^(n-1) that's why '<' sign and m<<=2 means m*=2; 
            for(int i=0;i<m;i++)
            {
                list.add(list.get(i));
            }
            int i;
            for(i=0;i<list.size()/2;i++)
            {
                String res=list.remove(i);
                list.add(i,"0"+res);
            }
            for(int j=i;j<list.size();j++)
            {
                String res=list.remove(j);
                list.add(i,"1"+res);
            }
        }
        System.out.println(list);
    }
}

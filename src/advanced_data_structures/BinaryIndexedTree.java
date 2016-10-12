/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advanced_data_structures;

import java.util.Arrays;

/**
 *
 * @author Saurabh <saurabh.mtcs15@iitp.ac.in>
 */

/*
By Ensuring that we each element can hold sum of numbers in 2^x form, we are forcing the nodes to hold certain range
of information only ,i.e. each element can hold info like sum of 2^0 nodes, 2^1 nodes, 2^2 nodes and so on....
So, when we have to get the next pointers we just have to set an unset bit from last one, because that's the range the
current node is going to be included.

*/
public class BinaryIndexedTree 
{
    int tree[];
    int size;
    public BinaryIndexedTree(int s)
    {
        size=s+1;
        tree=new int[size];
    }
    public void buildTree(int a[])
    {
        for(int i=0;i<a.length;i++)
            update(i,a[i]);
    }
    public void update(int index,int x)
    {
        /*Indexing must be start from 1*/
        index+=1;
        while(index<size)
        {
            tree[index]+=x;//update every effected nodes
            index+=(index&(~index+1));/*Gets The next pointer, i.e. setting first unset bit from last left of first set bit :) */
        }
    }
    public int getSum(int index)
    {
        /*Indexing must start from 1*/
        index+=1;
        int sum=0;
        while(index>0)
        {
            sum+=(tree[index]);
            index-=((index)&-index);/*Remove last set bit, first get last set bit and subtract this from index*/
            //index=((index)&(index-1));<<<<--------------ALTERNATIVE
        }
        return sum;
    }
    public String toString(){return Arrays.toString(tree);} 
    public static void main(String[] args)
    {
        int freq[] = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
        
        BinaryIndexedTree bit=new BinaryIndexedTree(freq.length);
        bit.buildTree(freq);
        System.out.println(bit.getSum(5));
        
        System.out.println(Arrays.toString(bit.tree));
        //System.out.println(Integer.toBinaryString((8&(-8))));<--get last set bit
    }
}

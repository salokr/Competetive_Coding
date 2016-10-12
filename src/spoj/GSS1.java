/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj;


import java.io.*;

/**
 *
 * @author Saurabh <saurabh.mtcs15@iitp.ac.in>
 * You are given a sequence A[1], A[2], ..., A[N] . ( |A[i]| ≤ 15007 , 1 ≤ N ≤ 50000 ). A query is defined as follows: 
Query(x,y) = Max { a[i]+a[i+1]+...+a[j] ; x ≤ i ≤ j ≤ y }. 
Given M queries, your program must output the results of these queries.

Input

The first line of the input file contains the integer N.
In the second line, N numbers follow.
The third line contains the integer M.
M lines follow, where line i contains 2 numbers xi and yi.
Output

Your program should output the results of the M queries, one query per line.
 */
public class GSS1
{
    class Node
    {
        int prefixSum,suffixSum,sum,maxsum;
        Node left,right;
        public Node(int psum,int ssum,int tsum,int msum)
        {
            this();
            prefixSum=psum;
            suffixSum=ssum;
            sum=tsum;
            maxsum=msum;
        }
        public Node(){left=null;right=null;}
        public String toString()
        {
            return ""+maxsum;
        }
    }
    class SegmentTree
    {
        Node root;
        int n;
        public SegmentTree(int a[])
        {
            n=a.length;
            root=new Node();
            root=buildTree(a,0,n-1);
        }
        private Node buildTree(int a[],int segstart,int segend)
        {
            if(segstart==segend)
                return new Node(a[segstart],a[segstart],a[segstart],a[segstart]);
            int mid=mid(segstart, segend);
            Node root=new Node();
            root.left=buildTree(a,segstart,mid);
            root.right=buildTree(a,mid+1,segend);
            root=merge(root.left, root.right);
            return root;
        }
        public int queryRange(int qs,int qe)
        {
            return queryRange(0,n-1,qs,qe,root).maxsum;
        }
        private Node queryRange(int segstart,int segend,int qs,int qe,Node root)
        {
            if(segstart==qs&&segend==qe)
                return root;
            int mid=mid(segstart,segend);
            if(qe<=mid)
                return queryRange(segstart,mid, qs, qe, root.left);
            if(qs>mid)
                return queryRange(mid+1, segend, qs, qe, root.right);
            Node left=queryRange(segstart,mid, qs, mid, root.left);
            Node right=queryRange(mid+1, segend, mid+1, qe, root.right);
            Node result=merge(left,right);
            return result;
        }
        
        public Node merge(Node left,Node right)
        {
            Node root=new Node();
            root.sum=left.sum+right.sum;
            root.prefixSum=max(left.prefixSum,left.sum+right.prefixSum);
            root.suffixSum=max(right.suffixSum,right.sum+left.suffixSum);
            root.maxsum=max(left.suffixSum+right.prefixSum,max(left.maxsum,max(right.maxsum,max(root.prefixSum,root.suffixSum))));
            root.left=left;root.right=right;
            return root;
        }
        
        public void postorder(){postorder(root);}
        private void postorder(Node root)
        {
            if(root==null)
                return;
            postorder(root.left);
            postorder(root.right);
            System.out.println(root);
        }
        private int max(int a,int b)
        {
            return Integer.max(a, b);
        }
        private int mid(int a,int b)
        {
            return (a+b)>>1;
        }
    }
    public static void main(String[] args) throws Exception
    {
        Reader sc=new Reader();
        PrintWriter out=new PrintWriter(System.out);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        GSS1 gs=new GSS1();
        SegmentTree st=gs.new SegmentTree(a);
        int q=sc.nextInt();
        for(int i=0;i<q;i++)
        {
            out.println(st.queryRange(sc.nextInt()-1,sc.nextInt()-1));
        }
        out.flush();
    }
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
/*
5 
3 -10 100 -2 20 
1 
1 5 
output: 
118
*/
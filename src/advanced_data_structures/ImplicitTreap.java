/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advanced_data_structures;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Saurabh <saurabh.mtcs15@iitp.ac.in>
 * Treap With Implicit Keys supporting many operations in O(log n) 
 */
public class ImplicitTreap 
{
    static Random rng;
    class TreapNode
    {
        int data,size,sum;/*Holds The Array Data, and size of this node, i.e. Left subtree +Right subtree, and the answer*/
        double priority;/*Priority Of the element*/
        TreapNode left,right;/*Links*/
        public TreapNode(){size=1;left=right=null;sum=0;}/*Default for empty node*/
        int lazy;
        public TreapNode(int d,double p)
        {
            this();/*call default first*/
            data=d;
            priority=p;
            lazy=0;
        }
        public TreapNode(int d)
        {
            this(d,rng.nextDouble());/*call with two parameters no need to write 'em again and again*/
            sum=d;
        }
        public String toString()
        {
            return data+"<Data Priority>"+priority+" "+size+"<Size Sum>"+sum+" lazy>"+lazy;
        }
    }
    public ImplicitTreap()
    {
        root=null;
        rng=new Random();
    }

    public NodePair split(TreapNode root,int key,int done)
    {
        push(root);/*Clear any pending updates and pass 'em to child, otherwise split may loose 'em*/
        NodePair np=new NodePair(null,null);
        if(root==null)
            return np;
        int rootkey=done+getSize(root.left);
        if(rootkey>=key)
        {
            np=split(root.left,key,done);
            root.left=np.right;
            np.right=root;
            update(root);
        }
        else
        {
            np=split(root.right,key,rootkey+1);
            root.right=np.left;
            np.left=root;
            update(root);
        }
        return np;
    }

    
    public void updateRange(int a,int b,int delta)/*Adds delta in array range l to r*/
    {
        NodePair leftright=split(root, a, 0);
        NodePair middle=split(leftright.right,b-a+1,0);
        middle.left.lazy+=delta;/*Add delta to current, and postpone the updation temporarily*/
        inorder(middle.left);
        /*Think About updation here ? */
        root=merge(middle.left,middle.right);
        root=merge(leftright.left,root);
    }
    
    
    
    
    
    public TreapNode merge(TreapNode left,TreapNode right)
    {
        push(left);/*Ensures that current pending updation is done, because of merge positions may get change*/
        push(right);
        if(left==null)return right;
        if(right==null)return left;
        if(left.priority>right.priority)
        {
            left.right=merge(left.right,right);
            update(left);
            return left;
        }
        else
        {
            right.left=merge(left,right.left);
            update(right);
            return right;
        }
    }
    
    public TreapNode insert(TreapNode root,TreapNode newnode,int pos,int done)
    {
        if(root==null)
            return newnode;
        /*Came to higher priority ? */
        if(root.priority<newnode.priority)
        {
            NodePair np=split(root,pos,0);
            newnode.left=np.left;
            newnode.right=np.right;
            update(newnode);
            return newnode;
        }
        int rootkey=getSize(root.left)+done;
        if(rootkey>=pos)
        {
            root.left=insert(root.left,newnode,pos,done);
            update(root);
            return root;
        }
        else
        {
            root.right=insert(root.right,newnode,pos,rootkey+1);
            update(root);
            return root;
        }
    }
    public void update(TreapNode root)
    {
        if(root==null)
            return;
        push(root.left);
        push(root.right);
        root.size=1+getSize(root.left)+getSize(root.right);
        root.sum= operation(root);
    }
    public int operation(TreapNode root)
    {
        /*Replace With whatever you want*/
        return ((getVal(root.left)+getVal(root.right))+root.data);
    }
    
    /*Performs a lazy propagation on segments*/
    public void push(TreapNode root)
    {
        if(root==null)
            return;
        root.data+=root.lazy;
        root.sum+=(getSize(root))*root.lazy;/*Remove any pending updation, here we add delta to current value, sum will be calculated while we go :)*/
        /*Something to do with sum value too........*/
        
        if(root.left!=null)
            root.left.lazy+=root.lazy;/*Pass updation to left child*/
        if(root.right!=null)
            root.right.lazy+=root.lazy;/*Pass updation to right child*/
        root.lazy=0;/*remove pending status from here*/
    }
    public int getVal(TreapNode root)
    {
        /*Replace with identity element of operation, in case of null*/
        return root==null?0:root.sum;
    }
    
    public int getSize(TreapNode root)
    {
        return root==null?0:root.size;
    }

    /*Returns Kth Smallest in range [1....n]*/
    public void kthSmallest(int k)
    {
        NodePair lr=split(root,k,0);
        NodePair mid=split(lr.left,k-1,0);
        System.out.println("Kth Smallest : "+mid.right);
        root=merge(mid.left,mid.right);
        root=merge(root,lr.right);
    }
    public int getOpnInRange(int l,int r)
    {
        /*Calculate Opeartion of array indices from l to r*/
        NodePair leftright=split(root, l, 0);
        NodePair middle=split(leftright.right,r-l+1,0);
        inorder(middle.left);
        int sum=getVal(middle.left);
        root=merge(middle.left,middle.right);
        root=merge(leftright.left,root);
        return sum;
    }
    
    public void inorder(){inorder(root);};
    private void inorder(TreapNode root){if(root==null)return; inorder(root.left);System.out.println(root);inorder(root.right);}
    TreapNode root;
    
    class NodePair
    {
        TreapNode left,right;
        public NodePair(TreapNode left,TreapNode right)
        {
            this.left=left;
            this.right=right;
        }
        public NodePair(){this(null,null);}
    }
    public static void main(String[] args)
    {
        int a[]={1,2,3,4,5};
        ImplicitTreap it=new ImplicitTreap();
        for(int i=1;i<=a.length;i++)
        {
            TreapNode newnode=it.new TreapNode(a[i-1]);
            it.root=it.insert(it.root, newnode, i, 0);
        }
        //System.out.println("Before Query");
        //it.inorder();
        /*Pass in terms of array indices*/
        //System.out.println(it.getOpnInRange(1,3));
        //System.out.println("After query");
        //it.inorder();
        
        //System.out.println("After Query, 4th Smallest ");
        /*Can pass in natural number order i.e. 1,2,3,4th smallest*/
        //it.kthSmallest(4);
        /******************************************************************************/
        System.out.println("Adding 10 in range 1-3");
        it.updateRange(1, 3, 10);
        //it.inorder();
        System.out.println("New Sum In range 1-3 "+it.getOpnInRange(1, 3));
        System.out.println("After Query");
        it.inorder();
        /******************************************************************************/
    }
    
}

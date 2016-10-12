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
 */
public class Treaps 
{
    TreapNode root;
    Random rng;
    public Treaps()
    {
        rng=new Random();
        root=null;
    }
    /**
     * Returns Size Of Current Node
     * @param r : Node whose size has to be determined
     * @return : The Size of current subtree rooted at r
     */
    public int getSize(TreapNode r)
    {
        return r==null?0:r.size;
    }
    
    /**
     * Updates Size Of Current Node r
     * @param r : The Node whose size has to be updated
     * @since : Current will also counted, so 1+(something)
     */
    public void update(TreapNode r)
    {
        r.size=1+getSize(r.left)+getSize(r.right);
    }
    
    /**
     * Splits The root into two parts, left will have all values less than equal to key,and right have greater than key
     * @param root :    The Node along whose split has to be done
     * @param key  :    The Key on which behalf you have to split
     * @return     :    Node Pair left & right
     */
    public NodePair split(TreapNode root,int key)
    {
        NodePair newpair=new NodePair();
        if(root==null)/*If Nothing in tree just return all NULL*/
            return newpair;
        if(root.key>key)/*If root is having value greater than key*/
        {
            newpair=split(root.left,key);/*Split left part*/
            root.left=newpair.right;/*Left of root will now contain node withvalue greater than key(if exists else null)*/
            update(root);/*Update the size of root*/
            newpair.right=root;/*since this node has val, greater than key, it Belongs to right*/
        }
        else
        {/*Explanation is same as above*/
            newpair=split(root.right,key);
            root.right=newpair.left;
            update(root);
            newpair.left=root;
        }
        return newpair;/*Return left and right parts*/
    }
    
    /*Asuumption left has all keys less than right*/
    public TreapNode merge(TreapNode left,TreapNode right)
    {
        if(left==null)/*If left is null nothing to link just return right*/
            return right;
        if(right==null)
            return left;/*If right is null nothing to link just return left*/
        if(left.priority>right.priority)/*See where to go and collect Left and Right trees*/
        {
            left.right=merge(left.right,right);/*Maintains Heap-Invariant and BST too, if assumtion is followed*/
            update(left);
            return left;
        }
        else
        {
            right.left=merge(left,right.left);/*Maintains Heap-Invariant and BST too, if assumtion is followed*/
            update(right);
            return right;
        }
    }
    
    public TreapNode insert(TreapNode root,TreapNode newnode)
    {
        if(root==null)
            return newnode;
        if(root.priority<newnode.priority)/*We have came to a right place for insertion*/
        {
            NodePair np=split(root,newnode.key);
            newnode.left=np.left;
            newnode.right=np.right;
            update(newnode);
            return newnode;
        }
        if(newnode.key<=root.key)
        {
            root.left=insert(root.left,newnode);
            update(root);
            return root;
        }
        else
        {
            root.right=insert(root.right,newnode);
            update(root);
            return root;
        }
    }
    public TreapNode insert2(TreapNode root,int key)
    {
        NodePair np=split(root,key);
        return merge(merge(np.left,new TreapNode(key, rng.nextDouble())),np.right);
    }
    public TreapNode remove(TreapNode root,int key)
    {
       if(root==null)
           return root;
       if(key<root.key)
       {
           root.left=remove(root.left,key);
           return root;
       }
       else if(key>root.key)
       {
           root.right=remove(root.right,key);
           return root;
       }
       else
       {
           return merge(root.left,root.right);
       }
    }
    void inorder()
    {
        inorder(root);
    }
    private void inorder(TreapNode curr)
    {
        if(curr==null)
            return;
        inorder(curr.left);
        System.out.println(curr);
        inorder(curr.right);
    }
    private int getHeight(TreapNode curr)
    {
        if(curr==null)
            return 0;
        return 1+(Integer.max(getHeight(curr.left), getHeight(curr.right)));
    }
    public int getHeight(){return getHeight(root);}
    public static void main(String[] args)
    {
        HashMap<Integer,TreapNode> map=new HashMap<>();
        Treaps t=new Treaps();
        for(int i=8;i>0;i--)
        {
            TreapNode newnode=new TreapNode(i, t.rng.nextDouble());
            t.root=t.insert(t.root, newnode);
            map.put(i, newnode);
        }
        t.inorder();
        System.out.println(t.getHeight()+"\nTrying Split");
        
        System.out.println("Left");
        NodePair np=t.split(t.root, map.get(3).key);
        t.inorder(np.left);
        System.out.println("Right");
        t.inorder(np.right);
        
        
        System.out.println("Merging 'em up");
        t.inorder(t.merge(np.left,np.right));
    }
}
class TreapNode
{
    int key;
    double priority;
    TreapNode left,right;
    int size;
    public TreapNode(int key,double priority)
    {
        this.key=key;
        this.priority=priority;
        left=right=null;
        size=1;
    }
    public String toString(){return key+" "+priority+" Size "+size;}
}
class NodePair
{
    TreapNode left,right;
    public NodePair()
    {
        left=right=null;
    }
    public NodePair(TreapNode left,TreapNode right)
    {
        this.left=left;
        this.right=right;
    }
}

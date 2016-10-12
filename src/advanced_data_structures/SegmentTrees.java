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
public class SegmentTrees
{
    public static void main(String[] args)
    {
        int a[] = {1, 3, 5};
        SegmentTree st=new SegmentTree(a);
        System.out.println("Sum in range 1,2 "+st.getSum(0,2));
        
        
        st.updateIndex(1, a, 10);
        System.out.println("Updated Sum in range 1,3 "+st.getSum(1,3));
    }
}
class SegmentTree
{
    int tree[],n;
    /**
     * How the tree height and size decided ?
     * Answer :) Let's derive mathematically :D
     * first what about size of tree ?
     * Size would be like, 1,2,4,8.......pow(2,k) (since tree is full binary tree, we are forcing each to have two child or zero)
     * so this will stop when pow(2,k)=1 => k >= (lgn) or k=Ceil(lgn), now we can use G.P. formula to get sum of series
     * 1+2+4+8+.......+pow(2,k) which gives us the array size required, so it is 2*(pow(2,ceil(lgn))-1)+1
     * which is equal to 2*pow(2,ceil(lgn)) - 1 :)
     */
    public SegmentTree(int a[])
    {
        this.n=a.length;
        int height=(int)Math.ceil((Math.log(n)/Math.log(2)));
        tree=new int[2*(int)(Math.pow(2, height))-1];
        constructTree(a,0,n-1,0);
        System.out.println(Arrays.toString(tree));
    }
    
    private int getMid(int start,int end)
    {
        return (start+end)/2;
    }
    
    /**
     * Construct recursively segment tree using the array a
     * @param a :   Array holding elements
     * @param segstart  : index which tells us about, the start index of current segment in array
     * @param segend : index which tells us about, the end index of current segment in array
     * @param segindex : tells about index current segment in TREE.
     * @see : Let the array is from a[0.....5], now first element will hold sum [0...2] and another [3...5],
     *        so, its left will be 0*2+1,0*2+2, thus left child of root is at 1 and right at 2, so in next recursive call
     *        we should call at, seg_start=0, seg_end=mid, seg_index=1, for left child
     *        and for right child, seg_start=mid+1, seg_end=end. seg_index=2 and recursion will take care of rest :)
     */
    private int  constructTree(int a[],int segstart,int segend,int segindex)
    {
        /*If leaf i.e. segment size is one, store from original array and return*/
        if(segstart==segend)
        {
            tree[segindex]=a[segstart];
            return tree[segindex];
        }
        int mid=getMid(segstart, segend);
        tree[segindex]=constructTree(a, segstart, mid, segindex*2+1)+constructTree(a, mid+1, segend, segindex*2+2);
        return tree[segindex];
    }
    
    public int getSum(int qstart,int qend)
    {
        return getSum(0,n-1,qstart,qend,0);
    }
    private int getSum(int segstart,int segend,int qstart,int qend,int segindex)
    {
        if(qstart>segend||qend<segstart)
            return 0;
        /*In-Range ? , think about parts of query segment and you will get to know about in-equalities :)*/
        if(segstart>=qstart&&segend<=qend)
            return tree[segindex];
        int mid=getMid(segstart, segend);//prepare childs now
        return getSum(segstart,mid,qstart,qend,segindex*2+1)+getSum(mid+1,segend,qstart,qend,segindex*2+2);
    }
    public void updateIndex(int index,int a[],int newval)
    {
        int diff=newval-a[index];/*set val at a[index]=newval, so a constant diff is to added in each affected segment*/
        a[index]=newval;
        updateIndex(0,n-1,diff,0,index);
    }
    /**
     * Updates segment tree in proper segment i.e. if index lies in current segment adds value to current segment
     */
    private void updateIndex(int segstart,int segend,int val,int segindex,int index)
    {
        /*Out of range ? */
        if(index>segend||index<segstart)
            return;
        /*if here, means index is in range so update segment tree*/
        tree[segindex]+=val;
        /*Update left and right childs too...*/
        if(segstart!=segend)
        {   /*To avoid infinite loop, also since if this is leaf it will not have childs*/
            int mid=getMid(segstart,segend);
            updateIndex(segstart,mid,val,segindex*2+1,index);/*Have to update only one index*/
            updateIndex(mid+1, segend, val, segindex*2+2, index);/*So donot worry about child sum, confused?
            look for lazy propagation and find answer.*/
            /*Remember, atmost one updation per level !!! */
        }
    }
}

/*
Simple to derive that time  complexity for
building tree O(n)
updation O(lgn)
query O(lgn)

Lastly Space Complexity O(n)
*/





/*
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sc=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(sc.nextToken());
        int a[]=new int[n];
        sc=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            a[i]=Integer.parseInt(sc.nextToken());
        GSS1 gs=new GSS1();
        SegmentTree st=gs.new SegmentTree(a);
        sc=new StringTokenizer(br.readLine());
        int q=Integer.parseInt(sc.nextToken());
        for(int i=0;i<q;i++)
        {
            sc=new StringTokenizer(br.readLine());
            System.out.println(st.queryRange(Integer.parseInt(sc.nextToken())-1,Integer.parseInt(sc.nextToken())-1));
        }
*/
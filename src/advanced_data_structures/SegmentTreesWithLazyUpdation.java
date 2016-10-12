/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advanced_data_structures;

/**
 *
 * @author Saurabh <saurabh.mtcs15@iitp.ac.in>
 */
public class SegmentTreesWithLazyUpdation
{
    class SegmentTrees
    {
        int n,size,tree[],lazy[];
        SegmentTrees(int a[])
        {
            n=a.length;
            int height=(int)(Math.ceil(Math.log(n)/Math.log(2)));
            size=2*(int)(Math.pow(2, height))-1;
            tree=new int[size];
            lazy=new int[size];
            buildTree(a,0,n-1,0);
        }
        private int buildTree(int a[],int segstart,int segend,int segindex)
        {
            if(segstart==segend)
            {
                tree[segindex]=a[segstart];
                return tree[segindex];
            }
            int mid=getMid(segstart,segend);
            tree[segindex]=buildTree(a,segstart,mid,segindex*2+1)+buildTree(a,mid+1,segend,segindex*2+2);
            return tree[segindex];
        }
        private int getMid(int s,int e){return (s+e)/2;}
        public int getSum(int qs,int qe)
        {
            return getSum(0,n-1,0,qs,qe);
        }
        private int getSum(int segstart,int segend,int segindex,int qstart,int qend)
        {
            if(lazy[segindex]!=0)
            {
                tree[segindex]+=(segend-segstart+1)*lazy[segindex];
                if(segstart!=segend)
                {
                    lazy[segindex*2+1]+=lazy[segindex];
                    lazy[segindex*2+2]+=lazy[segindex];
                }
                lazy[segindex]=0;
            }
            if(segstart>segend||qstart>segend||qend<segstart)
                return 0;
            /*Overlapping from either side or completely*/
            if(segstart>=qstart&&segend<=qend)
                return tree[segindex];
            int mid=getMid(segstart, segend);
            return getSum(segstart,mid,segindex*2+1,qstart,qend)+getSum(mid+1,segend,segindex*2+2,qstart,qend);
        }
        
        public void updateRange(int ustart,int uend,int val)
        {
            updateRange(0,n-1,0,val,ustart,uend);
        }
        private void updateRange(int segstart,int segend,int segindex,int val,int ustart,int uend)
        {
            if(lazy[segindex]!=0)
            {
                tree[segindex]+=(segend-segstart+1)*lazy[segindex];
                if(segstart!=segend)
                {
                    lazy[segindex*2+1]+=lazy[segindex];
                    lazy[segindex*2+2]+=lazy[segindex];
                }
                lazy[segindex]=0;
            }
            if(segstart>segend||segstart>uend||segend<ustart)
                return;
            /*Completely in range, then update set lazy for childs and return*/
            if(segstart>=ustart&&segend<=uend)
            {
                tree[segindex]+=(segend-segstart+1)*val;
                if(segstart!=segend)
                {
                    lazy[segindex*2+1]+=val;
                    lazy[segindex*2+2]+=val;
                }
                return;
            }
            int mid=getMid(segstart,segend);
            updateRange(segstart, mid, segindex*2+1, val, ustart, uend);
            updateRange(mid+1, segend, segindex*2+2, val, ustart, uend);
            tree[segindex]=tree[segindex*2+1]+tree[segindex*2+2];
            /*Because now range of values are updated which can lie anywhere in left or right*/
        }
    }
    
    
    public static void main(String[] args)
    {
        int a[] = {1, 3, 5, 7, 9, 11};
        SegmentTreesWithLazyUpdation stml=new SegmentTreesWithLazyUpdation();
        SegmentTrees st=stml.new SegmentTrees(a);
        System.out.println(st.getSum(1,3));
        st.updateRange(1, 5, 10);
        System.out.println(st.getSum(1, 3));
    }
}

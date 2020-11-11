package SegmentTreeAndDP;

public class Heap {

    static int capacity;
    static int heap[];
    static int heap_size;
    public static void main(String args[]){
        capacity=11;
        heap_size=0;
        heap=new int[capacity];
        //////////////////////////

        insertKey(3);
        insertKey(2);
        deleteKey(1);
        insertKey(15);
        insertKey(5);
        insertKey(4);
        insertKey(45);
        int v1=extractMin();
        System.out.println(v1);
        int v2=getMin() ;
        System.out.println(v2);

        decreaseKey(2, 1);
        int v3=getMin();
        System.out.println(v3);
        //////////////////////
    }
    static void decreaseKey(int i,int val){
        if(i<0 ||i>=heap_size){
            return;
        }
        heap[i]=val;
        heapify(i);
    }
    static int getMin(){
        if(heap_size==0){
            System.out.println("nothing to get");
            return -1;
        }
        return heap[0];

    }

    static void deleteKey(int i){
        if(i<0 || i>=heap_size){
            System.out.println("unable to delete");
            return;
        }
        heap[i]=Integer.MIN_VALUE;
        heapify(i);
        extractMin();



    }
    static int extractMin(){
        if(heap_size==0){
            System.out.println("nothing to extract");
        }
        int val=heap[0];
        heap[0]=heap[heap_size-1];
        heap_size--;
        heapify(0);
        return val;

    }
    static void heapify(int i){
        int p=parent(i);
        int l=left(i);
        int r=right(i);
        if(p>=0 && heap[p]>heap[i]){
            swap(p,i);
            heapify(p);
        }
        if(l>=0 &&heap[l]<heap[i]){
            swap(l,i);
            heapify(i);
        }
        if(r>=0 && heap[r]<heap[i]){
            swap(r,i);
            heapify(i);
        }

    }
    static int left(int i){
        int left=2*i+1;
        if(left>=heap_size){
            return -1;
        }
        return left;
    }
    static int right(int i){
        int left=2*i+2;
        if(left>=heap_size){
            return -1;
        }
        return left;
    }

    static void insertKey(int num){
        if(heap_size>=capacity){
            System.out.println("heap size reached");
            return;
        }
        //////////////////////////
        heap[heap_size]=num;
        int i=heap_size;
        while(i!=0 && heap[i]<heap[parent(i)]){
            swap(i,parent(i));
        }
        heap_size++;
        return;
    }
    static int parent(int i){
        if(i==0){
            return -1;
        }
        return (i)/2;
    }
    static void swap(int i,int j){
        int t=heap[i];
        heap[i]=heap[j];
        heap[j]=t;

    }
}

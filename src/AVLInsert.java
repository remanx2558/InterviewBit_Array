public class AVLInsert {

    public  Node insertToAVL(Node node,int data)
    {
        //code here

        //bst insert
        Node newNode=new Node();
        newNode.data=data;
        /////////
        node=BST(node,newNode);
        ////////bottom up
        int val=balancer(node);
        return node;

    }

    int balancer(Node root){
        if(root==null){
            return 0;
        }
        int l=balancer(root.left);
        int r=balancer(root.right);

        //left
        if(l>r+1){
            //left is big right
            root=rightRotate(root);
            l=balancer(root.left);
            r=balancer(root.right);


        }
        //right
        if(r>l+1){
            root=leftRotate(root);
            l=balancer(root.left);
            r=balancer(root.right);

        }
        //left
        if(l>r+1){
            //left is big right
            root=rightRotate(root);
            l=balancer(root.left);
            r=balancer(root.right);


        }
        //right
        if(r>l+1){
            root=leftRotate(root);
            l=balancer(root.left);
            r=balancer(root.right);

        }

        return Math.max(l,r);


    }
    Node BST(Node root,Node nn){
        if(root==null){
            root=nn;
            return root;
        }
        if(root.data>nn.data){
            root.left=BST(root.left,nn);
        }
        else if(root.data<nn.data){
            root.right=BST(root.right,nn);
        }
        return root;
    }
    Node rightRotate(Node z){

        Node y=z.left;
        Node t4=z.right;

        Node t3=y.right;
        Node x=y.left;
        //////////////////swap data of z and y
        int temp=z.data;
        z.data=y.data;
        y.data=temp;

        //////////////
        z.left=x;
        z.right=y;
        y.left=t3;
        y.right=t4;

        /////////////////
        return z;
    }
    Node leftRotate(Node z){
        Node y=z.right;
        Node t1=z.left;

        Node t2=y.left;
        Node x=y.right;
        //////////////////swap data of z and y
        int temp=z.data;
        z.data=y.data;
        y.data=temp;

        //////////////
        z.left=y;
        z.right=x;
        y.left=t1;
        y.right=t2;

        /////////////////
        return z;
    }
    class Node
    {
        int data;
        Node left;
        Node right;
        int height;
    };
}

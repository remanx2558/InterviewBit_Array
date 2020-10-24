package AmazonTarget;

public class LinkedListRearrange {


    Node reorderlist(Node head) {
        if(head==null||head.next==null){
            return null;
        }
        //////two parts
        Node root2=middle(head);
        Node nextt=root2.next;
        root2.next=null;
        root2=nextt;
        //reversing list
        root2=reverso(root2);
        //////////////////
        Node root1=head;
        while(root1!=null && root2!=null){
            Node next1=root1.next;
            Node next2=root2.next;
            root1.next=root2;
            root2.next=next1;
            /////////////
            root1=next1;
            root2=next2;

        }
        return head;

    }

    ////find middele
    Node middle(Node root){
        if(root==null||root.next==null){
            return root;
        }
        Node faster=root;
        Node curr=root;
        while(faster.next!=null && faster.next.next!=null){
            curr=curr.next;
            faster=faster.next.next;
        }
        return curr;
    }


    ////reversefrom here

    Node reverso(Node root){
    if(root==null||root.next==null){
    return root;}
    Node prev=null;
    Node curr=root;
    Node next=null;

    while(curr.next!=null){
    next=curr.next;
    curr.next=prev;
    curr=next;
    prev=prev;
    }
    curr.next=prev;
    return curr;
    }


    }

    class Node
    {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }

}

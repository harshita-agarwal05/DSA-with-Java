package Linked_list.circularLlinkedlist;

public class circularLL {
    private Node head;
    private Node tail;
    private int size;

    Node insertAtBeginning(int data){
        Node newNode = new Node(data);
        if(head==null){
            head =newNode;
            tail =newNode;
            head.next =head;
            size++;
            return head;
        }


        // if we have only tail then
       /*
        if(tail ==null){

            tail =newNode;
            tail.next=tail;
            size++;
            return tail;
        }
        */

        //case1 : we have both head and tail

        tail.next =newNode;
        newNode.next =head;
        head =newNode;
        size++;
        return head;


        // Case2 : we have only head
        /*
        Node temp =head;
        do{
            temp =temp.next;

        }while(temp.next != head);

        temp.next =newNode;
        newNode.next =head;
        head =newNode;
        size++;
        return head;
        */


        // case 3: we have only tail

        /* newNode.next =tail.next;
        tail.next =newNode;
        size++;
        return tail;
        */


    }

    Node insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head==null){
            head =newNode;
            tail = newNode;
            head.next = head;
            size++;
            return head;
        }

        // case 1: we have both head and tail
        tail.next =newNode;
        newNode.next = head;
        tail =newNode;
        size++;
        return head;
    }

    void traverseCll(Node head){
        if(head==null){
            System.out.println("List is empty");
        }
        Node temp =head;
        do{
            System.out.println(temp.data+"");
            temp=temp.next;

        }while(temp!=head);
        System.out.println();
    }
    public static void main(String[] args){
        Node head =null;
        circularLL cll =new circularLL();
        head =cll.insertAtBeginning(10);
        head =cll.insertAtBeginning(20);
        head =cll.insertAtBeginning(30);
        head =cll.insertAtBeginning(40);
        cll.traverseCll(head);
        head=cll.insertAtEnd(70);
        cll.traverseCll(head);
    }
}

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

    Node insertAtPosition(int data, int pos){
        Node newNode =new Node(data);
        if(pos<=0){
            System.out.println("Position cannot exist");
            return head;
        }

        if (pos==1){
            return insertAtBeginning(data);
        }

        Node temp,prevNode;
        prevNode=null;
        int currPos =1;
        temp=head;
        do{
            if(currPos==pos){
                break;
            }
            prevNode=temp;
            temp=temp.next;
            currPos++;
        }while(temp !=head);
        if(temp ==head){
            System.out.println("Not a valid position .so can ot insert");
            return head;
        }
        newNode.next=prevNode.next;
        prevNode.next =newNode;
        size++;
        return head;
    }

    Node insertAfterValue(int data,int value){
        Node newNode =new Node(data);
        if(head==null){
            System.out.println("Insert cannot be possible");
            return head;

        }
        if(head.data==value){
            newNode.next =head.next;
            head.next =newNode;
            size++;
            return head;
        }
        Node temp=head;
        do{
            if(temp.data==value){
                newNode.next =temp.next;
                temp.next =newNode;
                size++;

               break;
            }
            temp=temp.next;
        }while(temp !=head);


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
        head =cll.insertAtPosition(35,3);
        cll.traverseCll(head);
        head =cll.insertAfterValue(38,35);
        cll.traverseCll(head);
    }
}

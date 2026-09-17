package Linked_list.DoublyLinkedList;

public class DoublyLL {

    private Node head;
    private Node tail;
    private int size;

    Node insertAtBeginning(int data){
        Node newNode =new Node(data);
        if(head==null){
            head =newNode;
            tail =newNode;
            size++;
            return head;
        }
        newNode.next =head;
        head.prev=newNode;
        head=newNode;
        size++;
       return head;

    }

    void traverseDll(Node head){
        if(head==null){
            System.out.println("List is empty");
        }
        else{
            Node temp =head;
            while(temp != null){
                System.out.print(temp.data+ " ");
                temp =temp.next;
            }
            System.out.println();
        }
    }

    Node insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head ==null){
            head =newNode;
            tail =newNode;
            size++;
            return head;
        }
//        // case 1: when we have tail
//        tail.next =newNode;
//        newNode.prev =tail;
//        tail =newNode;
//        size++;
//        return head;

        //case 2: when we donot have tail

        Node temp =head;
        while(temp.next != null){
            temp =temp.next;
        }
        temp.next =newNode;
        newNode.prev =temp;
        size++;
        return head;


    }

    Node insertAtPosition(int data, int pos){
        if(pos<0){
            System.out.println("Position is not valid.so can not insert.");
            return head;
        }
        if(pos==1){
            return insertAtBeginning(data);
        }
        Node newNode =new Node(data);
        Node temp =head;
        int currPosition=1;
        while(temp != null){
            if(currPosition ==pos){
                break;
            }
            temp =temp.next;
            currPosition++;
        }
        if(temp ==null){
            System.out.println("Position is not valid");
            return head;
        }
        Node prevNode;
        prevNode =temp.prev;
        newNode.next =temp;
        temp.prev=newNode;
        newNode.prev =prevNode;
        prevNode.next =newNode;
        size++;
        return head;

    }

    Node insertAfterValue(int data, int val){
        if(head == null){
            System.out.println("No such value exist so can not insert");
            return head;

        }
        Node newNode=new Node(data);
        Node temp =head;
        while(temp != null && temp.data != val){
            temp =temp.next;
        }
        if(temp ==null){
            System.out.println("No such value exist in the list so can not insert");
            return head;
        }
        Node nextNode=temp.next;
        newNode.next=nextNode;
        newNode.prev = temp;
        temp.next =newNode;
        if(nextNode !=null){
            nextNode.prev =newNode;
        }
        size++;
        return head;

    }
    void insertBeforePosition(int data, int pos) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (pos <= 1) {
            System.out.println("Cannot insert before position 1");
            return;
        }

        Node newNode = new Node(data);

        // Special case: pos = 2
        // New node should be inserted at position 1
        if (pos == 2) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;

            size++;
            return;
        }

        Node temp = head;
        int currPos = 1;

        // Find position pos - 1
        while (temp != null && currPos < pos - 1) {
            temp = temp.next;
            currPos++;
        }

        if (temp == null) {
            System.out.println("Position is not valid");
            return;
        }

        // Insert newNode before temp
        Node prevNode = temp.prev;

        newNode.next = temp;
        newNode.prev = prevNode;

        if (prevNode != null) {
            prevNode.next = newNode;
        }

        temp.prev = newNode;

        size++;
    }


    Node deleteFromBeginning(){
        if(head == null){
            System.out.println("list is empty so we cannot delete");
            return head;
        }

        System.out.println("deleted Node is: " + head.data);

        head = head.next;

        if(head != null){
            head.prev = null;
        } else {
            tail = null;
        }

        size--;

        return head;
    }

    Node deleteFromEnd(){
        if(head==null){
            System.out.println("List is empty");
        }
        if(head.next==null){
            System.out.println("Dlete Node is:" +head.data);
            head=head.next;
            size--;
            return head;
        }
        Node temp;
        temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        System.out.println("Deleted node is:" +temp.data);
        temp.prev.next=temp.next;
        size--;
        return head;
    }

    Node deleteFromPosition(int pos){

        if(head == null){
            System.out.println("List is empty");
            return head;
        }

        if(pos <= 0){
            System.out.println("Position is not valid");
            return head;
        }

        if(pos == 1){
            deleteFromBeginning();
            return head;
        }

        int currPos = 1;
        Node temp = head;

        while(temp != null && currPos < pos){
            temp = temp.next;
            currPos++;
        }

        if(temp == null){
            System.out.println("Position is not valid");
            return head;
        }

        System.out.println("Deleted Node is: " + temp.data);

        Node prevNode = temp.prev;

        prevNode.next = temp.next;

        if(temp.next != null){
            temp.next.prev = prevNode;
        } else {
            tail = prevNode;
        }

        size--;

        return head;
    }
    void reverseTraverse(Node head){
        Node temp =head;
        if(head ==null){
            System.out.println("List is Empty");
        }
        else{
            while(temp.next != null){
                temp =temp.next;
            }
        }
        while(temp !=null){
            System.out.print(temp.data+ " ");
            temp =temp.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        Node head;
        head =dll.insertAtBeginning(15);
        dll.traverseDll(head);
        head =dll.insertAtEnd(25);
        dll.traverseDll(head);
        head = dll.insertAfterValue(25,10);
        head=dll.insertAtPosition(100,2);
        dll.traverseDll(head);
        dll.reverseTraverse(head);
        dll.insertBeforePosition(2,3);
        dll.traverseDll(head);
        head = dll.deleteFromBeginning();
        dll.traverseDll(head);
        head=dll.deleteFromEnd();
        dll.traverseDll(head);
        head=dll.insertAtBeginning(10);
        head=dll.insertAtEnd(50);
        head=dll.insertAtBeginning(45);
        dll.traverseDll(head);
        head=dll.deleteFromPosition(2);
        dll.traverseDll(head);

    }
}

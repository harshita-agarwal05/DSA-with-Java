package Linked_list;

public class SingleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    void insertAtBeginning(int data){
        Node newNode =new Node(data);
        newNode.next =head;
        head=newNode;

        if(tail==null){
            tail=newNode;
        }
        size++;
    }

    void traverseLinkedList(){
        if(head==null){
            System.out.println("list is empty");;
            return;
        }
        Node temp;
        temp = head;
        while(temp != null){
            System.out.print(temp.data+ "-->");
            temp =temp.next;
        }
        System.out.println("End");
    }

    void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head==null){
            insertAtBeginning(data);
            return;
        }
        //tail.next =newNode;
       // tail = newNode;
       // size++;
        //if you cnnot want to use tail then
        Node temp;
        temp =head;
        while(temp.next !=null){
            temp =temp.next;
        }
        temp.next =newNode;
        size++;

    }

    void insetAtPosition(int data , int pos){
        Node newNode = new Node(data);
        if(pos<0 || pos>size+1){
            System.out.println("Position is not valid");
            return;
        }
        if(head==null){
            if(pos==1){
                insertAtBeginning(data);
                return;
            }
        }

        if(pos==1){
            newNode.next =head;
            head = newNode;
            size++;
            return;
        }
        int currPosition=1;
        Node temp;
        temp =head;
        while(currPosition<pos-1){
            temp =temp.next;
            currPosition++;
        }
        newNode.next =temp.next;
        temp.next =newNode;
        size++;

    }

    void insertAfterValue(int data,int value){
        Node newNode = new Node(data);
        Node temp;
        temp =head;
        while((temp != null) && (temp.data !=value)){
            temp = temp.next;
        }
        if(temp != null){
            newNode.next =temp.next;
            temp.next = newNode;
            size++;
        }
        else {
            System.out.println("No such vlue exist so can not insert the data ");
        }
    }

    void deleteFromBegining(){
        if(head==null){
            System.out.println("Can not delete because list is empty");
            return;
        }
        System.out.println("Deleted node is" +head.data);
        head =head.next;
        size--;
        if(head==null){
            tail=null;
        }
    }

    void deleteFromEnd(){
        if(head == null){
            System.out.println("Can not delete because list is empty ");
        }
        if(head.next ==null){
            System.out.println("Deleted Node is :"+head.data);
            head = head.next;
            tail =null;
            size--;
            return;
        }
        Node temp;
        temp =head;
        while(temp.next.next !=null){
            temp =temp.next;
        }
        System.out.println("Deleted Node is"+temp.next.data);
        temp.next =temp.next.next;
        size--;
    }

    void deleteFromPosition(int pos){
        if(head == null){
            System.out.println("Cn not delete because list is empty");
            return;
        }
        if(pos==1){
            deleteFromBegining();
        }
        //if(pos<=0 || pos>size){
          //  System.out.println("Given Position is not valid so can not delete any node");
            //return;
        //}

        int currPos=1;
        Node temp,prevNode;
        prevNode = null;
        temp =head;
        while(currPos<pos-1){
            temp =temp.next;
            currPos++;
        }
        System.out.println("Deleted Node is:"+temp.next.data);
        temp.next =temp.next.next;
        size--;


    }

    void findLength(){
        Node temp;
        temp =head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        System.out.println("Length of linked list is:" +count);
    }

    boolean searchElement(int value){
        Node temp;
        temp = head;
        while(temp!=null){
            if(temp.data == value){
                return true;
            }
            temp =temp.next;

        }
        return false;
    }

    void reverseLL() {
        if (head == null) {
            System.out.println("List is empty so we can not reverse it");
            return;
        }
        if (head.next == null) {
            System.out.println("Only one element in the list");
            System.out.println(head.data);
            return;
        }
        Node temp, preNode, nextNode;
        temp = head;
        preNode = null;
        while (temp != null) {
            nextNode = temp.next;
            temp.next = preNode;
            preNode = temp;
            temp = nextNode;
        }
        head = preNode;

    }
    public static void main(String[] args) {
        SingleLinkedList obj = new SingleLinkedList();
        obj.insertAtBeginning(15);
        obj.insertAtBeginning(5);
        obj.insertAtEnd(10);
        obj.insetAtPosition(25,2);
        obj.traverseLinkedList();
        obj.insertAfterValue(20,25);
        obj.traverseLinkedList();
        obj.deleteFromBegining();
        obj.traverseLinkedList();
        obj.deleteFromEnd();
        obj.traverseLinkedList();
        obj.deleteFromPosition(3);
        obj.traverseLinkedList();
        obj.findLength();
        System.out.println(obj.searchElement(10)); //Time complexity o(n) space complexity o(1)
        obj.reverseLL();
        obj.traverseLinkedList();



    }
}

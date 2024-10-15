package ADILEC3;


public class Priorityqueue {
    public static void main(String[] args) {
        Priorityqueuee pq=new Priorityqueuee();
        pq.enque(3,3);
        pq.enque(1,1);
        pq.enque(2,2);

        System.out.println(pq.deque());
        System.out.println(pq.peek());
    }
}
class Node{
    int data;
    int priority;
    Node next;

    Node(int data,int priority){
        this.data=data;
        this.priority=priority;
        this.next=null;
    }
}
class Priorityqueuee {
    Node head;

    Priorityqueuee(){
        head=null;
    }

    void enque(int data,int priority){
        Node newNode= new Node(data,priority);

        if(head == null || head.priority > newNode.priority){
            newNode.next=head;
            head=newNode;
        }
        else {
            Node temp=head;
            Node prev = null;
            while(temp != null && temp.priority < newNode.priority){
                prev=temp;
                temp=temp.next;
            }

            prev.next=newNode;
            newNode.next=temp;
        }
    }

    int deque(){
        if(head == null){
            System.out.println("priority is empty");
            return -1;
        }
        int res= head.data;
        head=head.next;
        return res;
    }
    int peek(){
        if(head == null){
            System.out.println("priority is empty");
            return -1;
        }
        return head.data;
    }
}

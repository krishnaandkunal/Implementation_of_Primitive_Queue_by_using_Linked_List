import java.util.Scanner;

class Node{
    private int data;
    private Node next;

    public Node() {
        data = 0;
        next = null;
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
}

public class MyQueue {
    Node front;
    Node rear;

    public MyQueue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty(){
        if(front==null && rear==null){
            return true;
        }
        else
            return false;
    }

    public void enqueue(int val){
        Node n = new Node();
        n.setData(val);
        if(isEmpty()){
            front = rear =n;
        }
        else{
            rear.setNext(n);
            rear = n;
        }
    }

    public int dequeue(){
        int result;
        if(isEmpty()){
            System.out.println("Linked List is Empty");
            return 0;
        }
        else{
            result = front.getData();
            front = front.getNext();
            return result;
        }
    }

    public void display(){
        Node temp;
        temp = front;

        if(isEmpty()){
            System.out.println("Linked list is empty");
            return;
        }
        else{
            while(temp!=null){
                System.out.println(temp.getData());
                temp = temp.getNext();
            }
        }
    }

    public int count(){
        int ctr = 0;
        Node temp;
        temp = front;

        while(temp!=null){
            ctr++;
            temp = temp.getNext();
        }
        return ctr;
    }

    public static void main(String[] args) {
        char ch ='y';
        int choice;
        Scanner sc = new Scanner(System.in);
        int n;
        MyQueue que = new MyQueue();
        while(ch=='y' || ch=='Y') {
            System.out.println("Select any operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Count");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter Data:");
                    n = sc.nextInt();
                    que.enqueue(n);
                    break;
                case 2:
                    n = que.dequeue();
                    if (n!=0)
                        System.out.println("Removed data is "+n);
                    break;
                case 3:
                    que.display();
                    break;
                case 4:
                    n = que.count();
                    System.out.println("Total elements are "+n);
            }
            System.out.println("Want to continue(y/n)");
            ch = sc.next().charAt(0);
        }
    }
}

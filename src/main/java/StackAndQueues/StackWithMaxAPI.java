package StackAndQueues;

/**
 * Created by Vetriselvan on 22-12-2017.
 * Stack with max API implementation
 */
public class StackWithMaxAPI {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println(stack.peek()+" "+stack.max());
        stack.pop();
        System.out.println(stack.peek()+" "+stack.max());
    }
}

interface stackAPI<T> {
    void push(T node);
    T peek();
    T pop();
    T max();
}

class Stack {
    Node head;

    void push(int data) {
        if(head == null) {
            head = new Node(data, data);
        } else {
            int max = head.max > data ? head.max : data;
            Node temp = new Node(data, max);
            temp.next = head;
            head = temp;
        }
    }

    int peek() {
        return head == null ? -1 : head.data;
    }

    int pop() {
        if (head == null)
            return -1;
        int data = head.data;
        head = head.next;
        return data;
    }

    int max() {
        if (head == null)
            return -1;
        return head.max;
    }

}

final class Node {
    public int data;
    public int max;
    public Node next;

    public Node(int data, int max) {
        this.data = data;
        this.max = max;
        this.next = null;
    }
}
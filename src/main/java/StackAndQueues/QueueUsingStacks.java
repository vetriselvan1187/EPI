package StackAndQueues;


import java.util.LinkedList;

/**
 * Created by Vetriselvan on 26-12-2017.
 * 9.9 Implement Queue Using Stacks
 */
public class QueueUsingStacks {
    public static void main(String[] args) throws Exception {
        QueueStack<Integer> queueStack = new QueueStack<Integer>();
        queueStack.enque(10);
        queueStack.enque(20);
        queueStack.enque(30);

        System.out.println(queueStack.dequeue());
        System.out.println(queueStack.dequeue());
        System.out.println(queueStack.dequeue());
        System.out.println(queueStack.dequeue());


    }
}

class QueueStack<Integer> {
    LinkedList<Integer> stack1 = new LinkedList<Integer>();
    LinkedList<Integer> stack2 = new LinkedList<Integer>();

    public void enque(Integer x) {
        stack1.addFirst(x);
    }

    public Integer dequeue() throws Exception {
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.addFirst(stack1.removeFirst());
            }
        }
        if(!stack2.isEmpty()) {
            return stack2.removeFirst();
        }
        throw new Exception("Can not pop empty queue");
    }
}

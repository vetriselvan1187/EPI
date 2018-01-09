package LinkedList;

/**
 * Created by Vetriselvan on 28-12-2017.
 * 8.13 Add List Based Integers
 *
 */

public class AddListIntegers {
    public static void main(String[] args) {
        Node L1 = new Node(3);
        L1.next = new Node(1);
        L1.next.next = new Node(4);

        Node L2 = new Node(7);
        L2.next = new Node(0);
        L2.next.next = new Node(9);

        AddListIntegers addListIntegers = new AddListIntegers();
        Node L3 = addListIntegers.addToNumbers(L1, L2);
        addListIntegers.printList(L3);
    }

    private void printList(Node L3) {
        while(L3 != null) {
            System.out.print(L3.data);
            System.out.print(' ');
            L3 = L3.next;
        }
    }

    private Node addToNumbers(Node L1, Node L2) {
        Node dummyHead = new Node(0);
        Node placeIter = dummyHead;
        int carry = 0;

        while(L1 != null || L2 != null) {
            int sum = carry;
            if(L1 != null) {
                sum += L1.data;
                L1 = L1.next;
            }

            if(L2 != null) {
                sum += L2.data;
                L2 = L2.next;
            }

            Node node = new Node(sum % 10);
            carry = sum / 10;
            placeIter.next = node;
            placeIter = placeIter.next;
        }

        if(carry > 0) {
            placeIter.next = new Node(carry);
        }
        return dummyHead.next;
    }
}

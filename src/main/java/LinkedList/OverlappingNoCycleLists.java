package LinkedList;

/**
 * Created by Vetriselvan on 27-12-2017.
 * 8.4 Test for Overlapping Lists
 */

public class OverlappingNoCycleLists {
    public static void main(String[] args) {
        Node l1 = new Node(10);
        l1.next = new Node(20);
        l1.next.next = new Node(30);
        l1.next.next.next = new Node(40);
        l1.next.next.next.next = new Node(50);

        Node l2 = new Node(15);
        l2.next = l1.next.next.next;

        OverlappingNoCycleLists overlappingNoCycleLists = new OverlappingNoCycleLists();
        Node intersectedNode = overlappingNoCycleLists.findIntersectedNode(l1, l2);
        if(intersectedNode == null)
            System.out.println("There is no overlap");
        System.out.println(intersectedNode.next.data);
    }

    private Node findIntersectedNode(Node l1, Node l2) {
        int l1Length = lengthOfList(l1);
        int l2Length = lengthOfList(l2);

        if(l1Length > l2Length) {
            l1 = advanceListByK(l1Length-l2Length, l1);
        } else {
            l2 = advanceListByK(l2Length-l1Length, l2);
        }

        while(l1 != null && l2 != null && l1.next != l2.next) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }

    private Node advanceListByK(int k, Node l) {
        while(k-- > 0) {
            l = l.next;
        }
        return l;
    }

    private int lengthOfList(Node list) {
        int length = 0;
        while(list != null) {
            length++;
            list = list.next;
        }
        return length;
    }
}

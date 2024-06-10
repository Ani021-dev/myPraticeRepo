package src;

public class SwapPairsLinkedList {
    public static class LinkedList {
        int val;
        LinkedList next;

        LinkedList(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(2);
        list.next = new LinkedList(1);
        list.next.next = new LinkedList(4);
        list.next.next.next = new LinkedList(3);

        LinkedList head = swapPairs(list);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static LinkedList swapPairs(LinkedList list) {
        if (list == null || list.next == null) {
            return list;
        }

        LinkedList temp = list.next;
        list.next = swapPairs(list.next.next);
        temp.next = list;
        return temp;
    }
}

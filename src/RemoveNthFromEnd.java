package src;


public class RemoveNthFromEnd {
    public static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            this.data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode res = getNthEle(head, 2);

        while (res != null) {
            System.out.print(res.data + " ");
            res = res.next;
        }
        System.out.println();
        System.out.println("------------------------------------");

//        ListNode res1 = reverseList(head);
//        while (res1 != null) {
//            System.out.print(res1.data + " ");
//            res1 = res1.next;
//        }

        ListNode res2 = rotateList(head, 2);

        System.out.println();
        System.out.println("------------------------------------");

        while (res2 != null) {
            System.out.print(res2.data + " ");
            res2 = res2.next;
        }
    }

    public static ListNode getNthEle(ListNode head, int n) {
        ListNode fast = head, slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode next, current = head, prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;
    }

    public static ListNode rotateList(ListNode head, int k) {
        if(k == 0)
            return head;

        ListNode current = head;

        int count = 1;
        while((count < k) && (current != null)){
            current = current.next;
            count++;
        }

        if(current == null)
            return head;

        ListNode kthNode = current;

        while (current.next != null)
            current = current.next;

        current.next = head;

        head = kthNode.next;

        kthNode.next = null;

        return head;
    }
}

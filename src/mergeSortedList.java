package src;

public class mergeSortedList {
    static class LinkList {
        int val;
        LinkList next;

        LinkList(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] ar) {
        LinkList l1 = new LinkList(1);
        l1.next = new LinkList(3);
        l1.next.next = new LinkList(4);
        l1.next.next.next = new LinkList(6);

        LinkList l2 = new LinkList(2);
        l2.next = new LinkList(5);
        l2.next.next = new LinkList(7);
        l2.next.next.next = new LinkList(8);

        LinkList res = mergeList(l1, l2);

        while (res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static LinkList mergeList(LinkList l1, LinkList l2) {
        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l1.next = mergeList(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeList(l1, l2.next);
                return l2;
            }
        }

        if (l1 == null)
            return l2;
        return l1;
    }

}

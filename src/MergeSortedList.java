package src;

public class MergeSortedList {
    public static class LinkList {
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

        while (res != null) {
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

class MergeNSortedList {

    static class LinkList {
        int val;
        MergeNSortedList.LinkList next;

        LinkList(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        MergeNSortedList.LinkList l1 = new MergeNSortedList.LinkList(1);
        l1.next = new MergeNSortedList.LinkList(3);
        l1.next.next = new MergeNSortedList.LinkList(4);
        l1.next.next.next = new MergeNSortedList.LinkList(6);

        MergeNSortedList.LinkList l2 = new MergeNSortedList.LinkList(2);
        l2.next = new MergeNSortedList.LinkList(5);
        l2.next.next = new MergeNSortedList.LinkList(7);
        l2.next.next.next = new MergeNSortedList.LinkList(9);

        MergeNSortedList.LinkList l3 = new MergeNSortedList.LinkList(0);
        l3.next = new MergeNSortedList.LinkList(8);
        l3.next.next = new MergeNSortedList.LinkList(10);
        l3.next.next.next = new MergeNSortedList.LinkList(12);

        MergeNSortedList.LinkList[] lists = {l1, l2, l3};
        MergeNSortedList.LinkList res = mergeLists(lists);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static LinkList mergeLists(LinkList[] lists) {
        return partition(lists, 0, lists.length - 1);
    }

    public static LinkList partition(LinkList[] lists, int low, int high) {
        if (low == high)
            return lists[low];

        if (low < high) {
            int mid = (low + high) / 2;
            LinkList l1 = partition(lists, low, mid);
            LinkList l2 = partition(lists, mid + 1, high);
            return merge(l1, l2);
        } else {
            return null;
        }
    }

    public static LinkList merge(LinkList l1, LinkList l2) {
        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}

class Solution {
    public ListNode reverseKNodes(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            ListNode start = prev.next;
            ListNode end = curr;
            int count = 0;
            while (end != null && count < k) {
                end = end.next;
                count++;
            }
            if (count == k) {
                ListNode nextSegmentStart = end;
                ListNode reversedSegmentStart = reverseKNodes(start, k);
                prev.next = reversedSegmentStart;
                start.next = nextSegmentStart;
                prev = start;
                curr = nextSegmentStart;
            } else {
           
                break;
            }
        }

        return dummy.next;
    }
}
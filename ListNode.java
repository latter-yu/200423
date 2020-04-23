public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public ListNode partition(ListNode pHead, int x) {
        //以给定值x为基准将链表分割成两部分
        // 所有小于x的结点排在大于或等于x的结点之前
        ListNode node = new ListNode(-1);
        ListNode node1 = new ListNode(-1);
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        //设置两个链表
        //小于x的结点链表：head 为头结点，tail 为尾结点
        ListNode head = node;
        ListNode tail = node;
        //大于或等于x的结点链表：h 为头结点，t 为尾结点
        ListNode h = node1;
        ListNode t = node1;

        ListNode cur = pHead;
        while (cur != null) {
            if(cur.val < x) {
                tail.next = cur;
                tail = tail.next;
            }else {
                t.next = cur;
                t = t.next;
            }
            cur = cur.next;
        }
        tail.next = h.next;
        t.next = null;
        return head.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //将两个升序链表合并为一个新的升序链表并返回
        // 新链表是通过拼接给定的两个链表的所有节点组成的
        //示例：
        //输入：1->2->4, 1->3->4
        //输出：1->1->2->3->4->4
        ListNode node = new ListNode(-1);
        ListNode cur = node;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if(l1 == null) {
            cur.next =  l2;
        }else {
            cur.next = l1;
        }
        return node.next;
    }

    public ListNode FindKthToTail1(ListNode head, int k) {
        //输入一个链表，输出该链表中倒数第k个结点
        //算法复杂度过大
        ListNode cur = head;
        ListNode prev = new ListNode(-1);
        while(cur.next != null) {
            prev.next = cur;
            prev = cur.next;
            cur = cur.next;
        }
        ListNode tail = cur;
        //逆置
        while(cur != head) {
            cur.next = prev;
            cur = cur.next;
            prev = prev.next;
        }
        for(int i = 0; i < k; i++) {
            tail = tail.next;
        }
        return tail;
    }
    public ListNode FindKthToTail(ListNode head, int k) {
        //输入一个链表，输出该链表中倒数第k个结点
        ListNode pre = head;
        ListNode p = head;

        //记录k值
        int a = k;
        //记录节点的个数
        int count=0;
        //p指针先跑，并且记录节点数，当p指针跑了k-1个节点后，pre指针开始跑，
        //当p指针跑到最后时，pre所指指针就是倒数第k个节点
        while(p!=null){
            p=p.next;
            count++;
            if(k<1){
                pre=pre.next;
            }
            k--;
        }
        //如果节点个数小于所求的倒数第k个节点，则返回空
        if(count<a) {
            return null;
        }
        return pre;
    }
}
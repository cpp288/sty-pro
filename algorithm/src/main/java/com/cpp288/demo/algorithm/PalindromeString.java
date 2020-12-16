package com.cpp288.demo.algorithm;

/**
 * 使用单向链表数据结构判断字符串是否是回文
 *
 * @author chenjian
 * @date 2020/12/16 下午7:33
 */
public class PalindromeString {

    /**
     * 单向链表
     */
    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 先找到单向链表的中间节点，使用两个快慢指针寻找，快指针每次移动两步，慢指针每次移动一步
        ListNode pre = null;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            // 快指针每次移动两步，直到链表结束
            fast = fast.next.next;
            // 慢指针进行链表翻转
            // 将当前慢指针的下一个节点指向上一个节点（将下一个节点先缓存下来）
            ListNode next = slow.next;
            slow.next = pre;
            // 将前一个节点指向当前节点，慢指针指向下一个节点，进入下一次循环
            pre = slow;
            slow = next;
        }

        // 判断链表的长度奇偶，fast不为null表示奇数
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.value != pre.value) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abbbbbbbaa";
        final char[] chars = str.toCharArray();

        // 初始化nodes链表数据
        ListNode[] nodes = new ListNode[chars.length];
        for (int i = 0; i < chars.length; i++) {
            nodes[i] = new ListNode(chars[i]);
            if (i == chars.length - 1) {
                nodes[i].next = null;
            }
            if (i - 1 >= 0) {
                nodes[i - 1].next = nodes[i];
            }
        }
        final boolean palindrome = isPalindrome(nodes[0]);
        System.out.println("字符串【" + str + "】" + (palindrome ? "是回文" : "不是回文"));
    }
}

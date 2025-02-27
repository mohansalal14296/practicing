package org.example;

import java.util.*;
import java.util.LinkedList;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
public class ZigZagQueue {
    public static void main(String[] args) {
        TreeNode newNode = new TreeNode(1);
        newNode.left = new TreeNode(2);
        newNode.right = new TreeNode(3);
        newNode.left.left = new TreeNode(4);
        newNode.left.right = null;
        newNode.right.left = null;
        newNode.right.right = new TreeNode(5);
        ;
        System.out.println(zigzagLevelOrder(newNode));

/*        Deque<Integer> dq = new LinkedList<>();
        dq.offer(2);
        dq.offer(3);
        System.out.println(dq);
        dq.pollLast();
        System.out.println(dq);
        dq.addFirst(8);
        dq.addLast(9);
        System.out.println(dq);*/
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean even = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> current = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                System.out.println(even);
                TreeNode tmp = null;
                if (!even) {
                    tmp = q.pollFirst();
                    if (tmp.right != null)
                        q.addLast(tmp.right);

                    if (tmp.left != null)
                        q.addLast(tmp.left);

                } else {
                    tmp = q.pollLast();
                    if (tmp.left != null)
                        q.addFirst(tmp.left);

                    if (tmp.right != null)
                        q.addFirst(tmp.right);

                }
                current.add(tmp.val);
            }
            even = !even;
            result.add(current);
        }
        return result;
    }
}
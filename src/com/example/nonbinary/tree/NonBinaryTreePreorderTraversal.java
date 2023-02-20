package com.example.nonbinary.tree;

import java.util.*;

/*
Task #589
Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal.
Each group of children is separated by the null value

Example #1
Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]
 */
public class NonBinaryTreePreorderTraversal {

    public static void main(String[] args) {
        Integer[] arr = {1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14};
        LinkedList<Integer> values = new LinkedList<>(Arrays.asList(arr));
        Node root = new Node(values.remove());
        values.remove(); //null after root
        Queue<Node> rootAsList = new LinkedList<>();
        rootAsList.add(root);
        NaryTreeUtil.fillInNextLevelRoots(rootAsList, values);
        preorder(root);
    }

    public static List<Integer> preorder(Node root) {
        List<Integer> l = new ArrayList<>();
        traverse(l, root);
        return l;
    }

    public static void traverse(List<Integer> l, Node root) {
        if (root == null) {
            return;
        }
        l.add(root.val);
        if (root.children != null) {
            for (Node e : root.children) {
                traverse(l, e);
            }
        }
    }
}

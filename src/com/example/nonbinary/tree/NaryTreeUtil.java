package com.example.nonbinary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class NaryTreeUtil {
    public static void fillInNextLevelRoots(Queue<Node> nextLevelRoots, LinkedList<Integer> values) {
        if (values.size() == 0) {
            return;
        }
        Queue<Node> newNextLevelRoots = new LinkedList<>();
        while (!nextLevelRoots.isEmpty()) {
            Node node = fillInTreeNode(nextLevelRoots.poll(), values);
            if (node != null && node.children.size() > 0) {
                newNextLevelRoots.addAll(node.children);
            }
        }
        fillInNextLevelRoots(newNextLevelRoots, values);
    }

    public static Node fillInTreeNode(Node root, LinkedList<Integer> values) {
        Integer value = values.poll();
        if (value == null) {
            return null;
        }
        root.children = new LinkedList<>();
        while (value != null) {
            Node child = new Node(value);
            root.children.add(child);
            value = values.poll();
        }
        return root;
    }
}

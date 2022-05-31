package CopyListwithRandomPointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node node = head;
        Node prevNode = null;
        while (node != null) {
            Node newNode = new Node(node.val);
            map.put(node, newNode);
            node = node.next;
            if (prevNode == null) {
                prevNode = newNode;
            } else {
                prevNode.next = newNode;
                prevNode = prevNode.next;
            }
        }
        node = head;
        while (node != null) {
            if (node.random != null) {
                Node newNode = map.get(node);
                newNode.random = map.get(node.random);
            }
            node = node.next;
        }
        return map.get(head);
    }
}

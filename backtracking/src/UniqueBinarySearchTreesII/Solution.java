package UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] list = new List[n + 1];
        list[0] = new ArrayList<>();
        list[0].add(null);

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            int left = 0;
            int right = i - 1;
            while (left <= i - 1 && right >= 0) {
                for (TreeNode l: list[left]) {
                    for (TreeNode r: list[right]) {
                        TreeNode newNode = new TreeNode(left + 1);
                        newNode.left = l;
                        newNode.right = deepCopy(r, left + 1);
                        list[i].add(newNode);
                    }
                }
                left++;
                right--;
            }
        }

        return list[n];
    }

    private TreeNode deepCopy(TreeNode node, int n) {
        if (node == null) {
            return null;
        }
        TreeNode newNode = new TreeNode(node.val + n);
        newNode.right = deepCopy(node.right, n);
        newNode.left = deepCopy(node.left, n);

        return newNode;
    }
}

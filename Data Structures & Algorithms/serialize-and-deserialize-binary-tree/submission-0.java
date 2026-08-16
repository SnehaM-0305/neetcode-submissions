/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    public String serialize(TreeNode root) {
    if (root == null) return "";

    StringBuilder s = new StringBuilder();
    Queue<TreeNode> q = new LinkedList<>();

    q.offer(root);

    while (!q.isEmpty()) {
        TreeNode curr = q.poll();

        if (curr == null) {
            s.append("# ");
            continue;
        }

        s.append(curr.val).append(" ");

        q.offer(curr.left);
        q.offer(curr.right);
    }

    return s.toString();
}

    // Decodes your encoded data to tree.
   public TreeNode deserialize(String data) {
    if (data.equals("")) return null;

    String[] val = data.split(" ");
    TreeNode root = new TreeNode(Integer.parseInt(val[0]));

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    int i = 1;

    while (!q.isEmpty()) {
        TreeNode parent = q.poll();

        if (i < val.length && !val[i].equals("#")) {
            TreeNode left = new TreeNode(Integer.parseInt(val[i]));
            parent.left = left;
            q.offer(left);
        }
        i++;

        if (i < val.length && !val[i].equals("#")) {
            TreeNode right = new TreeNode(Integer.parseInt(val[i]));
            parent.right = right;
            q.offer(right);
        }
        i++;
    }

    return root;
}
}

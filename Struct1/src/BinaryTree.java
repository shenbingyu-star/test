public class BinaryTree {
    // 定义树节点类
    private static class TreeNode {
        int data;       // 数据域
        TreeNode left;  // 左子节点
        TreeNode right; // 右子节点

        // 构造函数
        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root; // 树的根节点

    // 构造函数，初始化空树
    public BinaryTree() {
        this.root = null;
    }

    // 插入节点
    public void insert(int value) {
        root = insertRec(root, value);
    }

    // 递归插入节点
    private TreeNode insertRec(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value < node.data) {
            node.left = insertRec(node.left, value);
        } else if (value > node.data) {
            node.right = insertRec(node.right, value);
        }
        return node;
    }

    // 删除节点
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    // 递归删除节点
    private TreeNode deleteRec(TreeNode node, int value) {
        if (node == null) {
            return null;
        }
        if (value < node.data) {
            node.left = deleteRec(node.left, value);
        } else if (value > node.data) {
            node.right = deleteRec(node.right, value);
        } else {
            // 要删除的节点找到了
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            // 节点有两个子节点，用右子树的最小值替换要删除的节点
            node.data = findMin(node.right);
            node.right = deleteRec(node.right, node.data);
        }
        return node;
    }

    // 查找最小值
    private int findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    // 查找节点
    public boolean search(int value) {
        return searchRec(root, value);
    }

    // 递归查找节点
    private boolean searchRec(TreeNode node, int value) {
        if (node == null) {
            return false;
        }
        if (node.data == value) {
            return true;
        }
        if (value < node.data) {
            return searchRec(node.left, value);
        } else {
            return searchRec(node.right, value);
        }
    }

    // 前序遍历
    public void preorder() {
        preorderRec(root);
    }

    // 递归前序遍历
    private void preorderRec(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorderRec(node.left);
        preorderRec(node.right);
    }

    // 中序遍历
    public void inorder() {
        inorderRec(root);
    }

    // 递归中序遍历
    private void inorderRec(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderRec(node.left);
        System.out.print(node.data + " ");
        inorderRec(node.right);
    }

    // 后序遍历
    public void postorder() {
        postorderRec(root);
    }

    // 递归后序遍历
    private void postorderRec(TreeNode node) {
        if (node == null) {
            return;
        }
        postorderRec(node.left);
        postorderRec(node.right);
        System.out.print(node.data + " ");
    }

    // 测试代码
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // 插入节点
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("前序遍历：");
        tree.preorder();
        System.out.println();

        System.out.println("中序遍历：");
        tree.inorder();
        System.out.println();

        System.out.println("后序遍历：");
        tree.postorder();
        System.out.println();

        // 查找节点
        System.out.println("查找值为40的节点：" + tree.search(40));

        // 删除节点
        tree.delete(20);
        System.out.println("删除值为20的节点后，中序遍历：");
        tree.inorder();
        System.out.println();
    }
}
package com.yjr.dataStructure.tree.BST;

/**
 * @author yangjiuran
 * @Date 2020/12/17
 */
public class BinaraySortTree {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        Tree tree = new Tree();
        for (int i = 0; i < arr.length; i++) {
            tree.add(new Node(arr[i]));
        }
        tree.preOrder();
        System.out.println("-----");
        tree.delNode(12);
        tree.delNode(7);
        tree.delNode(3);
        tree.delNode(10);
        tree.delNode(5);
        tree.delNode(1);
        tree.delNode(9);
        tree.preOrder();
    }
}

class Tree {
    Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void preOrder() {
        if (root == null) {
            return;
        }
        root.preOrder();
    }

    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 删除右子树最小的节点
     */
    public int delRightTreeMin(Node node) {
        Node targetNode = node;
        while (targetNode.left != null) {
            targetNode = targetNode.left;
        }
        delNode(targetNode.value);
        return targetNode.value;
    }

    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            Node delNode = search(value);
            Node parent = searchParent(value);
            if (parent == null && delNode != null && root.left == null && root.right == null && delNode.value == root.value) {
                root = null;
            }

            if (delNode.left == null && delNode.right == null) {
                //要删除的节点是 叶子节点（不包含子树）
                if (parent.left != null && parent.left.value == value) {
                    if (delNode.left == null && delNode.right == null) {
                        parent.left = null;
                    }
                } else if (parent.right != null && parent.right.value == value) {
                    if (delNode.right == null && delNode.right == null) {
                        parent.right = null;
                    }
                }
            } else if (delNode.left != null && delNode.right != null) {
                //有两颗子树的情况
                //找到要删除节点子树中最小的节点，按BTS生成规则，在left子树中找，删除min节点，将min节点的value赋予当前节点
                int i = delRightTreeMin(delNode.right);
                delNode.value = i;
            } else {
                //有一颗子树的情况
                if (delNode.left != null) {
                    if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = delNode.left;
                        } else {
                            parent.right = delNode.left;
                        }
                    } else {
                        delNode.value = delNode.left.value;
                        delNode.left = null;
                    }
                } else {
                    if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = delNode.right;
                        } else {
                            parent.right = delNode.right;
                        }
                    } else {
                        delNode.value = delNode.right.value;
                        delNode.right = null;
                    }
                }
            }
        }
    }
}

class Node {
    public int value;
    public Node left;
    public Node right;

    /**
     * 查询父节点
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (this.value > value && this.left != null) {
                return this.left.searchParent(value);
            } else if (this.value < value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    /**
     * 查询要删除的节点
     *
     * @param value
     */
    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else {
            if (this.value > value && this.left != null) {
                return this.left.search(value);
            } else if (this.value <= value && this.right != null) {
                return this.right.search(value);
            } else {
                return null;
            }
        }
    }

    public Node(int value) {
        this.value = value;
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (this.value > node.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    public void preOrder() {
        if (this.left != null) {
            this.left.preOrder();
        }
        System.out.println(this.value);
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}

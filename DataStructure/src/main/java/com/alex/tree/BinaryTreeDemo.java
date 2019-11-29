package com.alex.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的结点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        System.out.println("前序遍历");
        BinaryTree.preOrder(binaryTree.getRoot());
        System.out.println("后序遍历");
        BinaryTree.postOrder(binaryTree.getRoot());
        System.out.println("中序遍历");
        BinaryTree.infixOrder(binaryTree.getRoot());
        System.out.println("=======================================");
        System.out.println(BinaryTree.preOrderSearch(binaryTree.getRoot(), 5));
        System.out.println("====================================");
        BinaryTree.delNode(binaryTree.getRoot(), 1);
        System.out.println("删除节点测试");
        BinaryTree.preOrder(binaryTree.getRoot());
    }
}

//定义一个BinaryTree 二叉树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public HeroNode getRoot() {
        return root;
    }

    //删除二叉树节点
    public static void delNode(HeroNode root, int no) {
        if (root != null && root.getNo() == no) {
            root.setRight(null);
            root.setLeft(null);
            root = null;
            return;
            // delNode(root.getLeft(), no);
            // delNode(root.getRight(), no);
        }
        if (root.getLeft() != null && root.getLeft().getNo() == no) {
            root.setLeft(null);
            return;
        }
        if (root.getRight() != null && root.getRight().getNo() == no) {
            root.setRight(null);
            return;
        }
        if (root.getLeft() != null) {
            delNode(root.getLeft(), no);
        }
        if (root.getRight() != null) {
            delNode(root.getRight(), no);
        }
    }

    //前序遍历查找
    public static HeroNode preOrderSearch(HeroNode root, int no) {

        // if (root == null) {
        //     return null;
        // } else if (root != null && root.getNo() == no) {
        //     return root;
        // } else {
        //     HeroNode node1 = preOrderSearch(root.getLeft(), no);
        //     HeroNode node2 = preOrderSearch(root.getRight(), no);
        //     if (node1 != null && node1.getNo() == no) {
        //         return node1;
        //     } else if (node2 != null && node2.getNo() == no) {
        //         return node2;
        //     } else {
        //         return null;
        //     }
        // }

        if (root == null) {
            return null;
        } else {
            if (root.getNo() == no) {
                return root;
            }
            HeroNode node1 = preOrderSearch(root.getLeft(), no);
            HeroNode node2 = preOrderSearch(root.getRight(), no);
            if (node1 != null) {
                return node1;
            } else if (node2 != null) {
                return node2;
            } else {
                return null;
            }
        }

    }

    //    编写前序遍历的方法

    public static void preOrder(HeroNode root) {
        if (root != null) {
            System.out.println(root);
            //    递归向左子树前序遍历
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    //    编写中序遍历的方法
    public static void infixOrder(HeroNode root) {
        if (root != null) {
            infixOrder(root.getLeft());
            System.out.println(root);
            infixOrder(root.getRight());
        }
    }

    //    编写后序遍历的方法
    public static void postOrder(HeroNode root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root);
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
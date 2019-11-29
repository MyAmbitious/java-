package com.alex.binarysorttree;

/**
 * 删除BST节点的三种情况
 * 第一种情况:
 * 删除叶子节点 (比如：2, 5, 9, 12)
 * 思路
 * (1) 需求先去找到要删除的结点  targetNode
 * (2)  找到targetNode 的 父结点 parent
 * (3)  确定 targetNode 是 parent的左子结点 还是右子结点
 * (4)  根据前面的情况来对应删除
 * 左子结点 parent.left = null
 * 右子结点 parent.right = null;
 * 第二种情况: 删除只有一颗子树的节点 比如 1
 * 思路
 * (1) 需求先去找到要删除的结点  targetNode
 * (2)  找到targetNode 的 父结点 parent
 * (3) 确定targetNode 的子结点是左子结点还是右子结点
 * (4) targetNode 是 parent 的左子结点还是右子结点
 * (5) 如果targetNode 有左子结点
 * 5. 1 如果 targetNode 是 parent 的左子结点
 * parent.left = targetNode.left;
 * 5.2  如果 targetNode 是 parent 的右子结点
 * parent.right = targetNode.left;
 * (6) 如果targetNode 有右子结点
 * 6.1 如果 targetNode 是 parent 的左子结点
 * parent.left = targetNode.right;
 * <p>
 * <p>
 * <p>
 * 情况三 ： 删除有两颗子树的节点. (比如：7, 3，10 )
 * 思路
 * (1) 需求先去找到要删除的结点  targetNode
 * (2)  找到targetNode 的 父结点 parent
 * (3)  从targetNode 的右子树找到最小的结点 或者从targetNode 的左子树找到最大的结点
 * (4) 用一个临时变量，将 最小（大）结点的值保存 temp = 11
 * (5)  删除该最小（大）结点
 * (6)  targetNode.value = temp
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        // int[] arr = {7, 3, 10, 12, 5, 1, 9, 0};
        int[] arr = { 7};
        BinarySortTree binarySortTree = new BinarySortTree();
        //    循环的添加节点到二叉树
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        // //    中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树");
        binarySortTree.infixOrder();
        // //    测试单独添加节点到二叉排序树 观察其插入位置
        // binarySortTree.add(new Node(2));
        // System.out.println("中序遍历二叉排序树");
        // binarySortTree.infixOrder();
        //  测试删除叶子节点
        // binarySortTree.delNode(2);

        // System.out.println("删除叶子节点之后的二叉排序的情况");
        // binarySortTree.infixOrder();
        // System.out.println("删除有一个子数的节点之后的二叉排序的情况");
        // binarySortTree.delNode(1);
        // binarySortTree.infixOrder();
        System.out.println("删除有两颗子树节点之后的二叉排序的情况");
        binarySortTree.delNode(7);
        binarySortTree.infixOrder();

    }
}

class BinarySortTree {
    private Node root;

    //返回以node为根节点的二叉搜索树的最小节点的值
    //删除node为根节点的二叉排序树的最小节点
    public int delRightTreeMin(Node node) {
        Node target = node;
        //    循环的查找其左子树 就会找到最小值
        while (target.left != null) {
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    //返回以node为根节点的二叉搜索树的最小节点的值
    //删除node为根节点的二叉排序树的最大节点
    public int delLeftTreeMax(Node node) {
        Node target = node;
        //    循环的查找其右子树 就会找到最大值
        while (target.right != null) {
            target = target.right;
        }
        delNode(target.value);
        return target.value;
    }


    //删除节点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //    1 需要先找到要删除的节点 targetNode
            Node targetNode = search(value);
            //    如果没有找到要删除的节点
            if (targetNode == null) {
                return;
            }
            //    如果此二叉树只有一个节点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            //    去找到targetNode的父节点
            final Node parent = seaarhParent(value);
            //    如果要删除的节点是叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                //判断targetNode是父节点的左子节点还是右子节点
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {//删除有两颗子树的节点
                // * 情况三 ： 删除有两颗子树的节点. (比如：7, 3，10 )
                //  * 思路
                //  * (1) 需求先去找到要删除的结点  targetNode
                //  * (2)  找到targetNode 的 父结点 parent
                //  * (3)  从targetNode 的右子树找到最小的结点 或者从targetNode 的左子树找到最大的结点
                //  * (4) 用一个临时变量，将 最小（大）结点的值保存 temp = 11
                //  * (5)  删除该最小（大）结点
                //  * (6)  targetNode.value = temp
                // targetNode.value = delRightTreeMin(targetNode.right);
                targetNode.value = delLeftTreeMax(targetNode.left);

            } else {//删除只有一颗子树的节点
                //要删除的节点有左子节点
                if (targetNode.left != null) {
                    //    如果targetNode是parent的左子节点
                    if (parent == null) {
                        root = targetNode.left;
                    } else if (parent.left.value == value) {
                        parent.left = targetNode.left;
                    } else { //    如果targetNode是parent的右子节点
                        parent.right = targetNode.left;
                    }

                } else {//要删除的节点有有子节点
                    //    如果targetNode是parent的左子节点
                    if (parent == null) {
                        root = targetNode.right;
                    } else if (parent.left.value == value) {
                        parent.left = targetNode.right;
                    } else { //    如果targetNode是parent的右子节点
                        parent.right = targetNode.right;
                    }
                }

            }

        }
    }


    //查找要删除的节点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找要删除的节点的父节点
    public Node seaarhParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.seaarhParent(value);
        }
    }

    //    添加节点的方法
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //    中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空，不能遍历");
        }
    }

}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }


    //查找要删除节点的父节点
    public Node seaarhParent(int value) {
        //    如果当前节点就是要删除节点的父节点 就返回
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else if (value >= this.value && this.right != null) {
            return this.right.seaarhParent(value);
        } else if (value < this.value && this.left != null) {
            return this.left.seaarhParent(value);
        } else {
            return null; //没有找到父节点
        }
    }


    //查找要删除的节点

    /**
     * @param value 希望删除的节点的值
     * @return
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {//如果查找的值小于当前节点 向左子树递归查找
            //    如果左子节点为空
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {//如果查找的值不小于当前节点 则向右子树递归查找
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
        // if (this != null) {
        //     if(this.value==value){
        //         return this;
        //     }
        //     this.left.search(value);
        //      this.right.search(value);
        // }
        // return null;
    }


    //    递归的形式添加节点 注意满足二叉排序树的要求
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //    判断传入节点的值和当前子树跟节点的值关系
        if (node.value < this.value) {
            //    如果当前节点左子节点为null
            if (this.left == null) {
                this.left = node;
            } else {
                //    递归的向左子树添加
                this.left.add(node);
            }
        } else {//添加节点的值大于等于当前节点的值
            if (this.right == null) {
                this.right = node;
            } else {
                //递归地向右子节点添加
                this.right.add(node);
            }

        }
    }

    //    中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

}
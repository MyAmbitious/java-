package com.alex.avl;

public class AvlTreeDemo {
    public static void main(String[] args) {
        // int[] arr = {4, 3, 6, 5, 7, 8};
        // int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = {10, 11, 7, 6, 8, 9};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        //    遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();
        System.out.println(avlTree.getRoot().height());
        System.out.println(avlTree.getRoot().left.height());
        System.out.println(avlTree.getRoot().right.height());
        System.out.println(avlTree.getRoot());
        System.out.println(avlTree.getRoot().left);
    }
}

class AVLTree {
    private Node root;

    //
    // public void  leftRotate(){
    //     if(root==null){
    //         System.out.println();
    //     }
    // }

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


    public Node getRoot() {
        return root;
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

    //返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    //返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    //返回以该节点为根节点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //左旋转的方法
    private void leftRotate() {
        //    创建新的节点 作为当前根节点的值
        Node newNode = new Node(value);
        //    把新节点的左子树设置成当前节点的左子树
        newNode.left = left;
        //    把新节点的右子树设置为当前节点的右子树的左子树
        newNode.right = right.left;
        //    把当前节点的值换为右子节点的值
        value = right.value;
        //    把当前节点的右子树设置为右子树的右子树
        right = right.right;
        //    把当前节点的左子树设置为新节点
        left = newNode;
    }

    //右旋转的方法
    private void rightRotate() {
        //    创建一个新节点 值等于当前根节点的值
        Node newNode = new Node(value);
        //    把新节点的右子树设置成当前节点的右子树
        newNode.right = right;
        //    把新节点的左子树设置为当前节点的左子树的右子树
        newNode.left = left.right;
        //    把当前节点的值换为左子节点的值
        value = left.value;
        //    把当前节点的左子树设置为左子树的左子树
        left = left.left;
        //    把当前节点的右子树设置为新节点
        right = newNode;
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
        //    当添加完一个节点后 如果（右子树高度-左子树的高度)>1,左旋转
        if (rightHeight() - leftHeight() > 1) {
            //如果它的右子树的左子树高度大于它的右子树的高度
            if(right!=null&&right.leftHeight()>right.rightHeight()){
                //先对当前节点的右节点进行右旋转
                right.rightRotate();
            }
            //     再对当前节点进行左旋转
            leftRotate();
            return;//必须要！调整完之后没有必要再次调整
        }
        //    当添加完一个节点后 如果（左子树高度-右子树的高度)>1,右旋转
        if (leftHeight() - rightHeight() > 1) {
            //如果它的左子树的右子树高度大于他的左子树的高度
            if(left!=null&&left.rightHeight()>left.leftHeight()){
                //先对当前节点的左节点进行左旋转
                left.leftRotate();
            }
            //    再对当前节点进行右旋转
            rightRotate();
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
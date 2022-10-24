/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarytree;

/**
 *
 * @author musasina
 */
public class BinaryTree<AnyType> {

    TreeNode<AnyType> root;
    TreeNode<AnyType> treversal;

    public BinaryTree() {
        this.root = null;
        this.treversal = null;
    }

    TreeNode<AnyType> recursiveSearch(int value) {

        if (treversal.data == null) {
            treversal = this.root;
            return null;
        }
        if (Integer.parseInt(treversal.data.toString()) == value) {
            return treversal;
        } else {
            if (Integer.parseInt(treversal.data.toString()) > value) {
                treversal = treversal.left;
                return this.recursiveSearch(value);
            } else {
                treversal = treversal.right;
                return this.recursiveSearch(value);
            }
        }
    }

    public TreeNode getTreversal() {
        return this.treversal;
    }

    TreeNode<AnyType> iterativeSearch(int value) {
        this.treversal = this.root;
        while (treversal.data != null) {
            if (Integer.parseInt(treversal.data.toString()) == value) {
                this.treversalHelper();
                return this.treversal;
            } else {
                if (Integer.parseInt(treversal.data.toString()) > value) {
                    treversal = treversal.left;
                } else {
                    treversal = treversal.right;
                }
            }
        }
        return null;
    }

    private void initiliazeTree(TreeNode node) {
        this.root = node;
        this.treversal = root;
    }

    void treversalHelper() {
        this.treversal = this.root;
    }

    void insert(int value) {
        TreeNode prev_tmp = null;
        TreeNode tmp = this.root;
        while (tmp != null) {
            prev_tmp = tmp;
            if (Integer.parseInt(tmp.data.toString()) > value) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        if (prev_tmp == null) {
            this.root = new TreeNode(value);
        } else {
            if (Integer.parseInt(prev_tmp.data.toString()) > value) {
                prev_tmp.left = new TreeNode(value);
            } else {
                prev_tmp.right = new TreeNode(value);
            }
        }

    }

    TreeNode<AnyType> iterativeMinSearch() {
        this.treversal = this.root;
        while (this.treversal.left != null) {
            treversal = treversal.left;
        }
        TreeNode<AnyType> tmp = treversal;
        treversal = this.root;
        return tmp;
    }

    TreeNode<AnyType> recursiveMinSearch() {
        if (this.treversal.left == null) {
            TreeNode<AnyType> tmp = this.treversal;
            this.treversalHelper();
            return tmp;
        } else {
            return this.recursiveMinSearch();
        }
    }

    TreeNode<AnyType> iterativeMaxSarch() {
        this.treversal = this.root;
        while (this.treversal.right != null) {
            this.treversal = this.treversal.right;
        }
        TreeNode<AnyType> tmp = this.treversal;
        this.treversalHelper();
        return tmp;
    }

    TreeNode<AnyType> recursiveMaxSearch() {
        if (this.treversal.right == null) {
            TreeNode<AnyType> tmp = this.treversal;
            this.treversalHelper();
            return tmp;
        } else {
            return this.recursiveMaxSearch();
        }
    }

    void delete(int value) {
        this.treversalHelper();
        this.deletePriv(value);
        this.treversalHelper();
    }

    private void deletePriv(int value) {
        TreeNode num_tmp = null, prev_tmp = null, tmp = this.root;
        while (Integer.parseInt(tmp.data.toString()) != value) {
            if (Integer.parseInt(tmp.data.toString()) > value) {
                this.treversal = tmp;
                tmp = tmp.left;
            } else {
                this.treversal = tmp;
                tmp = tmp.right;
            }
        }
        int del_num = Integer.parseInt(tmp.data.toString());
        while (true) {
            if (tmp.left != null) {
                prev_tmp = tmp.left;
                num_tmp = tmp.left.iterativeMaxSarch();
            }
            if (num_tmp == null && tmp.right != null) {
                prev_tmp = tmp.right;
                num_tmp = tmp.right.iterativeMinSearch();
            }
            if (num_tmp != null) {
                tmp.data = num_tmp.data;
            }
            if (prev_tmp == num_tmp && prev_tmp != null) {
                if (Integer.parseInt(prev_tmp.data.toString()) >= del_num) {
                    tmp.right = null;
                    break;
                } else if (Integer.parseInt(prev_tmp.data.toString()) < del_num) {
                    tmp.left = null;
                    break;
                }

            }
            if (prev_tmp == null && num_tmp == null) {
                if (Integer.parseInt(this.treversal.data.toString()) > del_num) {
                    this.treversal.left = null;
                    break;
                } else {
                    this.treversal.right = null;
                    break;
                }
            }
            tmp = num_tmp;
        }

    }

    void printTree() {
        this.treversalHelper();
        this.printTreePriv(this.treversal);
        this.treversalHelper();
    }

    private void printTreePriv(TreeNode node) {
        if (node != null) {
            System.out.println(node.data.toString());
            this.printTreePriv(node.left);
            this.printTreePriv(node.right);
        }

    }

    void preorder() {
        this.treversalHelper();
        this.preorderPriv(this.treversal);
        this.treversalHelper();
    }

    private void preorderPriv(TreeNode node) {
        System.out.print(node.data.toString());
        if (node.left != null) {
            this.preorderPriv(node.left);
        }
        if (node.right != null) {
            this.preorderPriv(node.right);
        }
    }

    void inorder() {
        this.treversalHelper();
        this.inorderPriv(this.treversal);
        this.treversalHelper();
    }

    private void inorderPriv(TreeNode node) {
        if (node.left != null) {
            this.inorderPriv(node.left);
        }
        System.out.print(node.data.toString());
        if (node.right != null) {
            this.inorderPriv(node.right);
        }
    }

    void postorder() {
        this.treversalHelper();
        this.postorderPriv(this.treversal);
        this.treversalHelper();
    }

    private void postorderPriv(TreeNode node) {
        if (node.left != null) {
            this.postorderPriv(node.left);
        }
        if (node.right != null) {
            this.postorderPriv(node.right);
        }
        System.out.print(node.data.toString());
    }

    int nodeCountWithStack() {
        TreeNode tree_node = this.root;
        Node<TreeNode> stack_node;
        Stackll<TreeNode> stack = new Stackll();
        int count = 0;
        if (tree_node == null) {
            return count;
        } else {
            stack_node = new Node(tree_node);
            stack.push(stack_node);
        }

        while (!stack.isEmpty()) {
            stack_node = stack.pop();
            count++;
            tree_node = stack_node.data;
            if (tree_node.left != null) {
                stack_node = new Node(tree_node.left);
                stack.push(stack_node);
            }
            if (tree_node.right != null) {
                stack_node = new Node(tree_node.right);
                stack.push(stack_node);
            }
        }
        return count;
    }

    int nodeCountWithQueue() {
        TreeNode treeNode = this.root;
        Node<TreeNode> queueNode;
        Queuell<TreeNode> queue = new Queuell();
        int count = 0;
        if (treeNode == null) {
            return count;
        } else {
            queueNode = new Node(treeNode);
            queue.enqueue(queueNode);
        }

        while (!queue.isEmpty()) {
            queueNode = queue.dequeue();
            treeNode = queueNode.data;
            count++;

            if (treeNode.left != null) {
                queueNode = new Node(treeNode.left);
                queue.enqueue(queueNode);
            }
            if (treeNode.right != null) {
                queueNode = new Node(treeNode.right);
                queue.enqueue(queueNode);
            }
        }
        return count;
    }

    int height() {
        this.treversalHelper();
        int count = this.heightPriv(this.root);
        this.treversalHelper();
        return count;
    }

    int heightPriv(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        int num1 = 0, num2 = 0;
        if (node.left != null || node.right != null) {
            count++;
            if (node.left != null) {
                num1 = count + this.heightPriv(node.left);
            }
            if (node.right != null) {
                num2 = count + this.heightPriv(node.right);
            }
        }
        if (num2 > num1) {
            return num2;
        } else {
            return num1;
        }
    }

    TreeNode rotateLeft(TreeNode node) {
        if (node != null) {
            TreeNode tmp = node.left;
            node.left = tmp.right;
            tmp.right = node;
            return tmp;
        }
        return null;
    }

    TreeNode rotateRight(TreeNode node) {
        if (node != null) {
            TreeNode tmp = node.right;
            node.right = tmp.left;
            tmp.left = node;
            return tmp;
        }
        return null;
    }

    TreeNode stabilizer(TreeNode node) {
        if (node != null) {
            int leftHeight = this.heightPriv(node.left);
            int rightHeight = this.heightPriv(node.right);
            if (rightHeight != leftHeight) {
                if (leftHeight < rightHeight) {
                    while (leftHeight != rightHeight && leftHeight + 1 != rightHeight && rightHeight + 1 != leftHeight) {

                        if (node.right != null) {
                            node = this.rotateRight(node);
                        }
                        leftHeight = this.heightPriv(node.left);
                        rightHeight = this.heightPriv(node.right);
                    }
                }
                if (rightHeight < leftHeight) {
                    while (leftHeight != rightHeight && leftHeight + 1 != rightHeight && rightHeight + 1 != leftHeight) {

                        if (node.left != null) {
                            node = this.rotateLeft(node);
                        }
                        leftHeight = this.heightPriv(node.left);
                        rightHeight = this.heightPriv(node.right);
                    }

                }
                if (node.left != null || node.right != null) {
                    node.left = this.stabilizer(node.left);
                    node.right = this.stabilizer(node.right);
                }
            }return node;
        }
        return null;

    }

}

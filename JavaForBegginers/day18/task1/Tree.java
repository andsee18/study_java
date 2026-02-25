package day18.task1;

import java.util.Stack;

public class Tree {
    private Node rootNode;

    public Tree() {
        rootNode = null;
    }

    public Node findNodeByValue(int value){
        Node currentNode = rootNode;
        while(value!= currentNode.getValue()){
            if (value< currentNode.getValue()){
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }

    public void insertNode(int value) {
        Node newNode = new Node();
        newNode.setValue(value);
        if (rootNode == null) {
            rootNode = newNode;
        } else {
            Node currentNode = rootNode;
            Node parentNode;
            while (true) {
                parentNode = currentNode;
                if (value == currentNode.getValue()) {
                    return;
                } else if (value < currentNode.getValue()) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) {
                        parentNode.setLeftChild(newNode);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parentNode.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public boolean deleteNode(int value) {
        Node currentNode = rootNode;
        Node parentNode = rootNode;
        boolean isLeftChild = true;
        while (currentNode.getValue() != value) {
            parentNode = currentNode;
            if (value < currentNode.getValue()) {
                currentNode = currentNode.getLeftChild();
                isLeftChild = true;
            } else {
                currentNode = currentNode.getRightChild();
                isLeftChild = false;
            }
            if (currentNode == null) {
                return false;
            }
        }
        if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            if (currentNode == rootNode) {
                rootNode = null;
            } else if (isLeftChild) {
                parentNode.setLeftChild(null);
            } else {
                parentNode.setRightChild(null);
            }
        } else if (currentNode.getRightChild() == null) {
            if (currentNode == rootNode) {
                rootNode = currentNode.getLeftChild();
            } else if (isLeftChild) {
                parentNode.setLeftChild(currentNode.getLeftChild());
            } else {
                parentNode.setLeftChild(currentNode.getRightChild());
            }
        } else if (currentNode.getLeftChild() == null) {
            if (currentNode == rootNode) {
                rootNode = currentNode.getRightChild();
            } else if (isLeftChild) {
                parentNode.setLeftChild(currentNode.getRightChild());
            } else {
                parentNode.setRightChild(currentNode.getRightChild());
            }
        } else {
            Node heirNode = receiveHeir(currentNode);
            if (currentNode == rootNode) {
                rootNode = heirNode;
            } else if (isLeftChild) {
                parentNode.setLeftChild(heirNode);
            } else {
                parentNode.setRightChild(heirNode);
            }
        }
        return true;
    }

    private Node receiveHeir(Node node) {
        Node parentNode = node;
        Node currentNode = node;
        Node heirNode = node;
        while (currentNode != null) {
            parentNode = heirNode;
            heirNode = currentNode;
            currentNode = currentNode.getRightChild();
            if (heirNode != node.getRightChild()) {
                parentNode.setLeftChild(heirNode.getRightChild());
                heirNode.setRightChild(node.getRightChild());
            }
        }
        return heirNode;
    }

    public void printTree() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(rootNode);
        boolean isRowEmpty = false;
        while (isRowEmpty == false) {
            Stack<Node> localStack = new Stack<>();
            isRowEmpty = true;
            while (globalStack.isEmpty() == false) {
                Node temp = globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getValue() + " ");

                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null || temp.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("---");
                    localStack.push(null);
                    localStack.push(null);
                }
            }
            System.out.println();

            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }
    }

}

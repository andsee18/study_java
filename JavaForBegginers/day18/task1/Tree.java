package day18.task1;

import java.util.Stack;

public class Tree {
    private Node rootNode;

    public Tree() {
        rootNode = null;
    }

    public Node findNode(int value) {
        Node currentNode = rootNode;
        if (rootNode == null) {
            return null;
        }
        while (value != currentNode.getValue()) {
            if (value < currentNode.getValue()) {
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
        Node node = new Node();
        node.setValue(value);
        if (rootNode == null) {
            rootNode = node;
        } else {
            Node currentNode = rootNode;
            Node parrentNode;
            while (true) {
                parrentNode = currentNode;
                if (value < currentNode.getValue()) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) {
                        parrentNode.setLeftChild(node);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parrentNode.setRightChild(node);
                        return;
                    }
                }
            }
        }

    }

    public boolean deleteNode(int value) {
        Node currentNode = rootNode;
        Node parrentNode = rootNode;
        boolean isLeftChild = false;
        while (value != currentNode.getValue()) {
            parrentNode = currentNode;
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
                parrentNode.setLeftChild(null);
            } else {
                parrentNode.setRightChild(null);
            }
            return true;
        } else if (currentNode.getRightChild() == null) {
            if (currentNode == rootNode) {
                rootNode = currentNode.getLeftChild();
            } else if (isLeftChild) {
                parrentNode.setLeftChild(currentNode.getLeftChild());
            } else {
                parrentNode.setRightChild(currentNode.getLeftChild());
            }
            return true;
        } else if (currentNode.getLeftChild() == null) {
            if (currentNode == rootNode) {
                rootNode = currentNode.getRightChild();
            } else if (isLeftChild) {
                parrentNode.setLeftChild(currentNode.getRightChild());
            } else {
                parrentNode.setRightChild((currentNode.getRightChild()));
            }
            return true;
        } else {
            Node heir = receiveHeir(currentNode);
            if (currentNode == rootNode) {
                rootNode = heir;
            } else if (isLeftChild) {
                parrentNode.setLeftChild(heir);
            } else {
                parrentNode.setRightChild(heir);
            }
            return true;
        }

    }

    private Node receiveHeir(Node node) {
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.getRightChild();
        while (currentNode != null) {
            parentNode = heirNode;
            heirNode = currentNode;
            currentNode = currentNode.getLeftChild();
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

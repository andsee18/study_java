package day18.task1;

public class Tree {
    public Node rootNode;

    public Tree() {
        rootNode = null;
    }

    public Node findValue(int value) {
        Node currentNode = rootNode;
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
            Node parentNode;
            while (true) {
                parentNode = currentNode;
                if (value < currentNode.getValue()) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) {
                        parentNode.setLeftChild(node);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parentNode.setRightChild(node);
                        return;
                    }
                }
            }
        }
    }

    public boolean delNode(int value) {
        Node current = rootNode;
        Node parent = rootNode;
        boolean isLeftChild = false;
        while (value != current.getValue()) {
            parent = current;
            if (value < current.getValue()) {
                current = current.getLeftChild();
                isLeftChild = true;
            } else {
                current = current.getRightChild();
                isLeftChild = false;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == rootNode) {
                rootNode = null;
            } else if (isLeftChild) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
            return true;
        } else if (current.getRightChild() == null) {
            if (current == rootNode) {
                rootNode = current.getLeftChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
            return true;
        } else if (current.getLeftChild() == null) {
            if (current == rootNode) {
                rootNode = current.getRightChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
            return true;
        } else {
            Node heir = receiveHeir(current);
            if (current == rootNode) {
                rootNode = heir;
            } else if (isLeftChild) {
                parent.setLeftChild(heir);
            } else {
                parent.setRightChild(heir);
            }
            return true;
        }
    }

    public Node receiveHeir(Node node) {
        Node parent = node;
        Node heir = node;
        Node current = node.getRightChild();
        while (current != null) {
            parent = heir;
            heir = current;
            current = current.getLeftChild();
        }
        if (heir != node.getRightChild()) {
            parent.setLeftChild(heir.getRightChild());
            heir.setRightChild(node.getRightChild());
        }
        heir.setLeftChild(node.getLeftChild());
        return heir;
    }

    public void dfs(Node node) {
        if (node == null) {
            return;
        }
        dfs(node.getLeftChild());
        System.out.println(node.getValue());
        dfs(node.getRightChild());
    }


}

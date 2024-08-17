package application;

public class AVL_Tree<T extends Comparable<T>> {

    TNode<T> root;

    public TNode<T> getRoot() {
        return root;
    }

    public void setRoot(TNode<T> root) {
        this.root = root;
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(TNode<T> root) {
        if (root != null) {
            if (root.getLeft() != null)
                traverseInOrder(root.getLeft());
            System.out.print(root.getData() + "-->");
            if (root.getRigth() != null)
                traverseInOrder(root.getRigth());
        }
    }

    public void preTraverse() {
        preTraverse(root);
    }

    public TNode<T> find(T data) {
        return find(data, root);
    }

    private TNode<T> rotateRight(TNode<T> node) {
        TNode<T> leftChild = node.getLeft();
        node.setLeft(leftChild.getRigth());
        leftChild.setRigth(node);
        return leftChild;
    }

    private TNode<T> rotateLeft(TNode<T> node) {
        TNode<T> rightChild = node.getRigth();
        node.setRigth(rightChild.getLeft());
        rightChild.setLeft(node);
        return rightChild;
    }

    private TNode<T> rotateRightLeft(TNode<T> node) {
        node.setRigth(rotateRight(node.getRigth()));
        return rotateLeft(node);
    }

    private TNode<T> rotateLeftRight(TNode<T> node) {
        node.setLeft(rotateLeft(node.getLeft()));
        return rotateRight(node);
    }

    private int getHeightDifference(TNode<T> node) {
        return height(node.getLeft()) - height(node.getRigth());
    }

    private TNode<T> rebalance(TNode<T> node) {
        int diff = getHeightDifference(node);
        if (diff > 1) {
            if (getHeightDifference(node.getLeft()) > 0) {
                node = rotateRight(node);
            } else {
                node = rotateLeftRight(node);
            }
        } else if (diff < -1) {
            if (getHeightDifference(node.getRigth()) < 0) {
                node = rotateLeft(node);
            } else {
                node = rotateRightLeft(node);
            }
        }
        return node;
    }

    private TNode<T> find(T data, TNode<T> node) {
        if (node != null) {
            int comp = node.getData().compareTo(data);
            if (comp == 0)
                return node;
            if (comp > 0 && node.hasleft())
                return find(data, node.getLeft());
            if (comp < 0 && node.hasRight())
                return find(data, node.getRigth());
        }
        return null;
    }

    public TNode<T> getSmallest() {
        return getSmallest(root);
    }

    private TNode<T> getSmallest(TNode<T> root) {
        if (root != null) {
            if (!root.hasleft())
                return root;
            return getSmallest(root.getLeft());
        }
        return null;
    }

    public TNode<T> getLargest() {
        return getLargest(root);
    }

    private TNode<T> getLargest(TNode<T> root) {
        if (root != null) {
            if (!root.hasRight())
                return root;
            return getLargest(root.getRigth());
        }
        return null;
    }

    public int height() {
        return height(root);
    }

    public void insert(T data) {
        if (isEmpty())
            root = new TNode<>(data);
        else {
            root = insert(data, root);
        }
    }

    private TNode<T> insert(T data, TNode<T> node) {
        if (node == null) {
            return new TNode<>(data);
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(insert(data, node.getLeft()));
        } else {
            node.setRigth(insert(data, node.getRigth()));
        }
        return rebalance(node);
    }

    public TNode<T> delete(T data) {
        root = delete(data, root);
        return root;
    }

    private TNode<T> delete(T data, TNode<T> node) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(delete(data, node.getLeft()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRigth(delete(data, node.getRigth()));
        } else {
            if (!node.hasleft() && !node.hasRight()) {
                return null;
            } else if (!node.hasRight()) {
                return node.getLeft();
            } else if (!node.hasleft()) {
                return node.getRigth();
            } else {
                TNode<T> successor = getSuccessor(node);
                node.setData(successor.getData());
                node.setRigth(delete(successor.getData(), node.getRigth()));
            }
        }
        return rebalance(node);
    }

    private TNode<T> getSuccessor(TNode<T> node) {
        TNode<T> current = node.getRigth();
        while (current != null && current.hasleft()) {
            current = current.getLeft();
        }
        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private int height(TNode<T> node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.getLeft()), height(node.getRigth()));
    }

    private void preTraverse(TNode<T> root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            if (root.getLeft() != null)
                preTraverse(root.getLeft());
            if (root.getRigth() != null)
                preTraverse(root.getRigth());
        }
    }

    public void postTraverse() {
        postTraverse(root);
    }

    private void postTraverse(TNode<T> root) {
        if (root != null) {
            if (root.getLeft() != null)
                postTraverse(root.getLeft());
            if (root.getRigth() != null)
                postTraverse(root.getRigth());
            System.out.print(root.getData() + " ");
        }
    }

    public Queue<T> levelOrderTraversal() {
        Queue<TNode<T>> queue = new Queue<>();
        Queue<T> ret = new Queue<>();
        if (root == null)
            return null;
        queue.enqueue(root);
        levelOrderUtil(queue, ret);
        return ret;
    }

    private void levelOrderUtil(Queue<TNode<T>> queue, Queue<T> ret) {
        if (queue.isEmpty())
            return;
        TNode<T> node = queue.dequeue();
        ret.enqueue(node.getData());
        if (node.getLeft() != null)
            queue.enqueue(node.getLeft());
        if (node.getRigth() != null)
            queue.enqueue(node.getRigth());
        levelOrderUtil(queue, ret);
    }

    public int height1() {
        return height(root);
    }

    public Queue<T> levelOrderTraversalRev() {
        Queue<TNode<T>> queue = new Queue<>();
        Queue<T> ret = new Queue<>();
        if (root == null)
            return null;
        queue.enqueue(root);
        levelOrderUtilRev(queue, ret);
        return ret;
    }

    private void levelOrderUtilRev(Queue<TNode<T>> queue, Queue<T> ret) {
        if (queue.isEmpty())
            return;
        TNode<T> node = queue.dequeue();
        ret.enqueue(node.getData());
        if (node.getRigth() != null)
            queue.enqueue(node.getRigth());
        if (node.getLeft() != null)
            queue.enqueue(node.getLeft());
        levelOrderUtilRev(queue, ret);
    }
}

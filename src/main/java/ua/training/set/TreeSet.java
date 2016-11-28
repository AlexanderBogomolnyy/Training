package ua.training.set;

import java.util.Collection;

/**
 * <p> The Tree Set implementation.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 28.11.2016.
 *
 * @param <E> type of containing data implements Comparable
 */
public class TreeSet<E extends Comparable<E>> {

	private Node<E> root;
	private int size;
	private long modCount = 0;

	public TreeSet() {
		root = null;
		size = 0;
	}

	public TreeSet(Collection<E> collection) {
		root = null;
		size = 0;
		collection.stream().forEach(this::add);
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	/**
	 * This method adds value to the set
	 *
 	 * @param value - added value
	 * @return - false if added value already presents in set
	 */
	public boolean add(E value) {
		if (find(value) != null) return false;
		Node<E> newNode = new Node<>();
		newNode.data = value;
		if (root == null)
			root = newNode;
		else {
			Node<E> current = root;
			Node<E> parent;
			while (true) {
				parent = current;
				if (value.compareTo(current.data) < 0) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						break;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						break;
					}
				}
			}
		}
		size++;
		modCount++;
		return true;
	}

	// looks for an element in set (null if it is absent)
	private Node<E> find(E value) {
		if (value == null || root == null) return null;
		Node<E> current = root;
		while (!value.equals(current.data)) {
			if (value.compareTo(current.data) < 0)
				current = current.leftChild;
			else
				current = current.rightChild;
			if (current == null)
				return null;
		}
		return current;
	}

	/**
	 * The method executes containing element in the set
	 *
	 * @param value concrete value
	 * @return true if element presents in the set
	 */
	public boolean contains(E value) {
		return find(value) != null;
	}

	/**
	 * This method removes element from the set
	 *
	 * @param value removed element
	 * @return true if element have been removed
	 */
	public boolean remove(E value) {
		if (value == null || root == null) return false;
		Node<E> current = root;
		Node<E> parent = root;
		boolean isLeftChild = true;

		// looking for element and its parent
		while (!current.data.equals(value)) {
			parent = current;
			if (value.compareTo(current.data) < 0) {
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null)
				return false;
		}

		// if no children, simply delete it
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root)
				root = null;
			else if (isLeftChild)
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}

		// if no right child, replace with left subtree
		else if (current.rightChild == null)
			if (current == root)
				root = current.leftChild;
			else if (isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;

		// if no left child, replace with right subtree
		else if (current.leftChild == null)
			if (current == root)
				root = current.rightChild;
			else if (isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;

		else // two children, so replace with inorder successor
		{
			Node<E> successor = getSuccessor(current);
			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			successor.leftChild = current.leftChild;
		}
		modCount++;
		size--;
		return true; 
	}

	// returns node with next-highest value after delNode
	// goes to right child, then right child's left descendents
	private Node<E> getSuccessor(Node<E> delNode) {
		Node<E> successorParent = delNode;
		Node<E> successor = delNode;
		Node<E> current = delNode.rightChild;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}

		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}

	/**
	 * This class provides tree node
	 *
	 * @param <E> type of containing data
	 */
	private class Node<E> {
		public E data;
		public Node<E> leftChild;
		public Node<E> rightChild;
	}

}

# Linked List

A linked list is a data structure in which the objects are arranged in a linear order. Unlike an array, however, in which the linear order is determined by the array indices, the order in a linked list is determined by a pointer in each object.

[Singly Linked List](./LL/LinkedList.java)

[Doubly Linked List](./LL/DoublyLinkedList.java)

## Advantages over arrays:
- Dynamic size
- Ease of insertion/deletion

## Drawbacks:

- Random access is not allowed. We have to access elements sequentially starting from the first node. So we cannot do binary search with linked lists. In case random access is required array or arraylist should be preferred over linked list.
- Extra memory space for a pointer is required with each element of the list.
- Arrays have better cache locality that can make a pretty big difference in performance.

---
## Arbit

- Use case of circular linked list
	
	- In a timesharing environment, the operating system must maintain a list of present users and must alternately allow each user to use a small slice of CPU time, one user at a time. The operating system will pick a user, let him/her use a small amount of CPU time and then move on to the next user, etc.
		
	- Keeping track of whose turn it is in a multi-player board game. Put all the players in a circular linked list. After a player takes his turn, advance to the next player in the list. This will cause the program to cycle indefinitely among the players.	
 	

---

## Java Linked List

```java
public class LinkedList<E>
extends AbstractSequentialList<E>
implements List<E>, Deque<E>, Cloneable, Serializable
```

Doubly-linked list implementation. Implements all optional list operations, and permits all elements (including null).

**Note that this implementation is not synchronized.** To make it thread safe the list should be "wrapped" using the `Collections.synchronizedList` method.

```java
List list = Collections.synchronizedList(new LinkedList(...));
```

The iterators returned by this class's iterator and listIterator methods are fail-fast: if the list is structurally modified at any time after the iterator is created, in any way except through the Iterator's own remove or add methods, the iterator will throw a `ConcurrentModificationException`. Thus, in the face of concurrent modification, the iterator fails quickly and cleanly, rather than risking arbitrary, non-deterministic behavior at an undetermined time in the future.

---

## Reverse a singly linked list

- Maintain 3 references. currentNode, prevNode and the nextNode
- mark currentNode to the head, other two as null
- while the currentNode is not null
	- mark the nextNode as currentNode.next
	- make currentNode.next refer to prevNode
	- make prevNode to currentNode
	- make currentNode to nextNode
	
	```
	public void reverseLL() {
		Node currentNode = head, prevLink = null, nextNode = null;

		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = prevLink;
			prevLink = currentNode;
			currentNode = nextNode;
		}
		head = prevLink;
	}
	```
	
---

- Insertion and Deletion speed comparision in Singly Linked List Vs Doubly Linked List ?

	Deletion is fast is DLL because we can point the next of previous node to the next of current node and the previous of the next node to the previous of the current node. In singly linked list we have to traverse all the way maitaining prev pointer for the node to be deleted. Hence, deletion is fast in DLL compared to singly linked list.


## Problems on Linked List

- Merge two Sorted lists without any additional storage.
	[solution](./LL/Problems/MergeSortedLists.java)
	
- Checking for cyclicity in a Linked List.
	[solution](./LL/Problems/CheckingCycle.java)
	Actually, the pointers need not move one and two nodes at a time;it is only necessary that the pointers move at different rates.

- Swap nodes in a linked list without swapping data. [solution](./LL/SwapNodes.java)	

- Palindrome: Implement a function to check if a linked list is a palindrome.
	- Reverse linked list and compare
	- Use a stack to store elements one by one and then compare with original linked list

- Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node.

	1. Run through each linked list to get the lengths and the tails.
	2. Compare the tails. If they are different (by reference, not by value), return immediately. There is no intersection.
	3. Set two pointers to the start of each linked list.
	4. On the longer linked list, advance its pointer by the difference in lengths.
	5. Now, traverse on each linked list until the pointers are the same.
	
	
## to do	

- [Segregate even and odd nodes in a Linked List](http://www.practice.geeksforgeeks.org/problem-page.php?pid=400)	
	
- Check for median of a circular linked list.	
	
- Check for starting node of overlapping lists.

- Clone a doubly Linked List.

- Add two Number represented by linked list.

- http://www.geeksforgeeks.org/intersection-of-two-sorted-linked-lists/

- Rearrange a linked list such that all even and odd positioned nodes are together 
	
	http://www.geeksforgeeks.org/rearrange-a-linked-list-such-that-all-even-and-odd-positioned-nodes-are-together/


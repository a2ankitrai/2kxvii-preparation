import java.util.*;

class DepthList {

	static int height(BTNode root) {
		if (root == null)
			return 0;
		else {
			/* compute  height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else return (rheight + 1);
		}
	}

	public static void createDepthList(ArrayList<LinkedList<BTNode>> lists, BTNode root, int level) {
		if (root == null) {
			return;
		}

		LinkedList<BTNode> list = null;
		if (lists.size() == level) {
			list = new LinkedList<BTNode>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}

		list.add(root);
		createDepthList(lists, root.left, level + 1);
		createDepthList(lists, root.right, level + 1);

	}

	public static ArrayList<LinkedList<BTNode>> depthList(BTNode root) {
		ArrayList<LinkedList<BTNode>> lists = new ArrayList<LinkedList<BTNode>>();
		createDepthList(lists, root, 0);
		return lists;
	}

	public static void levelOrderPrint(BTNode root) {
		Stack<BTNode> s = new Stack<>();
		Queue<BTNode> q = new LinkedList<>();

		int h = height(root);
		s.push(root);

		while (h > 0) {

			while (!s.isEmpty()) {
				BTNode node = s.pop();
				System.out.print(node.data + " ");
				if (node.right != null) {
					q.offer(node.right);
				}
				if (node.left != null) {
					q.offer(node.left);
				}

			}

			System.out.println("");

			while (!q.isEmpty()) {
				s.push(q.poll());
			}
			h--;
		}

	}

	public static void levelOrderPrint2(BTNode root) {
		Queue<BTNode> q1 = new LinkedList<>();
		Queue<BTNode> q2 = new LinkedList<>();

		int h = height(root);
		q1.offer(root);

		while (h > 0) {

			while (!q1.isEmpty()) {
				BTNode node = q1.poll();
				System.out.print(node.data + " ");				
				if (node.left != null) {
					q2.offer(node.left);
				}
				if (node.right != null) {
					q2.offer(node.right);
				}
			}

			System.out.println("");

			while (!q2.isEmpty()) {
				q1.offer(q2.poll());
			}
			h--;
		}

	}

	public static void main(String[] args) {

		BTNode root = new BTNode(1);

		//Level 1 - nodes
		BTNode l1e1 = new BTNode(2);
		BTNode l1e2 = new BTNode(3);

		root.left = l1e1;
		root.right = l1e2;

		//-------------------------------------------
		//Level 2 - nodes
		BTNode l2e1 = new BTNode(4);
		BTNode l2e2 = new BTNode(5);
		BTNode l2e3 = new BTNode(6);
		BTNode l2e4 = new BTNode(7);

		l1e1.left = l2e1;
		l1e1.right = l2e2;
		l1e2.left = l2e3;
		l1e2.right = l2e4;

		//-------------------------------------------
		//Level 3 - nodes

		BTNode l3e1 = new BTNode(8);
		BTNode l3e2 = new BTNode(9);
		l2e1.left = l3e1;
		l2e1.right = l3e2;

		//-------------------------------------------
		//Level 4 - nodes
		BTNode l4e1 = new BTNode(10);
		l3e1.right = l4e1;


		BinaryTree bt = new BinaryTree(root);

		ArrayList<LinkedList<BTNode>> dl = depthList(root);
		int count = 0;
		/*for (LinkedList<BTNode> list : dl) {
			System.out.println("Level " + ++count + "\n");
			for (BTNode node : list) {
				System.out.print(node + " ");
			}
			System.out.println();
		}*/

		levelOrderPrint2(root);

	}

}
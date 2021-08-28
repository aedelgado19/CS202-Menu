class RBT {
	final int RED = 1;
	final int BLACK = 2;
	B_Node root;

	class B_Node {
		B_Node parent;
		B_Node left;
		B_Node right;
		int color;
		LLL order;
		
		class LLL{
			L_Node head;
			
			//wrapper display
			public void display() {
				display(head);
			}
			
			private void display(L_Node cur) {
				if(cur == null) {
					return;
				}
				System.out.println(cur.data);
				display(cur.next);
			}
			
			//similar to a hash. provides a key used in the tree
			public int key() {
				int count = 0;
				L_Node current = head;
				while(current.next != null) {
					count++;
					current = current.next;
				}
				int to_return = count + head.data.length();
				return to_return;
			}
			
			public L_Node delete() {
				head = null;
				return head;
			}
			
			class L_Node {
				String data;
				L_Node next;
				
				L_Node(String d){
					this.data = d;
				}
			}
		}
		
	}
	public B_Node delete() {
		root = null;
		return root;
	}
	
	//wrapper insert
	public RBT insert(B_Node node, RBT tree) {
		insert(node, tree.root, tree);
		return null;
		
	}
	
	//insert a new node
	private RBT insert(B_Node to_add, B_Node cur, RBT tree) {
		//new root
		if(tree == null) {
			tree.root = new B_Node();
			tree.root = to_add;
			return tree;
		}
		
		//right side
		else if(to_add.order.key() > cur.order.key()) {
			if(cur.right == null) {
				cur.right = to_add;
			} else {
				insert(to_add, cur.right, tree);
			}
		}
		
		//left
		else if(to_add.order.key() < cur.order.key()) {
			if(cur.left == null) {
				cur.left = to_add;
			} else {
				insert(to_add, cur.left, tree);
			}
		}
		
		return null;
	}
	
	//display the tree
	public void display(RBT tree) {
		display(tree.root);
	}
	
	//recursive display for the tree
	private void display(B_Node cur) {
		if(cur == null) {
			return;
		}
		cur.order.display();
		display(cur.right);
		display(cur.left);
		
	}
	
	public RBT tree_fixup(B_Node node, RBT tree) {
		while(node.parent != null && node.parent.color == RED) {
			if(node.parent.parent.left == node.parent) { //left child
				B_Node right_uncle = node.parent.parent.right;
				if(right_uncle != null && right_uncle.color == RED) {
					//recolor
					node.parent.color = BLACK;
					right_uncle.color = BLACK;
					node.parent.parent.color = RED;
					node = node.parent.parent;
				} else {
					if(node.parent.right == node) {
						node = node.parent;
						left_rotate(node, tree);
					}
					node.parent.color = BLACK;
					node.parent.parent.color = RED;
					right_rotate(node.parent.parent, tree);
				}
			} else { //right
				B_Node left_uncle = node.parent.parent.left;
				if(left_uncle != null && left_uncle.color == RED) {
					left_uncle.color = BLACK;
					node.parent.color = BLACK;
					node.parent.parent.color = RED;
					node = node.parent.parent;
				} else {
					if(node.parent.left == node) {
						node.parent.color = BLACK;
						node.parent.parent.color = RED;
						left_rotate(node.parent.parent, tree);
					}
				}
				tree.root.color = BLACK;
			}
			tree.root.color = RED;
		}
		
		return tree;
		
	}
	
	//left rotate tree for fix up
	public RBT left_rotate(B_Node node, RBT tree) {
		B_Node hold = node.right;
		if(hold.left != null) {
			hold.left.parent = node;
		}
		hold.parent = node.parent;
		if(node.parent == null) { //root
			tree.root = hold;
		}
		else if(node == node.parent.left) { //left child
			node.parent.left = hold;
		} else { //right child
			node.parent.right = hold;
		}
		hold.left = node;
		node.parent = hold;
		return tree;
	}
	
	//right rotate tree for fix up
	public RBT right_rotate(B_Node node, RBT tree) {
		B_Node hold = node.left;
		if(hold.right != null) {
			hold.right.parent = node;
		}
		hold.parent = node.parent;
		if(node.parent == null) { //root
			tree.root = hold;
		}
		else if(node == node.parent.right) { //left child
			node.parent.right = hold;
		} else { //right child
			node.parent.left = hold;
		}
		hold.right = node;
		node.parent = hold;
		return tree;
		
	}
}

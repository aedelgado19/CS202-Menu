public class Array {
	DLL d;
	int indices; //array size

	//DLL class. Each node contains an item to order from.
	class DLL {
		Node head;
		
		//inner node class
		class Node {
			String food;
			Node next;
			
			//constructor
			Node(String f){
				food = f;
			}
		}
		
		//insert method wrapper
		public DLL insert(DLL d, String to_add) {
			insert(d.head, d, to_add);
			return d;
		}
		
		//insert method recursive
		private DLL insert(Node current, DLL d, String to_add) {
			Node n = new Node(to_add);
			n.next = null;
			
			//check if list is empty
			if(current == null) {
				d.head = n;
			} else {
				if(current.next != null) {
					insert(current.next, d, to_add);
				} else {
					current.next = n;
				}
			}
			return d;
			
		}
	}
}

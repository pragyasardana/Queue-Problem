public class Queue {
	node first, last;
	int length;

	Queue() {
		first = null;
		last = null;
	}

	public void enqueue() {
		if (first == null) {
			first = new node();
			last = first;
		} else {
			node ptr = new node();
			last.next = ptr;
			last = ptr;
		}
		length++;
	}

	public boolean dequeue() {
		if ( isEmpty() ) {
			return false;
		} else {
			try{
				first = first.next;
			}catch(Exception e){
				return false;
			}
			length--;
			return true;
		}
	}

	int getLength(){
		return length;
	}
	
	boolean isEmpty() {
		if (first == null) {
			return true;
		} else {
			return false;
		}
	}
}

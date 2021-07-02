public class StaticQueue<E> implements Queue<E> {

	private E elements[];
	private int first;
	private int last;

	

	public StaticQueue(int maxSize) {
		elements = (E[])new Object[maxSize];
		first = last = -1;
	}

	public int numElements() {
		if (isEmpty()) return 0;
		return ((elements.length + last - first) % elements.length) + 1;
	}
	
	
	public boolean isEmpty() {
		return first == -1;
	}

	public boolean isFull() {
		if (first == 0 && last==elements.length -1) return true;
		if (first == last + 1) return true;
		return false;	
	}

	public void enqueue(E element) throws OverflowException {
		if (isFull()) throw new OverflowException();
		else {
			if (last == -1)
				first = last = 0;
			else
				last = (last + 1) % elements.length;
			elements[last] = element;
		}
	}

	public E dequeue() throws UnderflowException {
		if (isEmpty()) throw new UnderflowException();
		E element = elements[first];
		elements[first] = null; 
		if (first == last)
			first = last = -1;
		else
			first = (first + 1) % elements.length;

		return element;
	}

	public E front() throws UnderflowException {
		if (isEmpty()) throw new UnderflowException();
		return elements[first];
	}

	public E back() throws UnderflowException {
		if (isEmpty()) throw new UnderflowException();
		return elements[last];
	}

	public String toString() {
		if (isEmpty()) return "Fila Vazia";
		else {
			String s = "" + elements[first];
			for (int i = 1; i < numElements(); i++) {
				int k = (first + i) % elements.length;
				s += " " + elements[k];
			}
			s += "";
			return s;
		}
	}
}
package bibliotecaClasses;

public class StaticQueue<E> implements Queue<E> {

	//indice para o primeiro elemento
	protected int first;
	
	//indice para o �ltimo elemento
	protected int last;
	
	//array para armazenar as referencias  para os elementos
	protected E elements[];
	
	//constr�i fila para o tamanho m�ximo
	public StaticQueue(int maxSize) {
		elements = (E[]) new Object[maxSize];
		first = last = -1;
	}
	
	public boolean isEmpty() {
		return first == -1;
	}
	
	public boolean isFull() {
		/* O mod � utilizado para verificar se o resto da diviz�o de (last + 1) por elements.length � igual a zero
		 * comparando com o first*/
		return first == ((last + 1) % elements.length);
	}
	
	// isFull sem usar o mod 
	public boolean isFullNoMod() {
		if((first == 0 && last == elements.length-1) || first == last - 1)
			return true;
		else
			return false;		
	}
	
	public int numElements() {
		if (isEmpty())
			return 0;
		else {
			int n = elements.length; // p/ legibilidade da express�o abaixo
			return ((n + last - first) % n) + 1;
		}
	}
	
	public void enqueue(E element) throws OverflowException {
		if (isFull())
			throw new OverflowException();
		else {
			if (last == -1)
				first = last = 0;
			else
				last = (last + 1) % elements.length;
			elements[last] = element;
		}
	}
	
	public E dequeue() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		E element = elements[first];
		elements[first] = null; // p/ coleta de lixo
		if (first == last)
			first = last = -1;
		else
			first = (first + 1) % elements.length;

		return element;
	}
	
	
	public E front() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return elements[first];
	}

	
	public E back() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return elements[last];
	}
	
		
	public void foobar(Queue<Integer> f) { 
		try { 
			f.enqueue(1); 
			f.enqueue(3); 
			f.enqueue(5); 
			f.enqueue(7); 
			f.enqueue(9); 
		} catch (OverflowException e) { 
			System.out.println(e); 
		} 
		try { 
			f.dequeue(); 
			f.dequeue(); 
		} catch (UnderflowException e) { 
			System.out.println(e); 
		} 
		try { 
			f.enqueue(2); 
			f.enqueue(4); 
		} catch (OverflowException e) { 
			System.out.println(e); 
		} 
		try { 
			f.dequeue(); 
		} catch (UnderflowException e) { 
			System.out.println(e); 
		} 
		try { 
			f.enqueue(3); 
		} catch (OverflowException e) { 
			System.out.println(e); 
		} 
			System.out.println(f); 
		} 
	
	// Exercicio 2
	public void prependQueue(Queue<Integer> q1, Queue<Integer> q2) throws IllegalArgumentException{
		if(q1 == null || q2 == null) throw new IllegalArgumentException();
		Queue<Integer> aux = new StaticQueue<>(q1.numElements());
		while(!q1.isEmpty()) aux.enqueue(q1.dequeue());
		while(!q2.isEmpty()) q1.enqueue(q2.dequeue());
		while(!aux.isEmpty()) q1.enqueue(aux.dequeue());		
	}
	
	
	// Exercicio 3
	public void exterminateFromQueue(Queue<Character> q, char element) throws IllegalArgumentException {
		if(q == null) throw new IllegalArgumentException();
		Queue<Character> aux = new StaticQueue(q.numElements());
		while(!q.isEmpty()) {
			if(q.front() == element)
				q.dequeue();
			else
				aux.enqueue(q.dequeue());
		}
		while(!aux.isEmpty()) q.enqueue(aux.dequeue());
		/*while(!q.isEmpty()) {
			char temp = q.dequeue();
			if(temp != element)
				aux.enqueue(temp);
		}
		while(!aux.isEmpty())
			q.enqueue(aux.dequeue());*/
	}
	
	
	
	public String toString() {
		if (isEmpty())
			return "[Empty]";
		else {
			String s = "[" + elements[first];
			int n = numElements();
			for (int i = 1; i < n; i++) {
				int k = (first + i) % elements.length;
				s += ", " + elements[k];
			}
			s += "]";
			return s;
		}
	}
	
	public static void main (String [] args) {
		
		//Queue<Integer> exe1 = new StaticQueue<>(8);
		//exe1.enqueue(1); exe1.enqueue(2); exe1.enqueue(3); exe1.enqueue(4); 
		//System.out.println(exe1.toString());
		//System.out.println(exe1.isFull() ? true : false);
		//System.out.println(((StaticQueue<Integer>) exe1).isFullNoMod() ? true : false);
		
		//Queue<Integer> exe2 = new StaticQueue<>(8);
		//exe2.enqueue(5); exe2.enqueue(6); exe2.enqueue(7); exe2.enqueue(8);
		
		/*System.out.println(exe1.toString());
		System.out.println(exe2.toString());
		
		((StaticQueue<Integer>) exe1).prependQueue(exe1, exe2);
		
		System.out.println(exe1.toString());
		System.out.println(exe2.toString());*/
		
		// exercicio 3
		Queue<Character> exe3 = new StaticQueue<>(4);
		exe3.enqueue('a'); exe3.enqueue('b'); exe3.enqueue('b'); exe3.enqueue('c');
		System.out.println(exe3.toString());
		((StaticQueue<Character>)exe3).exterminateFromQueue(exe3, 'b');
		System.out.println(exe3.toString());
		
		
	}
	
	
}

package bibliotecaClasses;

import java.util.Arrays;

public class StaticQueue<E> implements Queue<E> {

	//indice para o primeiro elemento
	protected int first;
	
	//indice para o último elemento
	protected int last;
	
	//array para armazenar as referencias  para os elementos
	protected E elements[];
	
	//constrói fila para o tamanho máximo
	public StaticQueue(int maxSize) {
		elements = (E[]) new Object[maxSize];
		first = last = -1;
	}
	
	public boolean isEmpty() {
		return first == -1;
	}
	
	public boolean isFull() {
		/* O mod é utilizado para verificar se o resto da divizão de (last + 1) por elements.length é igual a zero
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
			int n = elements.length; // p/ legibilidade da expressão abaixo
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
	}
	
	
	// Exercicio 4
	public boolean contains(E element) throws IllegalArgumentException{
		if(element == null) throw new IllegalArgumentException();
		Queue<E> aux = new StaticQueue<>(this.numElements());		
		boolean achou = false;
		while(!this.isEmpty()) {
			E temp = this.dequeue();
			aux.enqueue(temp);
			if(temp.equals(element)) {
				achou = true;
				break;
			}
		}
		while(!this.isEmpty())
			aux.enqueue(this.dequeue());
		while(!aux.isEmpty())
			this.enqueue(aux.dequeue());
				
		return achou;
	}
	
	// exercicio 5 
	public void flip() {		
		Stack<E> pilha = new StaticStack<>(this.numElements());
		while(!this.isEmpty())
			pilha.push(this.dequeue());
		while(!pilha.isEmpty())
			this.enqueue(pilha.pop());	
	}
	
	
	// exercicio 6
	public void enqueue(Queue<E> fila) throws OverflowException {
		if (isFull())
			throw new OverflowException();
		else {			
			Queue<E> aux = new StaticQueue(this.numElements()+fila.numElements());
			
			while(!this.isEmpty())
				aux.enqueue(this.dequeue());
			
			while(!fila.isEmpty())
				aux.enqueue(fila.dequeue());
			
			while(!aux.isEmpty())
				this.enqueue(aux.dequeue());			
		}
	}
	
	// exercicio 7
	public void enqueueWithPriority(E element) throws OverflowException {
		if(isFull())
			throw new OverflowException();
		else {
			Queue<E> aux = new StaticQueue(this.numElements()+1);
			aux.enqueue(element);
			while(!this.isEmpty())
				aux.enqueue(this.dequeue());
			while(!aux.isEmpty())
				this.enqueue(aux.dequeue());
		}		
	}
	
	// exercicio 8
	public boolean equals(Queue<E> fila) {
		
		Queue<E> aux = new StaticQueue<>(this.numElements());
		Queue<E> aux2 = new StaticQueue<>(fila.numElements());
		boolean igual = false;
		
		while(!this.isEmpty()) {
			if(!this.front().equals(fila.front())) {
				igual = false;
				break;				
			}else {
				aux.enqueue(this.dequeue());
				igual = true;
			}
		}
		while(!this.isEmpty())
			aux.enqueue(this.dequeue());
		//while()
		
		return igual;
	}
	
	
	public void copy(Queue<E> fila){
		Queue<E> aux = new StaticQueue(this.numElements());
		while(!this.isEmpty()) {
			aux.enqueue(this.dequeue());
			fila.enqueue(aux.front());
		}
		while(!aux.isEmpty()) {
			System.out.println(aux.front());
			this.enqueue(aux.dequeue());					
		}		
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StaticQueue other = (StaticQueue) obj;
		if (!Arrays.deepEquals(elements, other.elements))
			return false;
		return true;
	}
	
}

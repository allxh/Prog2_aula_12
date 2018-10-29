package bibliotecaClasses;

public class Exercicios<E> {
	
	public void prependQueue(Queue<Integer> q1, Queue<Integer> q2) throws IllegalArgumentException{
		if(q1 == null || q2 == null) throw new IllegalArgumentException();
		Queue<Integer> aux = new StaticQueue<>(q1.numElements());
		while(!q1.isEmpty()) aux.enqueue(q1.dequeue());
		while(!q2.isEmpty()) q1.enqueue(q2.dequeue());
		while(!aux.isEmpty()) q1.enqueue(aux.dequeue());		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue<Integer> exe1 = new StaticQueue<>(5);
		exe1.enqueue(1); exe1.enqueue(2); exe1.enqueue(3); exe1.enqueue(4); 
		//System.out.println(exe1.toString());
		//System.out.println(exe1.isFull() ? true : false);
		//System.out.println(((StaticQueue<Integer>) exe1).isFullNoMod() ? true : false);
		
		Queue<Integer> exe2 = new StaticQueue<>(5);
		exe2.enqueue(5); exe2.enqueue(6); exe2.enqueue(7); exe2.enqueue(8);
		
		System.out.println(exe1.toString());
		System.out.println(exe2.toString());
		
		
		
		
	}

}

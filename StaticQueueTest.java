package bibliotecaClasses;

public class StaticQueueTest {

	public static void main(String[] args) {
		
		/*Queue<Character> exe3 = new StaticQueue<>(4);
		exe3.enqueue('a'); exe3.enqueue('b'); exe3.enqueue('c'); exe3.enqueue('d');
		System.out.println(exe3.toString());*/
		
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
		/*((StaticQueue<Character>)exe3).exterminateFromQueue(exe3, 'b');
		System.out.println(exe3.toString());*/
		
		// exercicio 4
		/*char elemento = 'a';
		System.out.println(exe3.contains(elemento) ? "Contém" : "Não contém");*/
				
		// exercicio 5
		/*exe3.flip();
		System.out.println(exe3.toString());*/
			
		// exercicio 6
		/*Queue<Character> exe6 = new StaticQueue<>(4);
		exe3.enqueue('e'); exe3.enqueue('f'); exe3.enqueue('g'); exe3.enqueue('h');
		exe3.enqueue(exe6);
		System.out.println(exe3.toString());*/
		
		Queue<Character> exe3 = new StaticQueue<>(4);
		exe3.enqueue('b'); exe3.enqueue('b'); exe3.enqueue('b'); exe3.enqueue('b');
		System.out.println(exe3.toString());
		
		// exercicio 7
		/*char elemento = 'x';
		exe3.enqueueWithPriority(elemento);
		System.out.println(exe3.toString());*/
		
		Queue<Character> exe8 = new StaticQueue<>(4);
		//exe8.enqueue('a'); exe8.enqueue('a'); exe8.enqueue('a'); exe8.enqueue('a');
		
		exe3.copy(exe8);
		
		System.out.println(exe3.equals(exe8) ? "É Igual" : "Não é igual");
		System.out.println(exe3.toString());
		
		System.out.println(exe8.toString());
		
	}

}

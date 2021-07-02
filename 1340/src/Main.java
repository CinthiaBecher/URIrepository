import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int testes = Integer.parseInt(teclado.nextLine());
		for (int i = 0; i < testes; i++) {
			int entrada = Integer.parseInt(teclado.nextLine());
			Queue<Integer> queue = new StaticQueue<Integer>(entrada);
			Stack<Integer> stack = new StaticStack<Integer>(entrada);
			PriorityQueue<Integer> pq = new PriorityQueue<>(entrada,Collections.reverseOrder());
			
			int pontosQueue = 0;
			int pontosStack = 0;
			int pontosPq = 0;
			

			for (int j = 0; j < entrada; j++) {
				String[] comandoEnumero = teclado.nextLine().split(" ");
				if(Integer.parseInt(comandoEnumero[0]) == 1) {
					queue.enqueue(Integer.parseInt(comandoEnumero[1]));
					stack.push(Integer.parseInt(comandoEnumero[1]));
					pq.add(Integer.parseInt(comandoEnumero[1]));
					
				}
				else {
					int dequeue = queue.dequeue();
					int pop = stack.pop();
					int poll = pq.poll();

					if(dequeue == Integer.parseInt(comandoEnumero[1])) 
						pontosQueue++;//System.out.println("ponto queue == " + dequeue + "\t" + comandoEnumero[1] );
					if(pop == Integer.parseInt(comandoEnumero[1]))
						pontosStack++;//System.out.println("ponto stack == " + pop + "\t" + comandoEnumero[1] );
					if(poll == Integer.parseInt(comandoEnumero[1]))
						pontosPq++;
				}		
				//System.out.println(queue.toString());
				//System.out.println(stack.toString());
			}
			//System.out.println(queue.toString());
			//System.out.println(stack.toString());
			if (pontosQueue > pontosStack  &&  pontosQueue > pontosPq) 
				System.out.println("queue");
			else if (pontosQueue < pontosStack && pontosStack > pontosPq) 
				System.out.println("stack");
			else if (pontosPq > pontosStack && pontosPq > pontosQueue) 
				System.out.println("priority queue");
			else if(pontosQueue == 0 && pontosStack == 0 && pontosPq == 0) 
				System.out.println("impossible");
			else
				System.out.println("not sure");
				
		}
	}

}

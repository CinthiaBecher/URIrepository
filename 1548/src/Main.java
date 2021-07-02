import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int entrada = Integer.parseInt(teclado.nextLine());
		for (int i = 0; i < entrada; i++) {
			//quantidade de alunos
			int qtddAlunos = Integer.parseInt(teclado.nextLine());
			
			Queue<Integer> fila = new StaticQueue<Integer>(qtddAlunos);
			Queue<Integer> filaParaComparacao = new StaticQueue<Integer>(qtddAlunos);
			
			//notas dos alunos
			String notasAlunos = teclado.nextLine();
			String[] notas = notasAlunos.split(" ");
			
			int[] notass = new int[qtddAlunos];
			
			for (int j = 0; j < qtddAlunos; j++) {
				fila.enqueue(Integer.parseInt(notas[j]));
				filaParaComparacao.enqueue(Integer.parseInt(notas[j]));
				notass[j] = Integer.parseInt(notas[j]); 
			}
			
			//verifica se é maior ou menor
			bubbleSort(notass,fila);
			fila.flip();
			
			int total = 0;
			for (int x = 0; x < qtddAlunos; x++) {
				if(fila.returnElement(x) == filaParaComparacao.returnElement(x))
					total++;
			}
			System.out.println(total);

		}
	}
	
		public static void bubbleSort(int[] a,Queue<Integer> fila) { 
			int i = a.length-1;
			int[] arrayAux = null;
			while (i > 0) {

				int lastFlipped = 0;

				for (int j = 0; j < i; j++) { 
					if (a[j] > a[j+1]) { // troca par de posição
						int T = a[j]; 
						
						a[j] = a[j+1]; 
						arrayAux = new int[j];
						for (int k = 0; k <= j+1; k++) {
							int dequeue = fila.dequeue();
							if(k < j)
								arrayAux[k] = dequeue;	
						}
						
						a[j+1] = T; 
						
						fila.enqueueWithPriority(a[j+1]);
						fila.enqueueWithPriority(a[j]);
						for (int aux : arrayAux) {
							fila.enqueueWithPriority(aux);		
						}
														
						lastFlipped = j; 
					}
				}
				i = lastFlipped;
			}
		}

}
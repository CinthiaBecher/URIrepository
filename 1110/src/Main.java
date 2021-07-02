import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int entrada = 1;
		
		entrada = Integer.parseInt(teclado.nextLine());
		while(entrada != 0) {
			 
			
			//coloca os elementos em lista
			List<Integer> lista = new StaticList<Integer>(entrada);
			for (int i = 1; i <= entrada; i++) {
				lista.insert(i, i-1);
			}
			
			int[] discarded = new int[entrada-1];
			int j = 0;
			
			while(lista.numElements() >= 2) {
				discarded[j++] = lista.remove(0);
				lista.insert(lista.remove(0), lista.numElements());
				//System.out.println(lista.toString());
			}

			System.out.print("Discarded cards: ");
			for (int k = 0; k < discarded.length; k++) {
				if(k == discarded.length -1)
					System.out.println(discarded[k]);
				else
					System.out.print(discarded[k] + ", ");
			}
			System.out.println("Remaining card: " + lista.toString());
			
			
			entrada = Integer.parseInt(teclado.nextLine());
		}

	}

}

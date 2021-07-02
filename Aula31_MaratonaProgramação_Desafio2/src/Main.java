import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int qtdd =Integer.parseInt(teclado.nextLine()); 
		
		for (int i = 0; i < qtdd; i++) {
			//le a linha
			String linha = teclado.nextLine();
			
			//separa os elementos
			String[] elementos = new String[1000];
			elementos = linha.split("");
			
			/*for (String string : elementos) {
				if(string != null)
				System.out.println(string);
			}*/
			
			List<String> lista = new StaticList<String>(1000);
			for (int j = 0; j < elementos.length; j++) {
				if(elementos[j] != null)	
					lista.insert(elementos[j], j);
			}
			
			int diamantes = 0;
			boolean encontrou = true;
			while (encontrou) {
			int menor = lista.search("<");
			int maior = lista.search(">");
			encontrou = false;
		
			if (menor != -1) 
				if (maior != -1) {
					encontrou = true;
					diamantes++;
					lista.remove(maior);
					lista.remove(menor);
				}
			}
			System.out.println(diamantes);
		}

	}

}

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		boolean correct = false;
		
		int p1 = 0;
		int p2 = 0;
		
		//para repetir o código x vezes
		for (int i = 0; i < 1 + (int) (Math.random() * 10000); i++) {
			//recebe a expressao
			String expressao = teclado.nextLine(); 
			
			//quebra a expressao
			String elementos[] = new String[20];
			elementos = expressao.split("");
			
			//coloca a expressao na pilha
			StaticStack<String> stackCompleta = new StaticStack<String>(elementos.length);	
			try{
				for (String string : elementos) {
					if(string != null)
						stackCompleta.push(string);
				}
				
				StaticStack<String> stackParenteses = new StaticStack<String>(elementos.length);
				//Adiciona só os parenteses em outra pilha
				while (!stackCompleta.isEmpty()) {
					String elemento = stackCompleta.pop();
					
					if (elemento.equals("(")) {	
						stackParenteses.push(elemento);
						p1++;
					}
					if (elemento.equals(")")){	
						stackParenteses.push(elemento);
						p2++;
					}
				}
				
				if(stackParenteses.numElements()%2 != 0)
					correct = false;
				else {
					if(stackParenteses.top().equals(")"))
						correct = false;
		            else {
		            	if (p1 != p2)
		            		correct = false;
		            	else
		            		correct = true;
		            	}
		            }
				if(correct)
					System.out.println("correct");
				else
					System.out.println("incorrect");
			}catch(UnderflowException e){
					System.out.println(e);
					e.printStackTrace();
			}catch(OverflowException e){
				System.out.println(e);
			}
		}

	}

}

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int entrada = Integer.parseInt(teclado.nextLine());
		
		for (int n = 1; n <= entrada; n++) {
			int[][] y = new int[9][9];
			for (int i = 0; i < 9; i++) {
				String numeros = teclado.nextLine();
				String[] numerosArray = numeros.split(" ");
				
				for(int row = 0; row < 9; row++) {
						y[i][row] = Integer.parseInt(numerosArray[row]);
					}
			}
			/*for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(y[i][j]+" "); 
				}
				System.out.println();
			}*/
			
			System.out.println("Instancia " + n + "\n" + is_sudoku(y));
			
		}	
	}
	
	public static String is_sudoku(int[][] matriz) {
		for(int row = 0; row < 9; row++)
		      for(int col = 0;col < 8; col++)
		      if(matriz[row][col] == matriz[row][col+1]) return "NÃO";
		    
		for(int col = 0; col < 9; col++)
			   for(int row = 0; row < 8; row++)
			      for(int row2 = row + 1; row2 < 9; row2++)
			         if(matriz[row][col] == matriz[row2][col]) return "NÃO";
		
		for(int row = 0; row < 9; row += 3)
			   for(int col = 0; col < 9; col += 3)
			      for(int pos = 0; pos < 8; pos++)
			         for(int pos2 = pos + 1; pos2 < 9; pos2++)
			            if(matriz[row + pos2%3][col + pos2/3] == matriz[row + pos%3][col + pos/3]) return "NÃO";
		return "SIM";
        
	}
      

}

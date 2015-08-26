import java.util.*;

public class Soduku {
	
	public final static int SIZE = 9 ;
	public final static int GRID = 3 ;
	
	private static int[][] matrix = new int[SIZE][SIZE] ;
	private static int[] numbers = new int[SIZE] ;
	
	
	public static void main(String[] args) {
		int s ;
		boolean go_on = true ;
		
		Scanner sc = new Scanner (System.in) ;
		
		for (int i = 0; i < SIZE; i ++) {
			for (int j = 0; j < SIZE; j ++) {
				s = sc.nextInt() ;
				
				if (s < 1 || s > 9) { 
					go_on = false ;
					break ;
				}
				
				matrix[i][j] = s ; 
			}
		}
		
		if (go_on) {
			System.out.println(verify());
		} else {
			System.out.println(go_on);
		}
		
		sc.close(); 
	} 

	public static boolean verify () {
		// Verifies the soduku puzzle and returns TRUE if the configuration is valid
		// False otherwise.

		int counter = 0;

		// Check horizontal
		for (int i = 0; i < SIZE; i ++) {
			for (int j = 0; j < SIZE; j ++) {
				numbers[j] = matrix[i][j] ;
			}

			if (!check_numbers (numbers)) { return false ; }

			for (int j = 0; j < SIZE; j ++) {
				numbers[j] = matrix[j][i] ;
			}

			if (!check_numbers (numbers)) { return false ; }

			if (i%3 == 0) {
				for (int j = 0; j < SIZE; j += 3) {
					counter = 0 ;

					for (int x = j; x < j + 3; x ++) {
						for (int y = j; y < j + 3; y ++) {
							numbers[counter] = matrix[x][y] ;
							counter ++ ;
						}
					}

					if (!check_numbers (numbers)) { return false ;}
				}
			}
		}

		return true ;
	}

	private static boolean check_numbers (int[] numbers) {
		Arrays.sort (numbers) ;

		for (int c = 1; c < SIZE; c ++) {
			if (numbers[c-1] == numbers[c]) {
				return false; 
			}
		}

		return true ;
	}
}

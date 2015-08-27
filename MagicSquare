import java.util.* ;

public class MagicSquare {

    private static int[][] matrix ;
    private static int size ;

    public static void main (String args[]) {
        Scanner sc = new Scanner (System.in) ;

        size = sc.nextInt() ;

        if (size % 2 == 0) {
            System.out.println ("ERROR: Matrix size cannot be a even number!") ;

        } else {
            fill_matrix () ;
            print_matrix () ;
        }
    }

    
    public static void fill_matrix () {
        int number = 1 ;
        int x, y ;
        int temp_x, temp_y ;

        matrix = new int[size][size] ;

        // Find the middle entry on the top row
        y = size / 2 ;
        x = 0 ;

        while (number <= (size * size)) {
            matrix[x][y] = number ;
            
            // Save current x and y in case of rollback
            temp_x = x;
            temp_y = y;
            
            // Attempt to go up and right.
            x --;
            y ++;
            
            // Handles the "wrap-around"
            if (x < 0) {
                x = size - 1 ;    
            }

            if (y == size) {
                y = 0 ;
            }
            
            // Check if the new cell is filled. If so, rollback and move
            // down.
            if (matrix[x][y] != 0) {
                x = temp_x + 1 ;
                y = temp_y ;
            }
            number ++ ;
        }
        
    }

    public static void print_matrix () {
       for (int i = 0; i < size; i ++) {
            for (int j = 0; j < size; j ++) {
                System.out.print (matrix[i][j]) ;
                System.out.print (" ") ;
            }

            System.out.print ("\n") ;
       }     
        
    }

}

import java.util.InputMismatchException;
import java.util.Scanner;
public class Assignment01 {
    //Main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean validation=false;
        do {
            try {
                System.out.println();
                System.out.print("Enter the number of Rows or Columns you want : ");
                int n = input.nextInt();
                System.out.println();
                int[][] square = inputArray(n);
                printSquare(square, n);
                int check1 = checkMagicSquare(n, square);
                int check2 = checkLoShuSquare(n, square);
                retry();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input.Please enter a number");
                input.next();
            }
        }while (validation==false);
    }

    //Retry method
    public static void retry(){
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.print("Do you want to enter a new square? (y/n) : ");
        String answer = input.next();
        if(answer.equalsIgnoreCase("y")){
            System.out.println();
            String[] args = {};
            main(args);
        }else if (answer.equalsIgnoreCase("n")){
            System.out.println();
            System.out.println("           Goodbye!!!           ");
            System.exit(0);
        }else{
            System.out.println();
            System.out.print("Wrong input.Do you want to enter a new square? (y/n) : ");
            input.next();
        }
    }

    //Method to creat array
    public static int[][] inputArray(int n){
        Scanner array = new Scanner(System.in);
        int count = 1;
        int[][] square = new int[n][n];
        for (int R = 0; R < n; R++) {
            for (int C = 0; C < n; C++) {
                boolean validation = false;
                int number = 0;
                do {
                    try {
                        System.out.print("Enter number" + " " + count + " : ");
                        number = array.nextInt();
                        count += 1;
                        validation =true;
                    } catch (InputMismatchException e) {
                        System.out.println("Wrong input.Please enter a number");
                        array.nextLine();
                    }
                }while (!(validation));
                square[R][C] = number;
            }
        }
        return square;
    }

    //Method to Display Square
    public static void printSquare(int[][] square, int n) {
        System.out.println();
        for (int R=0;R<n;R++) {
            for (int C=0;C<n;C++) {
                System.out.print(square[R][C]);
                System.out.print("\t");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    //Method to check if it is a Magic Square
    public static int checkMagicSquare(int n,int[][] square){
        int total1 = 0;
        int total2 = 0;

        //To calculate the total of each Row
        for (int R=0;R<n;R++) {
            int total_of_rows = 0;
            for (int C=0;C< n;C++) {
                total_of_rows += square[R][C];
            }
            total1 =total_of_rows;
        }

        //To calculate the total of each Column
        for (int C=0;C<n;C++) {
            int total_of_columns = 0;
            for (int R=0;R<n;R++) {
                total_of_columns += square[C][R];
            }
            total2 = total_of_columns;
        }

        //To calculate the total of Diagonal Left top to Right bottom
        int total_of_diagonal1 = 0;
        for (int R=0,C=0;R<n;R++,C++) {
            total_of_diagonal1 += square[R][C];
        }

        //To calculate the total of Diagonal Right top to Left bottom
        int total_of_diagonal2 = 0;
        for (int R=0,C=n-1;R<n;R++,C--) {
            total_of_diagonal2 += square[R][C];
        }

        //To find out the square is a Magic square
        if (total1 == total2 && total2 == total_of_diagonal1 && total_of_diagonal1 == total_of_diagonal2) {
            System.out.println("Magic Square" + "  " + ":" + " " + "TRUE");
        } else {
            System.out.println("Magic Square" + " " + ":" + " " + "FALSE");
        }
        return total1;
    }

    //Method to check if it is a Lou Shu Square
    public static int checkLoShuSquare(int n,int[][] square){
        System.out.println();
        int repeat = 0;
        int loshu = 0;
        int total1 = 0;
        int total2 = 0;

        //To calculate the total of each Row
        for (int R=0;R<n;R++) {
            int total_of_rows = 0;
            for (int C=0;C< n;C++) {
                total_of_rows += square[R][C];
            }
            total1 =total_of_rows;
        }

        //To calculate the total of each Column
        for (int C=0;C<n;C++) {
            int total_of_columns = 0;
            for (int R=0;R<n;R++) {
                total_of_columns += square[C][R];
            }
            total2 = total_of_columns;
        }

        //To calculate the total of Diagonal Left top to Right bottom
        int total_of_diagonal1 = 0;
        for (int R=0,C=0;R<n;R++,C++) {
            total_of_diagonal1 += square[R][C];
        }

        //To calculate the total of Diagonal Right top to Left bottom
        int total_of_diagonal2 = 0;
        for (int R=0,C=n-1;R<n;R++,C--) {
            total_of_diagonal2 += square[R][C];
        }

        //To find out the repeated numbers
        for (int R=0;R<n;R++) {
            for (int C=0;C<square[R].length;C++) {
                int number=square[R][C];
                for (int nextC=C+1;nextC<square.length;nextC++) {
                    if (number==square[R][nextC]) {
                        repeat += 1;
                    }
                }
            }
        }

        //To find out that each value is below 10 and not repeated
        for (int R=0;R<n;R++) {
            for (int C=0;C<n;C++) {
                if (square[R][C] <= 9 && repeat==0) {
                    loshu = 1;
                } else {
                    loshu = 0;
                }
            }
        }

        //To find out the square is a Lo Shu square
        if (loshu == 1 && total1 == total2 && total2 == total_of_diagonal1 && total_of_diagonal1 == total_of_diagonal2 ){
            System.out.println("Lo Shu square" + " " + ":" + " " + "TRUE");
        }else{
            System.out.println("Lo Shu square" + " " + ":" + " " + "FALSE");
        }
        return loshu;
    }
}

import java.util.*;
public class Computation {

        private int a, b;
        int[][] matrix;
        Scanner scan = new Scanner(System.in);

        public void getMatrixSize() {
            System.out.println("Введите размер матрицы в формате A x B");
            System.out.print("A = ");
            a =  scan.nextInt();
            System.out.print("B = ");
            b = scan.nextInt();
            if(this.a != this.b) {
                System.out.println("Определитель можно найти только для квадратной матрицы");
                getMatrixSize();
            }
            matrix = new int[a][b];
        }

        public void setMatrix(){
            System.out.println("Заполните марицу");
            for(int i = 0; i < a; i++){
                for(int t = 0; t < b; t++){
                    System.out.print("a [" + (i + 1) + "]" + "[" + (t + 1) + "] = ");
                    matrix[i][t] = scan.nextInt();
                }
            }
        }


        public  void print(int[][] puzzle) {
            System.out.println("Вывести матрицу в консоль ? [да/нет]");
            String answer = scan.next();
            answer = answer.toLowerCase();
            if(answer.equals("да")) {
                for (int[] row : puzzle) {
                    System.out.print('|');
                    for (int elem : row) {
                        System.out.printf("%4d", elem);
                    }

                    System.out.println('|');
                }
                System.out.println();
            }else {
                return;
            }
        }




        public int[][] getMinor(int z, int[][] source){
            int[][] minor = new int[source.length - 1][source.length - 1];
            int check = 0;
            for(int i = 0; i < minor.length; i++){
                for(int t = 0; t < minor.length; t++){
                    if(z == i){
                        minor[i][t] = source[i + 1][t + 1];
                        check = 1;
                    }
                    if(check == 0) {
                        minor[i][t] = source[i][t + 1];
                    }else {
                        minor[i][t] = source[i + 1][t + 1];
                    }
                }
            }

            return minor;
        }




        public int determinant(int[][] mm){
            int sum = 0;
            if(mm.length == 2) {
                return sum = ((mm[0][0] * mm[1][1]) - (mm[0][1] * mm[1][0]));

            } else {
                for(int i = 0; i < mm.length; i++){
                    if ((i % 2) == 0) {

                        sum +=  mm[i][0] * determinant(getMinor(i, mm));
                    } else {

                        sum -= mm[i][0] * determinant(getMinor(i, mm));

                    }
                }
            }
            return sum;
        }
    }


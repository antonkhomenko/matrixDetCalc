public class Main {
    public static void main(String[] args) {
        Computation c = new Computation();
        c.getMatrixSize();
        c.setMatrix();
        c.print(c.matrix);
        System.out.println("|Matrix| = " + c.determinant(c.matrix));
    }
}

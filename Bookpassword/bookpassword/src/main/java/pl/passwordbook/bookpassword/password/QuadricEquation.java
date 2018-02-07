package pl.passwordbook.bookpassword.password;

public class QuadricEquation {
    public static void main(String[] args) {
        Solver solver = new Solver(1,-7,4);
        System.out.print("Wynik" + solver.solve());


    }
}

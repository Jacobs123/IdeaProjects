package pl.passwordbook.bookpassword.password;

public class Solver {

    private double a;
    private double b;
    private double c;

    public Solver(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double delta(){
        double result = Math.pow(this.b,2)-4*this.a*this.c;
        return result;
    }

    public double[] solve(){
        double[] results = null;
        double delta = delta();
        if (delta>0){
            results = new double[2];
            results[0] = (-b-Math.sqrt(delta))/(2*a);
            results[1] = (-b+Math.sqrt(delta))/(2*a);
        }
        else if (delta == 0){
            results = new double[1];
            results[0] = -b/(2*a);
        }
        return results;
    }
}

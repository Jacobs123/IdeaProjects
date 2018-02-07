package pl.passwordbook.bookpassword;

import org.junit.Test;
import pl.passwordbook.bookpassword.password.Solver;
import static org.junit.Assert.assertEquals;

public class SolverTest {

    @Test
    public void test(){
        Solver solver = new Solver(1,-7,12);
        double[] result = solver.solve();
        assertEquals(2, result.length);
        assertEquals(3,result[0], 0.000001);
        assertEquals(4,result[1], 0.000001);
    }

    @Test
    public void delta(){
        Solver solver = new Solver(1,-7,12);
        double result = solver.delta();
        assertEquals(result,2);
    }
}

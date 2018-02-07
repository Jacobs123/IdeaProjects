package taxcalc;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TaxCalcTest {

    @Test
    public void shouldBeTaxFree(){
        TaxCalculator taxCalculator = new TaxCalculator();
        double tax = taxCalculator.calculateTax(3091);
        assertEquals(0, tax, 0.0000001);
    }

    @Test
    public void shouldBeHighTax(){
        TaxCalculator taxCalculator = new TaxCalculator();
        double tax = taxCalculator.calculateTax(100000);
        assertEquals(4, tax, 0.00001);
    }
}

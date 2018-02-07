package taxcalc;

public class TaxCalculator {

    private double tax;

    public double calculateTax(double ammount){
        /* jesli kwota jest mniejsza od 3091 zl podatek jet rowny 0 */
        if (ammount <=3091d){
            tax = 0;
        }
        /* w przeciwnym wypadku sprawdz warunek czy kwota jest mniejsza lub rowna 85 tysi*/
        else if (ammount <= 85528d){
            tax = 1;
        }
        else {
            tax = 4;
        }
        return tax;
    }
}

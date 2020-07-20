
public class Fraction {
    private int numerator; // tử số
    private int denominator; // mẫu số

    /**
     * Constructor
     * 
     * @param vNumerator
     * @param vDenominator
     */
    public Fraction(int vNumerator, int vDenominator) {
        this.numerator = vNumerator;
        this.denominator = vDenominator;
    }

    /**
     * Constructor tính toán
     * 
     * @param fractionA
     * @param fractionB
     * @param operator
     */
    public Fraction(Fraction fractionA, Fraction fractionB, String operator) {
        // thực hiện tối giản 2 phân số trước khi thực hiện phép tính
        fractionA.FractionNormalize();
        fractionB.FractionNormalize();
        switch (operator) {
            case "+":
                this.FractionAdd(fractionA, fractionB);
                break;
            case "-":
                this.FractionSub(fractionA, fractionB);
                break;
            case "*":
                this.FractionMultiply(fractionA, fractionB);
                break;
            case "/":
                this.FractionDivide(fractionA, fractionB);
                break;

            default:
                break;
        }
    }

    // setter
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    // getter
    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    /**
     * Tạo hiển thị phân số
     * 
     * @return
     */
    public String FractionPrint() {
        String fractionValue = this.getNumerator() + "/" + this.getDenominator();
        return fractionValue;
    }

    /**
     * Tổng 2 phân số x/y + a/b = (x*b + a*y)/(y*b)
     * 
     */
    // chỉ thực hiện trong class
    private void FractionAdd(Fraction fractionA, Fraction fractionB) {
        int addNumerator = fractionA.getNumerator() * fractionB.getDenominator()
                + fractionA.getDenominator() * fractionB.getNumerator();
        int addDenominator = fractionA.getDenominator() * fractionB.getDenominator();
        this.setNumerator(addNumerator);
        this.setDenominator(addDenominator);
        this.FractionNormalize();
    }

    /**
     * Hiệu 2 phân số x/y + a/b = (x*b + a*y)/(y*b)
     */
    // chỉ thực hiện trong class
    private void FractionSub(Fraction fractionA, Fraction fractionB) {
    }

    /**
     * Tích 2 phân số x/y + a/b = (x*b + a*y)/(y*b)
     */
    // chỉ thực hiện trong class
    private void FractionMultiply(Fraction fractionA, Fraction fractionB) {
    }

    /**
     * Thương 2 phân số x/y + a/b = (x*b + a*y)/(y*b)
     */
    // chỉ thực hiện trong class
    private void FractionDivide(Fraction fractionA, Fraction fractionB) {
    }

    /**
     * Tối giản phân số
     * 
     * @return true/false
     */
    public boolean CheckNormalize() {
        // tối giản là khi UCLN = 1
        boolean flg = false;
        int ucln = this.UCLN(this.getNumerator(), this.getDenominator());
        if (ucln == 1) {
            flg = true;
        }
        return flg;
    }

    // Xác định ước chung lớn nhất
    // Phương thức này chỉ thực hiện trong class -> private
    private int UCLN(int x, int y) {
        int result = Math.min(x, y);
        while (result >= 1) {
            if (x % result == 0 && y % result == 0) {
                return result;
            }
            result = result - 1;
        }
        return result;
    }

    public void FractionNormalize() {
        int ucln = this.UCLN(this.getNumerator(), this.getDenominator());
        if (ucln > 1) {
            this.setNumerator(this.numerator / ucln);
            this.setDenominator(this.denominator / ucln);
        }

    }

}
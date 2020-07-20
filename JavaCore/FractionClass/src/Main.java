public class Main {
    public static void main(String[] args) {
        Fraction fractionA = new Fraction(2, 4);
        Fraction fractionB = new Fraction(3, 9);
        // Tính toán 2 phân số
        Fraction fractionResult = new Fraction(fractionA, fractionB, "+");
        System.out.println("Tổng 2 phân số---  " + fractionResult.FractionPrint());
        // Kiểm tra phân số tối giản
        boolean checkNormalizeRes = fractionA.CheckNormalize();
        if (checkNormalizeRes == true) {
            System.out.println("checkNormalize----  Phân số đã tối giản---  " + fractionA.FractionPrint());
        } else {
            System.out.println("checkNormalize----  Phân số chưa tối giản");
            System.out.println("Phân số Input---    " + fractionA.FractionPrint());
            fractionA.FractionNormalize();
            System.out.println("Phấn số đã tối giản---    " + fractionA.FractionPrint());

        }

    }
}

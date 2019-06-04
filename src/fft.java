/**
 * @version $Revision$ $Date$
 * @author $Author$
*/
public class fft {
    //todo for now dtf,need fft优化
    public static  Complex[] fft(Complex[] numbers) {
        int size = numbers.length;
        Complex[] result = new Complex[size];
        for(int i =0;i < size;i++) {
            Complex sum = new Complex(0,0);
            double arg = -(i * 2 * Math.PI )/size;
            Complex complex = new Complex(0,arg);
            Complex res = Complex.exp(complex);
            for(int j =0; j<size;j++) {
                Complex va =  Complex.mul(numbers[j],Complex.forn(res,j));
                sum = Complex.add(sum,va);
            }
            result[i] = sum;
        }
        return result;
    }
    public static  Complex[] ifft(Complex[] numbers) {
        int size = numbers.length;
        Complex[] result = new Complex[size];
        for(int i =0;i < size;i++) {
            Complex sum = new Complex(0,0);
            double arg = (i * 2 * Math.PI )/size;
            Complex complex = new Complex(0,arg);
            Complex res = Complex.exp(complex);
            for(int j =0; j<size;j++) {
                Complex va =  Complex.mul(numbers[j],Complex.forn(res,j));
                sum = Complex.add(sum,va);
            }
            sum = Complex.divRel(sum,size);
            result[i] = sum;
        }
        return result;
    }
}

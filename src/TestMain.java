import java.util.Arrays;

/**
 * @version $Revision$ $Date$
 * @author $Author$
*/
public class TestMain {
    public static void main(String[] args) {
        Complex[] value = new Complex[50];
        for(int i =0; i< 50;i ++) {
            double rel = Math.sin(i*2*Math.PI / 50);
            value[i] = new Complex(rel,0);
            System.out.println(value[i]);
        }
        System.out.println("-----------------------------------------------");
        Complex[] res = fft.fft(value);
        Arrays.stream(res).forEach(System.out::println);
        System.out.println("------------------------------------------------");
        Complex[] rel = fft.ifft(res);
        Arrays.stream(rel).forEach(System.out::println);
    }
}

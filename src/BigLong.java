import com.sun.media.sound.FFT;

import java.util.Arrays;

/**
 * @version $Revision$ $Date$
 * @author $Author$
*/
public class BigLong {
    private int[] data;
    public BigLong(String n) {

    }
    public BigLong(int[] data) {
        this.data = data;
    }
    //卷积，可以使用fft
    public BigLong mul(BigLong n) {
        int[] target = n.getData();
        int len = target.length > data.length ? target.length : data.length;
        int resultLen = len*2 -1;
        long[] result = new long[resultLen];
        Arrays.fill(result, 0);
        for(int i =0;i < resultLen;i++) {
            for(int x=0;x<data.length;x++) {
                int k = i-x;
                if(k >=0 && k < target.length){
                    result[i] += data[x] * data[k];
                }
            }
        }
        int up = 0;
        int[] rs = new int[resultLen+1];
        for(int i =0;i<result.length;i++) {
            long add = result[i] + up;
            int[] k = divide(add);
            int hei = k[1];
            int low = k[0];
            rs[i] = low;
            up = hei;
        }
        rs[rs.length-1] = up;
        return new BigLong(rs);
    }
    public int[] getData(){
        return data;
    }
    public void setData(int[] data){
        this.data = data;
    }

    public int[] divide(long m) {
        int l = (int)(m & (Integer.MAX_VALUE));
        int h = (int)((m & (Long.MAX_VALUE - Integer.MAX_VALUE)) >> 31);
        return new int[]{l,h};
    }
}

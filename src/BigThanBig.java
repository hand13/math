/**
 * @author $Author$
 * @version $Revision$ $Date$
 */
public class BigThanBig {
    public static void mul(int x, int y) {
        int w = Math.abs(x);
        int b = Math.abs(y);
        int lw =  w & 0x00000fff;
        int mw = (w & 0x000ff000) >> 12;
        int hw = (w & 0xfff00000) >> 20;
        int lb =  b & 0x00000fff;
        int mb = (b & 0x000ff000) >> 12;
        int hb = (b & 0xfff00000) >> 20;
        //lw mw hw
        // 1 12 20
        //lb mb hb
        // 1 12 20


        // 1  lw * lb
        // 12 lw * mb + mw * lb
        // 20 lw * hb + lb * lb
        // 24 mw * mb
        // 32 mw * hb + mb * hw
        // 40 hw * hb
        int x1 = lw * lb;
        int x2 = lw * mb + mw * lb;
        int x3 = lw * hb + lb * lb;
        int x4 = mw * mb;
        int x5 = mw * hb + mb * hw;
        int x6 = hw * hb;
        int[] xx1 = divide(x1,0);
        int[] xx2 = divide(x2,12);
        int[] xx3 = divide(x3,20);
        int[] xx4 = divide(x4,24);
        int   xx5   = x5 <<1;
        int   xx    = x6 <<9;
        int height  = xx1[1] + xx2[1] + xx3[1] + xx4[1] + xx5 + xx;
        int down    = xx1[0] + xx2[0] + xx3[0] + xx4[0];
        System.out.println(height);
        System.out.println(down);
    }

    private static  int[] divide(int number,int b) {
        int bs = number << b;
        int ls = number >> (31 - b);
        return new int[]{bs,ls};
    }

    public static void main(String[] args) {
        int m = 0x80000;
        int w = 0x80000;
        System.out.println(m * w);
        mul(m,w);
    }
}

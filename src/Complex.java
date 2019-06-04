/**
 * @version $Revision$ $Date$
 * @author $Author$
*/
public final class Complex {
    public double rel;
    public double img;
    public Complex(double rel,double img) {
        this.rel = rel;
        this.img = img;
    }

    @Override
    public String toString() {
        return "rel = " + rel + " img = " + img;
    }

    public static Complex mul(Complex value1, Complex value2 ){
        double rel = value1.rel * value2.rel - value1.img * value2.img;
        double img = value1.rel * value2.img + value1.img * value2.rel;
        return new Complex(rel,img);
    }
        public static Complex add(Complex value1,Complex value2) {
            double rel = value1.rel + value2.rel;
            double img = value1.img + value2.img;
            return new Complex(rel,img);
    }
    public static Complex sub(Complex value1,Complex value2) {
        double rel = value1.rel - value2.rel;
        double img = value1.img - value2.img;
        return new Complex(rel,img);
    }
    public static Complex exp(Complex value) {
        double rel = Math.exp(value.rel) * Math.cos(value.img);
    double img = Math.exp(value.rel) * Math.sin(value.img);
        return new Complex(rel,img);
}
    public static Complex forn(Complex value,int n) {
        Complex result = new Complex(1,0);
        for(int i =0; i< n;i++) {
            result = Complex.mul(result,value);
        }
        return result;
    }
public static Complex divRel(Complex value1,double rel) {
    return new Complex(value1.rel/rel,value1.img/rel);
}
}

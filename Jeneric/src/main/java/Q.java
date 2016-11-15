
public class Q <X extends B, Y extends B, Z extends D> {
    X x;
    Y y;
    Z z;
    int allCalc() {
        return x.calc2() + y.calc2() + z.calc();
    }

}

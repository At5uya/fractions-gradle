public class Utils {

    static int findGDC(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return findGDC(n2, n1 % n2);
    }
}

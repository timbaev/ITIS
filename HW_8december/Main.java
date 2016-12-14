public class Main {

    public static void main(String args[]) {
        System.out.println("Result: " + calculateInt(-2, 1, 1000000, new Function()));
        System.out.println("Result trapeze: " + calculateIntTrapeze(-2, 1, 1000000, new Function()));
        System.out.println("Result Simpson: " + calculateIntSimpson(-2, 1, 1000000, new Function()));
    }

    private static float calculateInt(float a, float b, int n, Function function) {
        float sum = 0;
        float dx = (b - a) / n;
        for (float i = a; i <= b; i += dx) {
            sum += function.func(i) * dx;
        }
        return sum;
    }

    private static float calculateIntTrapeze(float a, float b, int n, Function function) {
        float sum = 0;
        float dx = (b - a) / n;
        for (float i = a; i < b; i += dx) {
            sum += function.func(i + dx);
        }
        sum += squareTrapeze(a, b, function);
        sum *= dx;
        return sum;
    }

    private static float calculateIntSimpson(float a, float b, int n, Function function) {
        float sum = 0;
        float dx = (b - a)/(2 * n);
        float sumEven = 0;
        float sumOdd = 0;
        for (float i = a + 2*dx; i <= b - 2*dx; i += 2*dx) {
            sumEven += function.func(i);
        }
        for (float i = a + dx; i < b; i += 2*dx) {
            sumOdd += function.func(i);
        }
        sum += function.func(a) + function.func(b) + 2 * sumEven + 4 * sumOdd;
        sum *= (dx / 3);
        return sum;
    }

    private static float squareTrapeze(float x1, float x2, Function function) {
        return (function.func(x1) + function.func(x2)) / 2;
    }
}

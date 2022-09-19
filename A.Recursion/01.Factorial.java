class Factorial {

    static int fact(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        int smallAns = fact(n-1);
        int myAns = n * smallAns;

        return myAns;
    }
    public static void main(String[] args) {
        System.out.println("5! -> " + fact(5));
        System.out.println("7! -> " + fact(7));
        System.out.println("2! -> " + fact(2));
        System.out.println("0! -> " + fact(0));
    }
}
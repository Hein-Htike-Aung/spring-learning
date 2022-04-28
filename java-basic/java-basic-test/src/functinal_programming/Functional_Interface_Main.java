package functinal_programming;

public class Functional_Interface_Main {

    public static void main(String[] args) {

        MyInterface myInterface = new MyInterface() {
            @Override
            public int calculate(int i, int j) {
                return i + j;
            }
        };
        System.out.println(myInterface.calculate(1, 2));


        MyInterface add = (a, b) -> a + b;
        MyInterface subtract = (a, b) -> a - b;
        MyInterface multiply = (a, b) -> a * b;

        System.out.println(add.calculate(1, 2));
        System.out.println(subtract.calculate(2, 3));
        System.out.println(multiply.calculate(2, 3));

        System.out.println(add.calculate(3, 4));
        subtract((a, b) -> a + b);

    }

    public MyInterface add() {
        return (a, b) -> a + b;
    }

    public static void subtract(MyInterface myInterface) {
        myInterface.calculate(2, 3);
    }
}

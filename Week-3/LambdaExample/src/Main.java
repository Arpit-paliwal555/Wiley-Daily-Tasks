interface MathOperation{
    int operate(int a,int b);
}
class calculator{
    int calculate(int a, int b, MathOperation operation){
        return operation.operate(a,b);
    }
}

public class Main {
    public static void main(String[] args) {
        MathOperation op = (a,b)->a+b;
        calculator clc = new calculator();
        System.out.println(clc.calculate(5,5,(a,b)->a*b));
        System.out.println(clc.calculate(10,10,op));
    }
}
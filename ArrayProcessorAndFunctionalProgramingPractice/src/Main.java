import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

// Functional Interfaces to do basic Math.
@FunctionalInterface
interface BasicMath<A,B> {
    public double calculate(A a, B b);
}

public class Main {

    public static void main(String[] args) {

        // This section tests the ArrayProcessing class and ArrayProcessor interface
        double [] test = {11, 9, 4, 2, 5.5, 9, 11, 11.1, 5, 22, 3, 11, 44, 0.99, 11};

        System.out.println(ArrayProcessing.MAX.apply(test));
        System.out.println(ArrayProcessing.MIN.apply(test));
        System.out.println(ArrayProcessing.SUM.apply(test));
        System.out.println(ArrayProcessing.AVERAGE.apply(test));
        System.out.println(ArrayProcessing.counter(11).apply(test));

        System.out.println();

        // This is a first-class function as the function is being assigned as a variable
        BasicMath<Double,Double> add = (a,b) -> a + b;
        System.out.println(add.calculate(9.23, 0.99));

        // This is also a first-class function as the function is being passed as a variable
        BasicMath<Double,Double> multiply = (a,b) -> a * b;
        getResult(multiply, 9.01, 3.87);

        // This is the final example of a first-class function as it is returning a function as a result
        BasicMath<Double,Double> divide = getDivision();
        System.out.println(divide.calculate(9.45, 6.78));

        System.out.println();

        // Functional Composition using Predicate
        Predicate<Integer> isEven = (value) -> value % 2 == 0;
        Predicate<Integer> isDivisibleByThree = (value) -> value % 3 == 0;
        Predicate<Integer> isEvenAndDivisibleByThree = isEven.and(isDivisibleByThree);

        System.out.println("is 10 an even number? " + isEven.test(10));
        System.out.println("is 13 an even number? " + isEven.test(13));
        System.out.println("is 15 divisible by 3? " + isDivisibleByThree.test(15));
        System.out.println("is 8 an even number and divisible by 3? " + isEvenAndDivisibleByThree.test(8));
        System.out.println("is 18 an even number and divisible by 3? " + isEvenAndDivisibleByThree.test(18));

        System.out.println();

        //Monads
        System.out.println("10 + 18 = " + addOptional(Optional.of(10), Optional.of(18)));
        System.out.println(concatOptional(Optional.of("Hello"), Optional.of("World")));

        System.out.println();

        // Currying
        Function<Integer, Function<Integer, Integer>> addUsingCurrying = x -> y -> x + y;
        Function<String, Function<String, String>> concatUsingCurrying = str1 -> str2 -> str1 + " " + str2;

        System.out.println("10 + 28 = " + addUsingCurrying.apply(10).apply(28));
        System.out.println(concatUsingCurrying.apply("Hello").apply("World"));

    }

    // This is a high order function as it is taking a function as a vairiable.
    public static void getResult(BasicMath<Double,Double> multiply, double x, double y) {

        System.out.println(multiply.calculate(x,y));

    }

    public static BasicMath<Double,Double> getDivision() {

        BasicMath<Double,Double> divide = (a,b) -> a / b;

        return divide;

    }

    // function of type Optional to display how Monads work using integers
    public static Optional<Integer> addOptional(Optional<Integer> value1, Optional<Integer> value2) {

        return value1.flatMap(first ->
                value2.flatMap(second ->
                        Optional.of(first + second)));

    }

    // function of type Optional to display how Monads work using Strings
    public static Optional<String> concatOptional(Optional<String> string1, Optional<String> string2) {

        return string1.flatMap(strFirst ->
                string2.flatMap(strSecond ->
                        Optional.of(strFirst + " " + strSecond)));

    }

}
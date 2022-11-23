import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;


public class TestWordStream {

    private static final String PATH = "D:\\GenSparkAssignments\\GenSparkAssignments\\words.txt";

    public static void main(String[] args) throws IOException {

        // Used to eliminate the duplicity of using Path.of()
        Path of = Path.of(PATH);

        System.out.println(Files.lines(of).count());

        System.out.println();

        // Prints out the first 100 words of the file
        Files.lines(of)
                .limit(100)
                .forEach(System.out::println);

        System.out.println();

        // Prints out all words that are over 22 letters long
        Files.lines(of)
                .filter(word -> word.length() >= 22)
                .forEach(System.out::println);

        System.out.println();

        // Prints out a word that is over 22 letters long
        Files.lines(of)
                .filter(word -> word.length() >= 22)
                .findAny().ifPresent(System.out::println);

        System.out.println();

        // Prints out all the words that are palindromes and measures performance
        long performance = System.currentTimeMillis();

        Files.lines(of)
                .filter(TestWordStream::isPalindrome)
                .forEach(System.out::println);

        System.out.println("performance: " + (System.currentTimeMillis() - performance));

        System.out.println();

        // Prints out all the words that are palindromes using parallel and measures performance
        long parallelPerformance = System.currentTimeMillis();

        Files.lines(of)
                .parallel()
                .filter(TestWordStream::isPalindrome)
                .forEach(System.out::println);

        System.out.println("parallel performance: " + (System.currentTimeMillis() - parallelPerformance));

        System.out.println();

        // Prints out the Min Max and Average length of the words
        System.out.println("Shortest word: "
                + Files.lines(of).mapToLong(String::length).summaryStatistics().getMin());
        System.out.println("Longest word: "
                + Files.lines(of).mapToLong(String::length).summaryStatistics().getMax());
        System.out.println("Average word length: "
                + Files.lines(of).mapToLong(String::length).summaryStatistics().getAverage());

        System.out.println();

        // Prints out the list of words by gropings
        Files.lines(of)
                .collect(Collectors.groupingBy(String::length))
                .forEach((key, value) -> System.out.println(key + " letter word(s): " + value));

        System.out.println();

        Files.lines(of)
                .collect(Collectors.groupingBy(String::length, Collectors.summingInt(var -> 1)))
                .forEach((key, value) -> System.out.println(key + " letter word(s) total: " + value));

        System.out.println();

        // Prints the number of letters in the first 100 words
        Files.lines(of)
                .map(TestWordStream::letters).limit(100).forEach(System.out::println);

        System.out.println();

        // Prints the number of times the letter e is used
        System.out.println(Files.lines(of)
                .map(TestWordStream::letters)
                .map(letter -> letter.getOrDefault('e', 0)).reduce(0, Integer::sum));

        System.out.println();

        // Prints all anagrams
        long performanceAnagrams = System.currentTimeMillis();

        System.out.println(Files.lines(of)
                .collect(Collectors.groupingBy(TestWordStream::letters)));

        System.out.println("Performance: " + (System.currentTimeMillis() - performanceAnagrams));

        System.out.println();

        long parallelPerformanceAnagrams = System.currentTimeMillis();

        System.out.println(Files.lines(of).parallel()
                .collect(Collectors.groupingBy(TestWordStream::letters)));

        System.out.println("Parallel Performance: " + (System.currentTimeMillis() - parallelPerformanceAnagrams));

    }

    public static boolean isPalindrome(String word) {

        if(word == null)
            throw new IllegalArgumentException();

        String palindrome = new StringBuilder(word).reverse().toString();

        return word.equals(palindrome);

    }

    public static Map<Character, Integer> letters(String word) {

        return word.toLowerCase().chars()
                .mapToObj(character -> (char) character)
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.summingInt(character -> 1)));

    }

}
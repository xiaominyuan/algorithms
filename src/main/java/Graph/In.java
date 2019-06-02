package Graph;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class In {
    private String name;
    private Scanner scanner;
    private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");
    public In(String name){
        this.name = name;
    }
    public static int[] readInts(String name){
        In in = new In(name);
        String input = in.readAll();
        String[] words = input.split("\\s+");
        int[] ints = new int[words.length];
        for (int i=0; i<words.length; i++){
            ints[i] = Integer.parseInt(words[i]);
        }
        return ints;
    }

    public String readAll(){
        if (! scanner.hasNextLine()){
            return "";
        }
        String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
        scanner.useDelimiter(WHITESPACE_PATTERN);
        return result;
    }

    public int readInt() {
        try {
            return scanner.nextInt();
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from the input stream, "
                    + "but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attemps to read an 'int' value from the input stream, "
                    + "but no more tokens are available");
        }
    }
}

import enums.TokenType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Expr expression = new Expr.Binary(
//                new Expr.Unary(
//                        new Token(TokenType.MINUS, "-", null, 1),
//                        new Expr.Literal(123)),
//                new Token(TokenType.STAR, "*", null, 1),
//                new Expr.Grouping(
//                        new Expr.Literal(45.67)));

//        System.out.println(new AstPrinter().print(expression));

        System.err.println("Logs from your program will appear here!");

        if (args.length < 2) {
            System.err.println("Usage: ./your_program.sh tokenize <filename>");
            System.exit(1);
        }

        String command = args[0];
        String filename = args[1];

        if (!command.equals("tokenize")) {
            System.err.println("Unknown command: " + command);
            System.exit(1);
        }

        String fileContents = "";
        try {
            fileContents = Files.readString(Path.of(filename));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }

        if (fileContents.isEmpty()) {
            System.out.println("EOF  null");
            return;
        }

        Scanner scanner = new Scanner(fileContents);
        List<Token> tokens = scanner.scanTokens();

        for (Token token : tokens) {
            System.out.println(token);
        }

        if (Lox.hadError) {
            System.exit(65);
        }
    }
}

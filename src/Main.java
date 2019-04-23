import Lexer.Lexer;
import Node.Node;
import Parser.Parser;
import Token.Token;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        while(true) {
//            Path p = Paths.get("src", "test.dsl").toAbsolutePath();
//            String data = new String(Files.readAllBytes(p));
//            Lexer l = new Lexer(data);
            Scanner sc = new Scanner(System.in);
            Lexer l = new Lexer(sc.nextLine());

            List<Token> tokens = l.parseInput();
            System.out.println(tokens.toString());

            Parser parser = new Parser();
            Node node = parser.parse(new LinkedList<>(tokens));

            System.out.println(node);
        }
    }
}

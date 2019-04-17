import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Path p = Paths.get("src","test.dsl").toAbsolutePath();
        String data = new String(Files.readAllBytes(p));
        Lexer l = new Lexer(data);
        List<Token> tokens = l.parseInput();
        System.out.println(tokens.toString());
    }
}

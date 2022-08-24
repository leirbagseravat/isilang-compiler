import com.gabriel.exceptions.SemanticException;
import com.gabriel.parser.IsilangLexer;
import com.gabriel.parser.IsilangParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class MainClass {
    public static void main(String[] args) {
        try {
            IsilangLexer lexer;
            IsilangParser parser;

            lexer = new IsilangLexer(CharStreams.fromFileName("input.isi"));
            CommonTokenStream stream = new CommonTokenStream(lexer);
            parser = new IsilangParser(stream);

            parser.prog();
            parser.generateCode();
            System.out.println("Compilation Succesful");

        } catch (SemanticException ex) {
            System.err.println("semantic err " + ex.getMessage());
        }
        catch (Exception ex) {
            System.err.println((ex));
        }
    }
}

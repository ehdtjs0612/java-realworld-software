import java.io.IOException;

public class MainApplication {
    public static void main(String[] args) throws IOException {

        BankTransactionAnalyzer analyzer = new BankTransactionAnalyzer();
        BankStatementParser bankStatementParser = new BankStatementCSVParser();

        analyzer.analyzedFile(bankStatementParser);
    }
}

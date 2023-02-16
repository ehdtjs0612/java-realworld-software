import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzer {
    private static final String RESOURCE = "/Users/yoodongseon/Desktop/유동선/RealWorldSoftware/src/main/resources/bank-data-simple.csv";

    public static void main(String[] args) throws IOException {
        BankStatementCSVParser parser = new BankStatementCSVParser();

        Path path = Path.of(RESOURCE);
        List<String> lines = Files.readAllLines(path);

        List<BankTransaction> bankTransactions = parser.parseLineFromCSV(lines);
        BankTransactionProcessor bankTransactionProcessor = new BankTransactionProcessor(bankTransactions);

        System.out.println("Your transaction total amount is " + bankTransactionProcessor.calculateTotalAmount());
        System.out.println("Your January total amount is " + bankTransactionProcessor.monthCaclulateTotalAmount(Month.JANUARY));
        System.out.println("Your select category amount is " + bankTransactionProcessor.yourCategoryCalculateTotalAmount("Royalties"));
    }
}

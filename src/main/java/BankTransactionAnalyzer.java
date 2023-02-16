import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzer {
    private static final String RESOURCE = "/Users/yoodongseon/Desktop/유동선/RealWorldSoftware/src/main/resources/bank-data-simple.csv";

    public void analyzedFile(BankStatementParser bankStatementParser) throws IOException {
        Path file = Path.of(RESOURCE);
        List<String> lists = Files.readAllLines(file);

        List<BankTransaction> bankTransactions = bankStatementParser.parseLine(lists);
        BankTransactionProcessor processor = new BankTransactionProcessor(bankTransactions);

        printInformation(processor);
    }

    private static void printInformation(BankTransactionProcessor bankTransactionProcessor) {
        System.out.println("Your transaction total amount is " + bankTransactionProcessor.calculateTotalAmount());
        System.out.println("Your January total amount is " + bankTransactionProcessor.monthCaclulateTotalAmount(Month.JANUARY));
        System.out.println("Your select category amount is " + bankTransactionProcessor.yourCategoryCalculateTotalAmount("Royalties"));
    }
}

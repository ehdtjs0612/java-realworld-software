import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private BankTransaction parseFromCSV(String line) {
        String[] colums = line.split(",");

        LocalDate localDate = LocalDate.parse(colums[0], DATE_PATTERN);
        Double amount = Double.parseDouble(colums[1]);

        return new BankTransaction(localDate, amount, colums[2]);
    }

    public List<BankTransaction> parseLineFromCSV(List<String> lines) {
        List<BankTransaction> bankTransactions = new ArrayList<>();

        for(String line : lines) {
            bankTransactions.add(parseFromCSV(line));
        }

        return bankTransactions;
    }
}

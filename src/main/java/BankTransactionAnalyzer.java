import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankTransactionAnalyzer {
    private static final String RESOURCE = "/Users/yoodongseon/Desktop/유동선/RealWorldSoftware/src/main/resources/bank-data-simple.csv";

    public static void main(String[] args) throws IOException {

        Path path = Path.of(RESOURCE);
        List<String> lines = Files.readAllLines(path);
        double total = 0d;
        DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for(String line : lines) {
            String[] colums = line.split(",");
            LocalDate date = LocalDate.parse(colums[0], DATE_PATTERN);
            if(date.getMonth() == Month.JANUARY) {
                double amount = Double.parseDouble(colums[1]);
                total += amount;
            }
        }
        System.out.println("Your transaction total amount is " + total);
    }
}

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface BankStatementParser {

    // CSV, JSON, XML 등 다른 파일을 읽어올수있는 메서드들 정의
    BankTransaction parse(String line);
    public List<BankTransaction> parseLine(List<String> lines);
}

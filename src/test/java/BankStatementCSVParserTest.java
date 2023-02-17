import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BankStatementCSVParserTest {

    private final BankStatementParser statementParser = new BankStatementCSVParser();


    @Test
    public void shouldParseLine() throws Exception {
        // given
        String line = "17-02-2023,50,Test";

        // when
        BankTransaction result = statementParser.parse(line);
        BankTransaction expected = new BankTransaction(LocalDate.of(2023, Month.FEBRUARY, 17), 50d, "Test");

        // then
        assertThat(result).isEqualTo(expected);
    }
}
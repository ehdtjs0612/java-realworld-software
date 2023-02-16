import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;

public class BankTransactionDAO {
    // DAO (Data Access Object)
    // DAO는 도메인 객체를 저장하는 데이터베이스와 상호작용할때 주로 쓰인다.
    // 데이터베이스의 데이터 소스로의 접근을 추상화하고 캡슐화한다.
    // 객체를 식별하는 일종의 id값이 필요하다

    public BankTransaction create(LocalDate date, double amount, String description) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    public BankTransaction read(long id) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    public BankTransaction update(long id) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    public BankTransaction delete(long id) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }
}

package repositories;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
    void save(T object) throws SQLException;
    void delete(int id);
    void update(T object) throws SQLException;
    T getObject(int id);
    List<T> getListOfObjects() throws SQLException;

}

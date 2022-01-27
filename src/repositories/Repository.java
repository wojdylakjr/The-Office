package repositories;

import java.util.List;

public interface Repository<T> {
    void save(T object);
    void delete(int id);
    void update(int id);
    T getObject(int id);
    List<T> getListOfObjects();

}

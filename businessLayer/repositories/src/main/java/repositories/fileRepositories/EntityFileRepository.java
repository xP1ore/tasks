package repositories.fileRepositories;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface EntityFileRepository<T> {
    public void create(T entity) throws IOException;
    public void update(T entity) throws IOException;
    public T getById(Long id) throws IOException;
    public List<T> getAll() throws IOException;

    public void deleteById(Long id) throws IOException;

    public void saveAll(List<T> entities) throws IOException;

}

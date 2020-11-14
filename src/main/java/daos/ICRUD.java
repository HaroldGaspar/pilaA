package daos;

import java.util.List;

public interface ICRUD<T>
{
    Boolean insert(T p0);    
    Boolean update(T p0);    
    T selectById(Integer p0);    
    List<T> selectAll();    
    void delete(Object p0);    
    void close();
}
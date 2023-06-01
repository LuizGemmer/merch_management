package orm;

import java.util.ArrayList;
import java.util.HashMap;

public interface IORM<T> {
    
    public ArrayList<T> getAll();
    
    public T getById(int id);
    
    public void saveNew(T object);
    
    public void update(T object);
    
    public void delete(T object);
    
    public void delete(int id);
    
    public ArrayList<T> query(String whereClause);
    
    public String[][] toJTable(String whereClause);
    
    public String[] getJTableColumns();
    
    public String saveForm(HashMap<String, Object> fieldSetMap);
    
}

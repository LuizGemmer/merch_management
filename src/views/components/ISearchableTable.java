package views.components;

import java.util.ArrayList;
import orm.IORM;

/**
 *
 * @author rg
 */
public interface ISearchableTable {
    
    public void setORM(IORM orm);
    
    public void updateTable(String term);
    
    public Object getSelectedItem();
}

package Entity;

public interface IEntity<T> {
    
    public FieldBuilderTemplate[] toEditForm();
    
    public int getId();
    
    public FieldBuilderTemplate[] toCreateForm();    
}

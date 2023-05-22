package Entity;

public interface IEntity<T> {
    
    public FieldBuilderTemplate[] toEditForm();
    
    public FieldBuilderTemplate[] toCreateForm();

}

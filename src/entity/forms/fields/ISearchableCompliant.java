/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package entity.forms.fields;


/**
 *
 * @author rg
 */
public interface ISearchableCompliant<IEntity>{
    public IEntity selectAction();
    
    public void show(IRelationshipField returnField);
}

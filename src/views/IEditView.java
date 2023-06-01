/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package views;

import Entity.IEntity;
import orm.IORM;

/**
 *
 * @author rg
 */
public interface IEditView {
    
    public void setEntity(IEntity entity);
    
    public void setIsEditable(boolean editable);
    
    public void setIsModeNew(boolean isNew);
    
    public void setWindowTitle(String title);
    
    public void setORM(IORM orm);
    
    public void build();
    
    public void save();
    
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package views;

import Entity.forms.FormBase;

/**
 *
 * @author rg
 */
public interface IEditView {
    
    public void setWindowTitle(String title);
    
    public void build();
    
    public void save();
    
    public void setForm(FormBase form);
}


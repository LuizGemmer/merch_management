/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package views.components;

import javax.swing.AbstractAction;

/**
 *
 * @author rg
 */
public interface IFormField {
    
    public boolean validateField();
    
    public boolean isRequired();
    
    public boolean wasModified();
    
    public String getLabel();
    
    public Object getFieldContent();
    
}

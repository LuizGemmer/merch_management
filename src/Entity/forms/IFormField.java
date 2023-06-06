/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Entity.forms;

import java.awt.Component;
import javax.swing.JComponent;

/**
 *
 * @author rg
 */
public interface IFormField {
    
    public Validator getValidator();
    
    public void setValidator(Validator validator) ;

    public void setLabel(String Label);

    public String getLabel();

    public JComponent getField();

    public void setField(JComponent field);

    public Object getInitialValue();

    public void setInitialValue(Object initialValue);

    public boolean isRequired();

    public void setRequired(boolean required);
    
    public String validateField();
    
    public boolean wasModified();
    
    public abstract Object getFieldContent();
}

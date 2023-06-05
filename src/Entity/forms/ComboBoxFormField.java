/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.forms;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author rg
 */
public class ComboBoxFormField extends BaseField {

    private DefaultComboBoxModel comboModel;
    
    public ComboBoxFormField(Object[] comboValues) {
        this.comboModel = new DefaultComboBoxModel(comboValues);
        super.setField(new JComboBox(comboModel));
    }
      
    @Override
    public Object getFieldContent() {
        JComboBox field = (JComboBox) super.getField();
        return field.getSelectedItem();
    }
    
}

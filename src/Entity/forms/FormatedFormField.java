/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.forms;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author rg
 */
public class FormatedFormField extends BaseField{
    
    private MaskFormatter formatter;
    
    public FormatedFormField() {
        this.setField(new JFormattedTextField());
    }

    @Override
    public Object getFieldContent() {
        /**
         * @Returns the field text
         */
        JFormattedTextField field =  (JFormattedTextField) this.getField();
        return field.getText();
    }

    public MaskFormatter getFormatter() {
        /**
         * @Retuns the MaskFormatter for the field
         */
        return formatter;
    }

    public void setFormatter(MaskFormatter formatter) {
        /**
         * Sets the maskFormatter for the field
         */
        this.formatter = formatter;
        this.formatter.install(
                (JFormattedTextField) this.getField()
        );
    }

    @Override
    public void setInitialValue(Object initialValue) {
        super.setInitialValue(initialValue);
        ((JFormattedTextField) this.getField()).setText((String) initialValue);
    }
}

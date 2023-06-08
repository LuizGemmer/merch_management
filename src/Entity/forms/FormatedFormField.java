/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.forms;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author rg
 */
public class FormatedFormField extends BaseField{
    
    private MaskFormatter formatter;
    
    public FormatedFormField() {
        JFormattedTextField field = new JFormattedTextField();
        this.setField(field);
    }

    @Override
    public Object getFieldContent() {
        /**
         * @Returns the field text
         */
        JFormattedTextField field =  (JFormattedTextField) this.getField();
        try {
            field.commitEdit();
        } catch (ParseException ex) {
            Logger.getLogger(FormatedFormField.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("commit" + field.getValue());
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

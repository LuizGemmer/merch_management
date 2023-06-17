/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity.forms.fields;

import javax.swing.JComponent;
import utils.Formating;

/**
 *
 * @author rg
 */
public abstract class BaseField implements IFormField {
    
    private JComponent component;
    private String label;
    private Object initialValue;
    private Validator validator = (String value) -> {return "";};
    private boolean required = false; 

    @Override
    public Validator getValidator() {
        return this.validator;
    }

    @Override
    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public JComponent getField() {
        return this.component;
    }

    @Override
    public void setField(JComponent field) {
        this.component = field;
    }

    @Override
    public Object getInitialValue() {
        return this.initialValue;
    }

    @Override
    public void setInitialValue(Object initialValue) {
        this.initialValue = initialValue;
    }

    @Override
    public boolean isRequired() {
        return this.required;
    }

    @Override
    public void setRequired(boolean required) {
        this.required = required;
    }

    @Override
    public String validateField(){
        /**
         * Validates the field based on the "required" class field and in
         * the validate method of the validator class.
         * @return true if the field passes validation, false otherwise.
         */
        StringBuilder validatorString = new StringBuilder();
        
        if (
                this.isRequired() && 
                Formating.clean((String) this.getFieldContent()).equals("")
            ) {
            validatorString.append(this.getLabel());
            validatorString.append( ": Esse campo é obrigatório");
        } else if (!this.validator.validate((String) this.getFieldContent()).equals("")) {
            validatorString.insert(0, this.getLabel()+ ": ");
            validatorString.append(this.validator.validate((String) this.getFieldContent()));
        }
        
        return validatorString.toString();
    }

    @Override
    public boolean wasModified() {
        /**
         * Compares the field initial value and the actual value
         * @returns true if initial and actual field values are different
         */
        return !(
                this.initialValue.equals(this.getFieldContent())
        );
    }

    @Override
    public abstract Object getFieldContent();
    
    
    public String getDisplayLabel() {
        /**
         * @returns the label field of the class, prefixed with a *
         * if the field is required
         */
        StringBuilder displayLabel = new StringBuilder(this.getLabel());
        if (this.isRequired()) {
            displayLabel.insert(0, "* ");
        }
        return displayLabel.toString();
    }
}

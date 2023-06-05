/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.forms;

import javax.swing.JComponent;

/**
 *
 * @author rg
 */
public abstract class BaseField implements IFormField {
    
    private JComponent component;
    private String label;
    private Object initialValue;
    private Validator validator;
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
    public boolean validateField() {
        /**
         * Validates the field based on the "required" class field and in
         * the validate method of the validator class.
         * @returns true if the field passes validation, false otherwise.
         */
        return !(
                this.isRequired() && this.getFieldContent().equals("")
        ) && this.validator.validate(new String[] {});
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

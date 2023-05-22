/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author rg
 */
public class FieldBuilderTemplate {
    private String label;
    private String type;
    private String value = "";
    private Object[] choices;
    private boolean required;

    public FieldBuilderTemplate(String label, String value, String type, Object[] choices, boolean required) {
        this.label = label;
        this.type = type;
        this.choices = choices;
        this.required = required;
        this.value = value;
        
        if (this.choices == null) this.choices = new Object[] {};
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Object[] getChoices() {
        return choices;
    }

    public void setChoices(Object[] choices) {
        this.choices = choices;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }    
}

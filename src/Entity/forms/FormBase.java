/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.forms;

import Entity.IEntity;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import orm.IORM;

/**
 *
 * @author rg
 */
public abstract class FormBase {
    
    private HashMap<String, BaseField> fields = new HashMap<>();
    private IEntity item;
    private IORM orm;
    
    public BaseField addField(String label, BaseField field) {
        /**
         * Adds a field to the fields hash map, using the label as key
         * @Returns the field passed, for further modifications
         */
        field.setLabel(label);
        this.fields.put(label, field);
        return field;
    }
    
    public ArrayList<JPanel> build() {
        /**
         * Converts all the fields in the form to JPanels with a label and a
         * JCompoenent. Shows all fields.
         * @Returns an array with JPanels, each with a JTextLabel and a component
         */
        return this.build(this.fields.keySet());
    }
    
    public ArrayList<JPanel> build(Set fieldSet) {
        /**
         * Converts all the fields in the form to JPanels with a label and a
         * JCompoenent
         * @Params set of strings with the fields to be shown
         * @Returns an array with JPanels, each with a JTextLabel and a component
         */
        ArrayList<JPanel> panels = new ArrayList();
        
        for (String key : fields.keySet()) {
            if (fieldSet.contains(key)) {
                BaseField field = fields.get(key);

                JPanel panel = new JPanel();
                BoxLayout layout = new BoxLayout(panel, BoxLayout.X_AXIS);

                panel.setLayout(layout);
                panel.setMaximumSize(new Dimension(500, 50));
                panel.setPreferredSize(new Dimension(300, 50));
                panel.setMinimumSize(new Dimension(100, 30));

                JLabel fieldLabel = new JLabel(field.getDisplayLabel());
                JComponent formField = this.fields.get(key).getField();

                panel.add(fieldLabel);
                panel.add(formField);
                panels.add(panel);            
            }
        }
        
        return panels;
    }
    
    protected boolean validateFields() throws Exception {
        /**
         * Validates all fields in the form
         * @Returns true if all fields are valid
         * @Throws Exception with the field error message if there's a validation error
         */
        for (String key : fields.keySet()) {
            BaseField field = this.fields.get(key);
            String fieldValidation = field.validateField();
            
            if (!fieldValidation.equals("")) {
                throw new Exception(fieldValidation);
            }
        }
        return true;
    };
    
    public boolean wasModified() {
        /**
         * Verifies if any field in the form was modified
         * @Return true if there's a modification, false otherwise
         */
        for (String key : fields.keySet()) {
            BaseField field = this.fields.get(key);
            if (field.wasModified()) {
                return true;
            }
        }
        return false;
    }
    
    public void setup(IEntity entity, IORM orm) {
        this.setItem(entity);
        this.setOrm(orm);
    }

    public HashMap<String, BaseField> getFields() {
        return fields;
    }

    public void setFields(HashMap<String, BaseField> fields) {
        this.fields = fields;
    }

    public IEntity getItem() {
        return item;
    }

    public void setItem(IEntity item) {
        this.item = item;
    }

    public IORM getOrm() {
        return orm;
    }

    public void setOrm(IORM orm) {
        this.orm = orm;
    }
    
    public abstract boolean validateForm() throws Exception;
    
    public abstract boolean saveForm();
    
    public abstract void populateForm();
}

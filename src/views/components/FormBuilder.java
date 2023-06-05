/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.components;

import Entity.forms.FormTextField;
import Entity.FieldBuilderTemplate;
import Entity.IEntity;
import Entity.forms.IFormField;

/**
 *
 * @author rg
 */
public class FormBuilder {
    
    private IEntity entity;
    private boolean isEditMode;
    private FieldBuilderTemplate[] fieldList;
    
    public FormBuilder(IEntity entity, boolean isEditMode) {
        this.entity = entity;
        this.isEditMode = isEditMode;
        
        if (this.isEditMode) {
            this.fieldList = this.entity.toEditForm();
        } else {
           this.fieldList = this.entity.toCreateForm();
        }
    }
    
    public IFormField[] Build() {
        IFormField[] fields = new IFormField[ this.fieldList.length ];
        
        for(int i = 0; i < this.fieldList.length; i++) {
            IFormField correctField = getFieldFromTemplate(this.fieldList[i]);
            fields[i] = correctField;
            System.out.println("");
        }
        
        return fields;
    }
    
    private IFormField getFieldFromTemplate(FieldBuilderTemplate fbt) {
        IFormField field;
        if (fbt.getChoices().length == 0) {
            field = new FormTextField(fbt.getLabel(), fbt.getValue(), fbt.getType(), fbt.isRequired());
        } else {
            field = new FormTextField(fbt.getLabel(), fbt.getValue(), fbt.getType(), fbt.isRequired());
        }
        
        return field;
    }
  
}

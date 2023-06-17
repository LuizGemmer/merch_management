/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.forms;

import entity.IEntity;
import entity.forms.FormBase;
import entity.forms.fields.ForeingKeyField;
import orm.IORM;

/**
 *
 * @author rg
 */
public class ForeingForm extends FormBase{
    
    @Override
    public boolean validateForm() throws Exception {
        return true;
    }
    
    @Override
    public void setup(IEntity entity, IORM orm) {
        super.setup(entity, orm);
    }

    @Override
    public boolean saveForm() {
        return true;
    }

    @Override
    public void populateForm() {
        this.addField("teste", new ForeingKeyField(this.getOrm()));
    }
    
}

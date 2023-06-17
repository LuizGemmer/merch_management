/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.forms;

import entity.Address;
import entity.IEntity;
import entity.forms.fields.BaseField;
import entity.forms.FormBase;
import entity.forms.fields.FormatedFormField;
import utils.Formating;
import orm.AddressORM;
import orm.IORM;

/**
 *
 * @author rg
 */
public final class AddressForm extends FormBase {
    
    public AddressForm(Address address) {
        this.setup(address, new AddressORM());
        this.populateForm();
    }
    
    public AddressForm() {
        Address address = new Address();
        this.setup(address, new AddressORM());
        this.populateForm();
    }

    @Override
    public void setup(IEntity e, IORM o) {
        /**
         * Setup form and form fields
         */
        
        Address address;
        if (e == null) address = new Address();
        else address = (Address) e;
        
        if (address.getId() == 0) this.setFormName("Novo Endereço");
        else this.setFormName("Editar Endereço");
        
        super.setup(address, o);
        
        BaseField description = this.addField("Descrição", new FormatedFormField());
        description.setRequired(true);
        
        FormatedFormField postalCode = 
                (FormatedFormField) this.addField(
                        "CEP", 
                        new FormatedFormField()
                );
        postalCode.setRequired(true);
        postalCode.setFormatter(Formating.getPostalCodeMask());
    }
    
    @Override
    public boolean validateForm() throws Exception {
        super.validateFields();
        return true;
    }

    @Override
    public boolean saveForm() {
        Address address = (Address) this.getItem();
        address.setPostalCode(
                (String) this.getFields().get("CEP").getFieldContent()
        );
        
        address.setDescricao(
                (String) this.getFields().get("Descrição").getFieldContent()
        );
        
        if (address.getId() == 0) this.getOrm().saveNew(address);
        else this.getOrm().update(address);
        
        return true;
    }

    @Override
    public void populateForm() {
        Address address = (Address) this.getItem();
        this.getFields()
                .get("Descrição")
                .setInitialValue(address.getDescricao());
        
        this.getFields()
                .get("CEP")
                .setInitialValue(address.getPostalCode());
    }
    
    
}

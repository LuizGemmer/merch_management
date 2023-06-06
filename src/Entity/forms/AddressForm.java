/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.forms;

import Entity.Address;
import Entity.IEntity;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;
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
        
        super.setup(address, o);
        
        BaseField description = this.addField("Descrição", new FormatedFormField());
        description.setRequired(true);
        
        System.out.println("field " + description.getLabel());
        System.out.println("map " + this.getFields().get("Descrição").getLabel());

        
        FormatedFormField postalCode = 
                (FormatedFormField) this.addField(
                        "CEP", 
                        new FormatedFormField()
                );
        postalCode.setRequired(true);
        try {
            postalCode.setFormatter(new MaskFormatter("#####-###"));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
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

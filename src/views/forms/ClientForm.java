/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.forms;

import Entity.Client;
import Entity.IEntity;
import Entity.forms.BaseField;
import Entity.forms.FormBase;
import Entity.forms.FormatedFormField;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;
import orm.ClientORM;
import orm.IORM;
import utils.Formating;
import utils.Validation;

/**
 *
 * @author rg
 */
public class ClientForm extends FormBase {
    
    public ClientForm(Client client) {
        this.setup(client, new ClientORM());
        this.populateForm();
    }
    
    public ClientForm() {
        Client client = new Client();
        this.setup(client, new ClientORM());
        this.populateForm();
    }

    @Override
    public void setup(IEntity e, IORM o) {
        /**
         * Setup form and form fields
         */
        
        Client client;
        if (e == null) client = new Client();
        else client = (Client) e;
        
        if (client.getId() == 0) this.setFormName("Novo Cliente");
        else this.setFormName("Editar Cliente");
        
        super.setup(client, o);
        
        BaseField name = this.addField("Nome", new FormatedFormField());
        name.setRequired(true);
        
        FormatedFormField email = (FormatedFormField) this.addField("Email", new FormatedFormField());
        email.setRequired(true);
        email.setValidator((value) -> {
            if (Validation.validateEmail(value)) return "";
            else return "Email especificado é inválido!";
        });
       
        FormatedFormField cpf = (FormatedFormField) this.addField("CPF", new FormatedFormField());
        cpf.setRequired(true);
        cpf.setFormatter(Formating.getCPFMask());
        cpf.setValidator((value) -> {
            if (Validation.validateCPF(value)) return "";
            else return "Email especificado é inválido!";
        });

        FormatedFormField phone = (FormatedFormField) this.addField("Telefone", new FormatedFormField());
        phone.setRequired(true);
        phone.setFormatter(Formating.getPhoneMask());
        phone.setValidator((value) -> {
            if (Validation.validatePhoneNumber(value)) return "";
            else return "Email especificado é inválido!";
        });
    }
    
    @Override
    public boolean validateForm() throws Exception {
        super.validateFields();
        return true;
    }

    @Override
    public boolean saveForm() {
        Client client = (Client) this.getItem();
   
        client.setName(
                (String) this.getFields().get("Nome").getFieldContent()
        );
        client.setEmail(
                (String) this.getFields().get("Email").getFieldContent()
        );
        client.setCpf(
                (String) this.getFields().get("CPF").getFieldContent()
        );
        client.setPhone(
                (String) this.getFields().get("Telefone").getFieldContent()
        );
        
        if (client.getId() == 0) this.getOrm().saveNew(client);
        else this.getOrm().update(client);
        
        return true;
    }

    @Override
    public void populateForm() {
        Client client = (Client) this.getItem();
        this.getFields()
                .get("Nome")
                .setInitialValue(client.getName());
        
        this.getFields()
                .get("Email")
                .setInitialValue(client.getEmail());
        
        this.getFields()
                .get("CPF")
                .setInitialValue(client.getCpf());
        
        this.getFields()
                .get("Telefone")
                .setInitialValue(client.getPhone());

    }
}

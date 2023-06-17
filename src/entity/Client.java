/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rg
 */
public class Client implements IEntity<Client>{
    private int id;
    private String name;
    private String email;
    private String cpf;
    private String phone;

    public Client(ResultSet queryResult) throws SQLException {
        // Creates a address from a query set from the database
        this.setId(queryResult.getInt("id"));
        this.setName(queryResult.getString("nome"));
        this.setEmail(queryResult.getString("email"));
        this.setCpf(queryResult.getString("cpf"));
        this.setPhone(queryResult.getString("telefone"));
    }

    public Client() {}

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public String[] toArray() {
        return new String[] {
            String.valueOf(this.getId()), 
            this.getName(),
            this.getEmail(),
            this.getCpf(),
            this.getPhone(),        
        };
    }
}

package Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public final class Address implements IEntity<Address>{
    private int id;
    private String descricao;
    private String postalCode;

    public Address(ResultSet queryResult) throws SQLException {
        // Creates a address from a query set from the database
        this.setId(queryResult.getInt("id"));
        this.setDescricao(queryResult.getString("descricao"));
        this.setPostalCode(queryResult.getString("cep"));
    }

    public Address() {}
    
    public Address(HashMap<String, Object> fieldValueSet) {
        this.setId((int) fieldValueSet.get("Id"));
        this.setDescricao((String) fieldValueSet.get("Descrição"));
        this.setPostalCode((String) fieldValueSet.get("CEP"));
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    public String[] toArray() {
        return new String[] {
            String.valueOf(this.getId()), 
            this.getDescricao(),
            String.valueOf(this.getPostalCode())
        };
    }

    @Override
    public FieldBuilderTemplate[] toEditForm() {
        return new FieldBuilderTemplate[] {
            new FieldBuilderTemplate("Descrição", this.getDescricao(), "String", null, true), 
            new FieldBuilderTemplate("CEP", String.valueOf(this.getPostalCode()), "String", null, true)  
        };
    }

    @Override
    public FieldBuilderTemplate[] toCreateForm() {
        return toEditForm();
    }
}

package Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Cidade implements IEntity<Cidade>{
    private int id;
    private String descricao;

    public Cidade(ResultSet queryResult) throws SQLException {
        this.setId(queryResult.getInt("id"));
        this.setDescricao(queryResult.getString("descricao"));
    }

    public Cidade() {}

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
    
    public String[] toArray() {
        return new String[] {
            String.valueOf(this.getId()), 
            this.getDescricao()
        };
    }

    @Override
    public FieldBuilderTemplate[] toEditForm() {
        return new FieldBuilderTemplate[] {
            new FieldBuilderTemplate("Descriçao", this.getDescricao(), "String", null, true)  
        };
    }

    @Override
    public FieldBuilderTemplate[] toCreateForm() {
        return toEditForm();
    }
}

package orm;

import Entity.Cidade;
import database.ConexaoBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CidadeORM implements IORM<Cidade>{

    @Override
    public ArrayList<Cidade> getAll() {
        return query("");
    }

    @Override
    public Cidade getById(int id) {
        String sql = "select * from cidade where id = " + id + ";";
        Cidade cidade = new Cidade();
        
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet querySet = st.executeQuery(sql);
            while (querySet.next()){
                cidade = new Cidade(querySet);
            }
        } catch (SQLException e) {
            System.out.println("sql: " + sql);
            System.out.println(e.getMessage());
        }
        
        return cidade;
    }

    @Override
    public void saveNew(Cidade object) {

    }

    @Override
    public void update(Cidade object) {

    }

    @Override
    public ArrayList<Cidade> query(String whereClause) {
        ArrayList<Cidade> cidades = new ArrayList<Cidade>();
        String sql = "select * from cidade" + whereClause + ";";

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet querySet = st.executeQuery(sql);
            while (querySet.next()){
                cidades.add(new Cidade(querySet));
            }
        } catch (SQLException e) {
            System.out.println("sql: " + sql);
            System.out.println(e.getMessage());
        }

        return cidades;
    }

    @Override
    public String[][] toJTable(String whereClause) {
        ArrayList<Cidade> linkCidades = this.getAll();
                
        String[][] cidades = new String
                [linkCidades.size()]
                [this.getJTableColumns().length];
        
        for (int i = 0; i < linkCidades.size(); i++) {
            cidades[i] = linkCidades.get(i).toArray();
        }
        
        return cidades;
    }

    @Override
    public String[] getJTableColumns() {
        return new String[] {
            "Id",
            "Nome"
        };
    }
}

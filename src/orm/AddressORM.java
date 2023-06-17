package orm;

import entity.Address;
import database.ConexaoBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddressORM implements IORM<Address>{

    @Override
    public ArrayList<Address> getAll() {
        return query("");
    }

    @Override
    public Address getById(int id) {
        String sql = "select * from endereco where id = " + id + ";";
        Address address = new Address();
        
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet querySet = st.executeQuery(sql);
            while (querySet.next()){
                address = new Address(querySet);
            }
        } catch (SQLException e) {
            System.out.println("sql: " + sql);
            System.out.println(e.getMessage());
        }
        
        return address;
    }

    @Override
    public void saveNew(Address object) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "insert into endereco values (default, '" 
                    + object.getDescricao() + "', '" 
                    + object.getPostalCode() + "');";
            st.executeUpdate(sql);
            System.out.println(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Address object) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "update endereco set " 
                    + "descricao='" + object.getDescricao() + "', " 
                    + "cep='" + object.getPostalCode() + "' " 
                    + "where id=" + object.getId();
            System.out.println(sql);
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Address> query(String whereClause) {
        ArrayList<Address> addresses = new ArrayList();
        String sql = "select * from endereco" + whereClause + ";";

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet querySet = st.executeQuery(sql);
            while (querySet.next()){
                addresses.add(new Address(querySet));
            }
        } catch (SQLException e) {
            System.out.println("sql: " + sql);
            System.out.println(e.getMessage());
        }

        return addresses;
    }

    @Override
    public String[][] toJTable(String whereClause) {
        ArrayList<Address> linkAddresses = this.getAll();
                
        String[][] Addresses = new String
                [linkAddresses.size()]
                [this.getJTableColumns().length];
        
        for (int i = 0; i < linkAddresses.size(); i++) {
            Addresses[i] = linkAddresses.get(i).toArray();
        }
        
        return Addresses;
    }

    @Override
    public String[] getJTableColumns() {
        return new String[] {
            "Id",
            "Nome",
            "CEP"
        };
    }

    @Override
    public void delete(Address object) {
        this.delete(object.getId());
    }

    @Override
    public void delete(int id) {
        Statement st;
        try {
            st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "delete from endereco where id=" + id + ";" ;
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AddressORM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

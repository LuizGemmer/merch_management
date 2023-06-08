package orm;

import Entity.Client;
import database.ConexaoBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientORM implements IORM<Client>{

    @Override
    public ArrayList<Client> getAll() {
        return query("");
    }

    @Override
    public Client getById(int id) {
        String sql = "select * from cliente where id = " + id + ";";
        Client client = new Client();
        
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet querySet = st.executeQuery(sql);
            while (querySet.next()){
                client = new Client(querySet);
            }
        } catch (SQLException e) {
            System.out.println("sql: " + sql);
            System.out.println(e.getMessage());
        }
        
        return client;
    }

    @Override
    public void saveNew(Client object) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "insert into cliente values (default, '" 
                    + object.getName() + "', '"
                    + object.getEmail() + "', '" 
                    + object.getCpf() + "', '" 
                    + object.getPhone() + "');";
            st.executeUpdate(sql);
            System.out.println(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Client object) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "update cliente set " 
                    + "name='" + object.getName()+ "', " 
                    + "cpf='" + object.getCpf() + "' " 
                    + "telefone='" + object.getPhone()+ "' " 
                    + "email='" + object.getEmail() + "' " 
                    + "where id=" + object.getId();
            System.out.println(sql);
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Client> query(String whereClause) {
        ArrayList<Client> client = new ArrayList();
        String sql = "select * from cliente" + whereClause + ";";

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet querySet = st.executeQuery(sql);
            while (querySet.next()){
                client.add(new Client(querySet));
            }
        } catch (SQLException e) {
            System.out.println("sql: " + sql);
            System.out.println(e.getMessage());
        }

        return client;
    }

    @Override
    public String[][] toJTable(String whereClause) {
        ArrayList<Client> linkClients = this.getAll();
                
        String[][] clients = new String
                [linkClients.size()]
                [this.getJTableColumns().length];
        
        for (int i = 0; i < linkClients.size(); i++) {
            clients[i] = linkClients.get(i).toArray();
        }
        
        return clients;
    }

    @Override
    public String[] getJTableColumns() {
        return new String[] {
            "Id",
            "Nome",
            "Email",
            "CPF",
            "Telefone"
        };
    }

    @Override
    public void delete(Client object) {
        this.delete(object.getId());
    }

    @Override
    public void delete(int id) {
        Statement st;
        try {
            st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "delete from cliente where id=" + id + ";" ;
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClientORM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

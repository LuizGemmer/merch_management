/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity.forms.fields;

import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import orm.IORM;

/**
 *
 * @author rg
 */
public class ForeingKeyField
extends BaseField
implements IRelationshipField
{
    private JButton btn_search;
    private FormatedFormField itemIdField;
    private FormatedFormField itemNameField; 
    private ISearchableCompliant modalWindow;
    
    private IORM orm;
    
    public ForeingKeyField(IORM orm) {
        this.orm = orm;
        itemIdField = new FormatedFormField();
        itemIdField.setField(new JFormattedTextField());
        btn_search = new JButton("Buscar");
        itemNameField = new FormatedFormField();
        itemNameField.setField(new JFormattedTextField());
        
        this.initComponents();
    }
    
    /**
     * @return the id of an item displayed on the item id field.
     */
    @Override
    public Object getFieldContent() {
        return this.itemIdField.getFieldContent();
    }
    
    /**
     * Set the text of the item id to equal i
     * searches the database and set the name field equals to the toString method of the entity
     * @param i the id of the item
     */
    public void setFieldContent(int i) {
        JFormattedTextField field = (JFormattedTextField) this.itemIdField.getField();
        field.setText(String.valueOf(i));
        this.idFieldLostFocus();
    }
    
    /**
     * Opens the defined modal window (implements ISearchableCompliant)
     */
    public void btn_searchOnAction() {
        this.modalWindow.show(this);
    };
    
    /**
     * Updates the item name field when the id field loses focus
     */
    private void idFieldLostFocus() {
        JFormattedTextField field = (JFormattedTextField) itemNameField.getField();
        field.setText(orm.getById(Integer.parseInt((String) this.getFieldContent())).toString());
    }
    
    public void initComponents() {
        btn_search.addActionListener((e) -> {btn_searchOnAction();});
        btn_search.setMinimumSize(new Dimension(80, 40));
        btn_search.setMaximumSize(new Dimension(80, 50));
        btn_search.setPreferredSize(new Dimension(80, 45));
        
        itemIdField.getField().setMinimumSize(new Dimension(50, 40));
        itemIdField.getField().setMaximumSize(new Dimension(70, 50));
        itemIdField.getField().setPreferredSize(new Dimension(60, 45));
        
        JFormattedTextField itemNameComponent = (JFormattedTextField) itemNameField.getField();
        itemNameComponent.setEditable(false);
        itemNameComponent.setFocusable(false);
        itemNameField.getField().setMinimumSize(new Dimension(300, 40));
        itemNameField.getField().setMaximumSize(new Dimension(360, 50));
        itemNameField.getField().setPreferredSize(new Dimension(200, 45));
        
        JFormattedTextField itemIdComponent = (JFormattedTextField) itemIdField.getField();
        itemIdComponent.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent evt) {
                idFieldLostFocus();
            }
        });
        
        JPanel container = new JPanel();
        BoxLayout layout = new BoxLayout(container, BoxLayout.X_AXIS);
        container.setMinimumSize(new Dimension(300, 40));
        container.setMaximumSize(new Dimension(500, 50));
        container.setPreferredSize(new Dimension(500, 50));

        container.add(itemIdComponent);
        container.add(itemNameComponent);
        container.add(btn_search);
        
        this.setField(container);
    }

    @Override
    public void setSearchResult(int i) {
        this.setFieldContent(i);
    }
}

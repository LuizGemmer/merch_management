/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestaomercadoria;

import database.ConexaoBD;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import views.MainView;

/**
 *
 * @author rg
 */
public class GestaoMercadoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (new ConexaoBD().getInstance().getConnection() != null) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GestaoMercadoria.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(GestaoMercadoria.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(GestaoMercadoria.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(GestaoMercadoria.class.getName()).log(Level.SEVERE, null, ex);
            }
            new MainView().setVisible(true);
        }
    }
    
}

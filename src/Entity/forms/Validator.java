/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.forms;

/**
 *
 * @author rg
 */
abstract class Validator {
    /**
     * Define the custom validation rules for a given form field
     * @param args anything needed to validate
     * @return null if valid, a error string otherwise
     */
    public abstract String validate(String[] args);
}

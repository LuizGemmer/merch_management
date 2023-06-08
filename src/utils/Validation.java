/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Fabricio Pretto
 */
public class Validation {

    private static final int[] cpfWheight = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] cnpjWheight = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    public static boolean validateCPF(String cpf) {
        String cleanedCPF = Formating.clean(cpf);
        if ((cleanedCPF == null) || (cleanedCPF.length() != 11)) {
            return false;
        }
        Integer digito1 = calcularDigito(cleanedCPF.substring(0, 9), cpfWheight);
        Integer digito2 = calcularDigito(cleanedCPF.substring(0, 9) + digito1, cpfWheight);
        return cleanedCPF.equals(cleanedCPF.substring(0, 9) + digito1.toString() + digito2.toString());
    }

    public static boolean validateCNPJ(String cnpj) {
        String cleanedCNPJ = Formating.clean(cnpj);
        if ((cleanedCNPJ == null) || (cleanedCNPJ.length() != 14)) {
            return false;
        }
        Integer digito1 = calcularDigito(cleanedCNPJ.substring(0, 12), cnpjWheight);
        Integer digito2 = calcularDigito(cleanedCNPJ.substring(0, 12) + digito1, cnpjWheight);
        return cleanedCNPJ.equals(cleanedCNPJ.substring(0, 12) + digito1.toString() + digito2.toString());
    }
    
    public static boolean validateEmail(String email) {
        // TODO
        return true;
    }

    public static boolean validateDateDMY (int d, int m, int a) {
        
        boolean correto = true;
        
        int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (a < 0 || m < 1 || m > 12) {
            correto = false;
        } else {
            // valida o dia
            if (a % 4 == 0 && (a % 100 != 0 || a % 400 == 0)) {
                dias[1] = 29;
            }
            if (d < 1 || d > dias[m - 1]) {
                correto = false;
            }
        }
        return (correto);
    }

    public static boolean validateFormatedDate (String dataComFormato) {
        String[] data = dataComFormato.split("/");
        return (validateDateDMY(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
    }

    public static boolean validatePhoneNumber(String phone) {
        return phone.trim().length() < 15;
    }
}

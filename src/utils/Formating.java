package utils;

import java.text.*;
import java.util.Date;
import java.util.Locale;
import javax.swing.text.*;

/**
 * Adapted
 * @author Professor
 */
public class Formating {

    static DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

    public static MaskFormatter getMask(String mask) {
        try {
            MaskFormatter mf = new MaskFormatter(mask);
            mf.setAllowsInvalid(false);
            return mf;
        } catch (ParseException e) {
            return null;
        }
    }
    
    public static MaskFormatter getDecimalFormatMask() {
        return getMask("0,00");
    }

    public static MaskFormatter getPhoneMask() {
        return getMask("(##) #####-####");
    }

    public static MaskFormatter getCNPJMask() {
        return getMask("##.###.###/####-##");
    }

    public static MaskFormatter getCPFMask() {
        return getMask("###.###.###-##");
    }
    
    public static MaskFormatter getPostalCodeMask() {
        return getMask("#####-###");
    }

    public static MaskFormatter getDateMask() {
        return getMask("##/##/####");
    }

    public static MaskFormatter getDateTimeMask() {
        return getMask("##/##/#### ##:##");
    }


    public static String formatDateDMY(String data) {
        String formatedDate = null;
        try {
            Date dataAMD = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            formatedDate = new SimpleDateFormat("dd/MM/yyyy").format(dataAMD);
        } catch (Exception e) {
            System.err.println(e);
        }
        return (formatedDate);
    }

    public static String formatDateISOStandard(String data) {
        String formatedDate = null;
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            formatedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        } catch (Exception e) {
            System.err.println(e);
        }
        return (formatedDate);
    }
    
    public static String formatDateTimeISOStandard(String data) {
        String formatedDate = null;
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
            formatedDate = new SimpleDateFormat("yyyy-MM-ddTHH:mm:00").format(date);
        } catch (Exception e) {
            System.err.println(e);
        }
        return (formatedDate);
    }

    public static String clean(String value) {
        String retorno = "";
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) != '.' && value.charAt(i) != '/' && value.charAt(i) != '-') {
                retorno = retorno + value.charAt(i);
            }
        }
        return (retorno.trim());
    }

    public static String getToday() {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String today = df.format(now);

        return today;
    }

    public static String getNow() {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String today = df.format(now);

        return today;
    }
}


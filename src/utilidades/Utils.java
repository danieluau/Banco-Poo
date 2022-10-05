package utilidades;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {

    static NumberFormat formatarValores = new DecimalFormat("R$ #,##0.00");

    public static String doubletoString(Double valor) {
        return formatarValores.format(valor);
    }

    public static String doubleToString(double saldo) {
        return null;
    }

}
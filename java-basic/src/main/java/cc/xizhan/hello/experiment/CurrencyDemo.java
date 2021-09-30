package cc.xizhan.hello.experiment;

import java.util.Currency;

/**
 * <p> Description: </p>
 *
 * @author chenxizhan(2021 - 06 - 22 15 : 06)
 */
public class CurrencyDemo {
    public static void main(String[] args) {
        for (Currency cur: Currency.getAvailableCurrencies()){
            System.out.println(cur.getCurrencyCode() + "\t:" + cur.getSymbol() + "\t:" + cur.getDisplayName() );
        }
        System.out.println(Currency.getInstance("CNY"));
    }
}

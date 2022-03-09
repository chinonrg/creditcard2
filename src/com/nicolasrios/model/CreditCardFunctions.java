package com.nicolasrios.model;

/**
 *
 * @author nicol
 */
public interface CreditCardFunctions {
   
    public boolean makePayment(double payment);
    
    public String getCardHolder();
    
    public int getExpireYear();
   
    public int getExpireMonth();
    
    public int getCardNumber();
    
    public double calcServiceFee(double payment);
    
    public CreditCard validateData(int cardNumber, int expireMonth, int expireYear);
}

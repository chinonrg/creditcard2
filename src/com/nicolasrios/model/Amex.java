package com.nicolasrios.model;
/**
 *
 * @author nicol
 */
public class Amex extends CreditCard {
    Amex amex;
    public Amex(String cardHolder, int cardNumber, int expireYear, int expireMonth) {
        super(cardHolder, cardNumber, expireYear, expireMonth);
    }

    @Override
    public int getCardNumber() {
        return cardNumber;
    }    
    @Override
    public int getExpireYear() {
        return expireYear;   
    }
    
    @Override
    public int getExpireMonth() {
        return expireMonth;
    }

    @Override
    public String getCardHolder() {
        return cardHolder;
    }

    @Override
    public boolean makePayment(double payment) {
        if (payment < 1000){
            System.out.println("Transacción exitosa. Costo de servicio $" + calcServiceFee(payment));     
        }
            return false;
    }

    @Override
    public double calcServiceFee(double payment) {
        double serviceFee = payment * (getExpireMonth()*0.1);
        return serviceFee;
    }
    @Override
        public Amex validateData(int cardNumber, int expireMonth, int expireYear) {
        for (CreditCard card : cards){
                if(card.getCardNumber() == cardNumber){
                if(card.getExpireYear() == expireYear){
                if(card.getExpireMonth() == expireMonth){
                    return amex;
                }    
                }
            }
        }
        return null;
    }
    
}

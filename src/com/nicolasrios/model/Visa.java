package com.nicolasrios.model;
/**
 *
 * @author nicol
 */
public class Visa extends CreditCard {
    Visa visa;
    
    public Visa(String cardHolder, int cardNumber, int expireYear, int expireMonth) {
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
        int serviceFee;
    if((getExpireYear() / getExpireMonth()) > 5 ){
        serviceFee = 5;
    } 
    else{
        serviceFee= getExpireYear() / getExpireMonth(); 
    }
    return payment * serviceFee / 100;
    }

    @Override
    public int getExpireMonth() {
        return expireMonth;
    }

    @Override
    public Visa validateData(int cardNumber, int expireMonth, int expireYear) {
        for (CreditCard card : cards){
                if(card.getCardNumber() == cardNumber){
                if(card.getExpireYear() == expireYear){
                if(card.getExpireMonth() == expireMonth){
                    return visa;
                }    
                }
            }
        }
        return null;
    }
 
}

package com.nicolasrios.model;

import java.time.LocalDate;

/**
 *
 * @author nicol
 */
public class Nara extends CreditCard {
    Nara nara;
    public Nara(String cardHolder, int cardNumber, int expireYear, int expireMonth) {
        super(cardHolder, cardNumber, expireYear, expireMonth);
    }

    @Override
    public int getCardNumber() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int getExpireYear() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    @Override
    public int getExpireMonth() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getCardHolder() {
        throw new UnsupportedOperationException("Not supported yet."); 
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
        double day = LocalDate.now().getDayOfMonth();
        double calcDay;
        if(day * 0.5 > 5){
            calcDay = 5;
        }else{
            calcDay= day*0.5;
        }
        return payment * calcDay / 100;
        }  
    @Override
    public Nara validateData(int cardNumber, int expireMonth, int expireYear) {
        for (CreditCard card : cards){
                if(card.getCardNumber() == cardNumber){
                if(card.getExpireYear() == expireYear){
                if(card.getExpireMonth() == expireMonth){
                    return nara;
                }    
                }
            }
        }
        return null;
    }
   }
    
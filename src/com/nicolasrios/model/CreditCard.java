package com.nicolasrios.model;

/**
 *
 * @author nicol
 */
public abstract class CreditCard implements CreditCardFunctions {
    protected String cardHolder;
    protected int cardNumber;
    protected int expireYear;
    protected int expireMonth;
    public static CreditCard creditCard;
    
    
    public static CreditCard getCreditCard() {
		return creditCard;
	}

	public static void setCreditCard(CreditCard creditCard) {
		CreditCard.creditCard = creditCard;
	}

	public static CreditCard[] getCards() {
		return cards;
	}

	public static void setCards(CreditCard[] cards) {
		CreditCard.cards = cards;
	}

	public static CreditCard[] cards = new CreditCard[]{
        new Visa("Ricardo Rodriguez", 11111, 23, 6),
        new Amex("Micaela Alvarez", 22222, 24, 9),
        new Nara("Miguel Fernandez", 33333, 22, 7)
    };

    public CreditCard(String cardHolder, int cardNumber, int expireYear, int expireMonth) {
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
        this.expireYear = expireYear;
        this.expireMonth = expireMonth;
    }
    
    @Override
    public abstract int getCardNumber();

    @Override
    public abstract int getExpireYear(); 

    @Override
    public abstract int getExpireMonth();

    @Override
    public abstract String getCardHolder();

    @Override
    public abstract boolean makePayment(double payment);

    @Override
    public abstract double calcServiceFee(double payment);
    
    @Override
    public abstract CreditCard validateData(int cardNumber, int expireMonth, int expireYear);
            
}

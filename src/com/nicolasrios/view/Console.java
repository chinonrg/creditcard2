package com.nicolasrios.view;
import com.nicolasrios.model.Amex;
import java.util.Scanner;
import com.nicolasrios.model.CreditCard;
import com.nicolasrios.model.Nara;
import com.nicolasrios.model.Visa;

public class Console {
    
    int cardNumber, expireYear, expireMonth;
    final private Scanner scanner = new Scanner(System.in);
    public static Console console;
    public static CreditCard creditCard;
    
    public Console() {
		super();
	}

	public Console getConsole() {
        return console;
    }
    
    public Console(int cardNumber, int expireYear, int expireMonth){
        this.cardNumber = cardNumber;
        this.expireYear = expireYear;
        this.expireMonth = expireMonth;
    }
    public void login(){

        //while(cardNumber == 0){
            System.out.println("Bienvenido!");
        //}
    while(true){
            try{
                System.out.println("Por favor, ingrese el número de su tarjeta.");
                cardNumber = Integer.parseInt(scanner.nextLine());
                if(Integer.toString(cardNumber).length() !=5){
                    System.out.println("El numero de tarjeta debe contener 5 dígitos");
                }else{
                    break;
                }
            }catch(NumberFormatException nfe){
                System.out.println("El valor ingresado no es númerico, intente nuevamente.");
            }
        while(true){
            try{
                System.out.println("Por favor, ingrese año de vencimiento de la tarjeta (2 dígitos)");
                expireYear = Integer.parseInt(scanner.nextLine());
                break;
            }catch(NumberFormatException nfe){
                System.out.println("El valor ingresado no es númerico, intente nuevamente.");
            }
        }
        while(true){
            try{
                System.out.println("Por favor, ingrese mes de vencimiento de la tarjeta (2 dígitos)");
                expireMonth = Integer.parseInt(scanner.nextLine());
                break;
            }catch(NumberFormatException nfe){
                System.out.println("El valor ingresado no es númerico, intente nuevamente.");
            }
        }
        creditCard = CreditCard.getCreditCard().validateData(cardNumber, expireYear, expireMonth);
        
        if(creditCard == null){
            System.out.println("Los datos ingresados no se corresponden con una tarjeta registrada. \n");
        }else{
            showOptions();
        }
        }
  }
    public void showOptions(){
        int option = 0;
        System.out.println("Bienvenido/a " + creditCard.getCardHolder() + "!");
        while(true){
            try{
                System.out.println("Por favor seleccione la opción deseada:");
                System.out.println("1) Realizar Pago");
                System.out.println("2) Consultar Informacion de Tarjeta");
                System.out.println("3) Consultar tasas de servicio");
                System.out.println("4) Salir \n");
                option= Integer.parseInt(scanner.nextLine());
            }catch(NumberFormatException nfe){
                System.out.println("La opción seleccionada no es correcta, vuelva a intentarlo...");
            }
            switch(option){
                case 1 -> {
                    System.out.println("Por favor, ingrese el monto a abonar");
                    while(true){
                        try{
                            creditCard.makePayment(Double.parseDouble(scanner.nextLine()));
                        }catch(NumberFormatException nfe){
                            System.out.println("El monto ingresado es incorrecto, debe ser un valor númerico inferior a $1000");
                            
                        }
                        break;}
                }
                case 2 ->{
                    System.out.println("Titular de la tarjeta: " +creditCard.getCardHolder());
                    System.out.println("Numero de tarjeta: " +creditCard.getCardNumber());
                    System.out.println("Vencimiento: " + creditCard.getExpireMonth() + "/" + creditCard.getExpireYear());
                    break;
                }
                case 3->{
                    System.out.println("Ingrese monto a calcular: ");
                    double payment;
                    payment = Double.parseDouble(scanner.nextLine());
                    if(payment < 1000){
                      while(true){
                            try{
                            Visa.getCreditCard().makePayment(payment);
                            Amex.getCreditCard().makePayment(payment);
                            Nara.getCreditCard().makePayment(payment);
                            }catch(NumberFormatException nfe){
                            System.out.println("El monto ingresado es incorrecto, debe ser un valor númerico inferior a $1000");
                            }
                        }  
                    }else{
                        System.out.println("Monto incorrecto, el mismo debe ser inferior a los $1000");
                        showOptions();
                    }
                    
                }
                case 4 ->{
                 creditCard = null;
                 login();
                }
            }
        }
    }
}

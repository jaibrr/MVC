package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

import model.entities.Reservation;


public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{

            System.out.print("Número do quarto: ");
            int number = sc.nextInt();
            System.out.print("Data de checkin (dd/MM/yyy): ");
            Date checkin = sdf.parse(sc.next());
            System.out.print("Data de checkout (dd/MM/yyy): ");
            Date checkout= sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reserva: " + reservation);

            System.out.println();
            System.out.println("Insira as data para atualizar a reserva");
            System.out.print("Data de checkin (dd/MM/yyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Data de checkout (dd/MM/yyy): ");
            checkout= sdf.parse(sc.next());
            
            reservation.updateDates(checkin, checkout);
            System.out.println("Reserva: " + reservation);
        }
        catch (ParseException e)
        {
            System.out.println("Formato inválido de data");

        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        
    
    
        sc.close();
    }
}

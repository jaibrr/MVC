package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entities.Reservation;

import java.util.Date;

public class App {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Número do quarto: ");
        int number = sc.nextInt();
        System.out.print("Data de checkin (dd/MM/yyy): ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("Data de checkout (dd/MM/yyy): ");
        Date checkout= sdf.parse(sc.next());

        if(!checkout.after(checkin)){
            System.out.println("Erro na reserva: a data de checkout deve ser posterior à data de checkin");
        } 
        else {
            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reserva: " + reservation);

            System.out.println();
            System.out.println("Insira as data para atualizar a reserva");
            System.out.print("Data de checkin (dd/MM/yyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Data de checkout (dd/MM/yyy): ");
            checkout= sdf.parse(sc.next());

            Date now = new Date();
            if(checkin.before(now) || checkout.before(now) ){
                System.out.println("Erro na reserva: as datas devem ser no futuro");
            }
            else if (!checkout.after(checkin)){
                System.out.println("Erro na reserva: a data de checkout deve ser posterior à data de checkin");
            }
            else{
                reservation.updateDates(checkin, checkout);
                System.out.println("Reserva: " + reservation);
            }        
        }



        sc.close();
    }
}

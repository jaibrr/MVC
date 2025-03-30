package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.script.SimpleScriptContext;

public class Reservation {

    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }
    public Integer getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duration(){
        //getTime devolve milissegundo de datas
        long diff = checkout.getTime() - checkin.getTime();
        //conversor de tempo
        return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    } 

    public String updateDates(Date checkin, Date checkout){

        Date now = new Date();
        if(checkin.before(now) || checkout.before(now) ){
            return "as datas devem ser no futuro";
        }
        
        if (!checkout.after(checkin)){
            return "a data de checkout deve ser posterior à data de checkin";
        }

        this.checkin = checkin;
        this.checkout = checkout;
        return null;
    }

    @Override    
    public String toString() {
        return "quarto reservado: " 
                + roomNumber 
                + ", checkin: " 
                + sdf.format(checkin) 
                + ", checkout: " 
                + sdf.format(checkout) 
                + ", " + duration() 
                + " noites";
    } 
    
}

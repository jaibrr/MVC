package model.exception;


//RuntimeException compilador não te obriga a tratar
//Exception compilador te obriga a tratar

public class DomainException extends Exception {
    //é uma classe que pode ser serializada, pode trafegar na web
    private static final long serialVerisonUID = 1L;



}

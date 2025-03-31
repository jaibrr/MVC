package model.exception;


//RuntimeException compilador não te obriga a tratar
//Exception compilador te obriga a tratar

public class DomainException extends Exception {
    //uma classe que pode ser serializada, exige versão, pode trafegar na web, arquivos etc
    private static final long serialVerisonUID = 1L;

    public DomainException(String msg){
        super(msg);
    }

}

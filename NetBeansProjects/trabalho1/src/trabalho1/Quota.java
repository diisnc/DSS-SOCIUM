package trabalho1;

/**
* Esta é a classe de cotas.
*
* @author Diana Costa, Marcos Pereira, Sérgio Oliveira, Vítor Castro
* @version 0.1
* @since 2017-09-25
*/

import java.util.*;
public class Quota {
    
    //VARIAVEIS DE INSTANCIA
    private Date date;
    private Double value;  
   
    //CONSTRUTORES
    public Quota(){
    this.date = new Date();
    this.value = 0.0;
    }
    
    public Quota(Date dat, Double val){
        this.date = dat;
        this.value = val;
    }
    
    public Quota(Quota q){
        this.date = q.getDate();
        this.value = q.getValue();
    }
    
    
    //METODOS DE INSTANCIA
    //GETTERS
    public Date getDate()   { return this.date; }
    public Double getValue()    { return this.value; }
    
    //SETTERS
    public void setDate(Date dat)   { this.date = dat; }
    public void setValue(Double val)    { this.value = val; }    
    
    //equals, clone, toString
}

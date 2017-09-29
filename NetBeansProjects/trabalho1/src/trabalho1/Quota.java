package trabalho1;

/**
* Esta é a classe de cotas.
*
* @author Diana Costa, Marcos Pereira, Sérgio Oliveira, Vítor Castro
* @version 0.1
* @since 2017-09-25
*/

import java.util.*;
public class Quota extends SociUM{
    
    //VARIAVEIS DE INSTANCIA
    private Date date;
    private Double value;  
   
    //CONSTRUTORES
    public Quota(){
    this.date = new Date();
    this.value = 0.0;
    }
    
    public Quota(Double d){
    this.date = new Date();
    this.value = d;
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
    public Date getDate()   { return (Date) this.date.clone(); }
    public Double getValue()    { return this.value; }
   
    //SETTERS
    public void setDate(Date dat)   { this.date = dat; }
    public void setValue(Double val)    { this.value = val; }    
    
    public boolean equals(Object o) {

        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Quota)) return false;

        Quota quota = (Quota) o;
        return (this.date.equals(quota.getDate()) && this.value == quota.getValue());
    }

    public Quota clone() {
        return new Quota(this);
    }

    public String toString() {
        return ("Date: " + getDate().toString() +"\n Value: " + getValue() + "\n");
    }

}

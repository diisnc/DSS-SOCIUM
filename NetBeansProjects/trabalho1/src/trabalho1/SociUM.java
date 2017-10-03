package trabalho1;
import java.util.*;
import java.io.Serializable;

public class SociUM implements Serializable {
    
    //VARIAVEIS DE INSTANCIA
    private static final long serialVersionUID = 7526472295622776147L;
    private String number;                  //A10000
    private String name;                    //Álvaro de Campos
    private String course;                  //código do curso(MIEI)
    private int year;                       //2
    private String address;                 //rua da misericórdia
    private ArrayList<Quota> quotas;        //<data,valor pago>, ordenado por data
    private Boolean monthpaid;
   
    //CONSTRUTORES
    public SociUM(){
        this.number = "";
        this.name = "";
        this.course = "";
        this.year = 0;
        this.address = "";
        this.quotas = new ArrayList<>();
        this.monthpaid = false;
    }
    
    public SociUM(String nmb, String name, String cours, int yea, String addres, ArrayList<Quota> quo, Boolean mp){
        this.number = nmb;
        this.name = name;
        this.course = cours;
        this.year = yea;
        this.address = addres;
        this.quotas = new ArrayList<>();
        for(Quota q: quo)
           quotas.add(q.clone());   
        this.monthpaid = mp;
    }
    
    public SociUM(String nmb, String name, String cours, int yea, String addres, Boolean mp){
        this.number = nmb;
        this.name = name;
        this.course = cours;
        this.year = yea;
        this.address = addres;
        this.quotas = new ArrayList<>();  
        this.monthpaid = mp;
    }
    
    public SociUM(SociUM s){
        this.number = s.getNumber();
        this.name = s.getName();
        this.course = s.getCourse();
        this.year = s.getYear();
        this.address = s.getAddress();
        this.quotas = new ArrayList<>();
        for(Quota q: s.getQuotas()) {
            quotas.add(q.clone());
        }
        this.monthpaid = s.getMonthPaid();
    }

    //METODOS DE INSTANCIA
    //GETTERS
    public String getNumber(){ return this.number; }
    
    public String getName(){ return this.name; }
    
    public String getCourse(){ return this.course; }
    
    public int getYear(){ return this.year; }
    
    public String getAddress(){ return this.address; }
    
    public Boolean getMonthPaid() { return this.monthpaid; }
    
    //devolve todas as quotas de um sócio
    public ArrayList<Quota> getQuotas(){
        ArrayList<Quota> ret = new ArrayList<Quota>();
        for(Quota q : this.quotas) {
            ret.add(q.clone()); 
        }
        return ret;
    }
    
    //SETTERS
    public void setNumber(String nmr){ this.number = nmr; }
    
    public void setName(String n){ this.name = n; }
    
    public void setCourse(String c){ this.course = c; }
    
    public void setYear(int yea){ this.year = yea; }
    
    public void setAddress(String addres){ this.address = addres; }
    
    public void setMonthPaid(Boolean mp) { this.monthpaid = mp; }
    
    //n deve ser preciso este método, mas wtv
    //adiciona quotas a um aluno, passadas como parâmetro 
    public void addQuotas(ArrayList<Quota> quo){
        for(Quota q: quo) {
            this.quotas.add(q.clone()); 
        }
    }
    
    //adiciona UMA cota, usar este método
    public void addQuota(double d){
        this.quotas.add(new Quota(d));
    }
    
    public void addQuota(Quota q){
        this.quotas.add(q.clone());
    }
   
    public boolean equals(Object o){
        if (this == o) return true;
        if (o==null || o.getClass() != this.getClass()) return false;
        SociUM q = (SociUM) o;
        return ( this.number.equals(q.getNumber()) &&
                 this.name.equals(q.getName()) &&
                 this.course.equals(q.getCourse()) &&
                 this.year == q.getYear() &&
                 this.address.equals(q.getAddress()) &&
                 this.quotas.equals(q.getQuotas()) &&
                 this.monthpaid.equals(q.getMonthPaid())
               );
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("----------SOCIO----------\n");
        s.append("NUMERO: " +this.number+ "\n");
        s.append("NOME: " +this.name+ "\n");
        s.append("CURSO: " +this.course+ "\n");
        s.append("ANO CURSO: " +this.year+ "\n");
        s.append("MORADA: " +this.address+ "\n");
        s.append("COTAS: \n");
        for(Quota q : this.quotas)
            s.append(q.toString());
        s.append("-------------------------\n");
        
    
        return s.toString();
    }
    
    public SociUM clone(){
        return new SociUM(this);
    }
}

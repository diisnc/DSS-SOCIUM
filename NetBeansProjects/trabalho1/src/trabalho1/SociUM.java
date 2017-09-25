/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

/**
 *
 * @authors Diana, Marcos, Sérgio e Vítor.
 */

import java.util.*;
public class SociUM {
    
    //VARIAVEIS DE INSTANCIA
    private String numero;                  //A10000
    private String nome;                    //Álvaro de Campos
    private String curso;                   //código do curso(MIEI)
    private int anoCurso;                   //2
    private int anoPresente;                //2017
    private String morada;                  //rua da misericórdia
    private ArrayList<Quota> quotas;                 //<data,valor pago>, ordenado por data
   
    //CONSTRUTORES
    public SociUM(){
    this.numero = "";
        this.nome = "";
        this.curso = "";
        this.anoCurso = 0;
        this.anoPresente = 0;
        this.morada = "";
        this.quotas = new ArrayList<>();
    }
    
    public SociUM(String nmr, String name, String curs, int anoC, int ano, String morad, ArrayList<Quota> cot){
        this.numero = nmr;
        this.nome = name;
        this.curso = curs;
        this.anoCurso = anoC;
        this.anoPresente = ano;
        this.morada = morad;
        this.quotas = new ArrayList<>();
        for( Quota q : cot  )
           quotas.add(q.clone());   
    }
    
    public SociUM(String nmr, String name, String curs, int anoC, int ano, String morad){
        this.numero = nmr;
        this.nome = name;
        this.curso = curs;
        this.anoCurso = anoC;
        this.anoPresente = ano;
        this.morada = morad;
        this.quotas = new ArrayList<>();  
    }
    
    public SociUM(SociUM s){
        this.numero = s.getNumero();
        this.nome = s.getNome();
        this.curso = s.getCurso();
        this.anoCurso = s.getAnoCurso();
        this.anoPresente = s.getAnoPresente();
        this.morada = s.getMorada();
        this.quotas = new ArrayList<>();
        for( Quota q : s.getQuotas() )
            quotas.add(q.clone());
    }

    //METODOS DE INSTANCIA
    //GETTERS
    public String getNumero(){ return this.numero; }
    
    public String getNome(){ return this.nome; }
    
    public String getCurso(){ return this.curso; }
    
    public int getAnoCurso(){ return this.anoCurso; }
    
    public int getAnoPresente(){ return this.anoPresente; }
    
    public String getMorada(){ return this.morada; }
    
    //devolve todas as quotas de um sócio
    public ArrayList<Quota> getQuotas(){
        ArrayList<Quota> ret = new ArrayList<Quota>();
        for( Quota q : this.quotas){ ret.add(q.clone()); }
        return ret;
    }
    
    //SETTERS
    public void setNumero(String nmr){ this.numero = nmr; }
    
    public void setNome(String n){ this.nome = n; }
    
    public void setCurso(String c){ this.curso = c; }
    
    public void setAnoCurso(int ano){ this.anoCurso = ano; }
    
    public void setAnoPresente(int anop){ this.anoPresente = anop; }
    
    public void setMorada(String morad){ this.morada = morad; }
    
    //n deve ser preciso este método, mas wtv
    //adiciona quotas a um aluno, passadas como parâmetro 
    public void addQuotas(ArrayList<Quota> cot){
        for( Quota q : cot ){ this.quotas.add(q.clone()); }
    }
    
    //adiciona UMA cota, usar este método
    public void addQuota(Quota q){
        this.quotas.add(q.clone());
    } 
   
    public boolean equals(Object o){
        if( this == o ) return true;
        if( o==null || o.getClass() != this.getClass() ) return false;
        SociUM q = (SociUM) o;
        return ( this.numero.equals(q.getNumero()) &&
                 this.nome.equals(q.getNome()) &&
                 this.curso.equals(q.getCurso()) &&
                 this.anoCurso == q.getAnoCurso() &&
                 this.anoPresente == q.getAnoPresente() &&
                 this.morada.equals(q.getMorada()) &&
                 this.quotas.equals(q.getQuotas())
               );
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("----------SOCIO----------\n");
        s.append("NUMERO: " +this.numero+ "\n");
        s.append("NOME: " +this.nome+ "\n");
        s.append("CURSO: " +this.curso+ "\n");
        s.append("ANO CURSO: " +this.anoCurso+ "\n");
        s.append("ANO PRESENTE: " +this.anoPresente+ "\n");
        s.append("MORADA: " +this.morada+ "\n");
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

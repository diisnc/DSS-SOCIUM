/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

/**
 *
 * @author Diana
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
    private TreeMap<Date, Double> cotas;    //<data,valor pago>, ordenado por data
   
    //CONSTRUTORES
    public SociUM(){
    this.numero = "";
        this.nome = "";
        this.curso = "";
        this.anoCurso = 0;
        this.anoPresente = 0;
        this.morada = "";
        this.cotas = new TreeMap<>();
    }
    
    public SociUM(String nmr, String name, String curs, int anoC, int ano, String morad){
        this.numero = nmr;
        this.nome = name;
        this.curso = curs;
        this.anoCurso = anoC;
        this.anoPresente = ano;
        this.morada = morad;
        //this.cotas = new TreeMap<>();
        //for()
    }
    
    public SociUM(SociUM s){
        this.numero = s.getNumero();
        this.nome = s.getNome();
        this.curso = s.getCurso();
        this.anoCurso = s.getAnoCurso();
        this.anoPresente = s.getAnoPresente();
        this.morada = s.getMorada();
        //this.cotas = 
    }
    
    
    //METODOS DE INSTANCIA
    //GETTERS
    public String getNumero(){ return this.numero; }
    public String getNome(){ return this.nome; }
    public String getCurso(){ return this.curso; }
    public int getAnoCurso(){ return this.anoCurso; }
    public int getAnoPresente(){ return this.anoPresente; }
    public String getMorada(){ return this.morada; }
    //public TreeMap<Date, Double> getCotas(){}
    
    
    //SETTERS
    public void setNumero(String nmr){ this.numero = nmr; }
    public void setNome(String n){ this.nome = n; }
    public void setCurso(String c){ this.curso = c; }
    public void setAnoCurso(int ano){ this.anoCurso = ano; }
    public void setAnoPresente(int anop){ this.anoPresente = anop; }
    public void setMorada(String morad){ this.morada = morad; }
    //public void setCotas(TreeMap<Date, Double> cot){}
 
    
    
    
    //equals, clone, toString
}

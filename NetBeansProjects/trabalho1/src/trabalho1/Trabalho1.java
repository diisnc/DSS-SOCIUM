package trabalho1;
import java.util.*;

/**
* Esta é a classe principal que gere o programa.
*
* @author Diana Costa, Marcos Pereira, Sérgio Oliveira, Vítor Castro
* @version 0.1
* @since 2017-09-25
*/

public final class Trabalho1 extends Observable {

    private HashMap<String, SociUM> members;
    
    public Trabalho1 () {
        this.members = new HashMap<String, SociUM>();
    }
    
    public HashMap<String, SociUM> getMembers() {
        return this.members;
    }
    
    // método que cria um novo sócio e notifica a UI relativamente a alterações
    public SociUM createSociUM(String nmb, String name, String course, int year, String address, Boolean mp) {

        SociUM newSociUM = new SociUM(nmb, name, course, year, address, mp);
        this.members.put(name, newSociUM);
        
        // Notificar UI
        setChanged();
        notifyObservers(this.members);

        return newSociUM;
    }

    // método que muda os atributos de um sócio e que é chamado pela janela de alteração de membro. Notifica também a UI relativamente a alterações
    public void changeSociUM(SociUM oldmember, String nmb, String name, String course, int year, String address) {

        oldmember.setName(name);
        oldmember.setNumber(nmb);
        oldmember.setCourse(course);
        oldmember.setYear(year);
        oldmember.setAddress(address);
        
        // Notificar UI
        setChanged();
        notifyObservers(this.members);
        
    }
    
    // método que remove um sócio da estrutura de dados que armazena os sócios da empresa. Notifica também a UI relativamente a alterações. Este método
    // é chamado pela janela de alteração de membro
    public void removeSociUM(String name) {

        this.members.remove(name);
        
        // Notificar UI
        setChanged();
        notifyObservers(this.members);
        
    }
    
    // método que determina se o sócio tem a cota do mês atual em dia
    public void monthpaid(SociUM s) {
        
        // Se o sócio tiver quotas pagas, acedemos à cota que está na última posição do array. Se essa cota não estiver datada com o mês atual
        // então o sócio ainda não pagou o mês currente.
        
        if (s.getQuotas() != null && !s.getQuotas().isEmpty()) {
            Quota lastquota = s.getQuotas().get(s.getQuotas().size()-1);
            if (lastquota.getDate().getMonth() ==  Calendar.getInstance().get(Calendar.MONTH)) {
                s.setMonthPaid(true);
            }
            else s.setMonthPaid(false);
        
        }
    }
    
    // método que paga a cota de um sócio e que notifica a UI relativamente a alterações
    public void payQuota(SociUM s) {
       
        s.addQuota(5.0);

        // Notificar UI
        setChanged();
        notifyObservers(this.members); // Enviar o HashMap members como parametro para a função update() da UI
        
    }

    public static void main(String[] args) {
        
        Trabalho1 controller = new Trabalho1();
        
        /*
        ///////////// TESTING ////////////////////////
        System.out.println("Testando trabalho1");

        SociUM diana = controller.createSociUM("A78985", "Diana Costa", "MIEI", 3, 2017, "Rua das flores");
        
        Date date = new Date();
        Quota quota = new Quota(date, 5.0);
        diana.addQuota(quota);
        
        controller.createSociUM("A77730", "Sérgio Oliveira", "MIEI", 3, 2017, "Quental");
        controller.createSociUM("A77875", "Vítor Castro", "MIAI", 3, 2017, "Rua das LEPRAS");
        controller.createSociUM("A78888", "Marcos Pereira", "MIOI", 3, 2017, "Rua das 7 casas, nmr 10");
        //////////////////////////////////////////////
        */
        
        IO io = new IO();
        io.ReadHashMap(controller.getMembers());
        
        /* Iniciar a UI */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                Trabalho1UI ui = new Trabalho1UI(controller);
                
                ui.show(controller.members);
                
                // Subscrever a UI a atualizações do modelo notificadas por esta classe
                controller.addObserver(ui);
                
                /*
                // Socios de teste
                controller.createSociUM("A78989", "Tarraxo", "MIMI", 3, 2017, "portela");
                controller.createSociUM("A78990", "Infiltrado", "MIMU", 3, 2017, "UM");
                */
            }
        });
    }
}

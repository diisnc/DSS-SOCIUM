/**
* Esta é a classe principal que gere o programa.
*
* @author Diana Costa, Marcos Pereira, Sérgio Oliveira, Vítor Castro
* @version 0.1
* @since 2017-09-25
*/
package trabalho1;
import java.util.*;
import java.util.Observable;

public final class Trabalho1 extends Observable {

    private HashMap<String, SociUM> members;
    
    public Trabalho1 () {
        this.members = new HashMap<String, SociUM>();
    }

    public SociUM createSociUM(String numero, String nome, String curso, int anocurso, int anopresente, String morada) {

        SociUM newSociUM = new SociUM(numero, nome, curso, anocurso, anopresente, morada);
        this.members.put(nome, newSociUM);
        
        // Notificar UI
        setChanged();
        notifyObservers(this.members); // Enviar o HashMap members como parametro para a função update() da UI

        return newSociUM;
    }

    public static void main(String[] args) {
        
        Trabalho1 controller = new Trabalho1();

        ///////////// TESTING ////////////////////////
        
        System.out.println("Testando trabalho1");

        SociUM diana = controller.createSociUM("A78985", "Diana Costa", "MIEI", 3, 2017, "Rua das flores");
        
        Date date = new Date();
        Quota quota = new Quota(date, 5.0);

        diana.addQuota(quota);
        
        controller.createSociUM("A78986", "Diana Costb", "MIUI", 3, 2017, "Rua das flores");
        controller.createSociUM("A78987", "Diana Costc", "MIAI", 3, 2017, "Rua das LEPRAS");
        controller.createSociUM("A78988", "Diana Costd", "MIOI", 3, 2017, "Rua das flores");

        //////////////////////////////////////////////
        
        /* Iniciar a UI */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                Trabalho1UI ui = new Trabalho1UI();
                
                System.out.println(controller.members.toString());
                
                ui.show(controller.members);
                
                // Subscrever a UI a atualizações do modelo notificadas por esta classe
                controller.addObserver(ui);
                
                //controller.createSociUM("A78989", "Antonio Peixoto", "MIMI", 3, 2017, "Pe choto");
                //controller.createSociUM("A78990", "Roberto Peichoco", "MIMU", 3, 2017, "Pe choco");
            }
        });
    }
}

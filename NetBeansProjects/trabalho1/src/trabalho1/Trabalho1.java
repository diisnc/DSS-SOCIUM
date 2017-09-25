/**
* Esta é a classe principal que gere o programa.
*
* @author Diana Costa, Marcos Pereira, Sérgio Oliveira, Vítor Castro
* @version 0.1
* @since 2017-09-25
*/
package trabalho1;
import java.util.*;
import java.text.SimpleDateFormat;

public final class Trabalho1 {

    private static HashMap<String, SociUM> listasocios = new HashMap<String, SociUM>();

    public static SociUM createSociUM(String numero, String nome, String curso, int anocurso, int anopresente, String morada) {

        SociUM newSociUM = new SociUM(numero, nome, curso, anocurso, anopresente, morada);
        listasocios.put(nome, newSociUM);

        return newSociUM;
    }

    public static void main(String[] args) {

        ///////////// TESTING ////////////////////////
        System.out.println("Testando trabalho1");

        SociUM diana = createSociUM("A78985", "Diana Costa", "MIEI", 3, 2017, "Rua das flores");
        
        Date date = new Date();
        Quota quota = new Quota(date,5.0);

        diana.addQuota(quota);
        
        diana.toString();
        System.out.println(diana);
        
        createSociUM("A78986", "Diana Costb", "MIUI", 3, 2017, "Rua das flores");
        createSociUM("A78987", "Diana Costc", "MIAI", 3, 2017, "Rua das LEPRAS");
        createSociUM("A78988", "Diana Costd", "MIOI", 3, 2017, "Rua das flores");

        //////////////////////////////////////////////
        //////////////////////////////////////////////
        
        Trabalho1UI.showUI();
    }
}

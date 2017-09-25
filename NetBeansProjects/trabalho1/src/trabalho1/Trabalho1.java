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


    public static SociUM createSociUM(String numero, String nome, String curso, int anocurso, int anopresente, String morada, ArrayList<Quota> cot) {

        SociUM newSociUM = new SociUM(numero, nome, curso, anocurso, anopresente, morada, cot);
        listasocios.put(nome, newSociUM);

        return newSociUM;
    }


    public static void main(String[] args) {

        ///////////// TESTING ////////////////////////
        System.out.println("Testando trabalho1");

        Date data = new Date();
        Quota quota = new Quota(data,5.0);

        ArrayList<Quota> test = new ArrayList<Quota>();
        test.add(quota);

        SociUM diana = createSociUM("A78985", "Diana Costa", "MIEI", 3, 2017, "Rua das flores", test);
        diana.toString();
        System.out.println(diana);

        //////////////////////////////////////////////
        //////////////////////////////////////////////
        
        Trabalho1UI.showUI();
    }
}

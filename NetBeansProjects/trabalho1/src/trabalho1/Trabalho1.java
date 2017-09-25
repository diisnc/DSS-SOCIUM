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
                    Date data = new Date();
                    SociUM diana = createSociUM( "A78985", "Diana Costa", "MIEI", 3, 2017, "Rua das flores", {{data, 5.0}} );
                    //diana.toString();
		}



}
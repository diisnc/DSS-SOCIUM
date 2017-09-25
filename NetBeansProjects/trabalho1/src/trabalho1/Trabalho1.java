/**
* Esta é a classe principal que gere o programa.
*
* @author Diana Costa, Marcos Pereira, Sérgio Oliveira, Vítor Castro
* @version 0.1
* @since 2017-09-25
*/
public final class Main {

		private static HashMap<String, SociUM> listasocios = new HashMap<String, SociUM>();

		public static void main(String[] args) {

		}


		public static SociUM createSociUM(String numero, String nome, String curso, int anocurso, int anopresente, String morada) {

			SociUM newSociUM = new Socium(numero, nome, curso, anocurso, anopresente, morada);
			listasocios.put(nome, newSociUM);

			return newSociUM;
		}

		


}
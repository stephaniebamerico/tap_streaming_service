package Visitor;
import Composite.Componente;
import Composite.EstiloMusical;
import Composite.Musica;

public class ListarMusicaPorEstilo implements ComponenteVisitor {
	private EstiloMusical estiloMusical;
	
	public ListarMusicaPorEstilo (EstiloMusical estiloMusical) {
		this.estiloMusical = estiloMusical;
	}

	@Override
	public void visitar(Componente componente) {
		if (componente == null)
			return;
		
		/* Imprime somente os componentes que:
		 * - forem da classe Musica;
		 * - possuirem determinado estilo. */
		if (componente.getClass() == Musica.class && 
				componente.getEstiloMusical().equals(estiloMusical)) {
			componente.imprimeInformacoes();
		}
	}

}

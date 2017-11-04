package Visitor;
import java.time.Duration;
import Composite.Componente;
import Composite.EstiloMusical;
import Composite.Musica;
import Composite.Playlist;

public class ListarPorEstiloDuracao implements ComponenteVisitor {
	private EstiloMusical estiloMusical;
	private Duration duracao;
	
	public ListarPorEstiloDuracao (EstiloMusical estiloMusical, Duration duracao) {
		this.estiloMusical = estiloMusical;
		this.duracao = duracao;
	}
	@Override
	public void visitar(Componente componente) {
		if (componente == null)
			return;
		
		/* Imprime somente os componentes que:
		 * - forem da classe Musica ou Playlist;
		 * - possuirem determinado estilo;
		 * - se Musica, com duração > 3 min. */
		if ((componente.getClass() == Musica.class ||
				componente.getClass() == Playlist.class) && 
				componente.getEstiloMusical().equals(estiloMusical)) {
			
			/* Compara a duração */
			if (componente.getClass() == Musica.class) {
				Musica comp = (Musica) componente;
				if(comp.getDuracao().compareTo(duracao) < 0)
					return;
			}
			
			componente.imprimeInformacoes();
		}
		
	}

}

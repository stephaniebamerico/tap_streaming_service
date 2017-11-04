package Composite;
import java.time.Duration;

/* "Leaf" */
public class Musica extends Componente {
	private Duration duracao;
	
	public Musica (String nome, EstiloMusical estiloMusical, Duration duracao) {
		this.nome = nome;
		this.estiloMusical = estiloMusical;
		this.duracao = duracao;
	}

	public Duration getDuracao() {
		return duracao;
	}
	
}

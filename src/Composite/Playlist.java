package Composite;
import java.util.ArrayList;
import java.util.List;

import Visitor.ComponenteVisitor;

/* "Composite" */
public class Playlist extends Componente {
	private EstiloMusical estiloMusicalSecundario;
	private List<Componente> albuns;
	
	public Playlist (String nome, EstiloMusical estiloMusical, EstiloMusical estiloMusicalSecundario) {
		this.nome = nome;
		this.estiloMusical = estiloMusical;
		this.estiloMusicalSecundario = estiloMusicalSecundario;
		albuns = new ArrayList<Componente>();
	}
	
	@Override
	public void aceitarVisitante (ComponenteVisitor visitor) {
		super.aceitarVisitante(visitor);
		for (Componente componente : albuns) {
            componente.aceitarVisitante(visitor);
        }
	}
	
	public void add (Componente componente) {
		albuns.add(componente);
	}
	
	public void remove (Componente componente) {
		albuns.remove(componente);
	}

	public EstiloMusical getEstiloMusicalSecundario() {
		return estiloMusicalSecundario;
	}
	
}

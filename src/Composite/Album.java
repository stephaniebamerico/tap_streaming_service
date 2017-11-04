package Composite;
import java.util.ArrayList;
import java.util.List;

import Visitor.ComponenteVisitor;

/* "Composite" */
public class Album extends Componente {
	private String nomeBanda;
	private List<Componente> musicas;
	
	public Album (String nome, EstiloMusical estiloMusical, String nomeBanda) {
		this.nome = nome;
		this.estiloMusical = estiloMusical;
		this.nomeBanda = nomeBanda;
		musicas = new ArrayList<Componente>();
	}
	
	@Override
	public void aceitarVisitante (ComponenteVisitor visitor) {
		super.aceitarVisitante(visitor);
		for (Componente componente : musicas) {
            componente.aceitarVisitante(visitor);
        }
	}
	
	public void add (Componente componente) {
		musicas.add(componente);
	}
	
	public void remove (Componente componente) {
		musicas.remove(componente);
	}

	public String getNomeBanda() {
		return nomeBanda;
	}
	
}

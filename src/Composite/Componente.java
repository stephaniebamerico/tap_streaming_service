package Composite;
import Visitor.ComponenteVisitor;

/* ====================================================================================================
 *                              "Component" (usando "design for type safety")
 * ====================================================================================================
 * Design for type safety: As operações relacionadas aos objetos composite (add e remove) são definidas 
 * apenas na classe composite. A segurança é obtida pois os clientes não podem executar essas operações
 * em objetos folha (leaf). 
 */

public abstract class Componente {
	protected String nome = null;
	protected EstiloMusical estiloMusical = null;
	
	/* "accept" */
	public void aceitarVisitante (ComponenteVisitor visitor) {
		visitor.visitar(this);
	}
	
	public void imprimeInformacoes () {
		System.out.println("Nome: " + nome);
		System.out.println("Estilo musical: " + estiloMusical.toString());
		System.out.println();
	}
	
	public String getNome () {
		return nome;
	}
	
	public EstiloMusical getEstiloMusical () {
		return estiloMusical;
	}
	
}

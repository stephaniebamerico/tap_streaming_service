package Visitor;
import Composite.Componente;

public class ListarTodosElementos implements ComponenteVisitor {

	@Override
	public void visitar(Componente componente) {
		if (componente == null)
			return;
		
		/* Imprime todos os elementos, sem exceção. */
		componente.imprimeInformacoes();
		
	}

}

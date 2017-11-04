import java.time.Duration;
import Composite.Album;
import Composite.EstiloMusical;
import Composite.Musica;
import Composite.Playlist;
import Visitor.ListarMusicaPorEstilo;
import Visitor.ListarPorEstiloDuracao;
import Visitor.ListarTodosElementos;

/* ========================================================================================================
 *                             Observações sobre a interpretação da especificação
 * ========================================================================================================
 * Os seguintes itens não ficaram claros na especificação e tomamos as decisões de projeto que cosideramos
 * mais adequadas:
 * 1 - Inseririmos elementos repetidos.
 * 2 - Listamos elementos repetidos quantas vezes aparecerem.
 * 3 - Usamos Component do tipo "design for type safety" (mais detalhes na classe Componente).
 * 4 - Não limitamos a capacidade de nenhuma lista de elementos.
 * 5 - A listagem só imprime Nome e Estilo dos elementos (atributos específicos são ignorados).
 * 6 - Na listagem "playlists e músicas de um determinado estilo e com duração de mais de 3 minutos"
 * julgamos que a duração só deveria ser considerada para músicas (e não playlists).
 */

public class Cliente {
	private static ServicoStreaming servicoStreaming;
	// TODO Perguntar se tem capacidade maxima para diretorio, playlist e album
	// TODO Perguntar se as listagens estão corretas imprimindo nome e estilo
	// TODO Perguntar o listar por duração considera só músicas ou soma a duração da playlist
	// TODO Perguntar o lista elementos repetidos
	public static void main(String[] args) {
		/* Cria e inicializa (opcional) serviço streaming.*/
		servicoStreaming = new ServicoStreaming();
		if (servicoStreaming == null)
			System.err.println("Erro ao criar ServicoStreaming.");
		servicoStreaming.inicializaServico("stephanie-talita", "123mudar", TipoPlano.FREE);
		
		/* Cria e inicializa todos componentes */
		inicializaServico();
		
		System.out.println("# Listando todos os elementos do diretorio:");
		for (Playlist p : servicoStreaming.getDiretorio()) {
			p.aceitarVisitante(new ListarTodosElementos());
		}
		
		System.out.println("# Listando todas as musicas de Rock:");
		for (Playlist p : servicoStreaming.getDiretorio()) {
			p.aceitarVisitante(new ListarMusicaPorEstilo(EstiloMusical.ROCK));
		}
		
		System.out.println("# Listando por Pagode com duracao de mais de 3min:");
		for (Playlist p : servicoStreaming.getDiretorio()) {
			p.aceitarVisitante(new ListarPorEstiloDuracao(EstiloMusical.PAGODE, Duration.ofSeconds(180)));
		}
			
	}
	
	public static void inicializaServico () {
		/* Cria playlists */
		Playlist p1 = new Playlist("Brasil Anos 90", EstiloMusical.PAGODE, EstiloMusical.ROCK);
		Playlist p2 = new Playlist("Rock dos anos 2000", EstiloMusical.ROCK, EstiloMusical.HEAVY_METAL);
		Playlist p3 = new Playlist("Treino anos 80", EstiloMusical.POP, EstiloMusical.ROCK);
		Playlist p4 = new Playlist("Músicas para cantar no chuveiro", EstiloMusical.POP, EstiloMusical.PAGODE);
		Playlist p5 = new Playlist("Chega de Brincadeira", EstiloMusical.HEAVY_METAL, EstiloMusical.ROCK);
		
		/* Cria albuns */
		Album a1 = new Album("5 músicas de Rock repetidas", EstiloMusical.ROCK, "Red Hot Chili Peppers");
		Album a2 = new Album("5 músicas de Pop repetidas", EstiloMusical.POP, "Sia");
		Album a3 = new Album("5 músicas de Pagode repetidas", EstiloMusical.PAGODE, "Molejo");
		Album a4 = new Album("5 músicas de Heavy Metal repetidas", EstiloMusical.HEAVY_METAL, "Iron Maiden");
		
		/* Cria músicas */
		Musica m1 = new Musica("Californication", EstiloMusical.ROCK, Duration.ofSeconds(322)); /* 5min 22s */
		Musica m2 = new Musica("Elastic Heart", EstiloMusical.POP, Duration.ofSeconds(308)); /* 5min 8s */
		Musica m3 = new Musica("Cilada", EstiloMusical.PAGODE, Duration.ofSeconds(226)); /* 3min 46s */
		Musica m4 = new Musica("The Number Of The Beast", EstiloMusical.HEAVY_METAL, Duration.ofSeconds(292)); /* 4min 52s */
		
		/* Inicializa albuns */
		a1.add(m1);
		a1.add(m1);
		a1.add(m1);
		a1.add(m1);
		a1.add(m1);
		
		a2.add(m2);
		a2.add(m2);
		a2.add(m2);
		a2.add(m2);
		a2.add(m2);
		
		a3.add(m3);
		a3.add(m3);
		a3.add(m3);
		a3.add(m3);
		a3.add(m3);
		
		a4.add(m4);
		a4.add(m4);
		a4.add(m4);
		a4.add(m4);
		a4.add(m4);
		
		/* Inicializa playlists */
		p1.add(a3);
		p1.add(a3);
		p1.add(a3);
		p1.add(a3);
		p1.add(p3);
		
		p2.add(a1);
		p2.add(a1);
		p2.add(a1);
		p2.add(a1);
		p2.add(p5);
		
		p3.add(a2);
		p3.add(a2);
		p3.add(a2);
		p3.add(a2);
		
		p4.add(a2);
		p4.add(a2);
		p4.add(a2);
		p4.add(a2);
		
		p5.add(a4);
		p5.add(a4);
		p5.add(a4);
		p5.add(a4);
		
		/* Inicializa diretorio */
		servicoStreaming.add(p1);
		servicoStreaming.add(p2);
		servicoStreaming.add(p3);
		servicoStreaming.add(p4);
		servicoStreaming.add(p5);
	}

}

import java.util.ArrayList;
import java.util.List;

public final class ServicoStreaming {
	private static ServicoStreaming instance = null;
	private String login, senha;
	private TipoPlano plano;
	private List<Playlist> diretorioMusicas;
	
	public static ServicoStreaming getInstance () {
		/* Usando "lazy initialization": cria a instancia se ainda não foi criada. */
		if (instance == null)
			instance = new ServicoStreaming();
		return instance;
	}
	
	public void inicializaServico (String login, String senha, TipoPlano plano) {
		this.login = login;
		this.senha = senha;
		this.plano = plano;
		this.diretorioMusicas = new ArrayList<Playlist>();
	}
	
	public void add (Playlist playlist) {
		diretorioMusicas.add(playlist);
	}
	
	public void remove (Playlist playlist) {
		diretorioMusicas.remove(playlist);
	}
	
	public String getLogin () {
		return login;
	}
	
	public String getSenha () {
		return senha;
	}
	
	public TipoPlano getPlano () {
		return plano;
	}
	
	public List<Playlist> getDiretorio () {
		return diretorioMusicas;
	}
	
}

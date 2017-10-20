package br.sceweb.servico;

/**
 * 
 * @author Guilherme
 *	@version 1.2
 */
public class ConfiguraDB {
	String url = "";
	String driver = "";
	String usuario = "";
	String senha = "";
	
	/**
	 * configuração do banco
	 * @param url
	 * @param driver
	 * @param usuario
	 * @param senha
	 */
	public ConfiguraDB(String url, String driver, String usuario, String senha) {
		this.url = url;
		this.driver = driver;
		this.usuario = usuario;
		this.senha = senha;
	}
	/**
	 * pega a url
	 * @return
	 */
	
	public String getUrl() {
		return url;
	}
	/**
	 * pega o driver
	 * @return
	 */
	public String getDriver() {
		return driver;
	}
	/**
	 * pega o usuario
	 * @return
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * pega a senha
	 * @return
	 */
	public String getSenha() {
		return senha;
	}
	
	
}
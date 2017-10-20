package br.sceweb.servico;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

/**
 * 
 * @author Guilherme
 * @version 1.2
 */
public class FabricaDeConexoes {

	String url = "jdbc:mysql://localhost/sceweb";
	String driver = "com.mysql.jdbc.Driver";
	String usuario = "root";
	String senha = "";

	/**
	 * pega os elementos da conexão com o banco
	 * @param configura
	 */
	public FabricaDeConexoes(ConfiguraDB configura) {
		this.url = configura.getUrl();
		this.driver = configura.getDriver();
		this.usuario = configura.getUsuario();
		this.senha = configura.getSenha();
	}
	/**
	 * 
	 */
	public FabricaDeConexoes() {

	}
	/**
	 * faz a conexão com o banco
	 * @return
	 */
	public Connection getConnection() {
		try {
			Class.forName(driver);
			return (Connection) DriverManager.getConnection(url, usuario, senha);
		} catch (CommunicationsException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
			
		}
	}
}

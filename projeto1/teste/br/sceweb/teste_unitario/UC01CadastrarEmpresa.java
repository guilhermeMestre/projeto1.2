package br.sceweb.teste_unitario;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.sceweb.model.Empresa;
import br.sceweb.model.EmpresaDAO;
import br.sceweb.servico.ConfiguraDB;
/**
 * Este script de teste verifica o comportamento do caso de uso UC01CadastrarEmpresa
 * @author professor
 * @version 1.2
 */
public class UC01CadastrarEmpresa {
	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	static ConfiguraDB configuraDB;
	static ConfiguraDB configuraDB1;
	
	/**
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String url = "jdbc:mysql://localhost/sceweb";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "alunofatec";
		configuraDB = new ConfiguraDB(url, driver,usuario,senha);
		empresaDAO = new EmpresaDAO(configuraDB);
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}
	/**
	 * ID - CT01UC01FBCadastra_com_sucesso
	 * Objetivo - verificar o comportamento do sistema na inclusao de empresa com 
	 * sucesso
	 * Pré-condiçao - O cnpj 89424232000180 nao esta cadastrado.
	 */
	@Test
	public void CT01UC01FBCadastra_com_sucesso() {
		String url = "jdbc:mysql://localhost/sceweb";
		assertEquals(1,empresaDAO.adiciona(empresa));
	}
	
	/**
	 * teste para cadastro invalido 
	 */
	@Test
	public void CT02UC01FBCadastra_cnpj_invalido() {
		assertEquals("CNPJ invalido.",empresa.setCnpj("89424"));
	}
	/**
	 * teste para cadastrar o cnpj ja cadastrado
	 */
	@Test
	public void CT03UC01FBCadastra_cnpj_ja_cadastrado() {
		empresaDAO.adiciona(empresa);
		assertEquals(0,empresaDAO.adiciona(empresa));
	}
	/**
	 * teste de cadastro invalido
	 */
	@Test
	public void CT04UC01FBCadastra_db_invalido() {
		String url = "jdbc:mysql://localhost/sceweb1";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "alunofatec";
		configuraDB1 = new ConfiguraDB(url, driver,usuario,senha);
		empresaDAO = new EmpresaDAO(configuraDB);
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
		empresaDAO.adiciona(empresa);
		
	}
	/**
	 * teste para cadastrar empresa em branco
	 */
	@Test
	public void CT05UC01FBCadastra_db_branco(){
		String url = "jdbc:mysql://localhost/sceweb1";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "alunofatec";
		configuraDB1 = new ConfiguraDB(url, driver,usuario,senha);
		empresaDAO = new EmpresaDAO(configuraDB);
		empresa = new Empresa();
		empresa.setNomeDaEmpresa(" ");
		empresa.setCnpj("");
		empresa.setNomeFantasia("");
		empresa.setEndereco("");
		empresa.setTelefone("");
		empresaDAO.adiciona(empresa);
	}
	/**
	 * teste para cadastrar uma empresa já cadastrada
	 */
	@Test
	public void CT06UC01FBjaCadastrado_db() {
		String url = "jdbc:mysql://localhost/sceweb1";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "alunofatec";
		configuraDB1 = new ConfiguraDB(url, driver,usuario,senha);
		empresaDAO = new EmpresaDAO(configuraDB);
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
		empresaDAO.adiciona(empresa);
	}
	
	/**
	 * exclui o cnpj
	 * @throws Exception
	 */
	@After
	public void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("89424232000180");
	}
}




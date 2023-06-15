package bddados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement; /* todos os imports neessarios para execução*/

public class Bddados {

	// Variáveis que exercem controle do banco de dados //
	private Connection connection = null; /* gerenciar conexão com o banco de dados */
	private Statement statement = null;   /* gerenciar consultas com o banco de dados */
	private ResultSet resultset = null;   /* armazenamento de informações buscadas */

	//CRIANDO A CONEXÃO COM O BANCO DE DADOS // 
	public void conectar() {
		String servidor = "jdbc:postgresql://localhost:5432/postgres"; /* endereços a serem encontrados estão aqui */
		String usuario = "postgres";
		String senha = "18899525757";

		//CRIADO PARA DESCOBRIR SE A CONEXÃO FUNCIONOU // 

		try {
			Class.forName("org.postgresql.Driver"); /* a entrada do driver se torna o parametro usado para conexão do banco */
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			statement = this.connection.createStatement();
			System.out.println("Conexão realizada!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public boolean conexao() {
		if(this.connection != null) {
			return true;
		} else {
			return false;
		}
	} /* enquanto a conexão for diferente de nulo, ou seja, enquanto houver um banco de dados, ele responde com o programa */

	// APRESENTAÇÃO DE FUNÇÕES //

	/* inserções no banco */

	public void InserirCliente (String cpf_cliente, String nome_cliente, String endereco_cliente, String contato_cliente) {
		try {
			String query /* query = consulta */ = "INSERT INTO cliente (cpf_cliente, nome_cliente, endereco_cliente, contato_cliente) "
					+ "VALUES ('89014444567', 'Tharsyla Jones', 'Rua João Cardoso dos Santos 53 Bolívia Valença BA', 75938475009)"; /* ordens de comando */
			this.statement.executeUpdate(query); /* busca as informações */
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void InserirFuncionario (String id_funcionario, String nome_funcionario, String contato_funcionario) {

		try {
			String query /* query = consulta */ = "INSERT INTO funcionario (id_funcionario, nome_funcionario, contato_funcionario) "
					+ "VALUES ('6789', 'Gabriela Rocha', '71838400999')"; /* apresenta o comando dado */
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void InserirProduto (String id_produto, String modelo, String tamanho) {

		try {
			String query /* query = consulta */ = "INSERT INTO produto (id_produto, modelo, tamanho) "
					+ "VALUES ('7', 'Viseira Elastica Sha la la', 'M')"; /* apresenta o comando dado */
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	/* estoque */
	public void InserirEstoque (String id_estoque, String quantidade, String id_produto) {

		try {
			String query /* query = consulta */ = "INSERT INTO estoque (id_estoque, quantidade, id_produto) "
					+ "VALUES ('7684', '5', '7');"; /* apresenta o comando dado */
			this.statement.executeUpdate(query); /* retorno ao query acima aplicação no banco */
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	/* venda */

	public void EfetuarVenda (String nota_fiscal, String tipo_pagamento, String id_produto, String id_funcionario) {
		try {
			String query /* query = consulta */ = "INSERT INTO venda (nota_fiscal, tipo_pagamento, id_produto, id_funcionario) "
					+ "VALUES ('256987', 'Pix', '5', '1458');"; /* apresenta o comando dado */
			this.statement.executeUpdate(query); /* retorno ao query acima aplicação no banco */
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void CancelamentoVenda (String nota_fiscal, String tipo_pagamento, String id_produto, String id_funcionario) {
		try { 
			String query /* query = consulta */ = "DELETE FROM venda WHERE nota_fiscal = " + nota_fiscal + ";"; /* apresenta o comando dado */
			this.statement.executeUpdate(query);
			System.out.println("Nota: " + nota_fiscal + " cancelada!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	/* apresentação das listagens */
	public void ListarClientes() {
		try {
			String query /* query = consulta */ = "SELECT * FROM cliente"; /* apresenta o comando dado */
			this.resultset = statement.executeQuery(query); /* retorno ao query acima aplicação no banco */
			while (this.resultset.next()) {
				System.out.println("CPF: " + this.resultset.getString("cpf_cliente") /* o resultset armazena a string fornecida alojada em getstring */
				+ " - Nome: " + this.resultset.getString("nome_cliente") + " - Endereço: " + this.resultset.getString("endereco_cliente") 
				+ " - Contato: " + this.resultset.getString("contato_cliente"));
			} /* se houve um próximo item, ele passa executando */
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		} /* caso de erro */

	}

	public void ListarFuncionarios() {

		try {
			String query /* query = consulta */ = "SELECT * FROM funcionario" ; /* apresenta o comando dado */
			this.resultset = this.statement.executeQuery(query); 
			/* se houve um proximo item, ele passa executando */
			while(this.resultset.next()) {
				System.out.println("ID: " + this.resultset.getString("id_funcionario") 
				+ " - Nome: " + this.resultset.getString("nome_funcionario") + " - Endereço: "  
				+ " - Contato: " + this.resultset.getString("contato_funcionario"));
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

	public void ListarProdutos() {

		try {
			String query /* query = consulta */ = "SELECT * FROM produto" ; /* apresenta o comando dado */
			this.resultset = this.statement.executeQuery(query);
			/* se houve um proximo item, ele passa executando */
			while(this.resultset.next()) {
				System.out.println("ID: " + this.resultset.getString("id_produto") 
				+ " - Modelo: " + this.resultset.getString("modelo") 
				+ " - Tamanho: " + this.resultset.getString("tamanho"));
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

	public void ListarEstoque() {

		try {
			String query /* query = consulta */ = "SELECT * FROM estoque" ; /* apresenta o comando dado */
			this.resultset = this.statement.executeQuery(query);
			/* se houve um proximo item, ele passa executando */
			while(this.resultset.next()) {
				System.out.println("ID: " + this.resultset.getString("id_estoque") 
				+ " - Quantidade: " + this.resultset.getString("quantidade") 
				+ " - ID: " + this.resultset.getString("id_produto"));
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

	/* edição no banco */

	public void EditarCliente(String cpf_cliente, String nome_cliente, String endereco_cliente) {
		try {
			String query /* query = consulta */ = "UPDATE cliente SET endereco_cliente = '" + endereco_cliente 
					+ "'WHERE cpf_cliente = '" + cpf_cliente + "'"; /* apresenta o comando dado */
			this.statement.executeUpdate(query); /* informação fornecida pelo/ao banco de dados */
			System.out.println("Cliente " + nome_cliente + " editado!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void EditarFuncionario( String id_funcionario, String contato_funcionario, String nome_funcionario) {
		try {
			String query /* query = consulta */ = "UPDATE funcionario SET contato_funcionario = '" + contato_funcionario + 
					"'WHERE id_funcionario = '" + id_funcionario + "'"; /* apresenta o comando dado */
			this.statement.executeUpdate(query); /* informação fornecida pelo/ao banco de dados */
			System.out.println("Funcionário " + nome_funcionario + " editado!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void EditarProduto(String id_produto, String modelo, String tamanho) {
		try {
			String query /* query = consulta */ = "UPDATE produto SET tamanho = '" + tamanho 
					+ "'WHERE id_produto = '" + id_produto + "'"; /* apresenta o comando dado */
			this.statement.executeUpdate(query); /* informação fornecida pelo/ao banco de dados */
			System.out.println("Produto " + modelo + " editado!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void EditarEstoque(String id_estoque, String quantidade, String id_produto) {
		try {
			String query /* query = consulta */ = "UPDATE estoque SET quantidade = '" + quantidade 
					+ "'WHERE id_estoque = '" + id_estoque + "'"; /* apresenta o comando dado */
			this.statement.executeUpdate(query); /* informação fornecida pelo/ao banco de dados */
			System.out.println("Estoque do produto " + id_produto + " foi atualizado!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}


	/* remoção no banco */

	public void RemoverCliente(String cpf_cliente, String nome_cliente) {
		try { 
			String query /* query = consulta */ = "DELETE FROM cliente WHERE cpf_cliente = " + cpf_cliente + ";"; /* apresenta o comando dado */
			this.statement.executeUpdate(query); /* informação fornecida pelo/ao banco de dados */
			System.out.println("Cliente " + nome_cliente + " removido!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void RemoverFuncionario(String id_funcionario, String nome_funcionario) {
		try { 
			String query /* query = consulta */ = "DELETE FROM funcionario WHERE id_funcionario = " + id_funcionario + ";"; /* apresenta o comando dado */
			this.statement.executeUpdate(query); /* informação fornecida pelo/ao banco de dados */
			System.out.println("Funcionário: " + id_funcionario + " - " + nome_funcionario + " não trabalha mais aqui!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void RemoverProduto(String id_produto, String modelo_produto) {
		try { 
			String query /* query = consulta */ = "DELETE FROM produto WHERE id_produto = " + id_produto + ";"; /* apresenta o comando dado */
			this.statement.executeUpdate(query); /* informação fornecida pelo/ao banco de dados */
			System.out.println("Produto " + modelo_produto + " acabou no estoque!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void RemoverEstoque(String id_estoque, String id_produto) {
		try { 
			String query /* query = consulta */ = "DELETE FROM estoque WHERE id_estoque = " + id_estoque + ";"; /* apresenta o comando dado */
			this.statement.executeUpdate(query); /* informação fornecida pelo/ao banco de dados */
			System.out.println("Remoção do produto de Id: " + id_produto + " efetuada!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	/* Aplicação sobre o JOIN */

	public void JoinVenda() {
		try {
			String query = "SELECT pr.modelo AS produto, fn.nome_funcionario AS vendedor, vd.nota_fiscal AS Cod_Compra, "
					+ " vd.tipo_pagamento as pagamento FROM venda vd "
					+ "INNER JOIN produto pr ON pr.id_produto = vd.id_produto "
					+ "INNER JOIN funcionario fn ON fn.id_funcionario = VD.id_funcionario "; /* união da tabela venda com produto e funcionario*/
			/* pr, vd e fn foram siglas criadas para ser relacionada a tabela, sendo a primeira produto, a segunda estoque e terceira funcionario */

			this.resultset = statement.executeQuery(query);  /* informação fornecida pelo/ao banco de dados */
			while (this.resultset.next()) {
				System.out.println("Funcionário: " + this.resultset.getString("vendedor") /* chamada do banco por meio de uma nova nomeclatura da variavel, vendedor = id_funcionario */
				+ " - Compra: " + this.resultset.getString("Cod_Compra")                  /* Cod_Compra = nota_fiscal */
				+ " - modelo: " + this.resultset.getString("produto")                     /* produto = id_produto */
				+ " - pagamento: " + this.resultset.getString("pagamento"));              /* pagamento = tipo_pagamento */
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void JoinControle() {
		try {
			String query = "SELECT pr.id_produto AS cod, pr.modelo AS produtos, es.quantidade AS unidades FROM produto pr " 
					+ "INNER JOIN estoque es ON pr.id_produto = es.id_produto "; /* união da tabela produto com a de estoque */
			/* pr, es foram ambas siglas criadas para ser relacionada a tabela, sendo a primeira produto e a segunda estoque */
				
			this.resultset = statement.executeQuery(query);  /* informação fornecida pelo/ao banco de dados */
			while (this.resultset.next()) {
				System.out.println("ID: " + this.resultset.getString("cod") /* chamada do banco por meio de uma nova nomeclatura da variavel, cod = id_produto */
				+ " - quantidade: " + this.resultset.getString("unidades")  /* unidades = quantidade */
				+ " - modelo: " + this.resultset.getString("produtos"));    /* produtos = modelo */
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}




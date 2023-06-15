package bddados;

public class Loja {

	public static void main(String[] args) {
		
		/* Visualização de todos os métodos colocados na classe Bddados*/
		
		Bddados bddados = new Bddados();
		bddados.conectar();
		if(bddados.conexao()) {
			System.out.println("BANCO AO INICIO DO PROCESSO:");
			System.out.println(" ");
			System.out.println("CLIENTES:");
			bddados.ListarClientes();
			System.out.println(" ");
			System.out.println("FUNCIONÁRIOS:");
			bddados.ListarFuncionarios();
			System.out.println(" ");
			System.out.println("PRODUTOS:");
			bddados.ListarProdutos();
			System.out.println(" ");
			System.out.println("ESTOQUES");
			bddados.ListarEstoque();
			System.out.println(" ");
			System.out.println("APÓS O INSERÇÕES NOVAS:");
			bddados.InserirCliente("89014444567", "Tharsyla Jones", "Rua João Cardoso dos Santos 53 Bolívia Valença BA", "75938475009");
			System.out.println(" ");
			bddados.InserirFuncionario("6789", "Gabriela Rocha", "71838400999");
			System.out.println(" ");
			bddados.InserirProduto("7", "Viseira Elastica Sha la la", "M");
			System.out.println("CLIENTES CADASTRADOS:");
			bddados.ListarClientes();
			System.out.println(" ");
			System.out.println("FUNCIONÁRIOS ATIVOS:");
			bddados.ListarFuncionarios();
			System.out.println(" ");
			System.out.println("PRODUTOS EM CATÁLOGO:");
			bddados.ListarProdutos();
			System.out.println(" ");
			System.out.println("ESTOQUES: ");
			bddados.InserirEstoque("7684", "5", "7");
			bddados.ListarEstoque();
			System.out.println(" ");
			bddados.EditarCliente("89014444567", "Tharsyla Jones", "Rua Milton Manoel dos Santos 370 Jardim Camburi Vitória ES");
			bddados.ListarClientes();
			System.out.println(" ");
			bddados.EditarFuncionario("6789", "71996543258", "Gabriela Rocha");
			bddados.ListarFuncionarios();
			System.out.println(" ");
			bddados.EditarProduto("7", "Viseira Elastica Sha la la", "P");
			bddados.ListarProdutos();
			System.out.println(" ");
			bddados.EfetuarVenda("256987", "Pix", "5", "1458");
			System.out.println(" ");
			bddados.CancelamentoVenda("256987", "Pix", "5", "1458");
			System.out.println(" ");
			bddados.EditarEstoque("7684", "2", "7");
			bddados.ListarEstoque();
			System.out.println(" ");
			System.out.println("APÓS REMOÇÕES:");
			bddados.RemoverCliente("89014444567", "Thasyla Jones");
			bddados.ListarClientes();
			System.out.println(" ");
			bddados.RemoverFuncionario("6789", "Gabriela Rocha");
			bddados.ListarFuncionarios();
			System.out.println(" ");
			bddados.RemoverEstoque("7684", "7");
			bddados.RemoverProduto("7", "Viseira Elastica Sha la la");
			System.out.println(" ");
			System.out.println("CONTROLE DE PRODUTO");
			bddados.JoinControle();
			System.out.println(" ");
			System.out.println("CONTROLE DE VENDA");
			bddados.JoinVenda();
			
		} else {
			
			System.out.println("Não foi possível conectar o banco de dados!");
		}

	}

}

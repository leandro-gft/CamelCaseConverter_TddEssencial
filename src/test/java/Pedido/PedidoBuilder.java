package Pedido;

import Pedido.Desconto.CalculadoraDescontoPrimeiraFaixa;
import Pedido.Desconto.CalculadoraDescontoSegundaFaixa;
import Pedido.Desconto.CalculadoraDescontoTerceiraFaixa;
import Pedido.Desconto.CalculadoraFaixaDesconto;
import Pedido.Desconto.SemDesconto;

public class PedidoBuilder {
	
	private Pedido instancia;
	
	public PedidoBuilder() {

		CalculadoraFaixaDesconto calculadoraFaixaDesconto = 
				new CalculadoraDescontoTerceiraFaixa(
						new CalculadoraDescontoSegundaFaixa(
								new CalculadoraDescontoPrimeiraFaixa(
										new SemDesconto(null))));
		instancia = new Pedido(calculadoraFaixaDesconto);
	}
	
	
	public PedidoBuilder comItem(double valorUnitario, int qtd) {
		instancia.adicionarItem(new ItemPedido ("Gerado", valorUnitario, qtd));
		return this;
	}
	
	public Pedido construir() {
		return instancia;
	}

}

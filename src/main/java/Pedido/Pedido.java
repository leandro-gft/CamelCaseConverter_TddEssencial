package Pedido;

import java.util.ArrayList;
import java.util.List;

import Pedido.Desconto.CalculadoraFaixaDesconto;

public class Pedido {
	
	private CalculadoraFaixaDesconto calculadoraFaixaDesconto;
	
	public Pedido(CalculadoraFaixaDesconto calculadoraFaixaDesconto) {
		this.calculadoraFaixaDesconto = calculadoraFaixaDesconto;
	}

	private List<ItemPedido> itens = new ArrayList<>();
	
	public ResumoPedido resumo() {
		double valorTotal = itens.stream().mapToDouble(i -> i.getValorUnitario()*i.getQtd()).sum();
		double desconto = calculadoraFaixaDesconto.desconto(valorTotal);
		
		return new ResumoPedido(valorTotal, desconto);
	}
	
	private void validarQtdItems(ItemPedido itemPedido) {
		if (itemPedido.getQtd() < 0) 
			throw new QuantidadeItensInvalidaException();
	}
	
	public void adicionarItem(ItemPedido itemPedido) {
		validarQtdItems(itemPedido);
		
		itens.add(itemPedido);
	}

}

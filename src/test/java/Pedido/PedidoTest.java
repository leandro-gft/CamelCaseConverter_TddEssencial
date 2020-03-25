package Pedido;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PedidoTest {
	private Pedido pedido;

	@Before
	public void setup() {
		pedido = new Pedido();
	}
		
	private void assertResumoPedido(double valorTotal, double desconto) {
		assertEquals(valorTotal, pedido.valorTotal());
		assertEquals(desconto, pedido.desconto());
	}
	 
	@Test
	public void devePermitirAdicionarUmItemNoPedido() {
		pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 10));
	}
	
	@Test
	public void deveCalcularOValorTotalEDescontoParaPedidoVazio() {
		assertResumoPedido(0.0, 0.0);
	}

	@Test
	public void deveCalcularResumoParaUmItemSemDesconto() {
		pedido.adicionarItem(new ItemPedido("Sabonete", 5.0, 5));
		assertResumoPedido(25.0, 0.0);
	}
	
	
}

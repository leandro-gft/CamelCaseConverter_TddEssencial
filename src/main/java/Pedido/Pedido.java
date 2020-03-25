package Pedido;

public class Pedido {
	private double valorTotal;
	private double desconto;
	
	public void adicionarItem(ItemPedido itemPedido) {
		valorTotal = itemPedido.getValorUnitario()*itemPedido.getQtd();
		
	}

	public Object valorTotal() {
		return valorTotal;
	}

	public Object desconto() {
		return 0.0;
	}
	
}

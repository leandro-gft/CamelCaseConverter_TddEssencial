package CamelCaseConverter;

public class CamelCaseConverter {

	public String converter(String nome) {
		if (nome.split(" ").length == 1) {
		return nome.substring(0, 1).toUpperCase()+nome.substring(1).toLowerCase();
		}
		return nome.replace(" ", "");
		}	

}

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int option = 0;
		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes"));
		Banco banco = new Banco();
		while(option != 4){
			option = mainMenu.getSelection();
			mainMenu.execute(option, banco);
		}
		System.out.println("Fim");
	}
	
}

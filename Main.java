import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciaPessoa gerenciaPessoa = new GerenciaPessoa();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1- Salvar uma pessoa");
            System.out.println("2- Listar todas as pessoas");
            System.out.println("3- Deletar pessoa por e-mail");
            System.out.println("4- Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcao) {
                case 1:
                    System.out.print("Informe o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Informe o e-mail: ");
                    String email = scanner.nextLine();
                    gerenciaPessoa.salvarPessoa(new Pessoa(nome, email));
                    break;
                case 2:
                    gerenciaPessoa.listarPessoas();
                    break;
                case 3:
                    System.out.print("Digite o e-mail da pessoa para ser deletada: ");
                    String emailParaDeletar = scanner.nextLine();
                    gerenciaPessoa.deletarPessoa(emailParaDeletar);
                    break;
                case 4:
                    System.out.println("Saindo.");
                    return;
                default:
                    System.out.println("Tente novamente.");
            }
        }
    }
}


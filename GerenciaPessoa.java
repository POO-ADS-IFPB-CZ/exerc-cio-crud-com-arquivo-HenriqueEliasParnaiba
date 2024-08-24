import java.io.*;
import java.util.HashSet;
import java.util.Set;
public class GerenciaPessoa {
    private Set<Pessoa> pessoas;
    private static final String ARQUIVO = "pessoas.bin";

    @SuppressWarnings("unchecked")
    public GerenciaPessoa() {
        pessoas = new HashSet<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            pessoas = (Set<Pessoa>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum arquivo encontrado. Um novo será criado.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void salvarPessoa(Pessoa pessoa) {
        if (pessoas.add(pessoa)) {
            salvarNoArquivo();
            System.out.println("Pessoa salva!");
        } else {
            System.out.println("Esse e-mail já existe.");
        }
    }

    public void listarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            pessoas.forEach(System.out::println);
        }
    }

    public void deletarPessoa(String email) {
        Pessoa pessoaParaDeletar = null;
        for (Pessoa p : pessoas) {
            if (p.getEmail().equals(email)) {
                pessoaParaDeletar = p;
                break;
            }
        }
        if (pessoaParaDeletar != null) {
            pessoas.remove(pessoaParaDeletar);
            salvarNoArquivo();
            System.out.println("Pessoa deletada!");
        } else {
            System.out.println("Nenhuma pessoa encontrada.");
        }
    }
    private void salvarNoArquivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(pessoas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


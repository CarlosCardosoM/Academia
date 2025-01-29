/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package json;

// Importa as classes necessárias para manipulação de JSON e arquivos
import Entidades.Aluno;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Classe responsável pela conversão de objetos Aluno para JSON
 * e armazenamento em um arquivo específico. Essa funcionalidade
 * permite registrar informações sobre os alunos da academia.
 * 
 * @author Carlo
 */
public class Jsonaluno {
    
    // Caminho do arquivo JSON onde as informações dos alunos serão salvas
    public static final String Aluno = "C:/Users/Carlo/Documents/NetBeansProjects/Academia/src/Json/JsonAluno.json";
    
    // Construtor padrão da classe Jsonaluno
    public Jsonaluno() {}

    /**
     * Método estático para salvar uma lista de objetos Aluno em um arquivo JSON.
     * 
     */
    public static void salvarAluno(List<Aluno> alunos) {
        // Configura a instância Gson para gerar um JSON formatado para leitura
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        // Converte a lista de alunos para o formato JSON
        String json = gson.toJson(alunos);

        // Tenta escrever o JSON gerado no arquivo especificado
        try (FileWriter writer = new FileWriter(Aluno)) {
            // Grava o conteúdo JSON no arquivo
            writer.write(json);
            System.out.println("Alunos salvos com sucesso!"); // Mensagem de confirmação
            
        } catch (IOException e) {
            // Exibe uma mensagem de erro e a causa caso ocorra uma falha ao salvar o arquivo
            System.err.println("Erro ao salvar Aluno! Verifique o caminho do arquivo e permissões.");
            e.printStackTrace(); // Imprime o stack trace para auxiliar na identificação do erro
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Json;

// Importa as classes necessárias para manipulação de JSON e arquivos
import Entidades.Aula;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Classe responsável pela conversão de objetos Aula para JSON
 * e armazenamento em um arquivo específico. Essa funcionalidade
 * permite registrar informações sobre as aulas da academia.
 * 
 * @author Carlo
 */
public class Jsonaula {
    
    // Caminho do arquivo JSON onde as informações das aulas serão salvas
    public static final String Aula = "C:/Users/Carlo/Documents/NetBeansProjects/Academia/src/Json/JsonAula.json";
    
    // Construtor padrão da classe Jsonaula
    public Jsonaula() {}

    /**
     * Método estático para salvar uma lista de objetos Aula em um arquivo JSON.
     * 
     */
    public static void salvarAula(List<Aula> aulas) {
        // Configura a instância Gson para gerar um JSON formatado para leitura
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        // Converte a lista de aulas para o formato JSON
        String json = gson.toJson(aulas);

        // Tenta escrever o JSON gerado no arquivo especificado
        try (FileWriter writer = new FileWriter(Aula)) {
            // Grava o conteúdo JSON no arquivo
            writer.write(json);
            System.out.println("Aulas salvas com sucesso!"); // Mensagem de confirmação
            
        } catch (IOException e) {
            // Exibe uma mensagem de erro e a causa caso ocorra uma falha ao salvar o arquivo
            System.err.println("Erro ao salvar Aula! Verifique o caminho do arquivo e permissões.");
            e.printStackTrace(); // Imprime o stack trace para auxiliar na identificação do erro
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Json;

// Importa as classes necessárias para manipulação de JSON e arquivos
import Entidades.Acesso;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Classe responsável pela conversão de objetos Acesso para JSON
 * e armazenamento em um arquivo específico. Útil para registrar
 * informações sobre acessos de usuários via catraca.
 * 
 * @author Carlo
 */
public class Jsoncatraca {

    // Caminho do arquivo JSON onde os dados dos acessos serão salvos
    public static final String Catraca = "C:/Users/Carlo/Documents/NetBeansProjects/Academia/src/Json/JsonCatraca.json";
    
    // Construtor padrão da classe Jsoncatraca
    public Jsoncatraca() {}

    /**
     * Método estático para salvar uma lista de objetos Acesso em um arquivo JSON.
     * 
     */
    public static void salvarAcessos(List<Acesso> acesso) {
        // Configura a instância Gson para gerar um JSON formatado para leitura
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        // Converte a lista de acessos para o formato JSON
        String json = gson.toJson(acesso);

        // Tenta escrever o JSON gerado no arquivo especificado
        try (FileWriter writer = new FileWriter(Catraca)) {
            // Grava o conteúdo JSON no arquivo
            writer.write(json);
            System.out.println("Informação salva com sucesso!"); // Mensagem de confirmação
            
        } catch (IOException e) {
            // Exibe uma mensagem de erro e a causa caso ocorra uma falha ao salvar o arquivo
            System.err.println("Erro ao salvar Informação! Verifique o caminho do arquivo e permissões.");
            e.printStackTrace(); // Imprime o stack trace para auxiliar na identificação do erro
        }
    }
}

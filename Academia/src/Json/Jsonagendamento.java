/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Json;

// Importa as classes necessárias para manipulação de JSON e arquivos
import Entidades.Agendamento;
import academia.SistemaCentral;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Classe responsável pela conversão de objetos Agendamento para JSON
 * e armazenamento em um arquivo específico. Essa funcionalidade
 * permite registrar informações sobre os agendamentos realizados na academia.
 * 
 * @author Carlo
 */
public class Jsonagendamento {
    
    // Caminho do arquivo JSON onde as informações dos agendamentos serão salvas
    public static final String agendamento = "C:/Users/Carlo/Documents/NetBeansProjects/Academia/src/Json/JsonAgendamento.json";
    
    // Construtor padrão da classe Jsonagendamento
    public Jsonagendamento() {}
    
    /**
     * Método estático para salvar uma lista de objetos Agendamento em um arquivo JSON.
     */
    public static void salvarAgendamento(List<Agendamento> listaAgendamentos) {
        // Configura a instância Gson para gerar um JSON formatado para leitura
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        // Converte a lista de agendamentos para o formato JSON
        String json = gson.toJson(listaAgendamentos);

        // Tenta escrever o JSON gerado no arquivo especificado
        try (FileWriter writer = new FileWriter(agendamento)) {
            // Grava o conteúdo JSON no arquivo
            writer.write(json);
            System.out.println("Agendamentos salvos com sucesso!"); // Mensagem de confirmação
            
        } catch (IOException e) {
            // Exibe uma mensagem de erro e a causa caso ocorra uma falha ao salvar o arquivo
            System.err.println("Erro ao salvar Agendamento! Verifique o caminho do arquivo e permissões.");
            e.printStackTrace(); // Imprime o stack trace para auxiliar na identificação do erro
        }
    }
}

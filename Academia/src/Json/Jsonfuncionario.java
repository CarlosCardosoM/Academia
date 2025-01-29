/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Json;

// Importa as classes necessárias para manipulação de JSON e arquivos
import Entidades.Funcionario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Classe responsável pela conversão de objetos Funcionario para JSON
 * e salvamento em um arquivo específico.
 * Permite armazenar de forma persistente uma lista de funcionários em JSON.
 * 
 * @author Carlo
 */
public class Jsonfuncionario {
    
    // Caminho do arquivo JSON onde os dados dos funcionários serão salvos
    public static final String Funcionario = "C:/Users/Carlo/Documents/NetBeansProjects/Academia/src/Json/JsonFuncionario.json";
    
    // Construtor padrão da classe Jsonfuncionario
    public Jsonfuncionario() {}

    /**
     * Método estático para salvar uma lista de objetos Funcionario em um arquivo JSON.
     * 
     */
    public static void salvarFuncionario(List<Funcionario> funcionarios) {
        // Configura a instância Gson para gerar um JSON formatado para leitura
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        // Converte a lista de funcionários para o formato JSON
        String json = gson.toJson(funcionarios);

        // Tenta escrever o JSON gerado no arquivo especificado
        try (FileWriter writer = new FileWriter(Funcionario)) {
            // Grava o conteúdo JSON no arquivo
            writer.write(json);
            System.out.println("Funcionários salvos com sucesso!"); // Mensagem de confirmação
            
        } catch (IOException e) {
            // Exibe uma mensagem de erro e a causa caso ocorra uma falha ao salvar o arquivo
            System.err.println("Erro ao salvar Funcionário! Verifique o caminho do arquivo e permissões.");
            e.printStackTrace(); // Imprime o stack trace para auxiliar na identificação do erro
        }
    }
}

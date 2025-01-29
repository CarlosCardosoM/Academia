/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Json;

// Importa as classes necessárias para a conversão em JSON e manipulação de arquivos
import Entidades.Gerente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Classe responsável pela conversão de objetos Gerente para JSON
 * e armazenamento em um arquivo específico.
 * Permite salvar uma lista de gerentes de forma persistente em JSON.
 * 
 * @author Carlo
 */
public class Jsongerente {
    
    // Caminho do arquivo JSON onde os dados dos gerentes serão salvos
    public static final String Gerente = "C:/Users/Carlo/Documents/NetBeansProjects/Academia/src/Json/JsonGerente.json";
    
    // Construtor da classe Jsongerente
    public Jsongerente() {}

    /**
     * Método estático para salvar uma lista de objetos Gerente em um arquivo JSON.
     */
    public static void salvarGerente(List<Gerente> gerentes) {
        // Configura a instância Gson para gerar um JSON com formatação legível (pretty printing)
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        // Converte a lista de gerentes para JSON
        String json = gson.toJson(gerentes);

        // Tenta escrever o JSON gerado no arquivo especificado
        try (FileWriter writer = new FileWriter(Gerente)) {
            // Grava o conteúdo JSON no arquivo
            writer.write(json);
            System.out.println("Gerentes salvos com sucesso!"); // Confirmação de sucesso
            
        } catch (IOException e) {
            // Exibe uma mensagem de erro e a causa caso ocorra uma falha ao salvar o arquivo
            System.err.println("Erro ao salvar Gerente! Verifique o caminho do arquivo e permissões.");
            e.printStackTrace(); // Imprime o stack trace para detalhamento do erro
        }
    }
}

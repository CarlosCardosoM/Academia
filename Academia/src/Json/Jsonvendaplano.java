/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Json;

// Importa as classes necessárias para a conversão em JSON e manipulação de arquivos
import Entidades.VendaPlano;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Classe responsável pela conversão de objetos VendaPlano para JSON e
 * armazenamento em arquivo.
 * Essa classe possibilita salvar uma lista de vendas de planos de forma persistente.
 * 
 * @author Carlo
 */
public class Jsonvendaplano {
    
    // Caminho do arquivo JSON onde os dados das vendas serão salvos
    public static final String vendaplano = "C:/Users/Carlo/Documents/NetBeansProjects/Academia/src/Json/JsonVendaPlano.json";
    
    // Construtor da classe Jsonvendaplano
    public Jsonvendaplano() {}

    /**
     * Método estático para salvar uma lista de objetos VendaPlano em um arquivo JSON.
     * 
     */
    public static void salvarVendaPlano(List<VendaPlano> listaVendasPlanos) {
        // Configura a instância Gson para gerar um JSON com formatação legível (pretty printing)
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        // Converte a lista de vendas para JSON
        String json = gson.toJson(listaVendasPlanos);

        // Tenta escrever o JSON gerado no arquivo especificado
        try (FileWriter writer = new FileWriter(vendaplano)) {
            // Grava o conteúdo JSON no arquivo
            writer.write(json);
            System.out.println("Venda de plano salva com sucesso!"); // Confirmação de sucesso
            
        } catch (IOException e) {
            // Exibe uma mensagem de erro e a causa caso ocorra uma falha ao salvar o arquivo
            System.err.println("Erro ao salvar venda! Verifique o caminho do arquivo e permissões.");
            e.printStackTrace(); // Imprime o stack trace para detalhamento do erro
        }
    }
}

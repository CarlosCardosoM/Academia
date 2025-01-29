/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Json;

// Importa as classes necessárias para conversão em JSON e manipulação de arquivos
import Entidades.Venda;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Classe responsável pela conversão de objetos Venda para JSON e
 * armazenamento em arquivo.
 * Permite salvar uma lista de vendas de forma persistente.
 * 
 * @author Carlo
 */
public class Jsonvenda {
    
    // Caminho do arquivo JSON onde os dados das vendas serão salvos
    public static final String Venda = "C:/Users/Carlo/Documents/NetBeansProjects/Academia/src/Json/JsonVenda.json";
    
    // Construtor da classe Jsonvenda
    public Jsonvenda() {}

    /**
     * Método estático para salvar uma lista de objetos Venda em um arquivo JSON.
     * 
     */
    public static void salvarAluno(List<Venda> listaVendas) {
        // Configura a instância Gson para gerar um JSON com formatação legível (pretty printing)
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        // Converte a lista de vendas para JSON
        String json = gson.toJson(listaVendas);

        // Tenta escrever o JSON gerado no arquivo especificado
        try (FileWriter writer = new FileWriter(Venda)) {
            // Grava o conteúdo JSON no arquivo
            writer.write(json);
            System.out.println("Venda salva com sucesso!"); // Confirmação de sucesso
            
        } catch (IOException e) {
            // Exibe uma mensagem de erro e a causa caso ocorra uma falha ao salvar o arquivo
            System.err.println("Erro ao salvar venda! Verifique o caminho do arquivo e permissões.");
            e.printStackTrace(); // Imprime o stack trace para detalhamento do erro
        }
    }
}

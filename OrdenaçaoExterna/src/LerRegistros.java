import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LerRegistros {
    private int contAcesso;
    private int contComp;
    private int contTroca;

    public LerRegistros(int n){
        this.contAcesso++;
        String arch = "";
        for(int i=0; i < n ; i++){
            Registros a = new Registros(i);
            a.geraRegistros();
            arch += a.escreverEmCSV() + "\n";
        }
        CriarArquivo(arch, "Arquivos//Desordenacao.csv", false);
        this.contAcesso++;
        this.contComp=0;
        this.contTroca=0;
    }

    public int getContAcesso() {
        return contAcesso;
    }
    public int getContComp() {
        return contComp;
    }
    public int getContTroca() {
        return contTroca;
    }

    public static void CriarArquivo(String texto, String path, boolean adiciona){
        try(BufferedWriter arquivo = new BufferedWriter(new FileWriter(path , adiciona))){
            arquivo.write(texto);

        }catch(IOException erro){
            System.out.println("Erro: " + erro);
        }
    }

    public static void CriarArquivo(List<Registros> lista, String path, boolean adiciona){
        try(BufferedWriter arquivo = new BufferedWriter(new FileWriter(path , adiciona))){
            for(Registros registro : lista){
                arquivo.write(registro.escreverEmCSV() + "\n");
            }

        }catch(IOException erro){
            System.out.println("Erro: " + erro);
        }
    }

    public static String lerArquivo(String path, int inicio, int fim){
        String texto = "";
        try(BufferedReader arquivo = new BufferedReader(new FileReader(path))){
            String linha = arquivo.readLine(); 
            int cont = 1;
            while(linha != null){
                if(cont >= inicio && cont <= fim){
                    texto += linha + "\n";
                }
                linha = arquivo.readLine();
                cont++;
            }
        }catch(IOException erro){
            System.out.println("Erro: " + erro);
        }
        return texto;
    }

    public static String lerArquivo(String path){
        String texto = "";
        try(BufferedReader arquivo = new BufferedReader(new FileReader(path))){
            String linha = arquivo.readLine(); 
            while(linha != null){
                texto += linha + "\n";
                linha = arquivo.readLine();
            }
        }catch(IOException erro){
            System.out.println("Erro: " + erro);
        }
        return texto;
    }
}
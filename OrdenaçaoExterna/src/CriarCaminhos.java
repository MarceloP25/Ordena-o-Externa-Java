import java.util.ArrayList;
import java.util.List;

public class CriarCaminhos {
    private int contComp[];
    private int contTroca[];
    private int contAcesso[];

    public CriarCaminhos(int n){
        this.contComp = new int[9];
        this.contTroca = new int[9];
        this.contAcesso = new int[9];

        ArquivosToLista(n);
    }
    

    public int[] getContComp() {
        return contComp;
    }
    public int[] getContTroca() {
        return contTroca;
    }
    public int[] getContAcesso() {
        return contAcesso;
    }

    public void ArquivosToLista(int n){
        List<Registros> lista = new ArrayList<Registros>();
        int k = 1;
        int l = n;
        String text;
        for(int i=1; i <= 8; i++){
            text = LerRegistros.lerArquivo("Arquivos//Desordenacao.csv", k, l);
            k += n;
            l += n;
            String[] vetorS = text.split("\n");
            for(String r: vetorS){
                lista.add(Registros.stringToRegistro(r));
            }
            MergeSort m = new MergeSort(lista);
            this.contComp[i] = m.getComparacoes();
            this.contTroca[i] = m.getTrocas();
            this.contAcesso[i] = 2;
            text = "";
            for(Registros r: lista){
                text += r.escreverEmCSV()+"\n";
            }
            LerRegistros.CriarArquivo(text, "Arquivos//Caminho"+ i + ".csv", false);
            lista = new ArrayList<Registros>();
        } 
    }

    public void imprimi(){
        for(int i=1; i<=8; i++){
            System.out.println(this.contAcesso[i]+"-"+this.contComp[i]+"-"+this.contTroca[i]);
        }
    }
}

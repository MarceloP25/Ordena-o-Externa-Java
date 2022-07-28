import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    private int comparacoes = 0;
    private int trocas = 0;

    //Contruntor
    public MergeSort(List<Registros> lista){
        List<Registros> dados = new ArrayList<Registros>(lista);
        performaOrdenacao(lista, dados, 0, lista.size()-1);
    }

    //Getters
    public int getComparacoes(){
        return this.comparacoes;
    }
    public int getTrocas(){
        return this.trocas;
    }

    private void performaOrdenacao(List<Registros> lista, List<Registros> dados, int inicio, int fim) {
		if(inicio < fim) {
			int meio = (inicio + fim) / 2;
            this.comparacoes++;
			performaOrdenacao(lista, dados, inicio, meio);
			performaOrdenacao(lista, dados, meio + 1, fim);
			merge(lista, dados, inicio, meio, fim);
		}
	}
	
	public void merge(List<Registros> lista, List<Registros> dados, int inicio, int meio, int fim) {
		for(int k = inicio; k <= fim; k++) {
            dados.set(k, lista.get(k));
		}
		int i = inicio;
		int j = meio + 1;
		
		for(int k = inicio; k <= fim; k++) {
			if(i > meio) {	
                lista.set(k,dados.get(j++));
                this.trocas++;
                this.comparacoes++;
			}else if (j > fim){
                lista.set(k,dados.get(i++));
                this.trocas++;
                this.comparacoes += 2;
			}else if(comparaRegistro(dados.get(i), dados.get(j)) == -1){
                lista.set(k,dados.get(i++));
                this.trocas++;
                this.comparacoes += 3;
            }else
            {
                lista.set(k,dados.get(j++));
                this.trocas++;
                this.comparacoes += 3;
			}
		}
	}

    public static int comparaRegistro(Registros a, Registros b){
        int cepA = Integer.parseInt(a.getCEP().replace("-", ""));
        int cepB = Integer.parseInt(b.getCEP().replace("-", ""));
        int resposta = 1;
        if(cepA < cepB){
            resposta = -1;
        }else if(cepA == cepB){
            if(a.getSexo() == 'F' && b.getSexo() == 'M'){
                resposta = -1;
            }else if(a.getSexo() == b.getSexo()){
                if(a.getIdade() < b.getIdade()){
                    resposta = -1;
                }else if(a.getIdade() == b.getIdade()){
                    int ordem = a.getNome().compareTo(b.getNome());
                    if(ordem == (-2)){
                        resposta = -1;
                    }else if(ordem == 0){
                        resposta = 0;
                    }else{
                        resposta = 1;
                    }
                }
            }
        }
        return resposta;
    }
}
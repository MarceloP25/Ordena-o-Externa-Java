import java.util.ArrayList;
import java.util.List;

public class OrdenarArquivos {
	List<Registros> registros;
	private int contAcesso;
    private int contComp;
    private int contTroca;

    public OrdenarArquivos(){
		this.registros = new ArrayList<Registros>();
        this.intercalar();
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

	private void intercalar(){
        List<List<Registros>> caminhos = new ArrayList<List<Registros>>();
        this.preencherCaminhos(caminhos);
        this.intercalarCaminhos(caminhos);
    }
    
    private void preencherCaminhos(List<List<Registros>> caminhos){
        for(int i = 0; i < 8; i++){
			this.contAcesso++;
            String caminho = LerRegistros.lerArquivo("Arquivos//Caminho"+ (i + 1) + ".csv");
            caminhos.add(registrosCsvToList(caminho));
        }
    }
    
    private List<Registros> registrosCsvToList(String text){
        List<Registros> lista = new ArrayList<Registros>();
        String[] registros = text.split("\n");
        for(String registro : registros){
            lista.add(Registros.stringToRegistro(registro));
        }
        return lista;
    }

    private void intercalarCaminhos(List<List<Registros>> caminhos){
		Registros menor = null;
		int indexMenor = 0;
		for(int i = 0; i < caminhos.size(); i++){
			if(i == 0 && caminhos.get(i).get(0) != null){
				menor = caminhos.get(i).get(0);
				indexMenor = i;
			}else if(MergeSort.comparaRegistro(menor, caminhos.get(i).get(0)) == 1 && caminhos.get(i).get(0) != null){
				indexMenor = i;
				menor = caminhos.get(i).get(0);
			}
        }
		this.registros.add(menor);
		caminhos.get(indexMenor).remove(0);
		LerRegistros.CriarArquivo(this.registros , "Arquivos//Ordenado.csv", true);
		this.contAcesso++;
		this.registros.remove(0);
		this.removerVazias(caminhos);
		if(!caminhos.isEmpty()){
			intercalarCaminhos(caminhos);
		}
    }

    private void removerVazias(List<List<Registros>> listaRegistros){
		for(int i = 0; i < listaRegistros.size(); i++){
			if(this.ListaEVazia(listaRegistros.get(i))){
				listaRegistros.remove(i);
			}
		}
	}
	private boolean ListaEVazia(List<Registros> listaRegistros){
		boolean resposta = true;
		for(Registros registro : listaRegistros){
			if(registro != null){
				resposta = false;
			}
		}
		return resposta;
	}
}

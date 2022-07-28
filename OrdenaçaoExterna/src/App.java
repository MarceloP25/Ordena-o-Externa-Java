import java.io.File;

public class App {

    public static void deletaArquivo(String caminho){
        File arquivo = new File(caminho);
        arquivo.delete();
    }

    public static void informacoes(){
        System.out.println("/*************************************************************/");
        System.out.println("/* Aluno: Marcelo Prata Patricio                             */");
        System.out.println("/* Matricula: 2021008470                                     */");
        System.out.println("/* Curso: Ciencia da Computacao                              */");
        System.out.println("/* 2° Trabalho Pratico -- Ordenacao Externa                  */");
        System.out.println("/* DCC288 -- 2022 -- IFSEMG, 3o.                             */");
        System.out.println("/* Prof. Flavio Augusto de Freitas                           */");
        System.out.println("/* Compilador: Visual Studio Code                            */");
        System.out.println("/* Sistema Operacional: Windows 10 Pro                       */");
        System.out.println("/*************************************************************/");
        System.out.println("/* Aluno: Leonardo Gravina Carlos                            */");
        System.out.println("/* Matricula: 2021008819                                     */");
        System.out.println("/* Curso: Ciencia da Computacao                              */");
        System.out.println("/* 2° Trabalho Pratico -- Ordenacao Externa                  */");
        System.out.println("/* DCC288 -- 2022 -- IFSEMG, 3o.                             */");
        System.out.println("/* Prof. Flavio Augusto de Freitas                           */");
        System.out.println("/* Compilador: Visual Studio Code                            */");
        System.out.println("/* Sistema Operacional: Windows 10 Pro                       */");
        System.out.println("/*************************************************************/");
    }

    public static String espaço(int valor){
        String aux = "";
        for(int i = 0; i <= valor; i++){
            aux+=" ";
        }
        return aux;
    }

    public static void deletaArquivos(){
        deletaArquivo("Arquivos//Desordenacao.csv");
        for(int i = 1; i <= 8; i++){
            deletaArquivo("Arquivos//Caminho" + i + ".csv");
        }
        deletaArquivo("Arquivos//Ordenado.csv");

    }

    public static void main(String[] args) throws Exception {
        Cronometro tempTotal = new Cronometro();
        tempTotal.inicioTimer();

        informacoes();

        int registros = 800;
        deletaArquivos();
        
        LerRegistros ler = new LerRegistros(registros);
        
        Cronometro tempIntercala = new Cronometro();
        tempIntercala.inicioTimer();
        CriarCaminhos cam = new CriarCaminhos(registros/8);//numero de registros em cada caminho
        
        OrdenarArquivos ord = new OrdenarArquivos();
        tempIntercala.fimTimer();
        tempTotal.fimTimer();
        System.out.println("\n/**************************************************************/");
        System.out.println("O tempo de intercalacao e de " + tempIntercala.getTempo() + " milissegundos");
        System.out.println("O tempo total e de " + tempTotal.getTempo() + " milissegundos");
        System.out.println("/**************************************************************/\n");

        System.out.println("/**************************************************************/");
        System.out.println("                            Acesso      Comparação      Troca */");
        System.out.println("/* Arquivo Desordenado:      "+ler.getContAcesso()+espaço(10)+ler.getContComp()+espaço(14)+ler.getContTroca()+"  */");
        for(int i = 1; i <=8; i++){
            System.out.println("/* caminho "+ i + ":"+ espaço(15) +cam.getContAcesso()[i]+espaço(10)+cam.getContComp()[i]+espaço(11)+cam.getContTroca()[i]+"  */");
        }
        System.out.println("/* Arquivo Ordenado:         "+ord.getContAcesso()+espaço(8)+ord.getContComp()+espaço(14)+ord.getContTroca()+"  */");
        System.out.println("/**************************************************************/");
    }
}
public class Registros {
    private int id;
    private String CEP;
    private char sexo;
    private int idade;
    private String nome;
    private String CPF;

    public void setCEP(String cEP) {
        CEP = cEP;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public int getId() {
        return id;
    }

    public String getCEP() {
        return CEP;
    }

    public char getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public Registros(int id){
        this.id = id;
        this.CEP = "";
        this.sexo = ' ';
        this.idade = 0;
        this.nome = "";
        this.CPF = "";
    }
    public Registros(int id, String CEP, char sexo, int idade, String nome, String CPF){
        this.id = id;
        this.CEP = CEP;
        this.sexo = sexo;
        this.idade = idade;
        this.nome = nome;
        this.CPF = CPF;
    }

    public void geraRegistros(){
        this.CEP = geraCEP();
        this.sexo = geraSexo();
        this.idade = geraIdade();
        this.nome = geraNome();
        this.CPF = geraCPF();
    }
    /*Funçao para gerar os CEPs */
    public String geraCEP(){
        String CEP = "";
        for(int i=0; i<8 ; i++){
            int a = random(0,9);
            CEP += Integer.toString(a);
            if(i==4){
                CEP += "-";
            }
        }
        return CEP;
    }
    /*Funçao para gerar o sexo */
    public char geraSexo(){
        int S = random(1,2);
        char sexo = ' ';
        if(S == 1){
            sexo = 'M';
        }else{
            if(S == 2){
                sexo = 'F';
            }
        }
        return sexo;
    }
    /*Funçao para gerar a idade */
    public int geraIdade(){
        int idade = 0;
        idade = random(1,99);
        return idade;
    }
    /*Funçao apra criar nomes */
    public String geraNome(){
        String nome = "";
        for(int i=0; i <=8; i++){
            nome += (char) random(97,122);
        }

        return nome;
    }
    /*Funçao para gerar CPFs */
    public String geraCPF(){
        String CPF = "";
        for(int i=1; i<=11; i++){
            int c = random(0,9);
            CPF += Integer.toString(c);
            if(i == 3 || i == 6){
                CPF += ".";
            }else{
                if(i == 9){
                    CPF += "-";
                }
            }
        }
        return CPF;
    }

    public static int random(int min, int max){
        return (int)Math.floor(Math.random()*(max - min + 1)+ min);
    }

    public String escreverEmCSV(){
        return (String) Integer.toString(this.id) + ";" + (this.CEP) + ";" + (this.sexo) + ";" + Integer.toString(this.idade) + ";" + (this.nome) + ";" + (this.CPF) + ";";
    }

    public static Registros stringToRegistro(String h){
        String[] vetorS = h.split(";");
        Registros registro = new Registros(Integer.parseInt(vetorS[0]));
        registro.setCEP(vetorS[1]);
        registro.setSexo(vetorS[2].charAt(0));
        registro.setIdade(Integer.parseInt(vetorS[3]));
        registro.setNome(vetorS[4]);
        registro.setCPF(vetorS[5]);
        return registro;
    }

    @Override
    public String toString(){
        return "[ " + Integer.toString(this.id) + ", " + this.CEP + ", " + this.sexo + 
        ", " + this.idade + ", " + this.nome + ", " + this.CPF + " ]\n";
    }
}

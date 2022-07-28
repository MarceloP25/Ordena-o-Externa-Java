public class Cronometro {
    private long tempo;

    public void inicioTimer(){
        tempo = System.nanoTime();
    }

    public long fimTimer(){
        tempo = System.nanoTime() - this.tempo;
        return getTempo();
    }

    public long getTempo(){
        return tempo/(long)1000000;
    }
}
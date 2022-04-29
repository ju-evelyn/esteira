
public class Pedido implements Comparable<Pedido> {
    private int numProdutos;
    private int prazo;
    public static final int VOLUME_PRODUTO = 250;
    Pedido(int numProdutos, int prazo){
        setNumProdutos(numProdutos);
        setPrazo(prazo);
    }
    public void setNumProdutos(int numProdutos) {
        this.numProdutos = numProdutos;
    }
    public int getNumProdutos() {
        return numProdutos;
    }
    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }
    public int getPrazo() {
        return prazo;
    }
    @Override
    public int compareTo(Pedido o) {
        if(this.prazo==0)return 1;
        if(this.prazo>o.getPrazo()){
            return 1;
        } else if(this.prazo<o.getPrazo()){
            return -1;
        } else {
            return 0;
        }
    }
    @Override
    public String toString() {
        return "prazo: "+this.prazo+" produtos: "+this.getNumProdutos();
    }
}
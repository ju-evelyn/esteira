import java.util.ArrayList;
import java.util.Collections;
public class Cliente implements Comparable<Cliente> {
    private String nome;
    private ArrayList<Pedido> pedidos;

    Cliente(String nome){
        this.setNome(nome);
        ArrayList<Pedido> pedidosConstruct = new ArrayList<Pedido>();
        this.pedidos = pedidosConstruct;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    public Pedido getPedido0(){
        return this.pedidos.get(0);
    }
    public void addPedido(int numProdutos, int prazo){
        Pedido novo = new Pedido(numProdutos, prazo);
        this.pedidos.add(novo);
        this.ordenarPorPrazo();
        if (this.pedidos.size()>1) {
            this.ajustarPedidos();
        }
    }
    public void removePedido(){
        this.pedidos.remove(0);
    }
    private void ordenarPorPrazo(){
        for(int i=0;i<pedidos.size();i++){
            if(pedidos.get(i).getPrazo()==0){
                Collections.swap(pedidos, i, pedidos.size()-1);
            }
        }
        Collections.sort(this.pedidos);
    }
    private void ajustarPedidos(){
        int produtosDoPedido;
        int produtosDoProximo;
        int falta;
        int count=0;
        for(int i=0;i<pedidos.size()-1;i++){
            produtosDoPedido = this.pedidos.get(count).getNumProdutos();
            produtosDoProximo = this.pedidos.get(count+1).getNumProdutos();
            falta = 20;
            if(produtosDoPedido%20!=0){
                falta -= produtosDoPedido%20;
                this.pedidos.get(count).setNumProdutos(produtosDoPedido+falta);
                this.pedidos.get(count+1).setNumProdutos(produtosDoProximo-falta);   
            }
            count++;
        }
    }
    public static void main(String[] args) {
        Cliente primeiro = new Cliente("Jose");
        primeiro.addPedido(40, 3); 
        primeiro.addPedido(18, 1);
        primeiro.addPedido(3, 2);
        System.out.println(primeiro.getPedidos().toString());
    }
    @Override
    public int compareTo(Cliente o) {
        if(this.pedidos.get(0).getPrazo()==0)return 1;
        if(this.pedidos.get(0).getPrazo()>o.getPedido0().getPrazo()){
            return 1;
        } else if(this.pedidos.get(0).getPrazo()<o.getPedido0().getPrazo()){
            return -1;
        } else {
            return 0;
        }
    }
}
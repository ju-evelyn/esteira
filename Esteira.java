import java.util.ArrayList;
import java.util.Collections;

public class Esteira {
    private ArrayList<Cliente> clientes;
    private ArrayList<Pedido> esteira;
    public static double TEMPO = 0.5;
    public static int PEDIDOS_ENTREGUES = 0;

    public void addPedido(String nomeCliente, int numProdutos, int prazo){
        boolean clienteFidelizado = false;
        for(int i=0; i<clientes.size();i++){
            if(nomeCliente.equalsIgnoreCase(clientes.get(i).getNome())){
                this.clientes.get(i).addPedido(numProdutos, prazo);
                clienteFidelizado = true;
                break;
            }
        }
        if(!clienteFidelizado){
            Cliente novo = new Cliente(nomeCliente);
            novo.addPedido(numProdutos, prazo);
            this.clientes.add(novo);
        }
        this.ordenarClientesPorPrazo();
    }
    private void ordenarClientesPorPrazo(){
        for(int i=0;i<clientes.size();i++){
            if(clientes.get(i).getPedido0().getPrazo()==0){
                Collections.swap(clientes, i, clientes.size()-1);
            }
        }
        Collections.sort(this.clientes);
    }
    public void ordenarEsteira(){
        
    }
}

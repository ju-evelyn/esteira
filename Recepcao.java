import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
public class Recepcao {
    private Esteira esteira;
    public Recepcao(){
        esteira = new Esteira();
    }
    try{
        File dados = new File("dados_tp01.txt");
        Scanner leitor = new Scanner(dados);
        int totalDePedidos = Integer.parseInt(leitor.nextLine());
        while(leitor.hasNextLine()){
            String[] novoPedido = leitor.nextLine().split(";");
            int numProdutos = Integer.parseInt(novoPedido[1]);
            int prazo = Integer.parseInt(novoPedido[2]);
            this.esteira.addPedido(novoPedido[0], numProdutos, prazo);
            
        }
        leitor.close();
    }catch(FileNotFoundException e1){
        System.out.println("Arquivo não encontrado");
    }
}
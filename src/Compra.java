
import java.util.ArrayList;


/**
 *
 * @author artur
 */
public class Compra
{
    public int codigo;
    public String data;
    public Usuario usuario;
    public ArrayList<Produto> produtos;

    @Override
    public String toString()
    {
        String detalhesDaCompra = "";
            
        detalhesDaCompra += "++++++++++++++++++++++++++++++++\n" +
                            "Compra: " + codigo + "\n" +
                            "Data: "   + data + "\n" +
                            "Usuario: "   + usuario + "\n";
        
        
        double valor = 0;
        
        for ( Produto produto : produtos )
        {
            valor += produto.valor;
            
            detalhesDaCompra += "\t" + produto.id + " - " + produto.nome + "\n";
        }

        detalhesDaCompra += "Valor total: R$ " + valor  + "\n";
        detalhesDaCompra += "Produtos: " + produtos.size() + "\n";
        
        detalhesDaCompra += "++++++++++++++++++++++++++++++++";

        return detalhesDaCompra;
    }
}

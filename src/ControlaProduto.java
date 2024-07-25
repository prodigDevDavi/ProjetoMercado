
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author artur
 */
public class ControlaProduto
{
    private ArrayList<Produto> produtos = new ArrayList();
    private int serial =1;
    
    public void addProduto( Produto novoProduto )
    {
        novoProduto.id = serial++;
        
        produtos.add( novoProduto );
    }
    
    public ArrayList<Produto> getProdutos()
    {
        return produtos;
    }

    public Produto getProdutoPorCodigo( int codigo )
    {
        for ( Produto produto : produtos )
        {
            if ( produto.id == codigo )
            {
                return produto;
            }
        }
        
        return null;
    }
    
    public void imprimirProdutos()
    {
        String resultado = "";
        
        for ( Produto produto : produtos )
        {
            resultado += produto.id + " - " + 
                                produto.nome + " = R$ " +
                                produto.valor + "\n";
        }
        
        JOptionPane.showMessageDialog( null, resultado );
    }
    
    
}

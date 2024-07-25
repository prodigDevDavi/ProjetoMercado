
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author artur
 */
public class ControlaCompra
{
    public ArrayList<Compra> compras = new ArrayList();
    public ControlaProduto controlaProduto ;
    private int serial = 1;
    
    public ControlaCompra( ControlaProduto instanciaControlaProduto )
    {
        controlaProduto = instanciaControlaProduto;
    }
    
    public void novaCompra( Usuario usuarioSelecionado, String data )
    {
        Compra novaCompra = new Compra();
        novaCompra.codigo = serial++;
        novaCompra.usuario = usuarioSelecionado;
        novaCompra.data = data;
        
        ArrayList<Produto> produtosDaCompra = new ArrayList();
        
        while ( true )
        {
            int opcao = Entrada.leiaInt( "Menu\n" +
                                         "1 - Selecionar produto\n" +
                                         "2 - Fechar compra" );
            
            if ( opcao == 1 )
            {
                String nomes = "";
                
                for ( Produto produto : controlaProduto.getProdutos() )
                {
                    nomes += produto.id + " - " + produto.nome + "\n";
                }
                
                Produto produto = null;
                
                while ( produto == null )
                {                    
                    int codigo = Entrada.leiaInt( "Qual código do Produto você deseja?\n" +
                                                  nomes );

                    produto = controlaProduto.getProdutoPorCodigo( codigo );
                    
                    if ( produto == null )
                    {
                        JOptionPane.showMessageDialog( null, "Produto não encontrado!" );
                    }
                }
                
                produtosDaCompra.add( produto );
                
                JOptionPane.showMessageDialog( null, "Produto " + 
                                                     produto.nome + "  adicionado no carrinho!" );
                
            }
            
            else if ( opcao == 2 )
            {
                break;
            }
        }
        
        novaCompra.produtos = produtosDaCompra;
        
        compras.add( novaCompra );
        
        JOptionPane.showMessageDialog( null, 
                                       "Compra realizado com sucesso!" );
    }
    
    
    public void imprimeCompras()
    {
        String resultado =  "";
        
        for ( Compra compra : compras )
        {
           resultado += compra;
        }
        
        JOptionPane.showMessageDialog( null, resultado );
    }
    
}

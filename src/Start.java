
import javax.swing.JOptionPane;

/**
 *
 * @author artur
 */
public class Start
{
    public static void main( String[] args )
    {
        ControlaUsuario controlaUsuario = new ControlaUsuario();
        ControlaProduto controlaProduto = new ControlaProduto();
        ControlaCompra controlaCompra = new ControlaCompra( controlaProduto );

        while( true )
        {
            int opcao = Entrada.leiaInt( "Menu \n"+
                                         "[1] - Cadastrar Produto\n" +
                                         "[2] - Listar Produtos\n" +
                                         "[3] - Cadastrar Usuário\n" +
                                         "[4] - Listar Usuários\n" +
                                         "[5] - Realizar Compra\n" +
                                         "[6] - Imprimir Compras\n" +
                                         "[7] - Sair"
                                         );
         
            if ( opcao == 1 )
            {
                Produto novoProduto = new Produto();
                novoProduto.nome = Entrada.leiaString( "Nome:" );
                novoProduto.valor = Entrada.leiaDouble( "Valor:" );
                
                controlaProduto.addProduto( novoProduto );
            }
            
            else if ( opcao == 2 )
            {
                controlaProduto.imprimirProdutos();
            }
            
            else if ( opcao == 3 )
            {
                String nome = Entrada.leiaString( "Nome: " );
                String login = Entrada.leiaString( "Login: ");
                
                Usuario novoUsuario = new Usuario( nome, login );
                controlaUsuario.addUsuaruio( novoUsuario );
            }
            
            else if ( opcao == 4 )
            {
                controlaUsuario.imprimeUsuarios();
            }
            
            else if ( opcao == 5 )
            {
                String nomes = "";
                
                for ( Usuario u : controlaUsuario.getUsuarios() )
                {
                    nomes += u.id + " - " + u.nome + "\n";
                }
                
                Usuario usuario = null;
                
                while ( usuario == null )
                {                    
                    int codigo = Entrada.leiaInt( "Qual usuário que irá realizar a compra?\n" +
                                                  nomes );

                    usuario = controlaUsuario.getUsuarioPorCodigo( codigo );
                    
                    if ( usuario == null )
                    {
                        JOptionPane.showMessageDialog( null, "Usuário não encontrado" );
                    }
                }

                String data = Entrada.leiaString( "Digite uma data (dd/mm/yyy)" );
                
                controlaCompra.novaCompra( usuario, data );
                
            }
            
            else if ( opcao == 6 )
            {
                controlaCompra.imprimeCompras();
            }
            
            else if ( opcao == 7 )
            {
                System.exit( 0 );
            }
        }
    }
}

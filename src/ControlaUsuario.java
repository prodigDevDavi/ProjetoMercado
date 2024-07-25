
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author artur
 */
public class ControlaUsuario
{
    private int serial = 1;
    private ArrayList<Usuario> usuarios = new ArrayList();
    
    public void addUsuaruio( Usuario novoUsuario )
    {
        novoUsuario.id = serial++;
        usuarios.add( novoUsuario );
        
        JOptionPane.showMessageDialog( null, "Usuário cadastrado com sucesso!" );
    }
    
    public ArrayList<Usuario> getUsuarios()
    {
        return usuarios;
    }
    
    public Usuario getUsuarioPorCodigo( int codigo )
    {
        for ( Usuario usuario : usuarios )
        {
            if ( usuario.id == codigo )
            {
                return usuario;
            }
        }
        
        return null;
    }
    
    
    public void imprimeUsuarios()
    {
        for ( Usuario usuario : usuarios )
        {
            System.out.println( usuario.id + " - " + 
                                usuario.nome +
                               " (" + usuario.login + ")" );
        }
    }
}

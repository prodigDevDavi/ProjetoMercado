/**
 *
 * @author artur
 */
public class Usuario
{
    public int id;
    public String nome;
    public String login;

     public Usuario( String nome, String login )
    {
        this.nome = nome;
        this.login = login;
        
        ajustaNome();
    }

    public void ajustaNome()
    {
        this.nome = this.nome.toUpperCase();
    }
    
    @Override
    public boolean equals( Object obj )
    {
        if ( obj instanceof Usuario usuario )
        {
            return usuario.id == id;
        }
        
        return false;
    }

    @Override
    public String toString()
    {
        return nome;
    }

    
    
}

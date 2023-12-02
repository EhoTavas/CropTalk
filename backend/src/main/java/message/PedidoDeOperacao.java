package message;


public class PedidoDeOperacao extends Comunicado
{
    private int valor;
    
    public PedidoDeOperacao (int valor)
    {
        this.valor    = valor;
    }
    
    public int getValor ()
    {
        return this.valor;
    }
    
    public String toString ()
    {
        return (""+this.valor);
    }
}

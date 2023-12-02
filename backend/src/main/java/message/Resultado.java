package message;

public class Resultado extends Comunicado
{
    private int valorResultante;

    public Resultado (int valorResultante)
    {
        this.valorResultante = valorResultante;
    }

    public int getValorResultante ()
    {
        return this.valorResultante;
    }
    
    public String toString ()
    {
		return (""+this.valorResultante);
	}

}

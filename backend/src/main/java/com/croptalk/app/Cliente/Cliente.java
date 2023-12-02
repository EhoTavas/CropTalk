package com.croptalk.app.Cliente;

import java.net.*;

import message.Comunicado;
import message.PedidoDeOperacao;
import message.PedidoDeResultado;
import message.PedidoParaSair;
import message.Resultado;

import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class Cliente
{
	public static final String HOST_PADRAO  = "localhost";
	public static final int    PORTA_PADRAO = 3030;


    public Parceiro connection() throws Exception{
        Socket connection = null;

        try {
          String host = Cliente.HOST_PADRAO;
          int    port = Cliente.PORTA_PADRAO;
    
          connection = new Socket(host, port);
        }catch(Exception e){
          throw new Exception("Indique o servidor e a porta corretos!\n");
    
        }
    
        ObjectOutputStream transmissor = null;
        try{
          transmissor = new ObjectOutputStream(connection.getOutputStream());
        }catch(Exception e){
          throw new Exception ("Indique o servidor e a porta corretos!\n");
    
        }
    
        ObjectInputStream receptor = null;
        try{
          receptor = new ObjectInputStream(connection.getInputStream());
        }catch(Exception e){
         throw new Exception ("Indique o servidor e a porta corretos!\n");
        }
        return new Parceiro(connection,receptor,transmissor);
    }


	public int  retornoNumeroPergunta (int num)
	{
        int novoNum = 0;
        Parceiro servidor = null;
        try
        {
            servidor = connection();
        }
        catch (Exception erro)
        {
            System.err.println ("Indique o servidor e a porta corretos!\n");
            return -1;
        }

        TratadoraDeComunicadoDeDesligamento tratadoraDeComunicadoDeDesligamento = null;
        try
        {
			tratadoraDeComunicadoDeDesligamento = new TratadoraDeComunicadoDeDesligamento (servidor);
		}
		catch (Exception erro)
		{} // sei que servidor foi instanciado
		
        tratadoraDeComunicadoDeDesligamento.start();
		
        try 
        {
            servidor.receba(new PedidoDeOperacao(num));
        } 
        catch(Exception erro)
        {}

        try
        {
            Comunicado comunicado = null;
            servidor.receba(new PedidoDeResultado());
			do
			{
				comunicado = (Comunicado)servidor.espie ();
			}while (!(comunicado instanceof Resultado));

            Resultado resultado = (Resultado)servidor.envie();
            novoNum = resultado.getValorResultante();

            System.out.println ("Novo valor: "+novoNum+"\n");
        }
        catch (Exception erro)
		{
			System.err.println ("Erro de comunicacao com o servidor;");
			System.err.println ("Tente novamente!");
			System.err.println ("Caso o erro persista, termine o programa");
			System.err.println ("e volte a tentar mais tarde!\n");
		}

		try
		{
			servidor.receba (new PedidoParaSair());
		}
		catch (Exception erro)
		{}
        return novoNum;
	}
}

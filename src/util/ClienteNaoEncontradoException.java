package util;

public class ClienteNaoEncontradoException extends Exception {
	
	public ClienteNaoEncontradoException(Integer codigo) {
		super(codigo.toString());
	}

}

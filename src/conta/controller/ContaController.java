package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

    /**
     *  Collection listaContas contendo Objetos do tipo Conta
     * */
    private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;
    
    /**
     *  Procurar Conta por numero
     * */
    @Override
    public void procurarPorNumero(int numero) {
        var conta = buscarNaCollection(numero);
		
		if (conta != null)
			conta.visualizar();
		else
			System.out.println("\nA Conta número: " + numero + " não foi encontrada!");
    }

    /**
     *  Método Listar todas as Contas
     * */
    @Override
    public void listarTodas() {
        for (var conta : listaContas) {
			conta.visualizar();
		}        
    }

    /** 
     * Método Cadastrar no Conta
     * */
    @Override
    public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nA Conta número: " + conta.getNumero() + " foi criada com sucesso!");
    }

    /**
     * Atualizar dados da Conta
     * */
    @Override
    public void atualizar(Conta conta) {
        var buscaConta = buscarNaCollection(conta.getNumero());
		
		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\nA Conta numero: " + conta.getNumero() + " foi atualizada com sucesso!");
		}else
			System.out.println("\nA Conta numero: " + conta.getNumero() + " não foi encontrada!");
    }

    /**
     *  Apagar Conta
     * */
    @Override
    public void deletar(int numero) {
        var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			if(listaContas.remove(conta) == true)
				System.out.println("\nA Conta numero: " + numero + " foi deletada com sucesso!");
		}else
			System.out.println("\nA Conta numero: " + numero + " não foi encontrada!");
    }

    @Override
    public void sacar(int numero, float valor) {
        var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			
			if(conta.sacar(valor) == true)
				System.out.println("\nO Saque na Conta numero: " + numero + " foi efetuado com sucesso!");		
		
		}else
			System.out.println("\nA Conta numero: " + numero + " não foi encontrada!");
        
    }

    @Override
    public void depositar(int numero, float valor) {
        var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			conta.depositar(valor);
			System.out.println("\nO Depósito na Conta numero: " + numero + " foi efetuado com sucesso!");
		}else
			System.out.println("\nA Conta numero: " + numero + " não foi encontrada ou a Conta destino não é uma Conta Corrente!");
    }

    @Override
    public void transferir(int numeroOrigem, int numeroDestino, float valor) {
        var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);

		if (contaOrigem != null && contaDestino != null) {
							
				if (contaOrigem.sacar(valor) == true) {
					contaDestino.depositar(valor);
					System.out.println("\nA Transferência foi efetuado com sucesso!");
				}
		}else
			System.out.println("\nA Conta de Origem e/ou Destino não foram encontradas!");
    }

    /** 
	 * Métodos Auxiliares
	 **/
	
	/**
	 * Método para gerar automaticamente o Número da Conta
	 * */
	public int gerarNumero() {
				
		return ++ numero;

	}

    /**
	 * Método para buscar a Conta na Collection
	 * */
	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		
		return null;
	}
    
}

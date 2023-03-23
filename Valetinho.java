import java.util.ArrayList;

public class Valetinho {
    private Estacionamento estacionamentoAtual;
    public Valetinho(int quant) throws Exception{
        estacionamentoAtual = new Estacionamento(quant);
    }
    public void Entrada(int vagaEscolhida, String placaVeiculo) throws Exception{
        estacionamentoAtual.entrar(vagaEscolhida, placaVeiculo);
    }
    public void Saida(int vagaEscolhida) throws Exception{
        estacionamentoAtual.sair(vagaEscolhida);
    }
    public int consultaPlaca(String placaEscolhida) throws Exception{
        int posVaga = estacionamentoAtual.consultarPlaca(placaEscolhida);
        if(posVaga>0) {
            return posVaga;
        }
        throw new Exception("Inexistente");
    }
    public void transfereVaga(String placaEscolhida, int vagaDestino) throws Exception{
        estacionamentoAtual.transferirVaga(placaEscolhida, vagaDestino);
    }
    public String[] listagemGeral(){
        return estacionamentoAtual.listarGeral();
    }
    public ArrayList<Integer> listagemLivres(){
        return estacionamentoAtual.listarLivres();
    }
}

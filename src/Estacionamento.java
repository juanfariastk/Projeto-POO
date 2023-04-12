

import java.io.*;
import java.time.LocalDateTime;
import java.time.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Estacionamento {
    private String[] placas;
    public  Estacionamento(int quantidade) throws Exception {
        if (quantidade <= 0) {
            throw new EstacionamentoException("A quantidade de vagas deve ser maior que 0");
        }
        placas = new String[quantidade];

    }

    public void entrar( String placaNova, int vagaEscolhida) throws Exception {
        if (vagaEscolhida < 1) {
            throw new EstacionamentoException("Digite o número de uma vaga maior que 0!");
        } else if (vagaEscolhida > placas.length) {
            throw new EstacionamentoException("Digite o número de uma vaga menor ou igual que " + placas.length);
        } else {
            if (placas[vagaEscolhida - 1] == null) {
                FileWriter arquivoHistorico = new FileWriter("historico.csv", true);
                BufferedWriter escreverHistorico = new BufferedWriter(arquivoHistorico);

                placas[vagaEscolhida - 1] = placaNova;
                escreverHistorico.write("Carro: " + placaNova + " | " + "Vaga: " + vagaEscolhida + " | " + "Entrou em: "
                        + LocalDateTime.now() + "\n");
                escreverHistorico.close();
            } else {
                throw new EstacionamentoException("Esta vaga já está ocupada!");
            }
        }

    }

    public void sair(int vagaEscolhida) throws Exception {
        if (vagaEscolhida < 1) {
            throw new EstacionamentoException("Digite o número de uma vaga maior que 0!");
        } else if (vagaEscolhida > placas.length) {
            throw new EstacionamentoException("Digite o número de uma vaga menor que " + placas.length);
        } else if (placas[vagaEscolhida - 1] == null) {
            throw new EstacionamentoException("Não é possivel realizar a saída, pois já está desocupada esta vaga");
        } else {
            FileWriter arquivoHistorico = new FileWriter("historico.csv", true);
            BufferedWriter escreverHistorico = new BufferedWriter(arquivoHistorico);
            escreverHistorico.write("Carro: " + placas[vagaEscolhida - 1] + " | " + "Vaga: " + vagaEscolhida + " | "
                    + "Saiu em: " + LocalDateTime.now() + "\n");
            escreverHistorico.close();
            placas[vagaEscolhida - 1] = null;
        }
    }

    public int consultarPlaca(String placaEscolhida) throws Exception{
        for (int i = 0; i < placas.length; i++) {
            if (placaEscolhida.equals(placas[i])) {
                return i + 1;
            }
        }
        return -1;
    }

    public void transferir(int vagaAtual, int vagaEscolhida) throws Exception {
        if (vagaEscolhida < 1 || vagaAtual < 1) {
            throw new EstacionamentoException("Digite o número de uma vaga maior que 0!");
        } else if (vagaEscolhida > placas.length) {
            throw new EstacionamentoException("Digite o número de uma vaga menor que " + placas.length);
        } else if (placas[vagaEscolhida - 1] != null) {
            throw new EstacionamentoException("Esta vaga já está ocupada");
        }else if(placas[vagaAtual-1] == null ){
            throw new EstacionamentoException("A vaga escolhida está vazia!");
        } else {
             placas[vagaEscolhida-1]=placas[vagaAtual-1];
             placas[vagaAtual-1]=null;
            }
    }

    public String[] listarGeral() {
        String[] lista = new String[placas.length];
        for (int i = 0; i < placas.length; i++) {
            if (placas[i] == null) {
                lista[i] = "Livre" + " ";
            } else {
                lista[i] = placas[i] + " ";
            }
        }
        return lista;

    }

    public ArrayList<Integer> listarLivres() {
        ArrayList<Integer> listaLivres = new ArrayList<>();
        for (int i = 0; i < placas.length; i++) {
            if (placas[i] == null) {
                listaLivres.add(i + 1);
            }
        }

        return listaLivres;
    }

    public void gravarDados() throws IOException {
        FileWriter arquivoPlacas = new FileWriter("./placas.csv");
        BufferedWriter escreverPlacas = new BufferedWriter(arquivoPlacas);
        for (int i = 0; i < placas.length; i++) {
            if (placas[i] != null) {
                escreverPlacas.write("vaga :" + (i+1) + " | Placa: "+ placas[i] + "\n");
            }
        }
        escreverPlacas.close();
    }
    public void lerDados() throws IOException{
        FileReader arquivoPlacas = new FileReader("./placas.csv");
        BufferedReader lerPlacas = new BufferedReader(arquivoPlacas);
        String linhas;
        while((linhas = lerPlacas.readLine()) != null){
            System.out.println(linhas);
        }
        lerPlacas.close();
    }

    public String toString() {
        return "Estacionamento vagas=" + placas.length + ", placas=" + Arrays.toString(placas) + " ";
    }

}



import java.io.*;
import java.time.LocalDateTime;
import java.time.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Estacionamento {
    private String[] placas;
    public Estacionamento(int quantidade) throws Exception {
        if (quantidade <= 0) {
            throw new Exception("A quantidade de vagas deve ser maior que 0");
        }
        placas = new String[quantidade];

    }

    public void entrar(int vagaEscolhida, String placaNova) throws Exception {
        if (vagaEscolhida < 1) {
            throw new Exception("Digite o número de uma vaga maior que 0!");
        } else if (vagaEscolhida > placas.length) {
            throw new Exception("Digite o número de uma vaga menorr que " + placas.length);
        } else {
            if (placas[vagaEscolhida - 1] == null) {
                FileWriter arquivoHistorico = new FileWriter("historico.csv", true);
                BufferedWriter escreverHistorico = new BufferedWriter(arquivoHistorico);

                placas[vagaEscolhida - 1] = placaNova;
                escreverHistorico.write("Carro: " + placaNova + " | " + "Vaga: " + vagaEscolhida + " | " + "Entrou em: "
                        + LocalDateTime.now() + "\n");
                escreverHistorico.close();
                // falta colocar a data de entrada;
            } else {
                throw new Exception("Esta vaga já está ocupada!");
            }
        }

    }

    public void sair(int vagaEscolhida) throws Exception {
        if (vagaEscolhida < 1) {
            throw new Exception("Digite o número de uma vaga maior que 0!");
        } else if (vagaEscolhida > placas.length) {
            throw new Exception("Digite o número de uma vaga menorr que " + placas.length);
        } else if (placas[vagaEscolhida - 1] == null) {
            throw new Exception("Não é possivel realziar a saída, pois já está desocupada esta vaga");
        } else {
            FileWriter arquivoHistorico = new FileWriter("historico.csv", true);
            BufferedWriter escreverHistorico = new BufferedWriter(arquivoHistorico);
            escreverHistorico.write("Carro: " + placas[vagaEscolhida - 1] + " | " + "Vaga: " + vagaEscolhida + " | "
                    + "Saiu em: " + LocalDateTime.now() + "\n");
            escreverHistorico.close();
            placas[vagaEscolhida - 1] = null;
        }
    }

    public int consultarPlaca(String placaEscolhida) {
        for (int i = 0; i < placas.length; i++) {
            if (placaEscolhida.equals(placas[i])) {
                return i + 1;
            }
            ;
        }
        return -1;
    }

    public void transferirVaga(String placaEscolhida, int vagaEscolhida) throws Exception {
        if (vagaEscolhida < 1) {
            throw new Exception("Digite o número de uma vaga maior que 0!");
        } else if (vagaEscolhida > placas.length) {
            throw new Exception("Digite o número de uma vaga menorr que " + placas.length);
        } else if (placas[vagaEscolhida - 1] != null) {
            throw new Exception("Esta vaga já está ocupada");
        } else {
            for (int i = 0; i < placas.length; i++) {
                if (placaEscolhida.equals(placas[i])) {
                    placas[vagaEscolhida - 1] = placas[i];
                    placas[i] = null;
                    break;
                } else {
                    new Exception("Esta placa não existe nas vagas atuais");
                }
            }
        }
    }

    public String[] listarGeral() {
        String[] lista = new String[10];
        for (int i = 0; i < placas.length; i++) {
            if (placas[i] == null) {
                lista[i] = "livre";
            } else {
                lista[i] = placas[i];
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
                escreverPlacas.write("vaga :" + i + " | Placa: "+ placas[i] + "\n");
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

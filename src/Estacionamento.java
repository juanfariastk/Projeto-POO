

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
                DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                escreverHistorico.write( LocalDateTime.now().format(formatarData) + " ; " + vagaEscolhida + " ; " + placaNova + " ; "+" Entrada " + "\n" );
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
            DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            escreverHistorico.write(LocalDateTime.now().format(formatarData) +  " ; " + placas[vagaEscolhida - 1] + " ; " + vagaEscolhida + " ; " + " Saida " + "\n");
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
    	FileWriter fileWriter = new FileWriter(new File("./placas.csv"));
		for (int i = 0; i < placas.length; i++) {
			if (!(placas[i] == null)) {	
				if(i == placas.length - 1) {			
					fileWriter.write((placas.length) + ";" + placas[placas.length - 1]);
				} else {
					fileWriter.write((i + 1) + ";" + placas[i] + "\n");
				}
			} 

		}
		fileWriter.flush();
		fileWriter.close();
    }
   public void lerDados() throws Exception{
        File salvos = new File("./placas.csv");
        if(salvos.exists()) {
            Scanner arquivo = new Scanner(new File("./placas.csv"));
            while (arquivo.hasNextLine()) {
                String[] salvo = arquivo.nextLine().split(";");
                try {
                    placas[Integer.parseInt(salvo[0]) - 1] = salvo[1];
                } catch (NumberFormatException e) {           
                }
            }
            arquivo.close();
        }
    }


    public String toString() {
        return "Estacionamento vagas=" + placas.length + ", placas=" + Arrays.toString(placas) + " ";
    }

}

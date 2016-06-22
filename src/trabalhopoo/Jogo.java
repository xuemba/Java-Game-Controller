package trabalhopoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import static java.lang.Boolean.TRUE;
import java.util.ArrayList;
import java.util.Objects;

/*Classe referente a Loja (por exemplo)*/
public class Jogo {

    /*Criar Lista de Jogadores*/
    ArrayList<Jogadores> listajogadores = new ArrayList<>();

    public void adicionar(String AccountName_, String Email_, String Senha_, String Nickname_, String Classe_, Boolean x) {
        if (Objects.equals(x, TRUE)) {
            Jogadores jo = new Jogadores();
            jo.setAccountName(AccountName_);
            jo.setEmail(Email_);
            jo.setSenha(Senha_);
            jo.setNickname(Nickname_);
            jo.setClasse(Classe_);
            listajogadores.add(jo);
            System.out.println("Jogador cadastrado com sucesso!");
        } else {
            System.out.println("Erro na autenticaçao");
        }
    }

    //Remoção feita através do AccountName do jogador.
    public void remover(String AccountName_, Boolean x) {
        if (Objects.equals(x, TRUE)) {
            int y = 0;
            for (int i = 0; i < listajogadores.size(); i++) {
                if (AccountName_.equals(listajogadores.get(i).getAccountName())) {
                    listajogadores.remove(i);
                    y = 1;
                }
            }
            if (y == 1) {
                System.out.println("Jogador removido com sucesso!");
            } else {
                System.out.println("Jogador não encontrado!");
            }
        } else {
            System.out.println("Erro na autenticaçao");
        }
    }

    //Edita um jogador atraves do AccountName informado
    public void editar(String editar_, String AccountName_, String Email_, String Senha_, String Nickname_, String Classe_, Boolean x) {
        if (Objects.equals(x, TRUE)) {
            int y = 0;
            for (int i = 0; i < listajogadores.size(); i++) {
                if (editar_.equals(listajogadores.get(i).getAccountName())) {
                    listajogadores.get(i).setAccountName(AccountName_);
                    listajogadores.get(i).setEmail(Email_);
                    listajogadores.get(i).setSenha(Senha_);
                    listajogadores.get(i).setNickname(Nickname_);
                    listajogadores.get(i).setClasse(Classe_);
                    y = 1;
                }
            }
            if (y == 1) {
                System.out.println("Jogador editado com sucesso!");
            } else {
                System.out.println("Jogador não encontrado!");
            }
        } else {
            System.out.println("Erro na autenticaçao");
        }

    }

    //Lista todos os jogadores contidos em listajogadores
    public void listar(Boolean x) {
        if (Objects.equals(x, TRUE)) {
            for (int i = 0; i < listajogadores.size(); i++) {
                System.out.println("AccountName: " + listajogadores.get(i).getAccountName());
                System.out.println("Email: " + listajogadores.get(i).getEmail());
                System.out.println("Senha: " + listajogadores.get(i).getSenha());
                System.out.println("Nickname: " + listajogadores.get(i).getNickname());
                System.out.println("Classe: " + listajogadores.get(i).getClasse());
            }
        } else {
            System.out.println("Erro na autenticaçao");
        }
    }

    //Lista todos os jogadores da classe determinada pelo usuário
    public void listarClasse(String Classe_, Boolean x) {
        if (Objects.equals(x, TRUE)) {
            int y = 0;
            for (int i = 0; i < listajogadores.size(); i++) {
                if (Classe_.equals(listajogadores.get(i).getClasse())) {
                    System.out.println("AccountName: " + listajogadores.get(i).getAccountName());
                    System.out.println("Email: " + listajogadores.get(i).getEmail());
                    System.out.println("Senha: " + listajogadores.get(i).getSenha());
                    System.out.println("Nickname: " + listajogadores.get(i).getNickname());
                    System.out.println("Classe: " + listajogadores.get(i).getClasse());
                    y = 1;
                }
            }
            if (y == 1) {
                System.out.println("Classe listada com sucesso!");
            } else {
                System.out.println("Jogadores com essa Classe não foram encontrados!");
            }
        } else {
            System.out.println("Erro na autenticaçao");
        }
    }

    public void geraArquivo(Boolean x) {
        //Escrevendo no Arquivo
        if (Objects.equals(x, TRUE)) {

            try {
                OutputStream os = new FileOutputStream("arquivoSaida.txt");
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                for (int i = 0; i < listajogadores.size(); i++) {
                    bw.write(listajogadores.get(i).getAccountName() + ";" + listajogadores.get(i).getEmail() + ";" + listajogadores.get(i).getSenha() + ";" + listajogadores.get(i).getNickname() + ";" + listajogadores.get(i).getClasse() + "\n");

                }

                bw.close();
            } catch (Exception e) {
                System.out.println("Erro ao abrir arquivo!");
            }
        } else {
            System.out.println("Erro na autenticaçao");
        }
    }

    //Lendo arquivo.txt informado pelo usuário, separando os segmentos e atribuindo os valores aos atributos locais.
    public void lerArquivo(Boolean x) {
        if (Objects.equals(x, TRUE)) {
            try {
                FileInputStream arquivo = new FileInputStream("arquivoEntrada.txt");
                InputStreamReader input = new InputStreamReader(arquivo);
                BufferedReader br = new BufferedReader(input);

                String linha = br.readLine();
                while (linha != null) {
                    String[] palavras = linha.split(";");
                    adicionar(palavras[0], palavras[1], palavras[2], palavras[3], palavras[4], true);
                    listar(true);
                    System.out.println(palavras[0]);
                    System.out.println(palavras[1]);
                    System.out.println(palavras[2]);
                    System.out.println(palavras[3]);
                    System.out.println(palavras[4]);
                    linha = br.readLine();
                }
                br.close();
            } catch (Exception e) {
                System.out.println("Erro ao abrir arquivo!");
            }
        } else {
            System.out.println("Erro na autenticaçao");
        }
    }

}

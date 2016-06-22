package trabalhopoo;

import java.util.ArrayList;

/*Classe referente a Gerente*/
public class Administrador {
    String nome;
    String login;
    String senha;
    ArrayList<GameMaster> listafunc = new ArrayList<>();
    
    //sem argumentos
    public Administrador() {
        
    }
    
    //com argumentos
    /*public Administrador(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }*/

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    //adicionar, remover, editar, listar todos Atendentes.
    public void adicionar(String nome_,String login_,String senha_){
        GameMaster gm = new GameMaster();
        gm.setNome(nome_);
        gm.setLogin(login_);
        gm.setSenha(senha_);
        listafunc.add(gm);  
    }
    public void remover(String remover_){
        int y=0;
        for(int i = 0 ; i < listafunc.size() ; i++){
            if(listafunc.get(i).getLogin().equals(remover_)){
                listafunc.remove(i);
                y=1;
            }
        }
        if(y==1){
            System.out.println("GameMaster removido com sucesso!");
        }
        else
            System.out.println("GameMaster não encontrado! :( ");
    }
    //Edita apartir do Login informado pelo usuário
    public void editar(String editar_,String nome_,String login_,String senha_){
        int y=0;
        for(int i = 0 ; i < listafunc.size() ; i++){
            if(listafunc.get(i).getLogin().equals(editar_)){
                listafunc.get(i).setNome(nome_);
                listafunc.get(i).setLogin(login_);
                listafunc.get(i).setSenha(senha_);
                y=1;
            }
        }
        if(y==0){
            System.out.println("Cadastro não encontrado! ");
        }
        
    }
    public void listar(){
        System.out.println("Imprimindo lista de GameMasters: ");
        for(int i = 0 ; i < listafunc.size();i++){
            System.out.println("Nome : " + listafunc.get(i).getNome());
            System.out.println("Login : " + listafunc.get(i).getLogin());
            System.out.println("Senha : " + listafunc.get(i).getSenha());
            System.out.println("-------------------------");
        }
    }
    
    public Boolean autenticar(String Login_ , String Senha_){
        for (int i = 0; i < listafunc.size(); i++) {
            if (Login_.equals(listafunc.get(i).getLogin()) && Senha_.equals(listafunc.get(i).getSenha())) {
                return true;
            }
        }
        return false;
        
    }
            
}

package trabalhopoo;

public class TrabalhoPOO {

    public static void main(String[] args) {
        //GITHUB https://github.com/xuemba/unisc
        
        //Lucas Fernando Schwnegber || 96631 
        
        Administrador adm = new Administrador();
        Jogo jog = new Jogo();
        Boolean x;
        //Testes na criaçao de GameMasters
        /*
        adm.adicionar("NomePessoa", "LoginPessoa", "SenhaPessoa");
        adm.adicionar("NomePessoa2", "LoginPessoa2", "SenhaPessoa2");
        adm.listar();
        adm.editar("LoginPessoa", "NewNomePessoa", "NewLoginPessoa", "NewSenhaPessoa");
        adm.listar();
        adm.remover("NewLoginPessoa");
        adm.listar();*/
       
        //Testes com manipulçao de arquivos no ArrayList jogadores
        
        x = adm.autenticar("dsad", "fdsgg");
        System.out.println(x);
        
        /*jog.lerArquivo();
        jog.listar();
        jog.editar("AccountName2", "BOSADSAD", "DSADSAF", "GFDGFD", "RTHRTEQ", "QWDWQDAS");
        jog.geraArquivo();*/

        
        
    }
    
}

package ElementosSistemas;

import java.util.HashMap;
import java.util.List;


public class Dados {
    private HashMap<Integer,Usuario> HashUsuario;
    private HashMap<Integer,Livro> HashLivros;
    private List<Reserva> ListaReservas;

    // Padrão Singleton
    private static Dados Instancia;
    private Dados(){
        CarregarLivros();
        CarregarUsuarios();
    }
    public static Dados ObterInstancia(){
        if(Instancia == null)
            Instancia = new Dados();
        
        return Instancia;
    }

    public Usuario getUsuario(int Id){
        return HashUsuario.get(Id);
    }

    public Livro getLivro(int Id){
        return HashLivros.get(Id);
    }

    public void CarregarLivros(){

    }

    public void CarregarUsuarios(){

    }



    // --------------------------getters and setters-------------------------

    public HashMap<Integer, Usuario> getHashUsuario() {
        return HashUsuario;
    }
    public void setHashUsuario(HashMap<Integer, Usuario> hashUsuario) {
        HashUsuario = hashUsuario;
    }
    
    public HashMap<Integer, Livro> getHashLivros() {
        return HashLivros;
    }
    public void setHashLivros(HashMap<Integer, Livro> hashLivros) {
        HashLivros = hashLivros;
    }
    
    public List<Reserva> getListaReservas() {
        return ListaReservas;
    }
    public void setListaReservas(List<Reserva> listaReservas) {
        ListaReservas = listaReservas;
    } 
}

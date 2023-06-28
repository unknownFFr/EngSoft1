package ElementosSistemas;

import java.time.LocalDate;
import java.util.List;

import StrategyObserver.EmprestimoBehavior;
import StrategyObserver.Observer.ObserverBehavior;

public class Usuario {
    private int Id;
    private String Nome;
    private List<Reserva> ListReserva; 


    // ----------------------------
    // hack para alugar devolver etc, para corrigir adicionar novas funções dentro de Estado (talvez)
    private List<Emprestimo> EmprestimosPassados;
    private List<Emprestimo> EmprestimosAtuais;
    // ----------------------------
    private ObserverBehavior ObserverManager;
    private EmprestimoBehavior EmprestimoManager;

    public EmprestimoBehavior getEmprestimoManager() {
        return EmprestimoManager;
    }
    public void setEmprestimoManager(EmprestimoBehavior emprestimoManager) {
        EmprestimoManager = emprestimoManager;
    }

    public String getNome() {
        return Nome;
    }  

    public List<Reserva> getListReserva() {
        return ListReserva;
    }
    public void setListReserva(List<Reserva> listReserva) {
        ListReserva = listReserva;
    }

    public List<Emprestimo> getEmprestimosPassados() {
        return EmprestimosPassados;
    }
    public void setEmprestimosPassados(List<Emprestimo> emprestimosPassados) {
        EmprestimosPassados = emprestimosPassados;
    }

    public List<Emprestimo> getEmprestimosAtuais() {
        return EmprestimosAtuais;
    }
    public void setEmprestimosAtuais(List<Emprestimo> emprestimosAtuais) {
        EmprestimosAtuais = emprestimosAtuais;
    }


    // mudar para a classe de mensagem

    public String ComandoUsu(){
        String Msg = "";
        Msg += "Emprestimos finalizados:\n ";
        for(Emprestimo E : EmprestimosPassados){
            Msg +="Livro: " + E.getExemplarNome() + " pego emprestado em " + E.getDataEmprestimo() + " ate " + E.getDataDevolucao() + "\n";
        }

        Msg += "\n";

        Msg +="Emprestimos ativos: \n";
        for(Emprestimo E : EmprestimosAtuais){
            Msg += "Livro: " + E.getExemplarNome() + " pego emprestado em " + E.getDataEmprestimo() + " ate" + E.getDataDevolucao() + "\n";
        }
        
        Msg += "\n";

        Msg += "Reservas: \n";

        for(Reserva R : ListReserva){
            Msg += "Reservou o Livro " + R.getLivroNome() + " em " + R.getData() + "\n";
        }

        return Msg;
    }

    public String ComandoNtf(){
        return ObserverManager.MostrarInfo();
    }

    public String Alugar(Livro Livro){
        return EmprestimoManager.Alugar(this, Livro);
    }

    public String Devolver(Livro Livro){
        return EmprestimoManager.Devolver(this, Livro);
    }

    public String Reservar(Livro L){
        return EmprestimoManager.Reservar(this, L);
    }

    public void RetirarEmpre(Emprestimo E){
        E.Finalizar();
        EmprestimosAtuais.remove(E);
        EmprestimosPassados.add(E);
    }

    public boolean IsDevedor(){
        LocalDate Hoje = java.time.LocalDate.now();

        for(Emprestimo E : EmprestimosAtuais){
            if(Hoje.isAfter(E.getDataDevolucao())){
                return true;
            }
        }

        return false;
    }

    public boolean TemReserva(Livro L){
        for(Reserva R : ListReserva) {
            if(R.getLivro().equals(L)){
                return true;
            }
        }

        return false;
    }

    public boolean JaTemLivro(Livro L){
        for(Emprestimo E : EmprestimosAtuais){
            if(L.EExemplar(E.getExemplar()))
                return true;
        }

        return false;
    }

    public void RegistrarEmprestimo(Emprestimo E){
        EmprestimosAtuais.add(E);
    }

    public int QuantidadeEmprestimos(){
        return EmprestimosAtuais.size();
    }
}

package ElementosSistemas;

import Estado.*;

public class Exemplar {
    private int Id;
    private Livro Livro;
    private Emprestimo Emprestimo;

    public String MostrarInfo(){
        String Msg = "";
        Msg += "Id do exemplar: " + Id;
        Msg += Emprestimo.MostrarInfo();
        return Msg;
    }

    public String getTitulo(){
        return Livro.getTitulo();
    }

    // --------------------------getters and setters-------------------------

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }

    public Livro getLivro() {
        return Livro;
    }
    public void setLivro(Livro livro) {
        Livro = livro;
    }

    public Emprestimo getEmprestimo() {
        return Emprestimo;
    }
    public void setEmprestimo(Emprestimo emprestimo) {
        Emprestimo = emprestimo;
    }

}

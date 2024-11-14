package modelo;

import java.util.LinkedList;

public class Aluno {
    private String nome;
    private long numero;
    private LinkedList<Aula> aulas;
    private LinkedList<Aluno> alunos;
    private String sumario;

    public Aluno(String nome, long numero) {
        this.nome = nome;
        this.numero = numero;
        aulas = new LinkedList<>();
    }

    public void preencherSumario(Aula aula) {
        if (aula == null || !getAulas().contains(aula)) {
            return;
        }
        aula.adicionarLinhaSumario(nome);
    }

    public void adicionar(Aula aula) {
        if (aula == null || aulas.contains(aula)) {
            return;
        }
        aulas.add(aula);
        aula.adicionar(this);
    }

    public String getNome() {
        return this.nome;
    }

    public long getNumero() {
        return this.numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public void remover(Aula aula) {
        if (aula == null || !aulas.contains(aula)) {
            return;
        }
        aulas.remove(aula);
        aula.remover(this);
    }

    public LinkedList<Aula> getAulas() {
        return new LinkedList<>(aulas);
    }
}
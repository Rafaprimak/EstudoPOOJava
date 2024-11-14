package modelo;

import java.util.LinkedList;

public class Aula {
    private String nome;
    private long numero;
    private StringBuilder sumario;
    private Professor professor;
    private LinkedList<Aluno> alunos;

    public Aula(String nome, long numero) {
        this(nome, numero, null, new LinkedList<>());
    }
    public Aula(String nome, long numero, Professor professor, LinkedList<Aluno> alunos) {
        this.nome = nome;
        this.numero = numero;
        sumario = new StringBuilder();
        setProfessor(professor);
        this.alunos = new LinkedList<>();
        for (Aluno aluno : alunos) {
            adicionar(aluno);
        }
    }


    public void setProfessor(Professor professor) {
        if (professor == null || this.professor == professor){
            return;
        }
        if (this.professor != null) {
            professor.remover(this);
        }
        this.professor = professor;
        professor.adicionar(this);
    }

    public Professor getProfessor() {
        return professor;
    }

    public void desassociarProfessor() {
        if (professor == null) {
            return;
        }
        Professor professorADesassociar = professor;
        professor = null;
        professorADesassociar.remover(this);
    }

    public void adicionar(Aluno aluno) {
        if (aluno == null || alunos.contains(aluno)) {
            return;
        }
        alunos.add(aluno);
        aluno.adicionar(this);
    }

    public void remover(Aluno aluno) {
        if (aluno == null || !alunos.contains(aluno)) {
            return;
        }
        alunos.remove(aluno);
        aluno.remover(this);
    }

    public void adicionarLinhaSumario(String linha) {
        sumario.append(linha).append('\n');
    }


    public String getSumario() {
        return sumario.toString();
    }

    public String getNome() {
        throw new UnsupportedOperationException("Unimplemented method 'getNome'");
    }

    public char[] getNumero() {
        throw new UnsupportedOperationException("Unimplemented method 'getNumero'");
    }

    public Iterable<Aula> getAlunos() {
        throw new UnsupportedOperationException("Unimplemented method 'getAlunos'");
    }

    public void preencherSumario(Aula aula) {
        throw new UnsupportedOperationException("Unimplemented method 'preencherSumario'");
    }

}



package modelo;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Professor professor1 = new Professor("Marco Ferreira", 1);
        Professor professor2 = new Professor("Joao Ramos", 2);
        Professor professor3 = new Professor("Sonia Luz", 3);

        Aula aula1 = new Aula("Programação 2 PL1", 1);
        Aula aula2 = new Aula("Programação 2 PL2", 2);

        Aluno aluno1 = new Aluno("José António", 2190354);
        Aluno aluno2 = new Aluno("Carlos Santos", 2191187);

        //atribuir o professor1 à aula1 e à aula2
        aula1.setProfessor(professor1);
        aula2.setProfessor(professor1);
        //voltar a atribuir o professor1 à aula 2
        // para verificar que o mesmo professor não é atribuído 2 vezes
        aula2.setProfessor(professor1);
        //atribuir o professor2 à aula2 e verificar o que acontece ao professor1
        aula2.setProfessor(professor2);
        //desassociar o professor da aula2
        //verificar que após ser desassociado,
        // também esta aula é removida da lista de aulas do professor
        aula2.desassociarProfessor();

        //adicionar o aluno1 à aula1
        aula1.adicionar(aluno1);
        //adicionar a aula1 ao aluno1 e verificar o que acontece
        aluno1.adicionar(aula1);
        //adicionar o aluno2 à aula1
        aluno2.adicionar(aula1);
        //a aula passa a ter uma lista com 2 alunos

        //remover o aluno1 da aula1
        aula1.remover(aluno1);
        //remover a aula1 do aluno1 e verificar o que acontece
        aluno1.remover(aula1);

        //colocar professsor1 a preencher sumario da aula 1
        professor1.preencherSumario(aula1);
        //professor2 deve preencher sumario da aula2
        professor2.preencherSumario(aula2);
        //apresentar o sumario da aula1
        System.out.println(aula1.getSumario());

        //criar uma lista de alunos e adicionar aluno1 e aluno2
        LinkedList<Aluno> alunos = new LinkedList<>();
        alunos.add(aluno1);
        alunos.add(aluno2);
        //testar o overloading de métodos através do novo construtor da classe Aula
        Aula aula3 = new Aula("Programação 2 PL3", 3, professor3, alunos);
        professor3.preencherSumario(aula3);
        //apresentar o sumário da aula3
        System.out.println(aula3.getSumario());
    }
}

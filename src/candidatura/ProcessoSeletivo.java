package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        // System.out.println("Processo Seletivo");
        // analisarCandidato(1900.0);
        // analisarCandidato(2200.0);
        // analisarCandidato(2000.0);
        // selecaoCandidatos();
        // imprimirselecionados();
        String [] candidatos = {"ALICE", "BRUNO", "CARLA", "DANIEL", "EDUARDA"};
        for(String candidato:candidatos) {
            entrandoEmcontato(candidato);
        }
    }

    static void entrandoEmcontato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
            tentativasRealizadas++;
            else 
            System.out.println("TENTATIVA REALIZADA COM SUCESSO!");
        } while(continuarTentando && tentativasRealizadas<3);

        if(atendeu)
        System.out.println("CONSEGUIMOS CONTATO COM O CANDIDATO "+ candidato + " NA " + tentativasRealizadas + " TENTATIVA.");
        else
        System.out.println("NÃO CONSEGUIMOS CONTATO COM O CANDIDATO" + candidato + " NÚMERO DE MÁXIMO DE " + tentativasRealizadas + " TENTATIVAS, REALIZADAS.");

    }

    static boolean atender() {
        return new Random().nextInt(3)==1;
    }

    static void imprimirselecionados() {
        String [] candidatos = {"ALICE", "BRUNO", "CARLA", "DANIEL", "EDUARDA"};
        System.out.println("Imprimindo a lista de candidatos, informando o índice do elemento");

        for(int indice=0; indice < candidatos.length; indice++){
            System.out.println("O candidato de número"+ (indice+1) + " é "+ candidatos[indice]);
        }

        System.out.println("Forma abreviada de interação for each");

        for(String candidato: candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void selecaoCandidatos() {
        String [] candidatos = {
            "ALICE", "BRUNO", "CARLA", "DANIEL", "EDUARDA", 
            "FELIPE", "GABRIELA", "HENRIQUE", "ISABELA", "JOÃO"
        };

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato "+ candidato + " solicitou o salároio " + salarioPretendido+".");
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;
            }
            candidatoAtual++;
            
        }   
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800.0, 2200.0);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        }else if(salarioBase==salarioPretendido) {
            System.out.println("LIGAR COM CONTRAPROPOSTA");
        }else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}

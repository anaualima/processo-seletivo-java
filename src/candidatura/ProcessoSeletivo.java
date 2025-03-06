package candidatura;

import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        // System.out.println("Processo Seletivo");
        // analisarCandidato(1900.0);
        // analisarCandidato(2200.0);
        // analisarCandidato(2000.0);
        selecaoCandidatos();
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

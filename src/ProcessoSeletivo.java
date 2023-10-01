import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Processo Seletivo : " + "\n");

   selecaoCandidatos();
   imprimirSelecionados();


        // Simular tentativa de ligação para os candidatos
        String [] candidatos = {"FELIPE",  "PAULO", "AUGUSTO", "MONICA",  "JOAO"};
        for (String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato){

        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando){
                tentativasRealizadas++;

            }else {
                System.out.println("\n");
                System.out.println("CONTATO REALIZADO COM SUCESSO!!");
                System.out.println("\n");
            }
            //elas precisarão sofrer alterações, caso não entra em loop infinito
        } while (continuarTentando && tentativasRealizadas < 3);
        if (atendeu){
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa");
            System.out.println("\n");
        }else {
            System.out.println("Não conseguimos contato com " + candidato +" , número máximo de tentativas: " + tentativasRealizadas);
        }
    }


    // Método para analisar os candidatos:
    static void analisarCadidato(double salarioPretendido){
        double salarioBase = 2000.0;
        //Quando se usa double necessita-se colocar o ".0"

        if (salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para ofertar contraproposta");
        } else {
            System.out.println("Aguardando demais candidatos");
        }
    }

    static void selecaoCandidatos (){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JOAO"};
        //Array de string


        int candidatosSelecionados = 0;
        int candidatosAtuais = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatosAtuais < candidatos.length){
            String candidato = candidatos[candidatosAtuais];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salário " + salarioPretendido);

            if (salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                System.out.println("\n");
                candidatosSelecionados++;
            } else {
                System.out.println("O candidato não foi selecionado para a vaga.");
                System.out.println("\n");
            }
            candidatosAtuais++;
        }

    }
    static void imprimirSelecionados(){

        String [] candidatos = {"FELIPE",  "PAULO", "AUGUSTO", "MONICA",  "JOAO"};
        System.out.println("imprimindo a lista de candidatos informando o indice de elementos ");
        System.out.println("\n");

        for (int indice=0; indice < candidatos.length; indice++){
            System.out.println("O candadidato de n " + (indice+1) + " é o " + candidatos[indice]);
            System.out.println("===============================" + "\n");
            //Esse (indice+1) é apenas para o indice não começar com 0 e sim com 1, facilitando a leitura do usuário
        }
    }

    //Método auxiliar: que simula através de uma expressão randomica que se o valor entre 1 e 3
    // for igual a 1, quer dizer que ele atendeu, caso não ele fica discando novamente até atender
    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }

    // Método que simula randomicamente o valor pretendido:
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }
}
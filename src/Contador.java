import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int parametroUm = 0;
        int parametroDois = 0;

        parametroUm = coletarParametro(scanner, "primeiro");
        parametroDois = coletarParametro(scanner, "segundo");

        try {
            contar(parametroUm, parametroDois);
        } catch (ParametrosInvalidosException exception) {
            System.err.println("O segundo parâmetro deve ser maior que o primeiro!");
        }

    }

    /**
     * Este é um método para imprimir a contagem da diferença entre dois números quando o segundo parâmetro for maior que o primeiro
     * @param parametroUm parâmetro representando o primeiro valor inteiro informado
     * @param parametroDois parâmetro representando o segundo valor inteiro informado
     */
    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {

        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException();
        }

        int contagem = parametroDois - parametroUm;

        for (int indice = 1; indice <= contagem; indice++) {
            System.out.println("Imprimindo o número " + indice);
        }
    }

    /**
     * Este é um método auxiliar para a coleta dos parâmetros inteiros, verificando se de fato o valor informado representa um inteiro e retornando-o
     * @param scanner parâmetro do Scanner que será utilizado para coletar os dados solicitados
     * @param textoParametro parâmetro descritivo do que esta sendo solicitado
     * @return retorna um valor inteiro que representa o parâmetro coletado
     */
    private static int coletarParametro(Scanner scanner, String textoParametro) {
        boolean inteiroValido = false;
        String parametroValidar;
        int parametroRetorno = 0;
        do {
            System.out.println(String.format("Digite o %s parâmetro inteiro: ", textoParametro));
            parametroValidar = scanner.next();
            if (parametroValidar.matches("[0-9]+")) {
                parametroRetorno = Integer.parseInt(parametroValidar);
                inteiroValido = true;
            } else {
                System.out.println(String.format("O %s parâmetro só pode ser um número inteiro!", textoParametro));
            }
        } while (!inteiroValido);
        return parametroRetorno;
    }
}

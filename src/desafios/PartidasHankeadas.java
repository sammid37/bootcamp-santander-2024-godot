import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException;

// FIXME: consertar método 
class PartidasHankeadas {
  private static final Map<Integer, String> nivelHank = new HashMap<>();
  static {
    nivelHank.put(10, "Ferro");
    nivelHank.put(20, "Bronze");
    nivelHank.put(50, "Prata");
    nivelHank.put(80, "Ouro");
    nivelHank.put(90, "Diamante");
    nivelHank.put(100, "Lendário");
  }

  /**
   * Recebe o nome do herói e o seu nível de XP para retornar a sua classificação
   * @param nomeHeroi
   * @param xp
   * @return a classificação do herói
   */
  public static String nivelHankeada(int qtdVitorias, int qtdDerrotas) {
    int saldoVitorias = qtdVitorias - qtdDerrotas;

    for (int nivelLimite : nivelHank.keySet()) {
      if (qtdVitorias <= nivelLimite) {
        return "O herói tem de saldo de " 
                + saldoVitorias 
                + " está no nível " 
                + nivelHank.get(nivelLimite);
      }
    }
    return "O herói tem de saldo de " 
            + saldoVitorias 
            + " está no nível Imortal";
  } 

  public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
    System.out.println("Hankeada de Heróis!");
    try {
      System.out.print("Digite o nº de vitórias do herói: ");
      int vitorias = input.nextInt();
      System.out.print("Digite o nº de derrotas do herói: ");
      int derrotas = input.nextInt();

      String classificacao = nivelHankeada(vitorias, derrotas);
      System.out.println(classificacao);
    } catch (InputMismatchException e) {
      System.out.println("Entrada inválida. Por favor, digite um valor válido.");
      input.next();
    } finally {
      input.close();
    }
  }
}
// Bootcamp Santander 2024 - Desenvolvimento de Jogos em Godot
// Desafio do Felipão da DIO
// Classificador de Heróis
// Samantha D. Medeiros, maio de 2024

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException;

// FIXME: consertar método 
public class ClassificadorHerois {
  private static final Map<Integer, String> niveisPoder = new HashMap<>();
  static {
    niveisPoder.put(1000, "Ferro");
    niveisPoder.put(2000, "Bronze");
    niveisPoder.put(5000, "Prata");
    niveisPoder.put(7000, "Ouro");
    niveisPoder.put(8000, "Platina");
    niveisPoder.put(9000, "Ascendente");
    niveisPoder.put(10000, "Imortal");
  }

  /**
   * Recebe o nome do herói e o seu nível de XP para retornar a sua classificação
   * @param nomeHeroi
   * @param xp
   * @return a classificação do herói
   */
  public static String classificacaoPoder(String nomeHeroi, int xp) {
    for (int xpLimite : niveisPoder.keySet()) {
      if (xp <= xpLimite) {
        return "O Herói de nome " + nomeHeroi + " está no nível " + niveisPoder.get(xpLimite) + "!";
      }
    }
    return "O Herói de nome " + nomeHeroi + " está no nível Radiante!";
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Classificador de Heróis!");
    try {
      System.out.print("Digite o nome do seu herói: ");
      String nomeHeroi = input.nextLine();
      System.out.print("Digite o nível de XP do seu herói: ");
      int xp = input.nextInt();
      String classificacao = classificacaoPoder(nomeHeroi, xp);
      System.out.println(classificacao);
    } catch (InputMismatchException e) {
      System.out.println("Entrada inválida. Por favor, digite um valor válido.");
      input.next();
    } finally {
      input.close();
    }
  }
}
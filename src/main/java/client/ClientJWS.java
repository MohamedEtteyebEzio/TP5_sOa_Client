package client;

import proxy.BanqueService;
import proxy.BanqueServiceService;
import proxy.Compte;

import java.util.Scanner;

public class ClientJWS {
    public static void main(String[] args) {
        // Création d'une instance du service web BanqueService à l'aide du proxy généré
        BanqueService banqueService = new BanqueServiceService().getBanqueServicePort();
        // Demande à l'utilisateur de saisir un montant
        System.out.println("Donner le Montant :");
        Scanner scanner = new Scanner(System.in);
        double montant = scanner.nextDouble();
        System.out.println("Montant avant conv:" + montant);
        // Appel de la méthode conversion du service web
        System.out.println("\nMontant apres conv:" + banqueService.conversion(montant));

        // Boucle pour parcourir et afficher les comptes retournés par la méthode getComptes
        for (Compte compte : banqueService.getComptes()) {
            System.out.println("Compte N°" + compte.getCode() + " a Solde : " + compte.getSolde() + "\n");
        }
    }
}

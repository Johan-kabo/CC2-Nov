
public class Banque__2{
    public static void main(String[] args) {
        client pedro = new client("pedro","Geneve",1000.0, 2000.0);
        client Alexandra = new client("Alexandra","Lausanne", 3000.0, 4000.0);
        System.out.println("Donnees avant le bouclement des comptes:");
        pedro.afficherDonnees();
        Alexandra.afficherDonnees();

        pedro.bouclercomptes();
        Alexandra.bouclercomptes();

        System.out.println("\nDonnees apres le bouclement des comptes:");
        pedro.afficherDonnees();
        Alexandra.afficherDonnees();

    }
}
class client{
    private String nom;
    private String ville;
    private compteprive compteprive;
    private compteepargne compteepargne;

    public client(String nom,String ville,double soldeprive,double soldeepargne){
        this.nom=nom;
        this.ville=ville;
        this.compteprive = new compteprive(soldeprive);
        this.compteepargne = new compteepargne(soldeepargne);
    }

    public void afficherDonnees(){
        System.out.println("Client: "+nom+" "+"de"+" "+ville);
        compteprive.affichersolde();
        compteepargne.affichersolde();
    }

    public void bouclercomptes(){
        compteprive.boucler();
        compteepargne.boucler();
    }

}

class Compte{
    protected double solde;

    public Compte(double solde){
        this.solde=solde;
    }
    public void affichersolde(){
        System.out.println("Compte prive: "+solde+ "francs");
    }
    public void boucler(){}

}

class compteprive extends Compte{
    private static final double TAUX = 0.01;

    public compteprive(double solde){
        super(solde);
    }

    @Override
    public void boucler() {
        solde += solde * TAUX;
    }
}

class compteepargne extends Compte{
    private static final double TAUX = 0.02;

    public compteepargne(double solde){
        super(solde);
    }

    public void boucler(){
        solde += solde * TAUX;
    }
}

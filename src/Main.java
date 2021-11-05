//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import java.io.File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static String getRandomWord(String word) throws IOException {
        String file = "";
        switch (word){
            case "cctemps":
                file = "cctemps.txt";
                break;

            case "cclieu":
                file = "cclieu.txt";
                break;

            case "nomf":
                file = "noms_feminins.txt";
                break;

            case "nomm":
                file = "noms_masculins.txt";
                break;

            case "verbe":
                file = "verbes.txt";
                break;

            case "transition": // alors, depuis, par la suite de...
                file = "mots_de_transition.txt";
                break;

            case "liaison": //avec, à, grâce à...
                file = "mots_de_liaison.txt";
                break;

            default:
                System.out.println("Mince! :/");
        }


        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        ArrayList<String> lines = new ArrayList<String>();
        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }
        Random r = new Random();

        return lines.get(r.nextInt(lines.size()));
    }



    public static String getRandomSentence() throws IOException {
        Random r = new Random();
        String personnage = perso_secondaires.get(r.nextInt(perso_secondaires.size()));

        //choix de la construction de la phrase:
        Random r2 = new Random();
        int caca = r.nextInt(5-1) + 1;;
        caca = 1;
        switch (caca) {          // liste des paramètres acceptés: verbe, cctemps, cclieu, transition, liaison, nomf, nomm, personnage,
            case 1:
                return getRandomWord("cctemps") + ", " + getRandomWord("cclieu") + ", " + perso_principal + " " + getRandomWord("verbe") + " " + getRandomWord("nomm") + " " + getRandomWord("liaison") + " " + personnage + ".";

            case 2:


            case 3:

            case 4:

            default:

        }
        return null;
    }


    static String getRandomName(){
        String[] prenoms = new String [] {"Abel",  "Absolon",  "Achille",  "Adam",  "Adolphe",  "Adrien",  "Aimé",  "Alain",  "Albert",  "Alexandre",  "Alexis",  "Alfred",  "Alison",  "Alphonse",  "Amaury",  "Ambroise",  "Amédée",  "Anatole",  "André",  "Anselme",  "Antoine",  "Apollinaire",  "Aristide",  "Armand",  "Armel",  "Arnaud",  "Auguste",  "Augustin",  "Aurèle",  "Aurelien",  "Baptiste",  "Barnabé",  "Barthélémy",  "Basile",  "Bastien",  "Baudouin",  "Benjamin",  "Benoit",  "Bernard",  "Bertrand",  "Blaise",  "Boniface",  "Brice",  "Bruno",  "Camille",  "Célestin",  "Cesaire",  "César",  "Charles",  "Charlot",  "Christian",  "Christophe",  "Claude",  "Clément",  "Colombain",  "Colombe",  "Constant",  "Constantin",  "Corentin",  "Corin",  "Cyrille",  "Damien",  "Daniel",  "David",  "Denis",  "Dennis",  "Désiré",  "Didier",  "Dieudonné",  "Dimitri",  "Diodore",  "Dion",  "Dominique",  "Donat",  "Donatien",  "Edgar",  "Edgard",  "Edmond",  "édouard",  "Eloi",  "émile",  "émilien",  "Emmanuel",  "Eric",  "Ermenegilde",  "Esmé",  "étienne",  "Eugène",  "Eustache",  "évariste",  "Evrard",  "Fabien",  "Fabrice",  "Felicien",  "Félix",  "Ferdinand",  "Fernand",  "Fiacre",  "Firmin",  "Florence",  "Florentin",  "Florian",  "Franck",  "François",  "Frédéric",  "Gabin",  "Gabriel",  "Gaétan",  "Gaspard",  "Gaston",  "Gautier",  "Geoffroi",  "Georges",  "Gerald",  "Gérard",  "Géraud",  "Germain",  "Gervais",  "Gervaise",  "Ghislain",  "Gilbert",  "Gilles",  "Godelieve",  "Gratien",  "Grégoire",  "Guillaume",  "Gustave",  "Guy",  "Hector",  "Henri",  "Herbert",  "Hercule",  "Hervé",  "Hilaire",  "Hippolyte",  "Honoré",  "Horace",  "Hubert",  "Hugues",  "Humbert",  "Ignace",  "Iréné",  "Isidore",  "Jacques",  "Jean",  "Jean-baptiste",  "Jean-marie",  "Jeannot",  "Jérémie",  "Jérôme",  "Joachim",  "Joël",  "Joseph",  "Josue",  "Jourdain",  "Jules",  "Julien",  "Juste",  "Justin",  "Lambert",  "Laurence",  "Laurent",  "Lazare",  "Léandre",  "Léon",  "Léonard",  "Léonce",  "Léopold",  "Lionel",  "Loic",  "Lothaire",  "Louis",  "Loup",  "Luc",  "Lucas",  "Lucien",  "Marc",  "Marcel",  "Marcellin",  "Marin",  "Marius",  "Martin",  "Mathieu",  "Mathis",  "Matthieu",  "Maurice",  "Maxime",  "Maximilien",  "Michel",  "Modeste",  "Modestine",  "Narcisse",  "Nazaire",  "Nicholas",  "Nicodème",  "Nicolas",  "Noah",  "Noé",  "Noel",  "Odilon",  "Olivier",  "Onesime",  "Osanne",  "Ozanne",  "Papillion",  "Pascal",  "Paschal",  "Patrice",  "Patrick",  "Paul",  "Perceval",  "Philbert",  "Philibert",  "Philippe",  "Pierre",  "Pierrick",  "Pons",  "Prosper",  "Quentin",  "Rainier",  "Raoul",  "Raphaël",  "Raphael",  "Raymond",  "Régis",  "Rémi",  "Rémy",  "Renard",  "Renaud",  "René",  "Reynaud",  "Richard",  "Robert",  "Roch",  "Rodolph",  "Rodolphe",  "Rodrigue",  "Roger",  "Roland",  "Romain",  "Sacha",  "Samuel",  "Sébastien",  "Serge",  "Séverin",  "Simon",  "Simone",  "Stéphane",  "Sylvain",  "Sylvestre",  "Telesphore",  "Theirn",  "Théo",  "Théodore",  "Théophile",  "Thibault",  "Thierry",  "Thomas",  "Timothée",  "Toussaint",  "Tristan",  "Ulrich",  "Urbain",  "Valentin",  "Valère",  "Valéry",  "Vespasien",  "Victor",  "Vincent",  "Vivien",  "Xavier",  "Yanick",  "Yann",  "Yannic",  "Yannick",  "Yves",  "Zacharie"};
        Random r = new Random();
        return prenoms[r.nextInt(prenoms.length)];
    }

    public static String perso_principal = "";
    public static ArrayList<String> perso_secondaires = new ArrayList<String>();
    public static String nbpage = "Pas encore défini";
    public static String nbmot = "Pas encore défini";

    public static void afficherTableau(){
        System.out.println("\n\n"+
                "\n-----------------------------|" + "-----------------------------|" +
                "\nNom du personnage principal: |" + perso_principal +
                "\n-----------------------------|" + "-----------------------------|");

        System.out.print("Personnages secondaires:     |");

        for (Object perso_secondaire : perso_secondaires) {
            System.out.print("\"" + perso_secondaire + "\", ");
        }
        System.out.println("\n-----------------------------|" + "-----------------------------|");

        System.out.println(""+
                "Nombre de pages aproximatif  |" + nbpage +
                "\n-----------------------------|" + "-----------------------------|");
        System.out.println(""+
                "Nombre de mots  aproximatif  |" + nbmot +
                "\n-----------------------------|" + "-----------------------------|\n");

    }




    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String tempstr;
        int tempint = 0;

        System.out.println("Entrez le nom du personnage principal:");
        perso_principal = sc.nextLine();
        System.out.println("Voulez-vous ajouter le nom des personnages secondaires? (si \"non\", ils seront générés aléatoirement.)");
        tempstr = sc.nextLine();
        if (tempstr.equals("oui")) {
            while (true) {
                System.out.println("\n\nEntrez un nom pour ajouter un personnage secondaire: (entrez \"fini\" pour terminer)");

                tempstr = sc.nextLine();

                if (!tempstr.equals("fini")) {
                    perso_secondaires.add(tempstr);
                }else{
                    break;
                }

                afficherTableau();
            }
        }else{
            for (int i=0;i<=5;i++) {
                perso_secondaires.add(getRandomName());
            }
            afficherTableau();


        }

        while(true) {
            try {
                System.out.println("Combien de page voulez-vous générer?");
                tempint = sc.nextInt();
                if (tempint>8000000 || tempint<0){
                    System.out.println("ERREUR: Veuillez entrer un nombre compris entre 0 et 8000000 (maximum théorique : 8,388,607)");

                }else{
                    nbpage = Integer.toString(tempint);
                    nbmot = Integer.toString((tempint * 450));
                    afficherTableau();
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERREUR: Veuillez entrer un nombre compris entre 0 et 8000000 (maximum théorique : 8,388,607)");
            }
            tempstr=sc.nextLine();
        }



        System.out.print(getRandomSentence());





/*
        PDDocument document = new PDDocument();
        PDPage my_page = new PDPage();
        document.addPage(my_page);
        document.save("Test.pdf");
        document.close();
*/



    }
}

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Font;
import java.io.*;
import java.nio.charset.StandardCharsets;
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

            case "nom":
                if (Math.random()*2==1) {
                    file = "noms_feminins.txt";
                }else{
                    file = "noms_masculins.txt";
                }
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


        InputStream is = Main.class.getResourceAsStream(file);
        BufferedInputStream reader = new BufferedInputStream(is);
        BufferedReader r = new BufferedReader(new InputStreamReader(reader, StandardCharsets.UTF_8));
        ArrayList<String> lines = new ArrayList<>();
        while(r.readLine() != null) {
            lines.add(r.readLine());
        }
        Random rand = new Random();
        return " " + lines.get(rand.nextInt(lines.size()));
    }



    public static String getRandomSentence() throws IOException {
        Random r = new Random();
        String personnage = " " + perso_secondaires.get(r.nextInt(perso_secondaires.size()));

        //choix de la construction de la phrase:
        Random r2 = new Random();
        int caca = r.nextInt(4-1) + 1;
        String phrase = "";
        switch (caca) {          // liste des paramètres acceptés: verbe, cctemps, cclieu, transition, liaison, nom, personnage
            case 1:
                phrase = getRandomWord("cctemps") + "," + getRandomWord("cclieu") + "," + perso_principal + getRandomWord("verbe") + getRandomWord("nom") + getRandomWord("liaison") + personnage;
                break;
            case 2:
                phrase = getRandomWord("transition") + personnage + getRandomWord("verbe") + getRandomWord("cclieu");
                break;
            case 3:
                phrase = getRandomWord("transition") + " il" + getRandomWord("verbe") + getRandomWord("liaison") + perso_principal;
                break;

            default:

        }
        return phrase.substring(0,2).toUpperCase() + phrase.substring(2).toLowerCase()+".";
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
    public static String tailleparag = "Pas encore défini";
    public static String titre = "Pas encore défini";

    public static void afficherTableau(){
        System.out.println("\n\n"+
                "\n-------------------------------|" + "-------------------------------|" +
                "\nNom du personnage principal:   |" + perso_principal +
                "\n-------------------------------|" + "-------------------------------|");
        System.out.println(""+
                "Titre                          |" + nbmot +
                "\n-------------------------------|" + "---------------------------|");

        System.out.print("Personnages secondaires:       |");

        for (Object perso_secondaire : perso_secondaires) {
            System.out.print("\"" + perso_secondaire + "\", ");
        }
        System.out.println("\n-------------------------------|" + "-----------------------------|");

        System.out.println(""+
                "Nombre de pages aproximatif    |" + nbpage +
                "\n-------------------------------|" + "-----------------------------|");
        System.out.println(""+
                "Nombre de mots  aproximatif    |" + nbmot +
                "\n-------------------------------|" + "-----------------------------|");
        System.out.println(""+
                "Nombre de lignes par paragraphe|" +
                "\naproximatif                    |" + tailleparag +
                "\n-------------------------------|" + "-----------------------------|\n");

    }




    public static void main(String[] args) throws IOException, DocumentException {
        Scanner sc = new Scanner(System.in);
        String tempstr;
        int tempint = 0;

        System.out.println("Entrez le nom du personnage principal:");
        perso_principal = " " + sc.nextLine();
        System.out.println("Entrez le titre du récit:");
        titre = sc.nextLine();
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

        while(true) {
            try {
                System.out.println("Entrez le nombre de ligne des paragraphes (aproximatif):");
                tempint = sc.nextInt();
                if (tempint>30 || tempint<0){
                    System.out.println("ERREUR: Veuillez entrer un nombre compris entre 0 et 30");

                }else{
                    tailleparag = Integer.toString(tempint);
                    afficherTableau();
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERREUR: Veuillez entrer un nombre compris entre 0 et 30");
            }
            tempstr=sc.nextLine();
        }



        int nbparagraphe = Integer.parseInt(nbpage)*34/Integer.parseInt(tailleparag)+2;
        System.out.println("nombre de paragraphes = " + nbparagraphe);
        System.out.println("Génération du PDF en cours, veuillez patienter...");

        StringBuilder content = new StringBuilder();
        ArrayList<String> contentlist = new ArrayList<>();

        for (int i = 0; i<nbparagraphe; i++) {
            for (int ii = 0; ii <=Integer.parseInt(tailleparag); ii++) {
                content.append(getRandomSentence());
            }
            contentlist.add(i, String.valueOf(content));
            content.delete(0, content.length());
        }





        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("ITextTest.pdf"));
        PdfHeader event = new PdfHeader();
        writer.setPageEvent(event);
        document.open();



        Paragraph preface = new Paragraph("\n\n"+titre+"\n\n", FontFactory.getFont(FontFactory.TIMES_BOLD, 20, Font.CENTER_BASELINE, new CMYKColor(0, 0, 0, 255)));
        preface.setAlignment(Element.ALIGN_CENTER);

        document.add(preface);


        for (int i=0;i<contentlist.size();i++){
            document.add(new Paragraph(String.valueOf(contentlist.get(i)), FontFactory.getFont(FontFactory.TIMES, 14, Font.CENTER_BASELINE, new CMYKColor(0, 0, 0, 255))));
            document.add(new Paragraph("\n\n"));

        }
        document.close();

    }

    public static class PdfHeader extends PdfPageEventHelper {

        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            try {
                Rectangle pageSize = document.getPageSize();
                ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase(titre), pageSize.getLeft(275), pageSize.getTop(30), 0);
                ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, new Phrase(String.format("Page%s", String.valueOf(writer.getCurrentPageNumber()))),
                        pageSize.getRight(30), pageSize.getTop(30), 0);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}

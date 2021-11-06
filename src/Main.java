//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import java.io.File;

import com.sun.rowset.internal.Row;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static final String SOURCE_FILE = "Tests.txt";
    public static final String CREATED_PDF = "Content.pdf";
    static double currentHeight = 0;
    static PDPageContentStream cs = null;


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
        ArrayList<String> lines = new ArrayList<String>();
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
        // caca = 3;
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
            case 4:
                // phrase =
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
        perso_principal = " " + sc.nextLine();
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



        StringBuilder content = new StringBuilder();
        for (int i = 0; i<20;i++) {
            for (int ii = 0; ii < 20; ii++) {
                content.append(getRandomSentence());
            }
            //content.append("\r\r");
        }










            try {
                PDDocument pdfDoc = new PDDocument();
                // for text file
                InputStream is = Main.class.getResourceAsStream(SOURCE_FILE);
                BufferedInputStream reader = new BufferedInputStream(is);
                BufferedReader br = new BufferedReader(new InputStreamReader(reader, StandardCharsets.UTF_8));
                PDPage page = new PDPage();
                // add page to the PDF document
                pdfDoc.addPage(page);
                String line;
                cs = new PDPageContentStream(pdfDoc, page);
                cs.beginText();
                cs.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 12);
                cs.newLineAtOffset(20, 750);
                cs.setLeading(12);
                // Read text file line by line
                while ((line = br.readLine()) != null) {
                    System.out.println("Line-- " + line);
                    showMultiLineText(pdfDoc, line, 20, 750, 580, 820, page, new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 15);
                }
                if(cs != null) {
                    cs.endText();
                    cs.close();
                }
                pdfDoc.save(CREATED_PDF);
                br.close();
                pdfDoc.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        /**
         *
         * @param pdfDoc
         * @param text
         * @param x
         * @param y
         * @param allowedWidth - allowed width for the line before content goes to next line
         * @param allowedHeight - Allowed height for the page before another page is added
         * @param page
         * @param font
         * @param fontSize
         * @throws IOException
         */
        private static void showMultiLineText(PDDocument pdfDoc, String text, int x, int y, int allowedWidth, double allowedHeight, PDPage page, PDFont font, int fontSize) throws IOException {
            List<String> lines = new ArrayList<String>();
            String line = "";
            // split the text on spaces
            String[] words = text.split(" ");
            for(String word : words) {
                if(!line.isEmpty()) {
                    line += " ";
                }
                // check if adding the word to the line surpasses the width of the page
                int size = (int) (fontSize * font.getStringWidth(line + word) / 1000);
                if(size > allowedWidth) {
                    // if line + word surpasses the width of the page, add the line without the current word
                    lines.add(line);
                    // start new line with the current word
                    line = word;
                } else {
                    // if line + word fits the page width, add the current word to the line
                    line += word;
                }
            }
            lines.add(line);

            for(String ln : lines) {
                System.out.println("Line- " + ln);
                // for each line add line height to current height
                // line height = 1.2 * fontSize is taken here
                currentHeight = currentHeight + 1.2 * fontSize;
                System.out.println("currentHeight " + currentHeight);

                if(currentHeight >= allowedHeight) {
                    System.out.println("adding new page " + currentHeight);
                    // When current height is more than allowed height for the page
                    // create a new page
                    page = new PDPage();
                    // add page to the PDF document
                    pdfDoc.addPage(page);
                    // reset currentHeight
                    currentHeight = 0;
                    cs.endText();
                    cs.close();
                    cs = new PDPageContentStream(pdfDoc, page);
                    cs.beginText();
                    cs.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 12);
                    cs.newLineAtOffset(20, 750);
                    cs.setLeading(12);
                }
                cs.showText(ln);
                cs.newLine();
            }











    }
}

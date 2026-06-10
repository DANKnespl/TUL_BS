package pkg27danknesemestralprojcect;

/**
 *
 * @author dankne
 */
public class SkalarniSoucin {
    
    /**
     * Testing method
     * @param args 
     */
    public static void main(String[] args) {
        //double a[][]={{1,2,3},{4,5,6},{7,8,9}};
        //dotProductOutput(dotProduct(a),a); 122
        logic();
        
    }
    /**
     * 27. Program searches for the largest dot product of multiple vectors.
     */
    public static void logic() {
        int n, k; //n = počet vektorů, k = počet prvků vektorů
        boolean escape = false; // escape = proměnná říkajíc zda ukončit vykonávání programu
        while (!escape) {
            System.out.println("Pocet vektoru (cele cislo), nula nebo zaporne cislo ukonci program");
            n = Main.sc.nextInt();
            if (n > 0) {
                System.out.println("Delka vektoru (cele nezaporne cislo)");
                k = Main.sc.nextInt();
                System.out.println("Zadej vektory (realna cisla)");
                double[][] vectors = createVectors(n,k); // 2D pole se všemy vektory
                double[] out = dotProduct(vectors); // 1D pole s indexy vektorů, s největším součinem, a největšíkm součinem
                dotProductOutput(out, vectors);
            } else {
                escape = true;
            }
        }
    }

    /**
     * Method used for initiation of 2D array based on users input.
     * Metoda pro načítání vektorů do 2D pole.
     * @param n number of vectors, počet vektorů
     * @param k number of elements in each vector
     * @return initiated 2D array
     */
    private static double[][] createVectors(int n, int k){
        double[][] vectors = new double[n][k];
        for (int i = 0; i < n; i++) { //počet vektorů
            for (int j = 0; j < k; j++) { //počet prvků vektorů
                vectors[i][j] = Main.sc.nextDouble();
            }
        }
        return vectors;
    }
    
    /**
     * Returns 1D array of indexes of vectors with largest dot product and their dot product
     * out[0] = smaller index
     * out[1] = larger index
     * out[2] = dot product of vectors with indexes stored in out[0] and out[1]  
     * @param vectors 2D array of vectors
     * @return 1D array
     */
    private static double[] dotProduct(double[][] vectors) {
        double tmpDP, maxDP = -Double.MAX_VALUE;  // tmp = pomocná proměnná, maxDP = největší součin
        int vector1 = 0, vector2 = 0;   // indexy vektorů s největším součinem
        for (int j = 1; j < vectors.length; j++) { 
            for (int p = 0; p < j; p++) {
                tmpDP = 0;
                for (int i = 0; i < vectors[0].length; i++) { 
                    tmpDP += vectors[j][i] * vectors[p][i]; 
                }
                if (tmpDP > maxDP) { 
                    maxDP = tmpDP;
                    vector1 = p;
                    vector2 = j; 
                }
            }
        }
        double[] out = {vector1, vector2, maxDP};
        return out;
    }

    /**
     * Method used for program output. Prints vectors and dotproduct
     * 
     * @param out indexes of vectors in vectors[] creating the largest dotproduct. And the largest dotproduct.
     * @param vectors vectors given by user 
     */
    private static void dotProductOutput(double[] out, double[][] vectors) {
        System.out.println("Vektory s nejvetsim skalarnim soucinem");
        for (int i = 0; i < 2; i++) { //vypsání vektorů
            System.out.print("(");
            for (int j = 0; j < vectors[0].length; j++) {
                System.out.format(Main.loc, (j + 1 == vectors[0].length) ? "%.2f" : "%.2f ", vectors[(int) out[i]][j]); // vypsání prvků vektorů, kde poslední prvek nepřidá mezeru
            }
            System.out.println(")");
        }
        if (out[0]!=out[1]){ //zjištění počtu vektorů
            System.out.format(Main.loc, "Skalarni soucin techto vektoru je %.2f \n", out[2]);
        }else{
            System.out.println("Pro skalarni soucin je potreba alespon dvou vektoru");
        }
    }
}
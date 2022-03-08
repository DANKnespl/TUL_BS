package pkg27danknesemestralprojcect;
public class Christmas {

    private static String color;
    private static String rColor;
    private static int thickness;

    public static void logic() {
        int[] in = inputs();
        if (validityCheck(in[0],in[1])){
            setup(in[0],in[1]);
            drawR(in[1]);
            drawBox(in[0],in[1]);
        }
    }
    private static int[] inputs(){
        int[] in = new int[2];
        System.out.println("Tvorime zde krabice na miru! Reknete si celou <vysku> a <sírku> a my Vam jednu vytvorime!");
        in[0]=Main.sc.nextInt(); //rows
        in[1]=Main.sc.nextInt(); //columns
        System.out.println();
        return in;
    }
    
    private static boolean validityCheck(int rows, int columns){
        if (rows<4 || columns <6){
            System.out.println("Mame pouze krabice vyssi nez 3 a sirsi nez 5");
            return false;
        }
        return true;
    }

    private static void setup(int rows,int columns){
        //final String[] COLOUR={"\u001B[31mR","\u001B[32mG","\u001B[34mB","\u001B[36mC","\u001B[35mM","\u001B[33mY","\u001B[30mK"};
        final String[] COLOUR={"\u001B[41m \u001B[0m","\u001B[42m \u001B[0m","\u001B[44m \u001B[0m","\u001B[46m \u001B[0m","\u001B[45m \u001B[0m","\u001B[43m \u001B[0m","\u001B[47m \u001B[0m"};
        color=COLOUR[(int)Math.floor(Math.random()*10000%(COLOUR.length))];
        rColor=COLOUR[(int)Math.floor(Math.random()*10000%(COLOUR.length))];
        thickness=(int)Math.floor(Math.random()*(rows<columns?rows:columns)/6);
    }

    private static void drawR(int columns){
        //for (int i=0;i<columns/2;i++){
        for (int i=0;i<3;i++){
            for(int j=0;j<columns;j++){
                if (j==columns/2-3+i||j==columns/2+2-i){
                    System.out.print(rColor);
                }else{
                    System.out.print(' ');
                }
            }
        System.out.println();
        }
    }

    private static void drawBox(int rows, int columns) {
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if ((j<columns/2-thickness-1||j>columns/2+thickness)&&(i<rows/2-thickness-1||i>rows/2+thickness)){
                    System.out.print(color);
                }else{
                    System.out.print(rColor);
                }
            }
            System.out.println();
        } 
    }
}
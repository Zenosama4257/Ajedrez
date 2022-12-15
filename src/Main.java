import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


    }
    public static  String[][] tablero(){
        String[][] tablero=new String[8][8];
        for (int i=7;i>-1;i--){
            for (int j=0;j<tablero[i].length;j++){
                String l="abcdefgh";
                char letra=l.charAt(i+1);
                tablero[i][j]=letra+""+(i+1);
            }
        }
        return tablero;
    }
    public  static  int posicion(String[][] tab) {
        Scanner SC = new Scanner(System.in);
        System.out.println("Introduce la posicion deseada");
        String pos = SC.next();
        int posi=0;
        int posj=0;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (pos.equals(tab[i][j])) {
                    posi=i;
                    posj=j;
                }
            }
        }
        String p=posi+""+posj;
        return Integer.getInteger(p);
    }
}
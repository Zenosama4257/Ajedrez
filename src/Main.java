import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] tablero = tablero();
        mostrarTablero(tablero);
        String pos = posicion(tablero);
        char pieza = elegirPieza();
        System.out.println("Pieza: " + pieza + "\n" + "Posición: " + pos);
    }

    public static void mostrarTablero(String[][] array){
        for (int i = 0; i <= array.length; i++){
            for (int j = 0; j < array.length; j++){
                if(i == 8){
                    if (j == 0){
                        System.out.print("   " + array[0][j].toUpperCase().charAt(0));
                    }else {
                        System.out.print("  " + array[0][j].toUpperCase().charAt(0));

                    }
                }else {
                    if (j == 0){
                        System.out.print(array[i][j].charAt(1) + " " + array[i][j]);
                    }else {
                        System.out.print(" " + array[i][j]);
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void imprimirTablero(String[][] array, String[] movimientos, char pieza){
        for (int i = 0; i <= array.length; i++){
            for (int j = 0; j < array.length; j++){
                if(i == 8){
                    if (j == 0){
                        System.out.print("   " + array[0][j].toUpperCase().charAt(0));
                    }else {
                        System.out.print("  " + array[0][j].toUpperCase().charAt(0));

                    }
                }else {
                    if (j == 0){
                        System.out.print(array[i][j].charAt(1) + " " + array[i][j]);
                    }else {
                        System.out.print(" " + array[i][j]);
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static char elegirPieza(){
        Scanner sc = new Scanner(System.in);
        char pieza;
        System.out.print("Elige una pieza pieza D(ama/reina), R(ey), P(eón), A(lfil), C(aballo), T(orre): ");
        pieza = sc.next().toUpperCase().charAt(0);
        return pieza;
    }

    public static String[][] tablero(){
        String[][] tablero=new String[8][8];
        for (int i=7;i>-1;i--){
            for (int j=0;j<tablero[i].length;j++){
                String l="abcdefgh";
                char letra=l.charAt(j);
                tablero[7-i][j]=letra+""+(i+1);
            }
        }
        return tablero;
    }

    public  static  String posicion(String[][] tab) {
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
        return posi+""+posj;
    }
}
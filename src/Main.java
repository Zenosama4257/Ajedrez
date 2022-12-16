import java.util.Scanner;

public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        String pos;
        char pieza;
        String[] movimientos = {"11", "22", "33", "44", "55", "66", "77"};
        String[][] tablero = tablero();
        mostrarTablero(tablero);
        pos = posicion(tablero);
        pieza = elegirPieza();
        System.out.println("Pieza: " + pieza + "\n" + "Posición: " + pos + "\n\n" + "Ahora mostraremos los posibles movimientos:");
        mostrarTablero(tablero, movimientos, pieza, pos);
        System.out.println("Donde te quieres mover? ");
        pos = posicion(tablero);
        mostrarTablero(tablero, pieza, pos);
    }

    public static String cambiarColor(int i){
        return switch (i) {
            case 1 -> BLUE;
            case 2 -> GREEN;
            default -> RESET;
        };
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

    public static void mostrarTablero(String[][] array, String[] movimientos, char pieza, String pos){
        int color = 0;
        for (int i = 0; i <= array.length; i++){
            for (int j = 0; j < array.length; j++){
                if(i == 8){
                    if (j == 0){
                        System.out.print("   " + array[0][j].toUpperCase().charAt(0));
                    }else {
                        System.out.print("  " + array[0][j].toUpperCase().charAt(0));
                    }
                }else {
                    if(pos.equals(String.valueOf(i) + j)){
                        color = 1;
                        if (j == 0){
                            System.out.print(array[i][j].charAt(1) + "  " + cambiarColor(color) + pieza + RESET);
                            System.out.print(RESET);
                        }else {
                            System.out.print("  " + cambiarColor(color) + pieza + RESET);
                            System.out.print(RESET);
                        }
                    }else{
                        for (int k = 0; k < movimientos.length; k++){
                            if(movimientos[k].equals(String.valueOf(i) + j)){
                                color = 2;
                            }
                        }
                        if (j == 0){
                            System.out.print(array[i][j].charAt(1) + " " + cambiarColor(color) + array[i][j] + RESET);
                            System.out.print(RESET);
                        }else {
                            System.out.print(" " + cambiarColor(color) + array[i][j] + RESET);
                            System.out.print(RESET);
                        }
                    }
                    color = 0;
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void mostrarTablero(String[][] array, char pieza, String pos){
        for (int i = 0; i <= array.length; i++){
            for (int j = 0; j < array.length; j++){
                if(i == 8){
                    if (j == 0){
                        System.out.print("   " + array[0][j].toUpperCase().charAt(0));
                    }else {
                        System.out.print("  " + array[0][j].toUpperCase().charAt(0));

                    }
                }else {
                    if(pos.equals(String.valueOf(i) + j)){
                        if (j == 0){
                            System.out.print(array[i][j].charAt(1) + " " + BLUE + " " + pieza + RESET);
                        }else {
                            System.out.print(" " + BLUE + " " + pieza + RESET);
                        }
                    }else{
                        if (j == 0){
                            System.out.print(array[i][j].charAt(1) + " " + array[i][j]);
                        }else {
                            System.out.print(" " + array[i][j]);
                        }
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
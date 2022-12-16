import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        String pos, pos1 = "";
        char pieza;
        String[] movimientos = {"11", "22", "33", "44", "55", "66", "77"};
        String[][] tablero = tablero();
        mostrarTablero(tablero);
        pieza = elegirPieza();
        pos = posicion(tablero);
        System.out.println("Ahora mostraremos los posibles movimientos:");
        mostrarTablero(tablero, movimientos, pieza, pos);
        do {
            if (pos.equals(pos1)){
                System.out.println("Error: No puedes mover la pieza a la posicion actual.");
            }
            pos1 = posicion(tablero);
        }while (pos.equals(pos1));
        pos = pos1;
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
            System.out.println("  -----------------------------------------");
            for (int j = 0; j < array.length; j++){
                if(i == 8){
                    if (j == 0){
                        System.out.print("     " + array[0][j].toUpperCase().charAt(0));
                    }else {
                        System.out.print("    " + array[0][j].toUpperCase().charAt(0));

                    }
                }else {
                    if (j == 0){
                        System.out.print(array[i][j].charAt(1) + " | " + array[i][j]);
                    }else {
                        System.out.print(" | " + array[i][j]);
                    }
                }
            }
            if (i == 8){
                System.out.println();

            }else {
                System.out.println(" |");
            }
        }
        System.out.println();
    }

    public static void mostrarTablero(String[][] array, String[] movimientos, char pieza, String pos){
        int color = 0;
        for (int i = 0; i <= array.length; i++){
            System.out.println("  -----------------------------------------");
            for (int j = 0; j < array.length; j++){
                if(i == 8){
                    if (j == 0){
                        System.out.print("     " + array[0][j].toUpperCase().charAt(0));
                    }else {
                        System.out.print("    " + array[0][j].toUpperCase().charAt(0));
                    }
                }else {
                    if(pos.equals(String.valueOf(i) + j)){
                        color = 1;
                        if (j == 0){
                            System.out.print(array[i][j].charAt(1) + " |  " + cambiarColor(color) + pieza + cambiarColor(0));
                        }else {
                            System.out.print(" |  " + cambiarColor(color) + pieza + cambiarColor(0));
                        }
                    }else{
                        for (int k = 0; k < movimientos.length; k++){
                            if(movimientos[k].equals(String.valueOf(i) + j)){
                                color = 2;
                            }
                        }
                        if (j == 0){
                            System.out.print(array[i][j].charAt(1) + " | " + cambiarColor(color) + array[i][j] + cambiarColor(0));
                        }else {
                            System.out.print(" | " + cambiarColor(color) + array[i][j] + cambiarColor(0));
                        }
                    }
                    color = 0;
                }
            }
            if (i == 8){
                System.out.println();

            }else {
                System.out.println(" |");
            }
        }
        System.out.println();
    }

    public static void mostrarTablero(String[][] array, char pieza, String pos){
        for (int i = 0; i <= array.length; i++){
            System.out.println("  -----------------------------------------");
            for (int j = 0; j < array.length; j++){
                if(i == 8){
                    if (j == 0){
                        System.out.print("     " + array[0][j].toUpperCase().charAt(0));
                    }else {
                        System.out.print("    " + array[0][j].toUpperCase().charAt(0));
                    }
                }else {
                    if(pos.equals(String.valueOf(i) + j)){
                        if (j == 0){
                            System.out.print(array[i][j].charAt(1) + " |  " + cambiarColor(1) + pieza + cambiarColor(0));
                        }else {
                            System.out.print(" |  " + cambiarColor(1) + pieza + cambiarColor(0));
                        }
                    }else{
                        if (j == 0){
                            System.out.print(array[i][j].charAt(1) + " | " + array[i][j]);
                        }else {
                            System.out.print(" | " + array[i][j]);
                        }
                    }
                }
            }
            if (i == 8){
                System.out.println();

            }else {
                System.out.println(" |");
            }
        }
        System.out.println("\n" + "--------------POSICIÓN FINAL---------------");
    }

    public static char elegirPieza(){
        Scanner sc = new Scanner(System.in);
        char pieza = '|';
        do{
            if(pieza == '|'){
                System.out.print("Elige una pieza D(ama/reina), R(ey), P(eón), A(lfil), C(aballo), T(orre): ");
                String a = sc.next();
                if (a.length() > 1){
                    pieza = '0';
                }else {
                    pieza = a.toUpperCase().charAt(0);
                }
            }else {
                System.out.print("Elige una pieza válida D(ama/reina), R(ey), P(eón), A(lfil), C(aballo), T(orre): ");
                String a = sc.next();
                if (a.length() > 1){
                    pieza = '0';
                }else {
                    pieza = a.toUpperCase().charAt(0);
                }
            }
        }while (pieza != 'D' && pieza != 'R' && pieza != 'P' && pieza != 'A' && pieza != 'C' && pieza != 'T');
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

        String pos="";
        boolean b;
        do {
            b=true;
            System.out.print("Elige una posición: ");
            try {

                pos= SC.next();
                for (int i=0;i<pos.length();i++){
                    char c1=pos.charAt(0);
                    char c2=pos.charAt(1);
                    if (c1<'a'||c1>'h') throw (new IndexOutOfBoundsException());
                    if (c2<'1'||c2>'8') throw (new IndexOutOfBoundsException());
                }
            }catch (IndexOutOfBoundsException e){
                b=false;
                System.out.println("Error: No has introducido una posicion valida");
            }
        }while (!b);
        int posi=0;
        int posj=0;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (pos.equalsIgnoreCase(tab[i][j])) {
                    posi=i;
                    posj=j;
                }
            }
        }
        return posi+""+posj;
    }

    public static String[] PosiblesMovimientos(String[][] tab,String pieza, String pos){
        if (Objects.equals(pieza, "P")) {
            /*int[] posicionPeon=PosicionPeon(tab, pos);
            return posicionPeon;*/
        }
        if (Objects.equals(pieza, "T")) {
            /*int[] posicionTorre=PosicionTorrre(tab, pos);
            return posicionTorre;*/
        }
        if (Objects.equals(pieza, "C")){
            /*int[] posicionCaballo=PosicionCaballo(tab, pos);
            return posicionCaballo;*/
        }
        if (Objects.equals(pieza, "A")){
            /*int[] posicionAlfil=PosicionAlfil(tab, pos);
            return posicionAlfil;*/
        }
        if (Objects.equals(pieza, "D")){
            /*int[] posicionTorre=PosicionTorre(tab, pos);
            int[] posicionAlfil=PosicionAlfil(tab, pos);
            int[] posionDama=posicionTorre+posicionAlfil;
            return posionDama;*/
        }
        if (Objects.equals(pieza, "R")){
            /*int[] posicionRey=PosicionRey(tab, pos);
            return posicionRey;*/
        }
        return new String[]{"00"};
    }
}
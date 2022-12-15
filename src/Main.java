import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] tablero = tablero();
        mostrarTablero(tablero);
        String i = posicion(tablero);
        System.out.println(i);

    }
    public static void mostrarTablero(String[][] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }
    }
    public static  String[][] tablero(){
        String[][] tablero=new String[8][8];
        for (int i=7;i>-1;i--){
            for (int j=0;j<tablero[i].length;j++){
                String l="abcdefgh";
                char letra=l.charAt(j);
                tablero[i][j]=letra+""+(i+1);
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
                if (Objects.equals(tab[i][j], pos)){
                    posi=i;
                    posj=j;
                }
            }
        }
        return posi+""+posj;

    }
    public static String PosiblesMovimientos(String[][] tab,String pieza, String pos){
        if (Objects.equals(pieza, "P")) {
            /*String posicionPeon=PosicionPeon(tab, pos);
            return posicionPeon;*/
        }
        if (Objects.equals(pieza, "T")) {
            /*String posicionTorre=PosicionTorrre(tab, pos);
            return posicionTorre;*/
        }
        if (Objects.equals(pieza, "C")){
            /*String posicionCaballo=PosicionCaballo(tab, pos);
            return posicionCaballo;*/
        }
        if (Objects.equals(pieza, "A")){
            /*String posicionAlfil=PosicionAlfil(tab, pos);
            return posicionAlfil;*/
        }
        if (Objects.equals(pieza, "D")){
            /*String posicionTorre=PosicionTorre(tab, pos);
            String posicionAlfil=PosicionAlfil(tab, pos);
            String posionDama=posicionTorre+posicionAlfil;
            return posionDama;*/
        }
        if (Objects.equals(pieza, "R")){
            /*String posicionRey=PosicionRey(tab, pos);
            return posicionRey;*/
        }
        return "";
    }
}
import org.w3c.dom.ls.LSOutput;

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

        String pos="";
        boolean b=true;
        do {
            System.out.println("Introduce la posicion deseada");
            try {

                pos= SC.next();
                for (int i=0;i<pos.length();i++){
                    char c1=pos.charAt(i);
                    char c2=pos.charAt(i++);
                    if (c1<'a'||c1>'h') throw (new IndexOutOfBoundsException());b=false;
                    if (c2<'1'||c2>'8') throw (new IndexOutOfBoundsException());b=false;
                }
            }catch (IndexOutOfBoundsException e){
                System.out.println("No has introducido una posicion valida");
            }
        }while (b);
        int posi=0;
        int posj=0;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (pos.equalsIgnoreCase(tab[i][j])){
                    posi=i;
                    posj=j;
                }
            }
        }
        return posi+""+posj;
    }
    public static int[] PosiblesMovimientos(String[][] tab,String pieza, String pos){
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
        return new int[]{0};
    }
}
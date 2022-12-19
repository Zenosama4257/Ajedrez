import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] tablero = tablero();
        mostrarTablero(tablero);
        String pos="h5";
        String[] Movimientos=PosiblesMovimientos(tablero,pos);
        System.out.println(Arrays.toString(Movimientos)+"lOS POSIBLE MOV");
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
                    char c1=pos.charAt(0);
                    char c2=pos.charAt(1);
                    if (c1<'a'||c1>'h') throw (new IndexOutOfBoundsException());
                    if (c2<'1'||c2>'8') throw (new IndexOutOfBoundsException());
                }
            }catch (IndexOutOfBoundsException e){
                b=false;
                System.out.println("No has introducido una posicion valida");
            }
        }while (!b);
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
    public static String[] PosiblesMovimientos(String[][] tab,/*String pieza,*/ String pos){
        return PosicionPeon(tab, pos);
        /*if (Objects.equals(pieza, "P")) {
            return PosicionPeon(tab, pos);
        }
        if (Objects.equals(pieza, "T")) {
            int[] posicionTorre=PosicionTorrre(tab, pos);
            return posicionTorre;
        }
        if (Objects.equals(pieza, "C")){
            int[] posicionCaballo=PosicionCaballo(tab, pos);
            return posicionCaballo;
        }
        if (Objects.equals(pieza, "A")){
            int[] posicionAlfil=PosicionAlfil(tab, pos);
            return posicionAlfil;
        }
        if (Objects.equals(pieza, "D")){
            int[] posicionTorre=PosicionTorre(tab, pos);
            int[] posicionAlfil=PosicionAlfil(tab, pos);
            int[] posionDama=posicionTorre+posicionAlfil;
            return posionDama;
        }
        if (Objects.equals(pieza, "R")){
            int[] posicionRey=PosicionRey(tab, pos);
            return posicionRey;
        }
        return new String[]{""};*/
    }
    public static String[] PosicionPeon(String[][] tab, String pos) {
        String[] MovimientosPeon = new String[4];
        int x = 0;
        int y = 0;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (Objects.equals(tab[i][j], pos)) {
                    x = i;
                    y = j;
                }
            }
        }
        Scanner sc = new Scanner(System.in);
        String color="";
        do {
            System.out.println("Introduce si es B (blanca) o N (negra)");
            color = sc.next();
        }while (color=="B"||color=="N");
        int cont =0;
        if (color.equalsIgnoreCase("B")) {
            if (x == 7) {
                System.out.println("Este peon no puede estar aqui porfavor intoduzca una adecuada");
                posicion(tab);
            }
            try {
                cont +=1;
                MovimientosPeon[0] = tab[x - 1][y - 1];

            } catch (ArrayIndexOutOfBoundsException e) {
                cont -=1;
            }
            try {
                cont +=1;
                MovimientosPeon[1] = tab[x - 1][y];

            } catch (ArrayIndexOutOfBoundsException e) {
                cont -=1;
            }
            try {
                cont +=1;
                MovimientosPeon[2] = tab[x - 1][y + 1];

            } catch (ArrayIndexOutOfBoundsException e) {
                cont -=1;
            }
            try {
                if (x == 6) {
                    cont +=1;
                    MovimientosPeon[3] = tab[x - 2][y];
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                cont -=1;
            }
            String[] PosicionPeon=new String[cont];
            if (cont==4){
                for (int i=0; i<PosicionPeon.length; i++){
                    PosicionPeon[i] = MovimientosPeon[i];
                }
            }
            if (cont==3){
                for (int i=0;i< PosicionPeon.length; i++){
                    PosicionPeon[i]=MovimientosPeon[i];
                }
            }
            int j=0;
            if (cont==2){
                for (int i=0;i< MovimientosPeon.length-2; i++){
                    String n=MovimientosPeon[i];
                    if (Objects.nonNull(n)){
                        PosicionPeon[j]=MovimientosPeon[i];
                        j++;
                    }

                }
            }
            return PosicionPeon;



        }
        if (color.equalsIgnoreCase("N")) {
            if (x == 0) {
                System.out.println("Este peon no puede estar aqui porfavor intoduzca una adecuada");
                posicion(tab);
            }
            try {
                cont +=1;
                MovimientosPeon[0] = tab[x + 1][y - 1];
            } catch (ArrayIndexOutOfBoundsException e) {
                cont -=1;
            }
            try {
                cont +=1;
                MovimientosPeon[1] = tab[x + 1][y];
            } catch (ArrayIndexOutOfBoundsException e) {
                cont -=1;
            }
            MovimientosPeon[2] = tab[x + 1][y + 1];
            try {
                if (x == 1) {
                    cont+=1;
                    MovimientosPeon[3] = tab[x + 2][y];

                }

            } catch (ArrayIndexOutOfBoundsException e1) {
                cont -=1;
            }
            String[] PosicionPeon=new String[cont];
            if (cont==4){
                for (int i=0; i<PosicionPeon.length; i++){
                    PosicionPeon[i] = MovimientosPeon[i];
                }
            }
            if (cont==3){
                for (int i=0;i< PosicionPeon.length; i++){
                    PosicionPeon[i]=MovimientosPeon[i];
                }
            }
            int j=0;
            if (cont==2){
                for (int i=0;i< MovimientosPeon.length-2; i++){
                    String n=MovimientosPeon[i];
                    if (Objects.nonNull(n)){
                        PosicionPeon[j]=MovimientosPeon[i];
                        j++;
                    }

                }
            }return PosicionPeon;
        }
        return MovimientosPeon;
    }
}
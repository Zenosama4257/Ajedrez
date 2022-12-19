import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        String pos, pos1;
        boolean repetir = true;
        char pieza;
        String[][] tablero = tablero();     //Creamos el tablero
        mostrarTablero(tablero);            //Mostramos el tablero vacio
        pieza = elegirPieza();              //Elegimos la pieza
        pos = posicion(tablero);            //Posicion donde empieza la pieza
        String[] movimientos = posiblesMovimientos(tablero, pieza, pos);    //Dependiendo de la pieza elegida se devolverá unos movimientos concretos
        System.out.println("Ahora mostraremos los posibles movimientos:");
        //System.out.println(Arrays.toString(movimientos));
        mostrarTablero(tablero, movimientos, pieza, pos);       //Esta vez muestra el tablero con la pieza en la posicion indicada y sus posibles movimientos
        do {                                            //Do While para comprobar si el usuario indica una posicion válida
            pos = posicion(tablero);                   //El usuario indica donde quiere moverse
            for (String movimiento : movimientos) {     //Comprueba si con los posibles movimientos mostrados en el tablero, el usuario elige uno de ellos
                if (movimiento.equals(pos)) {          //No se puede mover a casillas blancas ni a su propia casilla
                    repetir = false;                    //una vez encuentra que la posicion indicada por el usuario es válida sale del bucle
                    break;
                }
            }
            if (repetir){                               //Error por si no es valido el moviemiento
                System.out.println("Error: No puedes mover la pieza a esta posicion.");
            }
        }while (repetir);
        mostrarTablero(tablero, pieza, pos);            //Ahora mostrará el tablero con la posicion final de la pieza
    }

    public static String cambiarColor(int i){           //Devuelve un String que indica el color mostrado por pantalla
        return switch (i) {
            case 1 -> BLUE;
            case 2 -> GREEN;
            default -> RESET;
        };
    }

    public static void mostrarTablero(String[][] array){    //Muestra talbero vacio
        for (int i = 0; i <= array.length; i++){            //Hacemos uso de dos bucles anidados para mostrar la matriz
            System.out.println("  -----------------------------------------");
            for (int j = 0; j < array.length; j++){
                if(i == 8){                                                                 //Dependiendo de si quiere mostrar la ultima fila, que solo mostrará la
                                                                                            //número asociado a esa columna
                    if (j == 0){                                                            //Cuando imprime la primera posicion de cada Fila, muestra primero
                        System.out.print("     " + array[0][j].toUpperCase().charAt(0));    //el caracter que va asociado a esa fila
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

    //Esta función ahora tiene en cuenta la posicion de la pieza y sus posibles movimientos y los muestra con colores
    //Funciona igual que la anterior funcion pero tiene en cuenta si esa posicion está vacia, es un posible movimiento o es la posicion incial de la pieza
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
                        for (String movimiento : movimientos) {
                            if (movimiento.equals(String.valueOf(i) + j)) {
                                color = 2;
                                break;
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

    //Este tablero se muestra casi vacio ya que muestra la posicion final de la pieza
    public static void mostrarTablero(String[][] array, char pieza, String pos){
        System.out.println("\n" + "--------------POSICIÓN FINAL---------------");
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
        System.out.println("\n" + "--------------FIN DEL PROGRAMA-------------");
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

    public static String[] posiblesMovimientos(String[][] tab,char pieza, String pos){
        if (Objects.equals(pieza, 'P')) {
            /*String[] movPeon=movimientosPeon(tab, pos);
            return movPeon;*/
        }
        if (Objects.equals(pieza, 'T')) {
            String[] movTorre=movimientosTorre(tab, pos);
            return movTorre;
        }
        if (Objects.equals(pieza, 'C')){
            /*String[] movCaballo=movimientosCaballo(tab, pos);
            return movCaballo;*/
        }
        if (Objects.equals(pieza, 'A')){
            String[] movAlfil=movimientosAlfil(tab, pos);
            return movAlfil;
        }
        if (Objects.equals(pieza, 'D')){
            String[] movTorre=movimientosTorre(tab, pos);
            String[] movAlfil=movimientosAlfil(tab, pos);
            String[] movDama = new String[movTorre.length + movAlfil.length];
            System.arraycopy(movTorre, 0, movDama, 0, movTorre.length);
            System.arraycopy(movAlfil, 0, movDama, movTorre.length, movAlfil.length);
            return movDama;
        }
        if (Objects.equals(pieza, 'R')){
            return movimientosRey(pos);
        }
        return new String[]{"00"};
    }

    public static String[] movimientosRey(String pos){
        String[] mov = new String[8];
        int cont = 0;

        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
                if (i != 0 || j != 0){
                    int n = pos.charAt(0) - 48;
                    int m = pos.charAt(1) - 48;

                    n = n + i;
                    m = m + j;

                    if(n >= 0 && m >= 0 && n <= 7 && m <= 7){
                        mov[cont] = String.valueOf(n) + m;
                        cont++;
                    }
                }
            }
        }
        String[] mov1 = new String[cont];
        System.arraycopy(mov, 0, mov1, 0, cont);
        return mov1;
    }

    public static String [] movimientosTorre (String[][] tab, String posicion){
        char pos1 = posicion.charAt(0);
        String f = String.valueOf(pos1);
        char pos2 = posicion.charAt(1);
        String c = String.valueOf(pos2);
        int posf = Integer.parseInt(f);
        int posc = Integer.parseInt(c);
        int contador = 0;

        String [] posmov = new String[14];
        for (int i = 0;i <= 7 ; i++) {
            String aux = String.valueOf(i);
            String posaux = posf + aux;
            if (!posicion.equals(posaux)) {
                posmov[contador] = posaux;
                contador++;
            }
        }
        for (int p = 0; p<= 7 ; p++){
            String aux2 = String.valueOf(p);
            String posaux2 =  aux2 + posc ;
            if (!posicion.equals(posaux2)){
                posmov [contador] = posaux2;
                contador++;
            }
        }
        return posmov;
    }

    public static String [] movimientosAlfil (String[][] tab, String posicion) {
        char pos1 = posicion.charAt(0);
        String f = String.valueOf(pos1);
        char pos2 = posicion.charAt(1);
        String c = String.valueOf(pos2);
        int posf = Integer.parseInt(f);
        int posc = Integer.parseInt(c);
        int auxf = posf;
        int auxc = posc;
        String[] posmov = new String[13];
        int count = 0;
        for (int i = 0; i < 7; i++) {
            auxc++;
            auxf++;
            String aux = String.valueOf(auxf) + String.valueOf(auxc);
            if ( (auxc <= 7) && (auxf <= 7)) {
                posmov[count] = aux;
                count++;
            }
        }
        auxf = posf;
        auxc = posc;

        for (int j = 0; j < 7; j++) {
            auxc++;
            auxf--;
            String aux = String.valueOf(auxf) + String.valueOf(auxc);
            if ((auxc <= 7) && (auxf >= 0)) {
                posmov[count] = aux;
                count++;
            }
        }
        auxf = posf;
        auxc = posc;
        for (int u = 0; u < 7; u++) {
            auxc--;
            auxf++;
            String aux = String.valueOf(auxf) + String.valueOf(auxc);
            if ( (auxc >= 0) && (auxf <= 7)) {
                posmov[count] = aux;
                count++;
            }
        }
        auxf = posf;
        auxc = posc;
        for (int p = 0; p < 7; p++) {
            auxc--;
            auxf--;
            String aux = String.valueOf(auxf) + String.valueOf(auxc);
            if ((auxc >= 0) && (auxf >= 0)) {
                posmov[count] = aux;
                count++;
            }
        }

        String [] devuelve = new String[count];
        for (int d= 0; d< count; d++) {
            devuelve[d] = posmov[d];
        }
        return devuelve;

    }
}
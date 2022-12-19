import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in);
        String  [][] Tablero = new String[9][9];





    }

    public static  String[][] tablero(){
        String[][] tablero=new String[8][8];
        for (int i=7;i>=-1;i--){
            for (int j=0;j<tablero[i].length;j++){
                String l="abcdefgh";
                char letra=l.charAt(i+1);
                tablero[i][j]=letra+""+(i+1);
            }
        }
        return tablero;
    }

    public static String [] movimientosTorre (String[][] tab, String posicion){
        //Hasta la linea 34 son casteos que hago para transformar el string que me da posición con los números de la fila y la columna para poder pasarlo a enteros y trabajar con ellos.
        char pos1 = posicion.charAt(0);
        String f = String.valueOf(pos1);
        char pos2 = posicion.charAt(1);
        String c = String.valueOf(pos2);
        int posf = Integer.parseInt(f);
        int posc = Integer.parseInt(c);
        //Este contador sera el encargado de asignarle una posición dentro del array de String a cada posible resultado de la torre que va ha guardar
        int contador = 0;
        //Este es el String en el que se guardaran los resultados
        String [] posmov = new String[14];
        //Este bucle sera el que se quede una posición fija en este caso la de la fila y vaya aumentando las columnas. El bucle es de 7 posiciones porque le torre ya estará ocupando una de las 7 casillas
        for (int i = 0;i <= 7 ; i++) {
            String aux = String.valueOf(i);
            String posaux = posf + aux;
            //Esta condición sirve para comprobar que la nueva posición calculada teniendo en cuenta una fila fija y unas columnas que van aumentando no sea la posición que se le ha asignado a la torre al inicio
            if (!posicion.equals(posaux)) {
                posmov[contador] = posaux;
                contador++;
            }
        }
        //Este bucle es el mismo que el anterior pero esta vez la posición fija son las columnas y lo que se va incrementando son las filas
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
        //Hasta la linea 70 son casteos que hago para transformar el string que me da posición con los números de la fila y la columna para poder pasarlo a enteros y trabajar con ellos.
        char pos1 = posicion.charAt(0);
        String f = String.valueOf(pos1);
        char pos2 = posicion.charAt(1);
        String c = String.valueOf(pos2);
        int posf = Integer.parseInt(f);
        int posc = Integer.parseInt(c);
        //He creado 2 nuevas variables que son iguales a posf y posc para que al hacer los incrementos y decrementos para calcular las posibles posicionnes del Alfil no cambiar las posiciones originales de posf y posc y así tener una forma de volver ha inicializarlas después de cada bucle para que el alfil no se mueva de la posición original y vaya calculado los posibles movimientos desde las posiciones incorrectas
        int auxf = posf;
        int auxc = posc;
        String[] posmov = new String[13];
        //Este contador sera el encargado de asignarle una posición dentro del array de String a cada posible resultado de la torre que va ha guardar
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

    public static String [] movimientosCaballo (String[][] tab, String posicion){
        char pos1 = posicion.charAt(0);
        String f = String.valueOf(pos1);
        char pos2 = posicion.charAt(1);
        String c = String.valueOf(pos2);
        int posf = Integer.parseInt(f);
        int posc = Integer.parseInt(c);
//He creado 2 nuevas variables que son iguales a posf y posc para que al hacer los incrementos y decrementos para calcular las posibles posicionnes del Alfil no cambiar las posiciones originales de posf y posc y así tener una forma de volver ha inicializar las aux después de cada bucle para que la función no se ponga a calcular todos los posibles movimientos con los incrementos y decrementos que se le hayan atribuido en el bucle    anterior
        int auxf = posf;
        int auxc = posc;
        String[] posmov = new String[8];
        //Este contador sera el encargado de asignarle una posición dentro del array de String a cada posible resultado de la torre que va ha guardar
        int count = 0;
        for (int i = 0; i < 1; i++) {
            auxc += 2;
            auxf++;
            String aux = String.valueOf(auxf) + String.valueOf(auxc);
            if ( (auxc <= 7) && (auxf <= 7)) {
                posmov[count] = aux;
                count++;
            }
        }

        auxf = posf;
        auxc = posc;
        for (int j = 0; j < 1; j++) {
            auxc += 2;
            auxf--;
            String aux = String.valueOf(auxf) + String.valueOf(auxc);
            if ((auxc <= 7) && (auxf >= 0)) {
                posmov[count] = aux;
                count++;
            }

        }
        auxf = posf;
        auxc = posc;
        for (int u = 0; u < 1; u++) {
            auxc -= 2;
            auxf++;
            String aux = String.valueOf(auxf) + String.valueOf(auxc);
            if ( (auxc >= 0) && (auxf <= 7)) {
                posmov[count] = aux;
                count++;
            }

        }

        auxf = posf;
        auxc = posc;

        for (int p = 0; p < 1; p++) {
            auxc -= 2;
            auxf--;
            String aux = String.valueOf(auxf) + String.valueOf(auxc);
            if ((auxc >= 0) && (auxf >= 0)) {
                posmov[count] = aux;
                count++;
            }
        }

        auxf = posf;
        auxc = posc;

        for (int p = 0; p < 1; p++) {
            auxc--;
            auxf +=2 ;
            String aux = String.valueOf(auxf) + String.valueOf(auxc);
            if ((auxc >= 0) && (auxf <= 7)) {
                posmov[count] = aux;
                count++;
            }
        }

        auxf = posf;
        auxc = posc;

        for (int p = 0; p < 1; p++) {
            auxc--;
            auxf -= 2;
            String aux = String.valueOf(auxf) + String.valueOf(auxc);
            if ((auxc >= 0) && (auxf >= 0)) {
                posmov[count] = aux;
                count++;
            }
        }

        auxf = posf;
        auxc = posc;

        for (int p = 0; p < 1; p++) {
            auxc++;
            auxf -= 2;
            String aux = String.valueOf(auxf) + String.valueOf(auxc);
            if ((auxc <= 7) && (auxf >= 0)) {
                posmov[count] = aux;
                count++;
            }
        }

        auxf = posf;
        auxc = posc;

        for (int p = 0; p < 1; p++) {
            auxc++;
            auxf += 2;
            String aux = String.valueOf(auxf) + String.valueOf(auxc);
            if ((auxc <= 7) && (auxf <= 7)) {
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
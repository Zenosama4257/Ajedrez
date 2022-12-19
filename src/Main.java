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
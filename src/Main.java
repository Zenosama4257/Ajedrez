import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in);
        String  [][] Tablero = new String[9][9];
        int contador = 0;




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
}
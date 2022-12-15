public class Main {
    public static void main(String[] args) {


    }

    public static void mostrarTablero(){

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
}
import java.util.Scanner;

public class JuegoDeLaVida {

    int columna;
    int fila;
    int celula;


    Scanner e = new Scanner(System.in);

    public static void main(String[] args) {
        JuegoDeLaVida p = new JuegoDeLaVida();
        p.principal();
    }


    public void principal() {
        int inArray = 0;
        int opcio = 0;
        int imArray = 0;
        int posVida=0;
        int PosAuto=0;
        boolean seguir = false;


        System.out.println("Selecciona dimensió: ");
        System.out.println(" ");
        System.out.println("Quantes files vols?");
        fila = e.nextInt();
        System.out.println("Quantes columnes vols?");
        columna = e.nextInt();
        int array[][] = new int[fila][columna];
        System.out.println(" ");
        int array2[][] = new int[fila][columna];

        while (!seguir) {
            System.out.println("_______________________________");
            System.out.println("Selecciona opcio: ");
            System.out.println("[1] Manual ");
            System.out.println("[2] Automatica ");
            System.out.println("[3] Imprimir taulell");
            System.out.println("[4] Sortir");
            opcio = e.nextInt();
            switch (opcio) {
                case 1:
                    posVida = posicioVida(array,celula);

                    break;
                case 2:
                    PosAuto = posicioVidaAuto(array,celula);
                    break;
                case 3:
                    imprimirArray(array);

                    break;

                case 4:
                    System.exit(0);


            }


        }
    }

        public void imprimirArray (int [][] array) {

            for (int fila = 0; fila < array.length; fila++) {
                for (int columna = 0; columna < array[fila].length; columna++) {
                    System.out.print(" " + array[fila][columna] + " ");
                }
                System.out.println();
            }

        }

        public int posicioVida(int [][] array, int celula){
        int posVida=0;
        int num;
        int cont = 5;

            for (int i = 0 ; i < 5;i++){
            System.out.println("Selecciona una fila: " + "(Max." + cont + ")");
            fila = e.nextInt();
            fila = (fila-1);
            System.out.println("Selecciona una columna:"  + "(Max." + cont + ")");
            columna = e.nextInt();
            columna = (columna-1);
            cont--;
            if (fila > array.length || columna > array.length){
                System.out.println("Estas fora dels marges, selecciona una altre fila i columna dintre dels marges");
            }
            else if (fila <= array.length && columna <=array.length ) {
                if (array[fila][columna] > 0) {
                    System.out.println("Ja hi ha un numero en aquesta casella");

                } else if (array[fila][columna] == 0) {

                    System.out.println("Diposita un 1: ");
                    celula = e.nextInt();
                    if (celula != 1) {
                        System.out.println("Aixo no es un 1");
                        System.out.println("Torna a seleccionar l'opció");
                    } else {
                        array[fila][columna] = celula;
                    }
                }
              }
            }

        return posVida;
        }

    public int posicioVidaAuto(int [][] array, int celula){
        int PosAuto=0;
        int grupos=0;
        System.out.println("Quants grups vols posar?");
        grupos = e.nextInt();

        for (int a=0; a < grupos;a++){
            fila = (int)(Math.random()*array.length);
            columna = (int)(Math.random()*array[fila].length);
            celula = 1;
            array[fila][columna] = celula;
        }

        return PosAuto;
    }

    public void jugarVida (int [][] array, int [][] array2 ){

    }

    public int Veines (int [][]array,int fila,int columna){
        int Veines=0;
        if (array[fila+1][columna]==0){ //dreta
            Veines++;
        }
        if (array[fila+1][columna+1]==0){ //dreta diagonal adalt
            Veines++;
        }
        if (array[fila+1][columna-1]==0){ //dreta diagonal abaix
            Veines++;
        }
        if (array[fila-1][columna]==0){ //esquerra
            Veines++;
        }
        if (array[fila-1][columna-1]==0){ //esquerra diagonal abaix
            Veines++;
        }
        if (array[fila-1][columna+1]==0){ //esquerra diagonal adalt
            Veines++;
        }
        if (array[fila][columna-1]==0){ //abaix
            Veines++;
        }
        if (array[fila][columna+1]==0){ //adalt
            Veines++;
        }
        return Veines;
    }




}





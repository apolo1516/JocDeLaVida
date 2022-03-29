
import java.util.Random;
import java.util.Scanner;

public class JuegoDeLaVida {

    int columna;
    int fila;
    int celula;
    int Gen;
    int ContGen=0;
    Scanner e = new Scanner(System.in);
    Random random = new Random();

    {
        System.out.println("Selecciona dimensió: ");
    }

    {
        System.out.println(" ");
    }

    {
        System.out.println("Quantes files vols?");
    }

    {
        fila = e.nextInt();
    }

    {
        System.out.println("Quantes columnes vols?");
    }

    {
        columna = e.nextInt();
    }

    {
        System.out.println("Quantes generacions vols?");
    }

    {
        Gen = e.nextInt();
    }


    int array[][] = new int[fila][columna];


    public static void main(String[] args) {
        JuegoDeLaVida p = new JuegoDeLaVida();
        p.principal();
    }


    public void principal() {

        int opcio = 0;
        boolean seguir = false;


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
                    //No va bé l'evolució i no se perque//
                    posicioVida(array, celula);
                    imprimirArray(array);
                    while (ContGen < Gen) {
                        evo(fila, columna);
                        System.out.println("  ");
                        imprimirArray(array);
                        System.out.println(" ");
                        ContGen++;
                    }

                    break;
                case 2:
                    posicioVidaAuto(array, celula);
                    imprimirArray(array);
                    while (ContGen < Gen) {

                        evo(fila, columna);
                        System.out.println(" ");
                        imprimirArray(array);
                        System.out.println(" ");
                        ContGen++;
                    }
                    break;
                case 3:
                    imprimirArray(array);
                    break;
                case 4:
                    System.exit(0);


            }


        }
    }


    public void imprimirArray(int[][] array) {

        for (int fila = 0; fila < array.length; fila++) {
            for (int columna = 0; columna < array[fila].length; columna++) {
                System.out.print(" " + array[fila][columna] + " ");
            }
            System.out.println();
        }

    }

    public void posicioVida(int[][] array, int celula) {
        int posVida = 0;
        int num;
        int cont = 5;

        for (int i = 0; i < 5; i++) {
            System.out.println("Selecciona una fila: " + "(Max." + cont + ")");
            fila = e.nextInt();
            fila = (fila - 1);
            System.out.println("Selecciona una columna:" + "(Max." + cont + ")");
            columna = e.nextInt();
            columna = (columna - 1);
            cont--;
            if (fila > array.length || columna > array.length) {
                System.out.println("Estas fora dels marges, selecciona una altre fila i columna dintre dels marges");
            } else if (fila <= array.length && columna <= array.length) {
                if (array[fila][columna] > 0) {
                    System.out.println("Ja hi ha un numero en aquesta casella");

                } else if (array[fila][columna] == 0) {
                    celula = 1;
                    array[fila][columna] = celula;
                }
            }
        }

}

    public void posicioVidaAuto(int [][] array, int celula){
        System.out.println("Introdueix el nombre de colonies que vols");
        int colonies = e.nextInt();
        int Tcolonia = 0;
        for (int cont = 0; cont < colonies; cont++) {
            int posfila = random.nextInt((array.length - 1) - 1) + 1;
            int poscolumna = random.nextInt((array[0].length - 1) - 1) + 1;
            do {
                int poscol;
                int posfi;
                posfi = random.nextInt((posfila + 4) - (posfila - 4)) + (posfila - 4);

                while((posfi < 1) || (posfi > array.length - 1)) {
                    posfi = random.nextInt((posfila + 4) - (posfila - 4)) + (posfila - 4);
                }

                poscol = random.nextInt((poscolumna + 4) - (poscolumna - 4)) + (poscolumna - 4);
                while((poscol < 1) || (poscol > array.length - 1)) {
                    poscol = random.nextInt((poscolumna + 4) - (poscolumna - 4)) + (poscolumna - 4);
                }

                array[posfi][poscol] = 1;
                Tcolonia++;
            }

            while (Tcolonia < 5);
            Tcolonia = 0;
        }

    }


    public int Veines(int fila, int columna){
        int Veines=0;
        Veines += estadoCel(fila- 1, columna -1 );
        Veines += estadoCel(fila, columna - 1);
        Veines += estadoCel(fila + 1, columna - 1);
        Veines += estadoCel(fila - 1, columna);
        Veines += estadoCel(fila + 1, columna);
        Veines += estadoCel(fila - 1, columna + 1);
        Veines += estadoCel( fila + 1, columna + 1);
        return Veines;
    }

    public int estadoCel(int x, int y){
        if (x < 0 || x >= fila ){
            return 0;
        }
        if (y < 0 || y >=columna){

            return 0;
        }
        return array[x][y];
    }

    public void evo(int fila, int columna) {
        int [][] array2 = new int[fila][columna];
        for (int x = 0; x < fila ; x++) {
            for (int y = 0; y < columna; y++) {
                int vecinosVivos = Veines(x,y);
                if (estadoCel(x,y) == 1){
                    if (vecinosVivos < 2 ){
                        array2[x][y] = 0;
                    }else if (vecinosVivos == 2 || vecinosVivos == 3){
                        array2[x][y]= 1;
                    }else if (vecinosVivos > 3){
                        array2[x][y] = 0;
                    }
                }else {
                    if (vecinosVivos == 3){
                        array2[x][y] = 1;
                    }
                }



            }

        }

        this.array = array2;

    }

//hola

}






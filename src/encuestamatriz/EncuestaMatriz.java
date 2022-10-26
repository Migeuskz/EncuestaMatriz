/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


package encuestamatriz;

/**
 *
 * @author Mikey
 */
public class EncuestaMatriz {//Recuerda que primero evalua si trabaja o no
    
    public static int binarios() {//la persona si(1) trabaja o no(0)
        int respuesta;
        double valor = Math.random();
        if (valor < 0.5) {
            respuesta = 1;
        } else {
            respuesta = 0;
        }
        return respuesta;
    }

    public static int[][] encuesta() { 
        int[][] encuesta = new int[10][4];//Una Matriz de 10x4 representa Datos de 10 personas encuestadas, de la Sig. Forma:
        for (int i = 0; i < encuesta.length; i++) {
            for (int j = 0; j < encuesta[i].length; j++) {//Columna 0: Género->1 Hombres, 2 Mujeres.
                if (j == 0) {
                    encuesta[i][j] = (int) (Math.random() * 2 + 1);//Columna 1: Si la persona trabaja ->  0 No, 1 Sí
                } else if (j == 1) {
                    encuesta[i][j] = binarios();
                } else if ((j == 2) && (encuesta[i][1] == 1)) {
                    encuesta[i][j] = (int) (Math.random() * 6000 + 1);//Columna 2: Sueldo Mensual: valor entero de 0 a 6000
                } else if ((j == 2) && (encuesta[i][1] == 0)) {
                    encuesta[i][j] = 0;
                } else if (j == 3) {
                    encuesta[i][j] = (int) (Math.random() * 5 + 1);/*Columna 3: Grado de Estudios:
            1- Primaria
            2- Secundaria
            3- Bachillerato 
            4- Universidad Completa
            5- Posgrado*/
                }
            }
        }
        return encuesta;
    }

    public static void imprimirMatriz(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("%5d", array[i][j]);
            }
            System.out.println();
        }
    }

    public static int mujeres(int[][] array) {
        int mujeres = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] == 2) {
                mujeres++;
            }
        }
        return mujeres;
    }

    public static int hombres(int[][] array) {
        int hombres = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] == 1) {
                hombres++;
            }
        }
        return hombres;
    }

    public static void porcentajeGenero(int hombres, int mujeres) {
        double porcentajeMujeres, porcentajeHombres;
        porcentajeMujeres = (mujeres * 100) / 10;
        porcentajeHombres = (hombres * 100) / 10;
        System.out.println("Se entrevistaron a 10 personas de las cuales:");
        System.out.println(mujeres + " son mujeres, que equivale al " + porcentajeMujeres + "%");
        System.out.println(hombres + " son hombres, que equivale al " + porcentajeHombres + "%");
    }

    public static int mujeresT(int[][] array) {
        int mujeresT = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i][0] == 2) && (array[i][1] == 1)) {
                mujeresT++;
            }
        }
        return mujeresT;
    }

    public static int hombresT(int[][] array) {
        int hombresT = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i][0] == 1) && (array[i][1] == 1)) {
                hombresT++;
            }
        }
        return hombresT;
    }

    public static void porcentajeTrabajo(int hombres, int mujeres, int hombresT, int mujeresT, int[][] array) {
        double porcentajeM, porcentajeH;
        porcentajeM = (mujeresT * 100) / mujeres;
        porcentajeH = (hombresT * 100) / hombres;
        System.out.println("las " + mujeres + " mujeres entrevistadas, solo ellas " + mujeresT + " trabajan, y este " + porcentajeM + "% es el porcentajede Mujeres es del area laboral");
        System.out.println("De los " + hombres + " hombres entrevistados, únicamente " + hombresT + " trabajan,y este " + porcentajeH + "% es el porcentajede Hombres es del area laboral");
    }

    public static void sueldoPromedio(int hombresT, int mujeresT, int[][] array) {
        int sueldoM = 0;
        int sueldoH = 0;
        double promedioM, promedioH;
        for (int i = 0; i < array.length; i++) {
            if ((array[i][0] == 2) && (array[i][1] == 1)) {
                sueldoM = sueldoM + array[i][2];
            }
            if ((array[i][0] == 1) && (array[i][1] == 1)) {
                sueldoH = sueldoH + array[i][2];
            }
        }
        promedioM = sueldoM / mujeresT;
        promedioH = sueldoH / hombresT;
        System.out.println("su sueldo promedio de las mujeres es: $" + promedioM);
        System.out.println("su sueldo promedio de los hombres es: $" + promedioH);
    }

    public static void universitariosSinTrabajo(int[][] array) {
        int hombresST = 0;
        int mujeresST = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i][0] == 2) && (array[i][1] == 0) && (array[i][3] == 4)) {
                mujeresST++;
            }
            if ((array[i][0] == 1) && (array[i][1] == 0) && (array[i][3] == 4)) {
                hombresST++;
            }
        }
        System.out.println("Estas " + mujeresST + " mujeres tienen la universidad completa, pero no trabajan");
        System.out.println("Estos " + hombresST + " hombres tienen la universidad completa, pero no trabajan");
        
        
        if(hombresST > 1 && mujeresST > 1){
            System.out.println("Saquenme de LATAM!!!");
        }else{
            System.out.println("No estamos tan mal :)");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
Se requiere obtener:

(Generar los Datos aleatoriamente de acuerdo al rango solicitado)
        */
            int mujeres, hombres, mujeresT, hombresT;
            int[][] encuesta;
            encuesta = encuesta();//encuesta de 10x4
            imprimirMatriz(encuesta);
            mujeres = mujeres(encuesta);
            hombres = hombres(encuesta);
            porcentajeGenero(hombres, mujeres);//1. Porcentaje de hombres y mujeres 
            mujeresT = mujeresT(encuesta);
            hombresT = hombresT(encuesta);
            porcentajeTrabajo(hombres, mujeres, hombresT, mujeresT, encuesta);
            /*2. % de Hombres que trabajan
              3. % de Mujeres que trabajan */
            sueldoPromedio(hombresT, mujeresT, encuesta);
            /*4. El sueldo promedio de los hombres 
            5. El sueldo promedio de las Mujeres*/
            universitariosSinTrabajo(encuesta);
            /*6. ¿Cuantos Hombres con universidad completa No trabajan?
              7. ¿Cuantos Mujeres con universidad completa No trabajan?*/

    }
    
}

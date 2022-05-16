package Ex004;

import java.util.Scanner;

public class Radar {

    public static Double fineCalculate(Integer mph, Double pricePerMphAboveTheLimit, Integer limitOfMph){
        int mphAboveTheLimit = mph - limitOfMph;
        return mphAboveTheLimit * pricePerMphAboveTheLimit;
    }

    public static boolean aboveOfLimit(Integer mph, Integer limit){
        if(mph > limit){
            return true;
        }
        else{
            return false;
        }
    }

    public static String messageOfPolice(Integer mph, Integer limitOfMph){
        if(mph > limitOfMph){
            int mphAboveLimit = mph - limitOfMph;
            return "\u001B[31mVOCÊ FOI MULTADO POR PASSAR " + mphAboveLimit + "mph ACIMA DO LIMITE DA VIA ( " + limitOfMph + "mph" + " )!!";
        }
        else{
            return "\u001B[32mTenha um bom dia! Respeite as leis de trânsito.";
        }
    }

    public static String questions(Integer index){
        String[] questions = new String[10];
        questions[0] = "\u001B[36mVelocidade que ultrapassou o radar? ( MPH ): ";
        questions[1] = "\u001B[36mLimite da Via? ( MPH ): ";
        questions[2] = "\u001B[36mValor por MPH acima do limite? $";
        return questions[index];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print(questions(0));
        int mph = sc.nextInt();

        System.out.print(questions(1));
        int limitOfMph = sc.nextInt();

        System.out.print(questions(2));
        double pricePerMphAboveTheLimit = sc.nextDouble();

        System.out.println("\n\u001B[33m-------------------- RESULTADO DA ABORDAGEM --------------------\n\u001B[0m");

        if(aboveOfLimit(mph, limitOfMph)){
            double fine = fineCalculate(mph, pricePerMphAboveTheLimit, limitOfMph);
            String message = messageOfPolice(mph, limitOfMph);

            System.out.println("\u001B[36mMensagem do Policial: \n" + message + "\n\u001B[36mPreço da Multa: " + "\u001B[33m" + String.format("%.2f",fine));
        }
        else{
            String message = messageOfPolice(mph, limitOfMph);
            System.out.println("\u001B[36mMensagem do Policial: " + message);
        }

        sc.close();
    }
}

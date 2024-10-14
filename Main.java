import java.util.Scanner;
public class     GanjilGenap{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Inputkan angka: ");
        int n = input.nextInt();
        if(n % 2 == 1){
            System.out.println("Ganjil");
        }else{
            System.out.println("Genap");
        }
        input.close();
    }
}

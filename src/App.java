import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner cliReader = new Scanner(System.in);
        CepQuery cepQuery = new CepQuery();
        String cep;
        Address address;

        System.out.println("""
            ********************  
            Localiza CEP
            ********************  
            """);

        System.out.println("Qual CEP deseja consultar?");
        cep = cliReader.nextLine();
        cliReader.close();

        address = cepQuery.retrieveAddress(cep);

        System.out.println(address);

    }
}

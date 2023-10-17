import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner cliReader = new Scanner(System.in);
        CepQuery cepQuery = new CepQuery();
        String cep;
        Address address;
        String outFile;

        System.out.println("""
            ********************  
            Localiza CEP
            ********************  
            """);

        System.out.println("Qual CEP deseja consultar?");
        cep = cliReader.nextLine();

        System.out.println("Entre o nome to arquivo para salvar o resultado:");
        outFile = cliReader.next();

        FileGenerator mkFile = new FileGenerator(outFile);

        cliReader.close();

        address = cepQuery.retrieveAddress(cep);

        System.out.println(address);

        mkFile.saveJson(address);

    }
}

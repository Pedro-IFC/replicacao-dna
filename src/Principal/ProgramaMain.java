package Principal;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
public class ProgramaMain {

	public static void main(String[] args) {
        List<Fita> fitas = new ArrayList<>();
		int contFitas = -1;
		int contInvalidas =0;
		int contValidas =0;
		String file_path = "D:\\Projetos\\replicacao-dna\\src\\Principal";
		try {
			
			FileReader file = new FileReader(file_path+"\\fita.txt");
			
			BufferedReader reader = new BufferedReader(file);
			
			String line;
			
			while ((line = reader.readLine()) != null) {
				contFitas++;
                Fita fita = new Fita(line, fitas.size());
                fitas.add(fita);
				if(fita.validade()) {
					contValidas++;
					fita.generateComplement();
				}else {
					contInvalidas++;
				}
			}
			file.close();

			File arquivo = new File(file_path+"\\resposta.txt");
			if( arquivo.exists()) {
				arquivo.createNewFile();
			}
			FileWriter fw = new FileWriter( arquivo, true );
			BufferedWriter bw = new BufferedWriter( fw );

			for(Fita fita : fitas) {
				bw.write(fita.response());
				bw.newLine();
			}
			bw.close();
			fw.close();
			System.out.println("Total de fitas no arquivo: " + (contFitas + 1));
			System.out.println("Total de fitas validas: " + contValidas);
			System.out.println("Total de fitas inválidas: " + contInvalidas);
			System.out.println("Fitas inválidas: ");
			for(Fita fita : fitas) {
				if(!fita.validade()) {
					System.out.println(fita.response());
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}

package Principal;

public class FitaMain {

	public static void main(String[] args) {
	
		
		Fita f = new Fita("seq", 1);
		f.setSeq("GTCAACGGAAATCCATTAAATCGCCACACTAACTTGTATGCGCGAAGCGCACCTTAGTTGTCGATCTGCCTAATGGCCTTATCTAAAGACGGTACGACGCGTTGGGGGCTATATTGGCGTACGATCCCTACTCAGTAATTGGGGCCTACTS");
		f.generateComplement();

	}

}

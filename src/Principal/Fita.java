package Principal;

public class Fita {
	
	private String seq;
	private int id_line;
	private String seq_complement;
	
	// constructor
	public Fita(String seq, int id_line) {
		this.setId_line(id_line);
		this.setSeq(seq);
	}
	public Fita() {
	}
	
	// Methods
	public String response() {
		if (this.validade()) {
			return "Linha: "+(this.getId_line() + 1) + "\n" + this.getSeq_complement();
		}
		return "Linha: "+(this.getId_line() + 1) + "\n****FITA INVALIDA - " + this.getSeq();
	}
	
	public String generateComplement() {
		int i = 0;

		StringBuilder seq_complement = new StringBuilder();
		while(i<this.getSeq().length()){
			char caractere = this.getSeq().charAt(i);
			if(caractere == 'A') {
				seq_complement.append("T");
			}else if(caractere == 'T') {
				seq_complement.append("A");
			}else if(caractere == 'G') {
				seq_complement.append("C");
			}else if(caractere == 'C') {
				seq_complement.append("G");
			}
			i++;
		}
	
		this.setSeq_complement(seq_complement.toString());
		return this.getSeq_complement();
	}
	
	public boolean validade() {
		String dado = this.getSeq();
		dado = dado.replaceAll("A", "");
		dado = dado.replaceAll("T", "");
		dado = dado.replaceAll("C", "");
		dado = dado.replaceAll("G", "");
		return !(dado.length()>0);
	}
	
	// Get - Setters
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public int getId_line() {
		return id_line;
	}
	public void setId_line(int id_line) {
		this.id_line = id_line;
	}
	public String getSeq_complement() {
		return seq_complement;
	}
	public void setSeq_complement(String seq_complement) {
		this.seq_complement = seq_complement;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fita [seq=");
		builder.append(seq);
		builder.append(", id_line=");
		builder.append(id_line);
		builder.append(", seq_complement=");
		builder.append(seq_complement);
		builder.append(", validade()=");
		builder.append(validade());
		builder.append("]");
		return builder.toString();
	}
	

}

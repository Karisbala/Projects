package otherClasses;

import java.io.Serializable;

public class Mark implements Serializable {

	private int firstAttestation;
	private int secondAttestation;
	private int finalAttestation;
	
	public Mark() {
		
	}
	
	public Mark(int firstAttestation, int secondAttestation, int finalAttestation) {
		this.setFirstAttestation(firstAttestation);
		this.setSecondAttestation(secondAttestation);
		this.setFinalAttestation(finalAttestation);
	}

	public int getFirstAttestation() {
		return firstAttestation;
	}

	public void setFirstAttestation(int firstAttestation) {
		this.firstAttestation = firstAttestation;
	}

	public int getSecondAttestation() {
		return secondAttestation;
	}

	public void setSecondAttestation(int secondAttestation) {
		this.secondAttestation = secondAttestation;
	}

	public int getFinalAttestation() {
		return finalAttestation;
	}

	public void setFinalAttestation(int finalAttestation) {
		this.finalAttestation = finalAttestation;
	}
	
	public int getTotalMark() {
		return this.getFirstAttestation() + this.getSecondAttestation() + this.getFinalAttestation();
	}

	@Override
	public String toString() {
		return "First Attestation =" + firstAttestation 
				+ ", Second Attestation =" + secondAttestation
				+ ", Final Attestation =" + finalAttestation;
	}

}

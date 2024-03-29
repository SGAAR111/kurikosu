package org.kurikosu.transcription;

@SuppressWarnings("serial")
public class TranscriptionException extends RuntimeException {

	private String word;
	
	public TranscriptionException(String message, String word) {
		super(message);
	}

	@Override
	public String getMessage() {
		return super.getMessage() + " [" + word + "]";
	}
}

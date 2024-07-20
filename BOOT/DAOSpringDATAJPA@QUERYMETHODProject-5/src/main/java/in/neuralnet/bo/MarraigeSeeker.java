package in.neuralnet.bo;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class MarraigeSeeker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	private Long id;
	@NonNull
	private String name;
	@NonNull
	private String address;
	
	@Lob
	@NonNull
	private byte[]  photo;
	@NonNull
	private LocalDateTime dob;
	
	@Lob
	@NonNull
	private char[] bio;
	
	private boolean indian;

}

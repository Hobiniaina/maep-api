package mg.maep.api.models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "img_individu")
public class ImgIndividu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int idImage;

	private String name;

	private String contentType;

	private long contentSize;

	@Column(length = 16000000) // This should generate a medium blob
	@Basic(fetch = FetchType.LAZY)
	private byte[] files;

	public ImgIndividu() {
		super();
	}

	public int getIdImage() {
		return idImage;
	}

	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public long getContentSize() {
		return contentSize;
	}

	public void setContentSize(long contentSize) {
		this.contentSize = contentSize;
	}

	public byte[] getFiles() {
		return files;
	}

	public void setFiles(byte[] files) {
		this.files = files;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

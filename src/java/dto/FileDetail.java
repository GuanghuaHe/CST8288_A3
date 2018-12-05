package dto;

import java.time.LocalDate;




public class FileDetail {
	public static final String COL_NAME = "file";
	public static final String COL_TYPE = "Blob";
	
	
	
	private LocalDate date;
	private Integer file_id;
	private String name;
	private String size;
	private String type;

	public FileDetail() {
	}

	public FileDetail(Integer file_id, String name, String type, LocalDate date, String size) {
		setFile_id(file_id);
		setName(name);
		setType(type);
		setDate(date);
		setSize(size);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileDetail other = (FileDetail) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (file_id == null) {
			if (other.file_id != null)
				return false;
		} else if (!file_id.equals(other.file_id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public LocalDate getDate() {
		return date;
	}

	public Integer getFile_id() {
		return file_id;
	}

	public String getName() {
		return name;
	}

	public String getSize() {
		return size;
	}

	public String getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((file_id == null) ? 0 : file_id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setFile_id(Integer file_id) {
		this.file_id = file_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setType(String type) {
		this.type = type;
	}

}

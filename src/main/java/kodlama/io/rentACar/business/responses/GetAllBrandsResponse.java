package kodlama.io.rentACar.business.responses;

public class GetAllBrandsResponse {

	
	private String name;
	private int id;
	public GetAllBrandsResponse(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public GetAllBrandsResponse() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}

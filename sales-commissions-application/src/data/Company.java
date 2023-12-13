package data;
public class Company {

		private String companyName;
		private Address companyAddress;
		
		
		public Company(){
			companyAddress = new Address();
		}
		
		public String getName() {
			return companyName;
		}
		
		
		
		public Address getCompanyAddress(){
			
			return companyAddress;
		}
		public Address getAddress(){
			return companyAddress;
		}



		public void setName(String name) {
			this.companyName = name;
		}
}

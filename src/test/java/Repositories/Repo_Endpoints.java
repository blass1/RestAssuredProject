package Repositories;

public class Repo_Endpoints {
	
	public String get_def_menuCategoria(String base_url, String producto) {
		return "https://"+base_url+"/api/Productos/"+producto+"/Cuentas";
	};
	
	//
	public String ep_loginTest() {
		return "https://reqres.in/api/users/2";
	};
}

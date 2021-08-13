package Repositories;

public class Repo_Endpoints {

	// Endpoint perteneciente a GetAccessToken Aprepagas - QA
	public String get_GetAccessToken_Aprepagas_QA() {
		return "http://sso.global.globalprocessing.net.ar/auth/realms/GlobalProcessing/protocol/openid-connect/token";
	};
	
	public String get_def_menuCategoria(String base_url, String producto) {
		return "https://"+base_url+"/api/Productos/"+producto+"/Cuentas";
	};
	
	// Endpoint perteneciente a GetAccessToken Aprepagas - QA
	public String get_GetAccessTokenTest() {
		return "https://reqres.in/api/login";
	};
}

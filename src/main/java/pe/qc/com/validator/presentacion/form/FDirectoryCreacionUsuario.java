package pe.qc.com.validator.presentacion.form;

public class FDirectoryCreacionUsuario {
	
	private String loginProd;
	private String loginCert;
	private String loginDesa;
	private String usuarioProd;
	private String usuarioCert;
	private String usuarioDesa;
	private String descripcionProd;
	private String descripcionCert;
	private String descripcionDesa;
	
	public FDirectoryCreacionUsuario() {
		
	}

	public String getLoginProd() {
		return loginProd;
	}

	public void setLoginProd(String loginProd) {
		this.loginProd = loginProd;
	}

	public String getLoginCert() {
		return loginCert;
	}

	public void setLoginCert(String loginCert) {
		this.loginCert = loginCert;
	}

	public String getLoginDesa() {
		return loginDesa;
	}

	public void setLoginDesa(String loginDesa) {
		this.loginDesa = loginDesa;
	}

	public String getUsuarioProd() {
		return usuarioProd;
	}

	public void setUsuarioProd(String usuarioProd) {
		this.usuarioProd = usuarioProd;
	}

	public String getUsuarioCert() {
		return usuarioCert;
	}

	public void setUsuarioCert(String usuarioCert) {
		this.usuarioCert = usuarioCert;
	}

	public String getUsuarioDesa() {
		return usuarioDesa;
	}

	public void setUsuarioDesa(String usuarioDesa) {
		this.usuarioDesa = usuarioDesa;
	}

	public String getDescripcionProd() {
		return descripcionProd;
	}

	public void setDescripcionProd(String descripcionProd) {
		this.descripcionProd = descripcionProd;
	}

	public String getDescripcionCert() {
		return descripcionCert;
	}

	public void setDescripcionCert(String descripcionCert) {
		this.descripcionCert = descripcionCert;
	}

	public String getDescripcionDesa() {
		return descripcionDesa;
	}

	public void setDescripcionDesa(String descripcionDesa) {
		this.descripcionDesa = descripcionDesa;
	}

	@Override
	public String toString() {
		return "\n				FDirectoryCreacionUsuario [loginProd=" + loginProd + ", loginCert=" + loginCert + ", loginDesa="
				+ loginDesa + ", usuarioProd=" + usuarioProd + ", usuarioCert=" + usuarioCert + ", usuarioDesa="
				+ usuarioDesa + ", descripcionProd=" + descripcionProd + ", descripcionCert=" + descripcionCert
				+ ", descripcionDesa=" + descripcionDesa + "]";
	}
	
}

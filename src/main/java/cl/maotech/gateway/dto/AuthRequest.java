package cl.maotech.gateway.dto;

public class AuthRequest {
    private String email;
    private String password;
    
    public String getemail() {
        return email;
    }
    public void setemail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}



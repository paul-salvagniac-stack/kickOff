package bd;

public class Login {

    private String email;
    private String num;
    private String mdp;
    private int id;
    private String type;


    public Login (String email,String num,String mdp, int id,String type){
        this.email = email;
        this.num = num;
        this.mdp = mdp;
        this.id = id;
        this.type = type;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getMdp() {
        return mdp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

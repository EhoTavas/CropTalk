public class Usuario{
    private String nome="", email="", confirmarSenha="", telefone="", senha="";

    public Usuario(String nome, String email, String telefone, String senha, String confirmarSenha) throws Exception{

        
        if(!isValidaNome(nome)) throw new Exception("Nome inválido!");
        if(!isValidaEmail(email)) throw new Exception("E-mail inválido!");
        if(!isValidaTelefone(telefone)) throw new Exception("Telefone inválido!");
        if(!isValidaSenha(senha)) throw new Exception("Senha deve ter pelo menos 8 caracteres!");
        if(!isValidaConfirmarSenha(senha, confirmarSenha)) throw new Exception("Confirmar senha inválido!");

        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.confirmarSenha = confirmarSenha;
        
    }

    public String getNome(){
        return this.nome;
    }
    
    public String getEmail(){
        return this.email;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public String getSenha(){
        return this.senha;
    }

    public String getConfirmarSenha(){
        return this.confirmarSenha;
    }

    private boolean isValidaNome(String nome){
        if (nome.matches(".*\\d.*")) return false;
        return true;
    }

    public void setNome(String nome)throws Exception{
        if(nome == null)throw new Exception("Nome ausente");
        if(!isValidaNome(nome)) throw new Exception("Nome inválido!");      

        this.nome = nome;
    }

    private boolean isValidaEmail(String email){
        if (!email.matches("^[^@]+@[^@]+\\.(com|br)$")) return false;
        return true;
    }

    public void setEmail(String email)throws Exception{
        if(email == null) throw new Exception("E-mail ausente");
        if(!isValidaEmail(email))throw new Exception("E-mail inválido");

        this.email = email;
    }

    private boolean isValidaTelefone(String telefone){
        if(telefone.length()!=11) return false;
        return true;
    }

    public void setTelefone(String telefone)throws Exception{
        if(telefone == null) throw new Exception("Telefone ausente!");
        if(!isValidaTelefone(telefone))throw new Exception("Telefone inválido!");
        //arrumando o tel
        telefone = "(" + telefone.substring(0, 2) + ") " +
                                   telefone.substring(2, 7) + "-" +
                                   telefone.substring(7, 11);

        this.telefone = telefone;
    }

    private boolean isValidaSenha(String senha){
         if(senha.length() < 8) return false;
         return true;
    }

    public void setSenha(String senha) throws Exception{
        if(senha == null)throw new Exception("Senha ausente!");
        if(!isValidaSenha(senha))throw new Exception("A senha deve ter pelo menos 8 caracteres");
        this.senha = senha;
    }

    private boolean isValidaConfirmarSenha(String senha,String confirmarSenha){
        if(senha.length()!= confirmarSenha.length()) return false;
        if(!senha.equals(confirmarSenha)) return false;
        return true;
    }
    public void setConfirmarSenha(String confirmarSenha)throws Exception{
        if(confirmarSenha == null) throw new Exception("Senha ausente!");
        if(!isValidaConfirmarSenha(this.senha, confirmarSenha)) throw new Exception("Confirmar senha inválido");
        this.confirmarSenha = confirmarSenha;
    }


    @Override 
    public String toString(){

        return  this.nome + "\n "+
                this.email + "\n "+
                this.telefone + "\n "+
                this.senha + "\n "+
                this.confirmarSenha;
    }

    @Override 
    public int hashCode(){
        int ret = 6666;

        ret = 13*ret + String.valueOf(this.nome).hashCode();
        ret = 13*ret + String.valueOf(this.email).hashCode();
        ret = 13*ret + String.valueOf(this.telefone).hashCode();
        ret = 13*ret + String.valueOf(this.senha).hashCode();
        ret = 13*ret + String.valueOf(this.confirmarSenha).hashCode();

        if(ret<0)ret = -ret;
        return ret;
    }

    @Override 
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(obj != this) return false;
        if(obj.getClass()!= this.getClass())return false;

        if (!((Usuario) obj).nome.equals(this.nome) ||
            !((Usuario) obj).email.equals(this.email) ||
            !((Usuario) obj).telefone.equals(this.telefone) ||
            !((Usuario) obj).senha.equals(this.senha)) return false;

        return true;
    }

    private Usuario (Usuario modelo) throws Exception{
        if(modelo == null) throw new Exception("Modelo ausente");
        this.nome = modelo.nome;
        this.email = modelo.email;
        this.telefone = modelo.telefone;
        this.senha = modelo.senha;
    }

    @Override 
    public Object clone(){
        Usuario ret = null;

        try{
            ret = new Usuario (this);
        }catch(Exception erro)
        {}

        return ret;
    }

}
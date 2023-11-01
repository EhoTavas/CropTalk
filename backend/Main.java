public class Main {
    public static void main(String[] args) throws Exception{
        try {
            Usuario u1 = new Usuario("maria", "maria@gmail.com", "11994677949", "ABC12345", "ABC12345");
            Usuario u2 = new Usuario("joao", "joao@gmail.com", "11994677948", "14782589", "14782589");
            Usuario u3 = new Usuario("augusto", "augusto@gmail.com", "11994677925", "14782589", "14782589");
            u1.setTelefone("12345678912");
            u2.setNome("Tais");
            //u1.setEmail("tais@gmail.com");
            System.out.println(u1);
            System.out.println(u2);
            System.out.println(u3);
        } catch (Exception e) {
            System.err.println("Erro ao criar o usuário: " + e.getMessage());
        }
    }
    

}

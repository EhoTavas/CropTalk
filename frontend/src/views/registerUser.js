function registerUser() {

    const name = document.getElementById("nome").value;
    const email = document.getElementById("email").value;
    const phone = document.getElementById("telefone").value;
    const password = document.getElementById("senha").value;
    messagesResponse.textContent = ""; // Limpa mensagens de erro anteriores.

    // construcao do obj com os dados
    const userData = {
        name: name,
        email: email,
        phone: phone,
        password: password
    };

    // Envia a requisição POST para o backend
    axios.post('http://localhost:8080/api/v1/users', userData)
        .then(response => {
            console.log(response.data);
            messagesResponse.textContent = "Cadastro efetuado com sucesso!";
        })
        .catch(error => {
            console.error(error);
            messagesResponse.textContent = "Erro ao cadastrar! Tente novamente";
        });
        
}
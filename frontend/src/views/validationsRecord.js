function validateForm(event) {
  event.preventDefault();
    const name = document.getElementById("nome").value;
    const email = document.getElementById("email").value;
    const phone = document.getElementById("telefone").value;
    const senha = document.getElementById("senha").value;
    const confirmarSenha = document.getElementById("confirmarSenha").value;
    const errorMessages = document.getElementById("errorMessages");

    // construcao do obj com os dados
    const userData = {
      name: name,
      email: email,
      phone: phone,
      password: senha,
      confirmPassword: confirmarSenha
  };
   

    errorMessages.textContent = ""; // Limpa mensagens de erro anteriores.
    

    //validação do nome
    if (!/^[a-zA-ZÀ-ú\s]+$/.test(name)) {
        errorMessages.textContent = "Nome inválido.";
        return false;
      }
      

    //validação email
    if(!/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.(com|br)$/.test(email)){
        errorMessages.textContent = "E-mail inválido.";
        return false;
    }

    if(!validateAndFormatPhone(phone)){
        errorMessages.textContent = "Telefone inválido. Insira no formato (99) 99999-9999."
        return false;
    }

    //validação senha
    if(senha.length < 8){
        errorMessages.textContent = "Senha inválida. Deve conter no mínimo 8 dígitos."
        return false;
    }

    //validação confirmar senha
    if((confirmarSenha.length != senha.length) || (confirmarSenha !== senha)){
        errorMessages.textContent = "Senhas não conferem."
        return false;
    }

    registerUser(userData);
    return true;
  }

  //funcao valida phone
  function validateAndFormatPhone(phone) {
    phone = phone.replace(/\D/g, ''); // Remove caracteres não numéricos.
    if (phone.length !== 11) {
      return false; // Telefone inválido
    }
    return true;
  }

  async function registerUser(userData) {
    // Envia a requisição POST para o backend
    const config = {
      headers: {
        'Content-Type': 'application/json',
        // Adicione outros headers, se necessário
      },
    };
    axios.post('http://localhost:8080/api/v1/users', userData, config)
        .then(response => {
            console.log(response.data);
            errorMessages.textContent = "Cadastro efetuado com sucesso!";
        })
        .catch(error => {
            console.error(error);
            errorMessages.textContent = "Erro ao cadastrar! Tente novamente";
        });
        
}
  

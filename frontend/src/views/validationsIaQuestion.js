function validateFormQuestion(event) {
    event.preventDefault();
      const typeSolutions = document.getElementById
      const question = document.getElementById("textSection").value;
      const errorMessages = document.getElementById("errorMessages");
      const credits = 10;
      const type=0;

      errorMessages.textContent = ""; // Limpa mensagens de erro anteriores.
      
      //validação se pode fazer pergunta
      if(credits<=0){
        errorMessages = "Quantidade de créditos excedida! Adquira um novo plano."
        return false;
      }

      if(typeSolutions == null){
        errorMessages = "Escolha uma das três opções de negócios!";
        return false;
      }

      if(typeSolutions == "garden"){
        type == 1;
      }
      else if(typeSolutions == "smallFarm"){
        type == 2;
      } 
      else if(typeSolutions == "bigFarm"){
        type == 3;
      }

      if(question == null){
        errorMessages = "Informe o problema na caixa de texto!";
        return false;
      }
      
      // construcao do obj com os dados
      const questionData = {
        type: type,
        question: question
    };

      createQuestion(questionData);
      return true;
}  
  
    async function createQuestion(questionData) {
      // Envia a requisição POST para o backend
      const config = {
        headers: {
          'Content-Type': 'application/json',
        },
      };
      axios.post('http://localhost:8080/api/v1/iaQuestions', questionData, config)
          .then(response => {
              console.log(response.data);
              errorMessages.textContent = "Pergunta enviada!";
          })
          .catch(error => {
              console.error(error);
              errorMessages.textContent = "Erro ao enviar a pergunta! Tente novamente";
          });
          
  }
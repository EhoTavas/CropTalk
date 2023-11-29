function validateFormQuestion(event) {
  event.preventDefault();

  const question = document.getElementById("question").value.trim(); //retira os espaços em branco
  const errorMessages = document.getElementById("errorMessages");

  // Adicione a validação para os campos de rádio
  const businessTypeRadios = document.getElementsByName("tipoPropriedade");
  let selectedBusinessType = null; //aramazena a opcao de radio

  //percorre todas as opcoes e para quando achar a selecionada
  for (const radio of businessTypeRadios) {
      if (radio.checked) {
          selectedBusinessType = radio.value;
          break;
      }
  }

  errorMessages.textContent = "";

  // Verifica se algum campo está em branco
  if (!question) {
      errorMessages.textContent = "Escreva o seu problema!";
      return false;
  }
  
if (!selectedBusinessType) {
  errorMessages.textContent = "Escolha pelo menos uma das opções!";
  return false;
}

  // Adiciona os atributos ao objeto solutionData
  const questionData = {
      question: question,
      typeBusiness: selectedBusinessType
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
              errorMessages.textContent = "Solicitação enviada com sucesso!";
          })
          .catch(error => {
              console.error(error);
              errorMessages.textContent = "Erro ao enviar a solicitação! Tente novamente";
          });
          
  }
    
  
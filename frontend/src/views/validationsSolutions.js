function validateFormSolutions(event) {
  event.preventDefault();

  const solution = document.getElementById("solution").value.trim(); //retira os espaços em branco
  const applicationSolution = document.getElementById("applicationSolution").value.trim();
  const errorMessages = document.getElementById("errorMessages");

  // Adicione a validação para os campos de rádio
  const solutionTypeRadios = document.getElementsByName("solutionType");
  let selectedSolutionType = null; //aramazena a opcao de radio

  //percorre todas as opcoes e para quando achar a selecionada
  for (const radio of solutionTypeRadios) {
      if (radio.checked) {
          selectedSolutionType = radio.value;
          break;
      }
  }

  errorMessages.textContent = "";

  // Verifica se algum campo está em branco
  if (!solution) {
      errorMessages.textContent = "Escreva a sua solução!";
      return false;
  }
  if (!applicationSolution) {
    errorMessages.textContent = "Escreva como será a aplicação!";
    return false;
}
if (!selectedSolutionType) {
  errorMessages.textContent = "Escolha pelo menos uma das opções!";
  return false;
}

  // Adiciona os atributos ao objeto solutionData
  const solutionData = {
      solution: solution,
      applicationSolution: applicationSolution,
      typeSolutions: selectedSolutionType
  };

  createSolution(solutionData);
  return true;
}

  
    async function createSolution(solutionData) {
      // Envia a requisição POST para o backend
      const config = {
        headers: {
          'Content-Type': 'application/json',
        },
      };
      axios.post('http://localhost:8080/api/v1/solutions', solutionData, config)
          .then(response => {
              console.log(response.data);
              errorMessages.textContent = "Solução enviada com sucesso!";
          })
          .catch(error => {
              console.error(error);
              errorMessages.textContent = "Erro ao enviar a solução! Tente novamente";
          });
          
  }
    
  
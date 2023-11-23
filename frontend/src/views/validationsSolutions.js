function validateFormSolutions(event) {
    event.preventDefault();
      //const typeSolutions = document.getElementById("nome").value;
      const solution = document.getElementById("solution").value;
      const applicationSolution = document.getElementById("applicationSolution").value;
      const errorMessages = document.getElementById("errorMessages");
  
      // construcao do obj com os dados
      const solutionData = {
        //typeSolutions: typeSolutions,
        solution: solution,
        applicationSolution: applicationSolution
    };
      errorMessages.textContent = ""; // Limpa mensagens de erro anteriores.
      
  
      //validação do solução
      if (solution == null) {
          errorMessages.textContent = "Escreva a sua solução!";
          return false;
        }
        
  
      //validação application
      if(applicationSolution == null){
          errorMessages.textContent = "Escreva como será aplicada a sua solução!";
          return false;
      }
    
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
    
  
async function fetchData() {
  axios.get('http://localhost:8080/api/v1/solutions')
      .then(response => {
          console.log(response.data);
          displayData(response.data);
          errorMessages.textContent = "Sucesso!";
      })
      .catch(error => {
          console.error(error);
          errorMessages.textContent = "Erro!";
      });
}

// Função para exibir os dados na página
function displayData(data) {
  const solutionsContainer = document.getElementById('sectionBackgroundContent');

  // Limpa o container de soluções
  solutionsContainer.innerHTML = "";

  // Cria um novo card para cada item de dados
  data.forEach(item => {
    const card = document.createElement("div");
    card.className = "Cards";

    // 'solution' é o campo dos seus dados que você quer exibir
    const solution = document.createElement("h1");
    solution.textContent = item.solution;
    card.appendChild(solution);

    // Adiciona o card ao container de soluções
    solutionsContainer.appendChild(card);
  });
}

// Chama a função fetchData quando a página é carregada
window.onload = fetchData;

let loadedCards = 0;
let data = [];

async function getAllPosts() {
  axios.get('http://localhost:8080/api/v1/solutions')
      .then(response => {
          console.log(response.data);
          data = response.data;
          displayData(data, loadedCards);
          errorMessages.textContent = "Sucesso!";
      })
      .catch(error => {
          console.error(error);
          errorMessages.textContent = "Erro!";
      });
}

function displayData(data, start) {
  const solutionsContainer = document.getElementById('sectionBackgroundContent');

  // Cria um novo card para cada item de dados
  for (let i = start; i < start + 5 && i < data.length; i++) {
    const item = data[i];
    const card = document.createElement("div");
    card.className = "Cards";

    // 'solution' é o campo dos seus dados que você quer exibir
    const solution = document.createElement("h1");
    solution.textContent = item.solution;
    card.appendChild(solution);

    // Adiciona o card ao container de soluções
    solutionsContainer.appendChild(card);
  }

  loadedCards += 5;
}

window.onscroll = function(ev) {
    if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
        // O usuário chegou ao final da página, carregue mais cards
        displayData(data, loadedCards);
    }
};

// Chama a função getAllPosts quando a página é carregada
window.onload = getAllPosts;

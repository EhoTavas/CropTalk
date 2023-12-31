let loadedCards = 0;
let data = [];

function getAllPosts() {
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

function getSearchResults(searchTerm) {
  console.log(searchTerm);
  let url = 'http://localhost:8080/api/v1/solutions/search?solution=' + encodeURIComponent(searchTerm);

  axios.get(url)
      .then(response => {
          console.log(response.data);
          data = response.data;  // Atualiza os dados com os resultados da pesquisa
          loadedCards = 0;  // Reinicia a contagem de cards carregados
          const solutionsContainer = document.getElementById('sectionBackgroundContent');
          solutionsContainer.innerHTML = '';  // Limpa os cards existentes
          displayData(data, loadedCards);  // Exibe os resultados da pesquisa
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
    card.onclick = function() { openModal(item); };

    // 'solution' é o campo dos seus dados que você quer exibir
    const solution = document.createElement("h1");
    solution.textContent = item.solution;
    card.appendChild(solution);

    // Adiciona o card ao container de soluções
    solutionsContainer.appendChild(card);
  }

  loadedCards += 5;
}

function openModal(item) {
  // Cria o elemento modal
  const modal = document.createElement("div");
  modal.className = "Modal";

  // Adiciona o título ao modal
  const title = document.createElement("h1");
  title.textContent = item.solution;  // Supondo que 'solution' seja o título
  modal.appendChild(title);

  // Adiciona a descrição ao modal
  const description = document.createElement("h2");
  description.textContent = item.applicationSolution;  // Supondo que 'applicationSolution' seja a descrição
  modal.appendChild(description); 

  // Adiciona um botão para fechar o modal
  const closeButton = document.createElement("button");
  closeButton.textContent = "Fechar";
  closeButton.onclick = function() { modal.style.display = "none"; };
  modal.appendChild(closeButton);

  // Adiciona o modal ao body
  document.body.appendChild(modal);
}

window.onscroll = function(ev) {
    if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
        // O usuário chegou ao final da página, carregue mais cards
        displayData(data, loadedCards);
    }
};

function addSearchFilter() {
  // Pega o elemento do campo de pesquisa
  document.getElementById('searchForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Impede o formulário de ser submetido normalmente

    var solution = document.getElementById('inputSearch').value;

    // Limpa os cards atuais
    const solutionsContainer = document.getElementById('sectionBackgroundContent');
    solutionsContainer.innerHTML = '';

    // Busca as soluções com o termo de pesquisa
    getSearchResults(solution);
  }
  )
}

window.onload = function() {
  setTimeout(function() {
    // Mostra o conteúdo da página após um atraso
    document.body.style.display = '';

    // Chama as funções depois do atraso
    getAllPosts();
    addSearchFilter();
  }, 600);  // Atraso de 600 milissegundos
};

// Importa o axios
import axios from 'axios';

// Cria uma instância do axios com uma configuração padrão
const api = axios.create({
  baseURL: 'http://localhost:8080/api/v1/comunityPosts',
  headers: {
    'Content-Type': 'application/json',
  },
  timeout: 5000
});

// Função que faz uma requisição HTTP para a API REST do servidor em Java e retorna os dados dos cards em formato JSON
async function getData() {
  // Cria uma variável para armazenar os dados recebidos
  let data = null;

  try {
    // Usa o await para esperar a resposta da requisição
    let response = await api.get('/cards');
    // Se o status da resposta for 200 (OK)
    if (response.status == 200) {
      // Atribui os dados da resposta à variável data
      data = response.data;
    }
  } catch (error) {
    // Exibe uma mensagem de erro no console
    console.error("Erro ao obter os dados dos cards: " + error);
  }

  // Retorna os dados recebidos
  return data;
}

// Função que cria um elemento HTML para um card e retorna ele
function createCard(data) {
  let card = document.createElement("div");
  card.className = "Cards";

  let name = document.createElement("h3");
  name.textContent = data.name;

  let title = document.createElement("h4");
  title.textContent = data.title;

  let release = document.createElement("h3");
  release.textContent = data.release;

  

  card.appendChild(name);
  card.appendChild(title);
  card.appendChild(release);
  return card;
}

// Função que adiciona um número de cards ao container
async function addCards(number) {
  let data = await getData();
  let container = document.getElementById("sectionBackgroundContent");
  for (let i = 0; i < number; i++) {
    let card = createCard(data[i]);
    container.appendChild(card);
  }
}

// Função que verifica se o usuário chegou ao final do container e adiciona mais cards se sim
function checkScroll() {
  let container = document.getElementById("sectionBackgroundContent");
  if (container.scrollTop + container.clientHeight >= container.scrollHeight) {
    addCards(5); // Adiciona mais 5 cards
  }
}

// Adiciona um evento de scroll ao container
document.getElementById("sectionBackgroundContent").addEventListener("scroll", checkScroll);

// Adiciona os primeiros 5 cards ao carregar a página
window.onload = async function() {
  await addCards(5);
}

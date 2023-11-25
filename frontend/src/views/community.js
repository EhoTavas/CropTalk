function getData() {
    return [
      {name: "Guilherme", title: "Card 1", release: "19/03/2018 - 16:30",imgLike:"images/like.png",imgComment:"images/comments.png"},
      {name: "Guilherme", title: "Card 2", release: "19/03/2018 - 16:30",imgLike:"images/like.png",imgComment:"images/comments.png"},
      {name: "Guilherme", title: "Card 3", release: "19/03/2018 - 16:30",imgLike:"images/like.png",imgComment:"images/comments.png"},
      {name: "Guilherme", title: "Card 4", release: "19/03/2018 - 16:30",imgLike:"images/like.png",imgComment:"images/comments.png"},
      {name: "Guilherme", title: "Card 5", release: "19/03/2018 - 16:30",imgLike:"images/like.png",imgComment:"images/comments.png"},
      {name: "Guilherme", title: "Card 6", release: "19/03/2018 - 16:30",imgLike:"images/like.png",imgComment:"images/comments.png"},
      {name: "Guilherme", title: "Card 7", release: "19/03/2018 - 16:30",imgLike:"images/like.png",imgComment:"images/comments.png"},
      {name: "Guilherme", title: "Card 8", release: "19/03/2018 - 16:30",imgLike:"images/like.png",imgComment:"images/comments.png"},
      {name: "Guilherme", title: "Card 9", release: "19/03/2018 - 16:30",imgLike:"images/like.png",imgComment:"images/comments.png"},
      {name: "Guilherme", title: "Card 10", release: "19/03/2018 - 16:30",imgLike:"images/like.png",imgComment:"images/comments.png"}
    ];
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

    let imgLike = document.createElement("img");
    imgLike.src = data.imgLike;
    imgLike.alt = "Botão de curtir";

    let imgComment = document.createElement("img");
    imgComment.src = "images/comment.png";
    imgComment.alt = "Botão de comentário";


    card.appendChild(name);
    card.appendChild(title);
    card.appendChild(release);
    card.appendChild(imgLike);
    card.appendChild(imgComment);
    return card;
  }

  // Função que adiciona um número de cards ao container
  function addCards(number) {
    let data = getData();
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
  window.onload = function() {
    addCards(5);
  }

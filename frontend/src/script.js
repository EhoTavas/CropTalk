const inputQuestion = document.getElementById("inputQuestion");
const result = document.getElementById("result");
const sendButton = document.getElementById("sendButton");
const MAX_QUESTIONS = 5; // Limite de perguntas

let remainingQuestions = MAX_QUESTIONS;

inputQuestion.addEventListener("keypress", (e) => {
  if (inputQuestion.value && e.key === "Enter") SendQuestion();
});

sendButton.addEventListener("click", () => {
  if (inputQuestion.value) SendQuestion();
});

function updateRemainingQuestions() {
  if (remainingQuestions === 0) {
    inputQuestion.disabled = true;
    sendButton.disabled = true;
  }
  document.getElementById("remainingQuestions").textContent = `${remainingQuestions} /5 análises`;
}

updateRemainingQuestions(); // Atualiza o número restante inicialmente

const OPENAI_API_KEY = "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 ";

function SendQuestion() {
  if (remainingQuestions > 0) {
    var sQuestion = inputQuestion.value;

    fetch("https://api.openai.com/v1/completions", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
        Authorization: "Bearer " + OPENAI_API_KEY,
      },
      body: JSON.stringify({
        model: "text-davinci-003",
        prompt: sQuestion,
        max_tokens: 1048, // tamanho da resposta
        temperature: 0.5, // criatividade na resposta
      }),
    })
      .then((response) => response.json())
      .then((json) => {
        if (result.value) result.value += "\n";

        if (json.error?.message) {
          result.value += `Error: ${json.error.message}`;
        } else if (json.choices?.[0].text) {
          var text = json.choices[0].text || "Sem resposta";

          result.value += "Chat GPT: " + text;
        }

        result.scrollTop = result.scrollHeight;
      })
      .catch((error) => console.error("Error:", error))
      .finally(() => {
        inputQuestion.value = "";
        inputQuestion.focus();
        remainingQuestions--;
        updateRemainingQuestions(); // Atualiza o número restante após cada pergunta
      });

    if (result.value) result.value += "\n\n\n";

    result.value += `Eu: ${sQuestion}`;
    inputQuestion.value = "Carregando...";

    result.scrollTop = result.scrollHeight;
  }
}

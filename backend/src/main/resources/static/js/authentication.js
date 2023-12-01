document.addEventListener('DOMContentLoaded', function () {
  document
    .getElementById('loginForm')
    .addEventListener('submit', function (event) {
      event.preventDefault(); // Prevents the default form submission
      const formData = new FormData(this); // Get form data

      const requestBody = {
        email: formData.get('email'),
        password: formData.get('senha'),
      };

      fetch('http://localhost:8080/api/v1/auth/signin', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(requestBody),
      })
        .then(response => {
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
          return response.text();
        })
        .then(data => {
          console.log('API response:', data);
          window.location.replace('/quiz');
        })
        .catch(error => {
          console.error('There was a problem with the fetch operation:', error);
        });
    });
});

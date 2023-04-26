const form = document.getElementById('fileUploadForm');
const fileInput = document.querySelector('input[name="fileInput"]');
const responseDiv = document.getElementById('response');

console.log()

form.addEventListener('submit', (event) => {
  event.preventDefault();

  const formData = new FormData();
  formData.append('file', fileInput.files[0]);

  const xhr = new XMLHttpRequest();
  xhr.open('POST', '/uploadFile');
  xhr.send(formData);

  xhr.onreadystatechange = () => {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        responseDiv.textContent = xhr.responseText;
      } else {
        responseDiv.textContent = 'File upload failed.';
      }
    }
  };
});

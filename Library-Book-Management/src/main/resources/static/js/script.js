const apiUrl = "http://localhost:8080/books";
const bookForm = document.getElementById("bookForm");
const tableBody = document.getElementById("bookTableBody");

const loadBooks = async () => {
  const res = await fetch(apiUrl);
  const books = await res.json();
  tableBody.innerHTML = "";

  books.forEach((book) => {
    tableBody.innerHTML += `
      <tr>
        <td>${book.id}</td>
        <td>${book.title}</td>
        <td>${book.author}</td>
        <td>${book.genre}</td>
        <td>${book.available ? "Yes" : "No"}</td>
        <td>
          <button class="btn btn-sm btn-danger" onclick="deleteBook(${book.id})">Delete</button>
        </td>
      </tr>
    `;
  });
};

bookForm.addEventListener("submit", async (e) => {
  e.preventDefault();
  const book = {
    title: document.getElementById("title").value,
    author: document.getElementById("author").value,
    genre: document.getElementById("genre").value,
    available: document.getElementById("available").value === "true"
  };

  await fetch(apiUrl, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(book)
  });

  bookForm.reset();
  loadBooks();
});

const deleteBook = async (id) => {
  await fetch(`${apiUrl}/${id}`, {
    method: "DELETE"
  });
  loadBooks();
};

loadBooks();

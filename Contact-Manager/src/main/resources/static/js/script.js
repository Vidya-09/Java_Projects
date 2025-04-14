const apiUrl = "http://localhost:8080/contacts";
const contactForm = document.getElementById("contactForm");
const tableBody = document.getElementById("contactTableBody");

const loadContacts = async () => {
  const res = await fetch(apiUrl);
  const contacts = await res.json();
  tableBody.innerHTML = "";

  contacts.forEach(contact => {
    tableBody.innerHTML += `
      <tr>
        <td>${contact.id}</td>
        <td>${contact.name}</td>
        <td>${contact.email}</td>
        <td>${contact.phone}</td>
        <td>
          <button class="btn btn-sm btn-danger" onclick="deleteContact(${contact.id})">Delete</button>
        </td>
      </tr>
    `;
  });
};

contactForm.addEventListener("submit", async (e) => {
  e.preventDefault();
  const contact = {
    name: document.getElementById("name").value,
    email: document.getElementById("email").value,
    phone: document.getElementById("phone").value,
  };

  await fetch(apiUrl, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(contact)
  });

  contactForm.reset();
  loadContacts();
});

const deleteContact = async (id) => {
  await fetch(`${apiUrl}/${id}`, {
    method: "DELETE"
  });
  loadContacts();
};

loadContacts();

import React, { useState, useEffect } from "react";
import "./App.css";
import Header from "./Header";
import AddContact from "./AddContact";
import ContactList from "./ContactList";
import service from "./service/contacts" ;

function App() {
  
  const [persons, setPersons] = useState([]);

  const addContactHandler = async (person) => {
    console.log(person);
    const req = { ...person};
    const response = await service.post("/persons", req);
    setPersons([...persons, response.data]);
  };

  const retrievePersons = async () => {
    const response = await service.get("/persons");
    console.log(response.data);
    return response.data;
  };

  const removeContactHandler = async (id) => {
    await service.delete(`/persons/${id}`);
    const newContactList = persons.filter((contact) => {
      return contact.id !== id;
    });

    setPersons(newContactList);
  };

  useEffect(() => {
    
    const getAllPersons = async () => {
      const persons = await retrievePersons();
      setPersons(persons);
    }
    getAllPersons();
  }, []);


  return (
    <div className="ui container">
      <Header />
      <AddContact addContactHandler={addContactHandler} />
      <ContactList contacts={persons} getContactId={removeContactHandler} />
    </div>
  );
}

export default App;

import React from "react";

class AddContact extends React.Component {
  state = {
    firstName: "",
    email: "",
  };

  add = (e) => {
    e.preventDefault();
    if (this.state.firstName === "" || this.state.email === "") {
      alert("All the fields are mandatory!");
      return;
    }
    this.props.addContactHandler(this.state);
    this.setState({ firstName: "", email: "" });
  };
  render() {
    return (
      <div className="ui main">
        <h2>Agregar contacto</h2>
        <form className="ui form" onSubmit={this.add}>
          <div className="field">
            <label>Nombre</label>
            <input
              type="text"
              name="firstName"
              placeholder="Name"
              value={this.state.firstName}
              onChange={(e) => this.setState({ firstName: e.target.value })}
            />
          </div>
          <div className="field">
            <label>Email</label>
            <input
              type="text"
              name="email"
              placeholder="Email"
              value={this.state.email}
              onChange={(e) => this.setState({ email: e.target.value })}
            />
          </div>
          <button className="ui button teal">Agregar</button>
        </form>
      </div>
    );
  }
}

export default AddContact;

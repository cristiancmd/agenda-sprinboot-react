import React from "react";



const ContactCard = (props) => {
  const { id, firstName, lastName, email } = props.contact;
  return (
    <div className="item">
      
      <div className="content">
        <div className="header">{`${firstName}`}</div>
        <div>{email}</div>
      </div>
      <i
        className="trash alternate outline icon"
        style={{ color: "red", marginTop: "7px", marginLeft:"9px" }}
        onClick={() => props.clickHander(id)}
      ></i>
     
    </div>
  );
};

export default ContactCard;

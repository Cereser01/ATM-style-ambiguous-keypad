import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

function Button({ icon, label, onClick, fullWidth }) {
  const estiloBotao = {
    fontSize: '20px',
    width: fullWidth ? '100%' : '200px',
    height: '80px',
    margin: '10px',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    cursor: 'pointer',
    borderRadius: '12px',
    boxShadow: '0px 2px 6px rgba(0, 0, 0, 0.2)',
    transition: 'box-shadow 0.3s ease',
  };

  const estiloIcone = {
    marginRight: '8px',
  };

  const handleClick = () => {
    onClick();
  };

  return (
    label != null && (
      <button onClick={handleClick} style={estiloBotao}>
        {icon && <FontAwesomeIcon icon={icon} style={estiloIcone} />}
        <span>{label}</span>
      </button>
    )
  );

}

export default Button;
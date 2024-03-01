import React from 'react';

function Button({ label, onClick, clicado, fullWidth }) {
  const estiloBotao = {
    fontSize: '32px',
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

  const estiloRotulo = {
    visibility: clicado ? 'hidden' : 'visible',
  };

  const handleClick = () => {
    onClick();
  };

  return (
    <button onClick={handleClick} style={estiloBotao}>
      <span style={estiloRotulo}>{label}</span>
    </button>
  );
}

export default Button;
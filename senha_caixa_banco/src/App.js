import React from 'react';
import Button from './components/Button';

function App() {
  const handleButtonClick = (label) => {
    // Lógica para tratar o clique nos botões
  };

  return (
    <div>
      <div className="row">
        <Button label="3 ou 9" onClick={() => handleButtonClick("3 ou 9")} />
        <Button label="0 ou 5" onClick={() => handleButtonClick("0 ou 5")} />
        <Button label="2 ou 8" onClick={() => handleButtonClick("2 ou 8")} />
      </div>
      <div className="row">
        <Button label="1 ou 4" onClick={() => handleButtonClick("1 ou 4")} />
        <Button label="6 ou 7" onClick={() => handleButtonClick("6 ou 7")} />
        <Button label="Apagar" onClick={() => handleButtonClick("Apagar")} />
      </div>
      <div className="row">
        <Button label="Acessar" onClick={() => handleButtonClick("Acessar")} fullWidth />
      </div>
    </div>
  );
}

export default App;
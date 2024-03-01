import React, { useState } from 'react';
import Button from './components/Button';

function App() {
  const [options, setOptions] = useState('');

  const handleButtonClick = (label) => {
    setOptions(options + label);
  };

  return (
    <div>
      <div>
        <Button label="3 ou 9" onClick={() => handleButtonClick("3 ou 9")} />
        <Button label="0 ou 5" onClick={() => handleButtonClick("0 ou 5")} />
        <Button label="2 ou 8" onClick={() => handleButtonClick("2 ou 8")} />
      </div>
      <div>
        <Button label="1 ou 4" onClick={() => handleButtonClick("1 ou 4")} />
        <Button label="6 ou 7" onClick={() => handleButtonClick("6 ou 7")} />
        <Button label="Apagar" onClick={() => handleButtonClick("Apagar")} />
      </div>
      <div>
        <Button label="Acessar" onClick={() => handleButtonClick("Acessar")} fullWidth />
      </div>
      <div>
        <p>Opções digitadas: {options}</p>
      </div>
    </div>
  );
}

export default App;